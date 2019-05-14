# JPA 세미나 준비

- 목차
  - JPA Lazy loading 
    - JPA lazy loading 간단 설명
    - 동작 원리
    - 코드

## Lazy loading
쉽게 말해 Lazy loading 은 필요할 때까지 객체 초기화를 지연하기 위해 사용하는 디자인 패턴이다. 

JPA 에서는 어떻게 사용되는지 아래를 보고 확인해보자.

![exmaple_code_13](./lazy_loading_1_3.PNG)

![exmaple_code_1](./lazy_loading_1.PNG)

![example_code_1_1](./lazy_loading_1_1.PNG)

아래의 로그처럼 실제 `List<UserConnected>` 에 접근했을 때 `SELECT` query 가 수행되는 것을 볼 수 있다.

----

`hibernate 완벽 가이드` 책을 인용했을 때 다음과 같은 내용을 볼 수 있다.

> load() 연산 후 메모리 상에 있는 것은 영속 item 객체가 아니다. SQL 도 실행되지 않았다. 하이버네이트가 실제 객체처럼 보이는 프록시를 생성했을 뿐이다.

보통 책이나 블로그에선 lazy loading 은 프록시를 이용해 구현을 했다고 한다. 하지만 `이 프록시가 과연 어떤 프록시인가?` 에 대해서는 나와있지 않다. 

---

### AOP 에 등장하는 용어
우선 미리 이야기를 하자면 lazy loading 은 프록시 기술을 사용하는데 JPA 에선 Aop 의 Dynamic proxy 를 사용한다. 그렇기 때문에 먼저 AOP 에 관한 용어에 대해서 간략하게 설명을 해보도록 하겠다.

- AOP(Aspect-Oriented Programming) 란
  - 애플리케이션의 핵심적인 기능에서 부가적인 기능을 분리해 aspect 라는 모듈로 만들어 설계하고 개발하는 방법

- Target 
   - 부가 기능을 부여할 대상

- Advice
  - 실질적으로 부가 기능을 담은 구현체. target object 에 종속되 않기 때문에 순수하게 부가 기능에만 집중할 수 있음
  - spring 에선 `advice` 와 `pointCut` 을 하나로 합쳐서 `advisor` 라고 한다.

- Join point
  - 쉽게 말해서 advice 가 적용될 수 있는 위치를 얘기함.
  - 클래스의 객체 생성 시점, 메소드 호츌 시점, Exception 발생 시점 등, AOP 가 개입되는 시점. spring 에소는 메소드 join point 만 제공.

- Pointcut
  - 부가 기능(advice) 이 적용될 대상, 즉 메소드를 선정하는 방법을 얘기함. advice 를 적용할 join point 를 선별하는 기능을 정의한 모듈이라고도 얘기할 수 있음

- Advisor
  - pointcut + advice

---

### 프록시란
일반적으로 말하는 프록시는 클라이언트와 사용 대상 사이의 대리 역할을 맡은 오브젝트를 두는 방법을 말한다. 

프록시 패턴의 프록시는 프록시를 사용하는 방법 중에서 타깃에 대한 접근 방법을 제어하려는 목적을 가진 경우를 말한다. 그래서 target 의 기능을 확장, 추가하지 않는다.

#### lazy loading
`target object` 를 필요한 시점까지 생성하지 않고 있다가 `target object` 에 대한 `reference` 가 필요하면 `프록시 패턴`을 적용했을 때 이게 바로 `lazy loading` 이다.

클라이언트에게 target 에 대한 reference 를 넘기는 대신 프록시를 넘기고 해당 target 을 사용하려 할 때 프록시가 target object 를 생성하고 요청을 위임해 주는 방식이다.

---

책이나 구글링을 통해 나오는 `프록시`가 어떤 것이며, 어떻게 동작을 하는지 알아보도록 하겠다.

위에서 보았던 `lazy_loading_JPA()` 테스트 메소드를 이용해서 알아보도록 하겠다.

### JDK Dynamic proxy, CGLib
그 전에 먼저, 프록시는 크게 2가지 종류로 `JDK Dynamic Proxy`, `CGLIB Proxy` 가 있다. 

- JDK Dynamic Proxy
  - java reflection 을 이용해 프록시 객체 생성
  - inteface 정의된 것을 기준으로 생성

- CGLib Proxy
  - 바이트 코드를 조작해 프록시 객체를 생성
  - interface 없이 프록시 객체 생성
    - class 를 상속받아 프록시 객체를 생성하기 때문에 final, private 와 같은 경우 지원하지 않음

Spring 에서는 몇몇 특정 조건에 따라 2가지 프록시를 각각 사용하게 끔 설계가 돼 있다.

우선 그 중 하나의 조건이 AOP 의 target 이 되는 클래스가 인터페이스를 구현했다면 `JDK Dynamic Proxy` 를 사용하고, 구현하지 않았다면 `CGLIB` 방식을 사용하도록 돼 있는데 코드를 통해 살펴보도록 하자.

![proxy_code_7](./lazy_loading_7.PNG)

디버깅을 통해서 각각의 JpaRepository 상속하는 interface 들이 각각의 `JdkDynamicAopProxy` 객체를 가지는 것을 확인을 할 수 있었다.


