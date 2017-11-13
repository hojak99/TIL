# OAuth

## OAuth 란?
기존의 기본인증이었던 아이디와 비밀번호가 보안상 취약했기 때문에 만든 표준화 된 인증방식으로, 웹, 앱 서비스에서 제한적으로 권한을 요청해 사용 할 수 있는 키를 발급해주는 방식이다.

## OAuth 의 원리
먼저, OAuth 에 대해서 이야기하기 위해서는 3가지가 필요하다. <code>User</code>, <code>Client</code>, <code>Resource Server:(Server)</code> 란 개념이 필요하다.

> Resource Server 는 쉽게 말하면 Facebook, Google 이라고 생각하자.

Client 에서는 Resource Server 에 User 에 대한 데이터를 가져와서 User 에게 어떠한 서비스를 제공한다고 하자.

그렇다면 Clent 는 Resource Server 에 해당 Service 를 이용하기 위해 등록을 하게 된다. 그래서 Resource Server 에서는 해당 Client 를 식별하기 위해, <code>ID</code>, <code>Secret Key</code> 를 발급해준다. 그리고 Client 이 발급 받은 ID 와 Secret Key 를 저장해놓는다.

이제 Client 는 User 에게 Resource Server 에서 어떠한 정보를 사용할 수 있도록 허락해달라는 요청을 한다. 

> ~ 한 이유로 해당 서비스에서는 Google 의 ~ 한 정보가 필요합니다. 구글에 로그인 하여 승인해주세요.

User 가 허락을 한다면 Resource Server 에서는 로그인이 되어있지 않을 시에 로그인을 하라는 요청 창이 뜬다. 그리고 유저가 로그인을 하게 되면, Resource Server 에서는 어떤 서비스가 이런 정보에 접근하려고 한다고 하며 승인을 할 것인지를 묻는 창이 뜨게 된다.

> ~ 서비스에서 당신의 Google ~ 정보를 이용하려고 합니다. 승인하시겠습니까?

만약 User 가 승인하게 된다면, Resource Server 는 Client 가 User 의 정보에 접근할 수 있다라는 것을 증명할 수 있는 어떠한 패스워드를 제공하게 된다. 이것을 <code>Code</code> 라고 한다.

이제 Client 에서는 Resource Server 에게 그 동안 제공받았던, <code>ID</code>, <code>Secret Key</code>, <code>Code</code> 의 정보를 Resource Server 에게 다시 보내게 된다. 그러면 Resource Server 에서는 해당 Client 에게 발급한 <code>Code</code> 와 Client 를 증명할 수 있는 <code>ID</code>, <code>Secret Key</code> 를 비교해서 User 가 승인했던 Client 가 맞다면, <code>Access Token (실질적 비밀번호)</code> 정보를 주는데 이 정보를 DB에 저장한다. 

그래서 이 토큰을 이용해 Resource Server 에 정보를 요청하게 되는데 Resource Server 에서는 해당 토큰이 자신이 발급했었던 토큰이 맞다면 데이터를 Client 에게 주고, Client 에서는 이 정보를 가공해 User 에게 제공한다.

---

## 인증방식 요약

1. Client가 Resource Server 에게 요청토큰을 요청한다.
2. Resource Server 가 Client 에게 요청토큰을 발급해준다.
3. Client가 User 를 Resource Server 로 이동시킨다. 여기서 User 인증이 수행된다.
4. Resource Server 가 User 를 Client 로 이동시킨다.
5. Client 가 접근토큰을 요청한다.
6. Resource Server 가 접근토큰을 발급한다.
7. 발급된 접근토큰을 이용하여 Client 에서 User 정보에 접근한다.


### 출처
생활코딩 : https://opentutorials.org/course/2473/16571  
위키백과 : https://ko.wikipedia.org/wiki/OAuth