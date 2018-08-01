# Spring JPA List to Json Converter

DB 테이블에 json 데이터를 넣어야 한다고 하자. `Entity` 클래스에는 그러면 json 데이터를 담을 변수가 있어야 한다.

```
@Column(name = "user_json_data")
private String userJsonData;
```

아마 이렇게 `userJsonData` 변수에 넣으려고 할 것이다. 하지만 만약 json 데이터에 여러 데이터가 존재한다고 가정할 시 그 안에 있는 데이터를 수정하거나 새로 추가, 삭제할 때 어려움을 겪을 것이다.

그렇기에 converter 를 사용해서 `Entity` 클래스에서는 `List<?>` 변수를 사용하도록 하고, DB에 넣거나 뺄 때는 List 를 Json 으로 변경시켜 넣으면 편할 것이다.

```

@Converter
@Slf4j
public class JsonArrayToListConverter implements AttributeConverter<List<String>, String> {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if(attribute == null) {
            attribute = new ArrayList<>();
        }

        try {
            return mapper.writeValueAsString(attribute);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String json) {
        if(json == null) {
            return new ArrayList<>();
        }

        try {
            // 해당 메소드는 Json -> List<User> 로 convert 되기 때문에 TypeReference<List<?>> 에 User 로 타입을 지정해줬다.
            return mapper.readValue(json, new TypeReference<List<User>>(){});
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

다음과 같은 클래스를 작성한다. 이제 우리는 convert 를 원하는 필드에 어노테이션을 달아주면 된다.

```
@Convert(converter = JsonArrayToListConverter.class)
private List<User> userJsonData;
```

다음과 같이 작성하면 해결된다.

이 때 `LocalTimeDate`, `LocalDate` 같은 객체들을 json 으로 convert 할 때 `created_at : "2018-09-91:~~"` 과 같이 convert 되는 것이 아니라, `year`, `month`, `day` 들 따로따로 분리되서 json 으로 변경되기 때문에 해당 코드를 추가해줘야 제대로 convert 를 한다.

```
mapper.registerModule(new JavaTimeModule());
mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
```

