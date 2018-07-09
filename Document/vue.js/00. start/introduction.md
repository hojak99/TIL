# Vue.js 란?
프론트엔드 자바스크립트 프레임워크이다. Vue.js 는 View 에만 초점을 두기 때문에 다른 라이브러리와 프레임워크와 혼용하기 쉽다고 한다. 

Vue.js 를 불러오기 위해선 Vue.js 에서 제공하는 CDN 주소에서 unpkg 에서 제공하는 링크를 사용하면 된다.

```
<script src="https://unpkg.com/vue"></script>
```

## 선언적 렌더링
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

## 조건문과 반복문
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

---

## 사용자 입력 핸들링
사용자가 앱과 상호 작용할 수 있게 `v-on` 디렉티브를 사용하여 Vue 인스턴스에 메소드를 호출하는 이벤트 리스너를 달 수 있다.

```
<div id="app-5">
    <p>{{ message }}</p>
    <button v-on:click="reverseMessage">메세지 뒤집기</button>
</div>
```
```
var app5 = new Vue({
    el: '#app-5',
    data: {
        message : '안녕하세요를레히후'
    },
    methods: {
        reverseMessage: function(){ 
            this.message = this.message.split('').reverse().join('')
        }
    }
})
```
```
// 버튼 클릭 전
안녕하세요를레히후
[메세지 뒤집기]
```
```
// 버튼 클릭 후
후히레를요세하녕안
[메세지 뒤집기]
```

다음과 같이 동작을 한다. 매번 버튼을 누를 때마다 뒤집는다고 생각하면 된다.

---

다음 메소드는 단순히 DOM 을 건드리지 않고 앱의 상태를 업데이트 한다. 모든 DOM 조작은 Vue 에 의해 처리되며 작성한 코드는 기본 로직에만 초점을 둔다.

Vue 는 또한 양식에 대한 입력과 앱 상태를 양방향으로 바인딩하는 `v-model` 디렉티브를 제공한다.

```
<div id="app-6">
    <p>{{ message }}</p>
    <input v-model="message">
</div>
```
```
var app6 = new Vue({
    el: '#app-6',
    data: {
        message : '안녕하세요vue!'
    }
})
```
```
안녕하세요vue!
[안녕하세요vue!] 

// input 창에 입력한 대로 출력된다
```

---

## 컴포넌트를 사용한 작성방법
컴포넌트 시스템은 Vue 의 또다른 중요한 개념이다. 이는 작고 그 자체로 제 기능을 하며 재사용할 수 있는 컴포넌트로 구성된 대규모 응용 프로그램을 구축할 수 있게 해주는 추상적 개념이다. (거의 모든 유형의 응용 프로그램 인터페이스를 컴포넌트 트리로 추상화할 수 있다)

Vue 에서 컴포넌트는 본질적으로 미리 정의된 옵션을 가진 Vue 인스턴스다. Vue 에서 컴포넌트를 등록하는 방법은 간단하다.
```
// todo-item 이라는 이름을 가진 컴포넌트를 정의
Vue.component('todo-item', {
    template: '<li>할 일 항목 하나입니다.</li>'
})
```

이제 다른 컴포넌트의 템플릿에서 이 컴포넌트를 사용할 수 있다.

```
<ol>
    <!-- todo-item 컴포넌트의 인스턴스 만들기 -->
    <todo-item></todo-item>
</ol>
```

그러나 이는 모든 todo-item 인스턴스에 똑같은 내뇽을 렌더링 할 것이다. 부모 영역의 데이터를 자식 컴포넌트에 집어넣을 수 있도록 `prop` 이란 것을 전달 받을 수 있도록 todo-item 컴포넌트를 수정해보도록 하겠다.

```
Vue.component('todo-item', {
    // 이제 todo-item 컴포넌트는 'prop' 이라고 하는 
    // 사용자 정의 속성 같은 것을 입력받을 수 있다.
    // 이 prop 은 todo 라는 이름으로 정의했다.
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})
```

이제 이 todo를 `v-bind` 를 사용하여 각각의 반복되는 컴포넌트에 전달 할 수 있다.

```
<div id="app-7">
    <ol>
        <!--
            이제 각 todo-item 에 todo 객체를 제공한다.
            화면에 나오므로, 각 항목의 컨텐츠는 동적으로 바귈 수 있다.
            또한 각 구성 요소에 '키'를 제공해야 한다
        -->
        <todo-item
            v-for="item in groceryList"
            v-bind:todo="item"
            v-bind:key="item.id">
        </todo-item>
    </ol>
</div>
```
```
Vue.component('todo-item', {
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})

var app7 = new Vue({
    el: '#app-7',
    data: {
        groceryList : [
            { id: 0, text: 'Vegetables' },
            { id: 1, text: 'Cheese' },
            { id: 2, text: 'Whatever else humans are supposed to eat' }
        ]
    }
})
```

위의 예제는 인위적이지만 실제 앱을 개발할 때에는 다음과 같이 컴포넌트를 사용할 수 있다.

```
<div id="app">
    <app-nav></app-nav>
    <app-view>
        <app-sidebar></app-sidebar>
        <app-content></app-content>
    </app-vie>
</div>
```