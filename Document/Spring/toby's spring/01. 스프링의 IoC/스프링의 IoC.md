# 스프링의 IoC
> Bean : 스프링이 제어권을 가지고 직접 만들거나 관계를 부여하는 오브젝트
> Bean Factory : bean 의 생성과 관계설정 같은 제어를 담당하는 IoC 오브젝트

> Application Context : 보통 bean factory 보다는 이를 더 확장한 애플리케이션 컨텍스트를 주로 사용한다.

---

> @Configuration : bean factory 를 위한 오브젝트 설정을 담당하는 클래스를 인식하기 위함
> @Bean : 오브젝트를 만들어 주는 메소드에 붙임 

```
@Configuration      // application context 또는 bean factory 가 사용할 설정정보라는 표시
public class DaoFactory {

    @Bean   // 오브젝트 생성을 담당하는 IoC 용 메소드라는 표시
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
```

application context 는 DaoFactory 클래스를 설정정보로 등록해두고 @Bean 이 붙은 메소드의 이름을 가져와 bean 목록을 만들어둔다. 클라이언트가 application context 의 getBean() 메소드를 호출하면 해당 메소드를 호출해 오브젝트를 생성 후 클라이언트에 돌려준다.

application context 를 사용했을 때의 장점은 다음과 같다.
 - 클라이언트는 구체적인 factory class 를 알 필요가 없다. 
    - xml 로 설정정보를 만들 수 있음
    - application context 로 일관된 방식으로 원하는 오브젝트 가져옴

 - application context 는 종합 IoC 서비스를 제공해줌
    - 오브젝트가 만들어지는 방식, 시점, 전략을 다르게 가져갈 수 있음
    - 자동생성, 후처리, 정보 조합, 인터셉터 등 다양한 기능 제공
 
 - application context 는 bean 을 검색하는 다양한 방법 제공
    - getBean() 메소드는 빈의 이름 통해 찾는다.
    - 타입만으로 빈을 검색할 수 있다.

