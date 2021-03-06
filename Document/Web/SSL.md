# SSL(Secure Socket Layer)
HTTPS 는 HTTP 통신을 하는 부분을 SSL or TLS 로 대체하는 프로토콜이다. HTTPS 에서 사용하는 SSL 에 대해서 알아보자,,

> SSL(Secure Socket Layer) 프로토콜은 처음에 Netscape 사에서 웹서버와 브라우저 사이의 보안을 위해 만들었다고 한다. 먼저, SSL은 Certificate Authority(CA)라 불리는 서드 파티로부터 서버와 클라이언트의 인증을 하는데 사용된다.

다음은 SSL의 동작원리이다.
1. [웹브라우저] SSL로 암호화된 페이지를 요청하게 된다. (https://)
2. [웹서버] Public Key 를 인증서와 함께 전송한다.
3. [웹브라우저] 인증서가 자신이 신용이 있다고 판단되는 CA로부터 서명된 것인지 확인한다.
4. [웹브라우저] Public Key 를 사용해 랜덤 대칭 암호화키를 비롯한 URL, Http 데이터들을 암호화해서 전송한다.
5. [웹서버] Private Key를 이용해서 랜덤 대칭 암호화키와 URL, Http 데이터를 복호화한다.
6. [웹서버] 요청받은 URL 에 대한 응답을 웹브라우저로부터 받은 랜덤 대칭 암호화키를 이용하여 암호화해서 브라우저로 전송한다.
7. [웹브라우저] 대칭 키를 이용해서 Http 데이터와  html 문서를 복호화하고 화면에 뿌려준다.


또한, SSL 은 대칭키와 공개키 방식 암호화 기법을 혼용해서 사용한다고 한다.
> 클라이언트와 서버가 주고 받는 데이터는 대칭키 방식으로 암호화를 한다. 대칭키 방식으로 암호화된 데이터를 복호화할 때 사용되는 대칭키는 공개키 방식으로 암호화해서 클라이언트와 서버가 주고 받는다.


> https://opentutorials.org/course/228/4894 참고사이트이다.