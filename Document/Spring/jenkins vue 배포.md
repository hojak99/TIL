# spring 과 vue 를 서버 하나에 포트를 다르게 해서 배포하기

서버 배포 관련은 구글링하면 많이 나오기 때문에 vue 배포만 이야기합니다.

---

우선 간단히 생각해보면 실행해야할 커맨드는 아래와 같다고 생각했습니다.

1. npm install
2. npm run build
3. npm run {BUILD_PROFILE}


해당 스크립트는 jenkins build script 에 넣어줍니다.

```
sh "cd dobby-front"
sh "npm install"
sh "npm run build"
```

우선 성공했습니다.

이제 `rsync` 를 이용해서 배포되는 서버의 dist 폴더에 복사를 해야합니다. 

```
sh "rsync -rav --delete (젠킨스 서버의 npm 빌드 폴더) (복사되는 배포되는 서버)"
```
 `unexplained error` 오류가 발생했습니다. 잘 모르겠습니다. 권한이 없는 것 같습니다.

열심히 구글링을 한 결과 서버에 대해 ssh 키 등록이 되지 않아서 그런 것이다라고 나왔습니다. 

우선 Test 서버에 jenkins 서버의 ssh 키가 등록이 되어있지 않은 것 같으니 jenkins 서버에서 `ssh-keyjen` 을 해주었습니다. 

해당 키는 `/root/.ssh/id_rsa.pub` 에 생겼다고 로그가 남아서 복사 후에 ssh 로 dobby에 접속해 `.ssh/authorized_keys` 에 추가를 해주었습니다. 

그리고 그리고 `sh "rsync -rav --delete (젠킨스 서버의 npm 빌드 폴더) (복사되는 배포되는 서버)` 를 해주니 작동이 되었습니다. 

> `sh "rsync -rav --delete (젠킨스 서버의 npm 빌드 폴더) (복사되는 배포되는 서버)` 다음과 같은 명렁어가 있어서 rsync 가 무엇인지 알아보니 `원격에 있는 파일과 디렉토리를 복사하고 동기화 하기 위해서 사용하는 툴이며 동시에 네트워크 프로토콜` 이라고 구글링을 통해 알게 되었습니다. 그냥 간단하게 파일 복사하는 거라고 생각하면 될 것 같습니다. 지금은 이게 중요한게 아니니까용ㅎㅎ

그래서 이것도 jenkins build script 에 추가를 해줬습니다. 으음,, 잘 되군요. 기분이 좋습니다.

이렇게 npm run 까지 작동이 되었습니다.

---

이제 서버가 켜졌으니 `(서버 url):8080` 에 접속하였습니다. spring 에서 페이지가 없다는 페이지가 보였습니다. 아무리 찾아도 front 페이지는 보이지 않았습니다.

node 서버 포트랑 spring 서버 포트가 달라야합니다! 그래서 spring 서버 포트를 변경해주었습니다.

그래도 되지 않았습니다.

이제 nginx를 설정해야합니다.

하지만 nginx 는 셋팅할 자신이 없어서 다른 방법을 찾아보았지만 아무리 생각해도 nginx 때문인 것 같습니다.

1. nginx 설치
2. nginx conf 파일 만들기
3. 실행
4. 끝

```
server {
    listen       8080 default_server;
    listen       [::]:8080 default_server;
    server_name  (server-name);

    #charset koi8-r;
    #access_log  /var/log/nginx/host.access.log  main;

    root   /opt/(빌드 압축 푼 폴더명);

    location / {
        try_files $uri $uri/ @rewrites;
    }

    location @rewrites {
        rewrite ^(.+)$ /index.html last;
    }

    location ~* \.(?:ico|css|js|gif|jpe?g|png)$ {
        # Some basic cache-control for static files to be sent to the browser
        expires max;
        add_header Pragma public;
        add_header Cache-Control "public, must-revalidate, proxy-revalidate";
    }
}
```
성공했습니다. 
