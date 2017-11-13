# Spring Filter 와 Interceptor 의 차이

## Filter or Interceptor 를 사용하는 이유
무척 간단한 예시를 <code>Session</code> 과 관련해 들 수 있다.  

1. 사용자가 로그인 함 (login.do)
2. 게시글 작성 페이지로 이동한다 (write.do)
3. 게시글 작성을 하면 DB에 해당 게시글을 작성한 사용자의 ID 와 게시글 정보가 insert 된다.

라는 상황이 있을 때 <code>Session</code> 처리를 하지 않을 시 로그인 하지 않은 사용자가 게시글 작성 페이지 (write.do) 로 곧장 이동해 게시글을 올리면 아마 서버는 터질 것이다. 

그래서 이런 상황을 없애기 위해 나는 컨트롤러 클래스의 메소드마다 <code>Session</code> 을 검사하는 코드를 추가했는데, 추가하고 보니 총 100개의 메소드에 추가를 했다. 가독성도 떨어지고, 코드가 중복될 것이다.

그래서 우리는 Filter 와 Interceptor 를 사용해 이런 상황들을 사전에 처리할 수 있다.

이런 상황들을 사전에 처리할 수 있는 이유는 Spring 동작 과정을 이해하면 알 수 있다. 
기존에 Spring 동작 과정에서는 사용자 요청 시 DispatcherServlet 을 거쳐 HandlerMapping 으로 Controller 검색한다~ 라고 되어 있다. 하지만 DispatcherServlet 을 거치기 전과 후에 거치는 단계가 한 개씩 있다.

이 거치는 단계가 <code>Filter</code>, <code>Interceptor</code> 이다. 

> User Request -> Filter -> DispatcherServlet -> HandlerInterceptor 과 같다.

## Filter
DispatcherServlet 앞 단에서 처리를한다.

## Interceptor 
DispatcherServlet 에서 Controller 로 가기 전 처리를 한다.


<br><br>
그렇기 때문에 정확히 어떤 상황에 어떤 기능을 사용해야 하는가에 대해서 아리송한데, 
- <code>Filter</code> : 인코딩이나 보안관련 처리같은 전역적으로 처리해야하는 로직
- <code>Interceptor</code> : 디테일한 처리(인증, 권한 등)에 대해 주로 처리

도움 : http://www.leafcats.com/39