# Spring JPA Specification

Spring JPA Specification 에 알아보려고 한다.

> 다음의 사이트에서 Spring JPA Specification 에 대해서 그마나 쉽게 이해가 되도록 이야기하는 것 같다.
https://dzone.com/articles/using-spring-data-jpa-specification

---

Spring JPA Specification 은 매우 짧게 이야기 한다면 기존에 인터페이스에 JpaRepository 같이 상속받아서 CRUD 메소드를 제공 받았으나, 동적인 쿼리를 작성할 때 JPA Specification 이 도움이 된다.

예를 들어, 다음과 같은 기능이 있다고 생각하자.

```
유저를 검색하는 게시판에, 각각 필터가 달려있다.

userId, userName, createdAt, cellphone, .......

관리자는 제공하는 필터를 사용해서 필터와 일치하는 유저를 검색할 수 있다.
```

물론 Jpa 에서 기본으로 제공하는 CRUD 메소드로 구현을 할 수는 있긴 있을테지만 코드가 더러워질 것 이다. 각각의 필터에 맞는 read 메소드가 필요하고, 뭐 if 문도 필요하는 등,,,

이 때 Specification 을 사용하면 무척 깔끔해진다.

---

위에서 조금 추상적으로 이야기를 해서, 아마 지금은 Specification 은 알겠지만 어떻게 구현하지? 라는 생각이 들 것이다.

우선 JpaRepository 를 상속받는 인터페이스에 또 다른 클래스인 `JpaSpecificationExecutor<T>` 를 상속받게 한다. 

```
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
```

다음과 같이 말이다. 여기서 `JpaSpecificationExecutor` 는 JPA criteria API 를 기반으로 Specification 을 허용하는 인터페이스이다. 

직접 해당 인터페이스를 타고 들어가면

```
	/**
	 * Returns a {@link Page} of entities matching the given {@link Specification}.
	 *
	 * @param spec can be {@literal null}.
	 * @param pageable must not be {@literal null}.
	 * @return never {@literal null}.
	 */
	Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);
```

와 같이 메소드가 정의 되있고 주석이 달려 있을 것이다.


그러면 우리가 할 일은 이제 Specification 클래스를 정의하는 것이 남았다.


```
public class UserSpecification {

  public static Specification<User> searchUser(Map<String, Object> filter) {
    return (root, query, criteriaBuilder) -> {

    }
  }
}
```

다음과 같이 코드를 작성할 수 있다. criteriaBuilder 는 `Used to construct criteria queries, compound selections, expressions, predicates, orderings.` 라고 나와 있다.


이제 조건 식을 추가하려고 한다. 필자는 filter 란 Map 객체에 각각 Filter id 와 그 검색하려는 데이터를 가지도록 해놓았다.

```
public static Specification<User> searchUser(Map<String, Object> filter) {
  return (root, query, criteriaBuilder) -> {
    // Predicate 는 criteria 에서 제공하는 클래스이다. 이상한 클래스 임포트 받지 말자.
    List<Predicate> predicates = new ArrayList();
  
    filter.forEach((key, value) -> {
      String likeValue = "%" + value + "%"

      switch (key) {
        case "userId":
          predicates.add(criteriaBuilder.like(root.get(key).as(String.class), likeValue));
          break;

        .
        .
        .
      }
    });

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }
}
```

다음과 같이 Specification 클래스를 정의해서 사용하면 정~말 간편할 것이다.

참고로 join 도 지원한다. 

> http://javacan.tistory.com/entry/SpringDataJPA-Specifcation-Usage 해당 블로그도 많이 도움이 됐다.


---

그리고 이제 findAll() 메소드에 적용시킬 차례다. 아까 위에서 `JpaSpecificationExecutor` 는 다음과 같은 메소드를 제공한다고 했다.

```
Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);
```

그러면 우리는 이제 다음과 같은 코드를 짤 수 있을 것이다.

```
findAll(UserSpecification.searchUser(filter), pageable);
```

이제 끝이다.