### 코드
우선 다음의 코드에 브레이크 포인트를 걸었다.

```
User user = userRepository.findById(595525L)
        .orElseThrow(() -> new IllegalArgumentException("데이터가 존재하지 않습니다."));
```

![debugging_code_3](./lazy_loading_3.PNG)
![debugging_code_3_1](./lazy_loading_3_1.PNG)

사진을 보다시피 바로 `JdkDynamicAopProxy` 클래스의 `invoke()` 메소드로 접근 하는 것을 볼 수 있다.

`JdkDynamicAopProxy` 클래스는 `org.springframework.aop.framework` 에서 제공하는 클래스이다. 

### DynamicProxy
`DynamicProxy` : 프록시 팩토리에 의해 런타임 시 다이나믹하게 만들어지는 오브젝트이다. `Dynamic Proxy Object` 는 target 의 `interface` 와 같은 타입으로 만들어진다.

Spring aop 에서는 `DefaultAopProxyFactory` 클래스를 제공하여 `DynamicAopProxy` 를 생성한다.

![dynamic_proxy_4](./lazy_loading_4.PNG)

클라이언트는 `Dynamic Proxy Object` 를 `target interface` 통해 사용할 수 있는데 해당 프록시를 생성할 때 인터페이스 정보만 제공하면 해당 interface 를 구현한 클래스의 오브젝트를 자동으로 만들어주기 때문에 편리하다.

`Dynamic Proxy` 가 인터페이스 구현 클래스의 오브젝트는 만들어주나, 부가 기능 코드는 직접 생성해야 하는데 이때 부가 기능은 `InvocationHandler` 를 구현해야 한다. 해당 인터페이스는 다음과 같은 메소드 하나만 가지고 있다.

```
package java.lang.reflect;

public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
```

`invoke()` 메소드는 reflection 의 method 인터페이스를 파라미터로 받고 호출될 때 전달할 파라미터도 `args` 로 받는다. 

즉, `Dynamic Proxy Object` 는 클라이언트의 모든 요청을 reflection 정보로 변환해 해당 `invoke()` 메소드로 넘긴다.

> `DynamicAopProxy` 는 `InvocationHandler` 를 구현하는 final 클래스이다.

---

그리고 실제 `target object` 의 method 를 내부적으로 실행하기 위한 `MethodInvocation` 이 존재한다. 이 `MethodInvocation` 은 `proceed()` 메소드를 호출해 사용한다.

```
// We need to create a method invocation...
invocation = new ReflectiveMethodInvocation(proxy, target, method, args, targetClass, chain);
// Proceed to the joinpoint through the interceptor chain.
retVal = invocation.proceed();
```

위 debugging 사진을 참고하도록 하자. 

즉, 해당 `target(targetClass)` 에 대한 `method(method)` 를 `args(args)` 를 이용해 메소드를 실행한다. 여기서 `chain` 파라미터는 런타임에 필요한 인터셉터를 의 해놓은 list 이다. 

![interceptor_5](./lazy_loading_5.PNG) 

다음의 사진을 참고하자.

----

`ReflectiveMethodInvocation` 클래스의 생성자 파라미터에는 다음과 같이 존재한다.

![ReflectiveMethodInvocation_constructor_6](./lazy_loading_6.PNG)

- proxy : 호출한 프록시 객체
- target : 호출하는 target 객체
- method : 호출하는 메소드
- args : 메소드에 사용되는 인자
- targetClass : MethodMatcher 호출의 타겟 클래스
- interceptorsAndDynamicMethodMatchers : 런타임에 필요한 InterceptorAndDynamicMethodMatchers와 함께 적용되어야하는 인터셉터를 정의(잘 이해가 가지 않음)

---

위에서 알아본 방식으로 실제 lazy_loading 을 구현하고 있다. 실제 단순 `findById()` 를 호출해도 `DynamicAopProxy` 로 접근한다. 이렇게 프록시를 이용하기 위해 `JpaRepository Interface` 를 제공하는 것 같다

간단하게 정리하자면 다음과 같은 순으로 동작하게 된다.

1. DB 에서 데이터 조회 시도
   -  `user.getUserConnectedList()`
2. 해당 호출 코드로 인해 실제 프록시에 요청하게 됨
3. `DynamicAopProxy` 에서 각각 reflection 을 이용해 클래스, 메소드, 인자 정보를 가지게 됨
4. 그러면 해당 proxy 에 설정된 target 에 대한 method 를 호출하게 함
5. 해당 `findById()` 를 `5955525` 라는 인자와 함께 수행하게 됨 (`proceed()`)
6. 실제 collection 을 사용하려고 할 때 select 쿼리가 수행됨으로 써 동작이 가능해짐


> 어떻게 advisor 를 통해 메소드를 선택하고 호출하는지 디버깅을 하고 싶었으나 이해가 딸려 하지 못함


> http://blog.naver.com/PostView.nhn?blogId=tmondev&logNo=220558804255&parentCategoryNo=&categoryNo=6&viewDate=&isShowPopularPosts=false&from=postView


### 코드
