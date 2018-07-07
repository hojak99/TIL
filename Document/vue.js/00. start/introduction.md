# Vue.js 란?
프론트엔드 자바스크립트 프레임워크이다. Vue.js 는 View 에만 초점을 두기 때문에 다른 라이브러리와 프레임워크와 혼용하기 쉽다고 한다. 

Vue.js 를 불러오기 위해선 Vue.js 에서 제공하는 CDN 주소에서 unpkg 에서 제공하는 링크를 사용하면 된다.

```
<script src="https://unpkg.com/vue"></script>
```

### 선언적 렌더링
Vue.js 의 핵심은 간단한 템플릿 구문을 사용해 선언적으로 DOM 에 데이터를 렌더링하는 것이라고 한다.

```
<div id="app">
    {{ message }}
</div>
```
```
var app = new Vue({
    el: '#app',
    data: {
        message: 'vue 하이룽'
    }
})
```
```
vue 하이룽
```