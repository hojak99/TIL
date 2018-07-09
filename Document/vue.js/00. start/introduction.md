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

---

### 조건문과 반복문
엘리먼트의 존재 여부를 컨트롤 할 수도 있다. 아래의 예제를 확인해봄으로 써 텍스트와 속성 뿐 아니라 DOM 의 구조에도 데이터를 바인딩 할 수 있음을 보여준다.

```
<div id="app-3">
    <p v-if="seen">이제 나를 볼 수 있다</p>
</div>
```
```
var app3 = new vue({
    el: '#app-3',
    data : {
        seen : true
    }
})
```
```
이제 나를 볼 수 있다.
```

그리고 크롬 콘솔창에서 `app3.seen = false` 를 입력하면 해당 메시지가 사라지는 것을 볼 수 있다.

---

이제 `v-for` 디렉티브는 배열의 데이터를 사용해 항목을 표시하는데 사용할 수 있다.
```
<div id="app-4">
    <ol>
        <li v-for="todo in todos">
            {{ todo.text }}
        </li>
    </ol>
</div>
```
```
var app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            { text : 'JavaScript 배우기' },
            { text : 'Vue 배우기' },
            { text : '너무 어렵다' }
        ]
    }
})
```
```
1. JavaScript 배우기
2. Vue 배우기
3. 너무 여럽다
```

그리고 콘솔에서 `app4.todos.push({ text: 'New item' })` 을 입력하면 목록에 새 항목이 추가된다.