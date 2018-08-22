# access token 과 refresh token

OAuth 인증에 성공하면 Access Token 과 Refresh Token 을 얻게 된다고 한다. 

> Kakao Developers 에서는 이 두 가지 토큰을 묶어 사용자 토큰이라고 부른다고 한다.

Access Token 과 Refresh Token 에 대해서 알아보기 전에 OAuth 의 동작 과정을 간단히 살펴보도록 하겠다. 물론, 해당 내용은 TIL 어딘가에 내가 마크 다운으로 정리해놓았었다.

```
1. 사용자가 SNS 로그인 버튼 눌렀음.
2. 해당 SNS 에 연결된 자격정보를 통해 사용자 인식
3. 자격정보가 올바르면 사용자로부터 접근 자원에 대한 동의 및 허가를 얻음
4. 리소스 서버(SNS 서버)에서 인증코드를 클라이언트에게 발급. 
5. 인증코드를 기반으로 access token, refresh token 을 얻는다
```

대충 이렇게 동작한다.

그렇다면 access token 과 refresh token 은 무슨 차이일까

- access token 은 거의 ID 와 PW 라고 생각하면 된다. 하지만 해당 토큰은 만료기한이 있는데 보안상 짧은 유효기간을 가지고 있다고 한다. 해당 토큰이 만료되면 refresh token (만료되지 않았다고 가정) 으로 access token 을 갱신함.

---

refresh token 이 굳이 있는 이유는 access token 은 노출되더라도 유효기간이 짧아 남용할 시간이 제한된다. refresh token 이 노출되더라도 실질적인 access token 을 얻기 위해서 클라이언트의 id 와 secret key 가 추가로 필요하기 때문이다.