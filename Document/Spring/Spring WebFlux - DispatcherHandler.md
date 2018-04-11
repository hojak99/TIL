# Spring WebFlux - DispatcherHandler
Spring WebFlux 프레임워크의 DispatcherHandler 에 대해서 알아볼 것이다. Spring WebFlux 동작구조에 대해서 알아보고 싶었으나, 따로 동작구조에 대한 문서는 못 찾아서 DispatcherHandler 가 적절한 것 같아 이에 대해 알아보려고 한다.


## Introduction
Spring WebFlux 는 Spring MVC 처럼 중앙에 `WebHandler` 인 `DispatcherHandler` 가 있는데 프론트 컨트롤러 패턴을 중심으로 설계되었으며, 실제 작업이 설정(configurable)이나 delegate 컴포넌트에 의해 행해지는 동안 request 처리를 위한 shared 알고리즘을 제공한다. 이 모델은 유연하고, 다양한 wrokflow(작업흐름)를 지원한다. 

`DispatcherHandler` 는 Spring configuration 에서 필요한 delegate 컴포넌트들을 검색한다. 또한, Spring bean으로 설계되었으며 실행 컨테스트에 대한 액세스를 위해 `ApplicationContextAware` 를 구현한다. 만약 `DispatcherHandler`가 "webHandler" 란 이름의 bean 으로 선언된다면, `WebHandler API` 에 설명되있는 대로 request 처리 chain을 합치는 `WebHttpHandlerBuilder` 에 의해 결과적으로 발견된다. 

WebFlux 애플리케이션의 Spring configuration 은 다음을 포함하고 있다.
- bean 이름이 "webHandler" 인 `DispatcherHandler`
- `WebFilter` 및 `WebExceptionHandler` beans
- `DispathcerHandler` 의 특별한 bean 
    - `HandlerMapping` : 요청을 어떤 컨트롤러에서 처리할지 결정  
    - `HandlerAdapter` : `HandlerMapping` 으로 선택한 컨트롤러를 `DispatcherHandler가` 호출할 때 사용
    - `HandlerResultHandler` : `handler` 호출의 결과를 처리하고 응답
- 그 외


WebHttpHandlerBuilder 에 processing chain 을 구축하는 configuration 을 제공한다.

```
ApplicationContext context = ...
HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context);
```