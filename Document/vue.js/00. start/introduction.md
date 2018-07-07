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

---

```
<div id="app-2">
  <span v-bind:title="message">
    마우스 올리면 동적으로 바인딩 된 title 을 볼 수 있음
  </span>
</div>
```
```
var app2 = new Vue({
 el : '#app-2',
 data: {
 message: '이 페이지는 '+new Date() + ' 에 로드 되었습니다.'
 }
})
```
```
마우스 올리면 동적으로 바인딩 된 title 을 볼 수 있음
```

여기서 `v-bind` 속성은 디렉티브라고 한다. 디렉티브는 Vue 에서 제공하는 특수 속성임을 나타내는 `v-` 접두어가 붙어있으며 렌더링 된 DOM 에 특수한 반응형 동작을 한다고 한다.   
기본적으로 해당 요소의 title 속성을 Vue 인스턴스의 message 속성으로 최신 상태를 유지한다.