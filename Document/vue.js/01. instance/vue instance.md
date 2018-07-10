# Vue 인스턴스

## Vue 인스턴스 만들기
모든 Vue 앱은 `Vue` 함수로 새 Vue 인스턴스를 만드는 것부터 시작한다.

```
var vm = new Vue({
    // 옵션
})
```

MVVM 패턴과 관련이 없지만 Vue의 디자인은 부분적으로 그것에 영감을 받았다. 컨벤션으로, Vue 인스턴스를 참조하기 위해 종종 변수 `vm(VieModel 의 약자)` 를 사용한다.

Vue 인스턴스를 인스턴스화 할 때에는 데이터, 템플릿, 마운트할 엘리먼트, 메소드, 라이프사이클 콜백 등의 옵션을 포함할 수 있는 `options 객체`를 전달해야한다. 전체 옵션 목록은 `https://kr.vuejs.org/v2/api/` 여기서 찾을 수 있다.

Vue 생성자는 미리 정의된 옵션으로 재사용 가능한 컴포넌트 생성자를 생성하도록 확장될 수 있다.

Vue 앱은 `new Vue`를 통해 만들어진 `루트 Vue 인스턴스` 로 구성되며 선택적으로 중첩이 가능하고 재사용 가능한 컴포넌트 트리로 구성된다. 예를 들어 Todo 앱의 컴포넌트 트리는 다음과 같다.
```
Root Instance
 - TodoList
    - TodoItem
        - DeleteTodoButton
        - EditTodoButton
    - TodoListFooter
        - ClearTodosButton
        - TodoListStatistics
```

확장된 인스턴스를 만들 수 있으나 대게 템플릿에서 사용자 지정 엘리먼트로 선언적으로 작성하는 것이 좋다고 한다. 지금은 우선 모든 Vue 컴포넌트가 본질적으로 확장된 Vue 인스턴스라는 것을 알아야한다.

---

## 속성과 메소드
각 Vue 인스턴스는 `data` 객체에 있는 모든 속성을 프록시 처리한다.

```
var data = { a : 1 }

// Vue 인스턴스에 데이터 객체를 추가한다.
var vm = new Vue({
    data: data
})

// 같은 객체를 참조
vm.a === data.a;       // => true

vm.a = 2;
data.a      // => 2

data.a = 3;
vm.a // => 3
``` 

데이터가 변경되면 화면은 다시 렌더링 된다. 유의해야 할 점은 data 에 있는 속성들은 인스턴스가 생성될 때 존재하는 것들에만 반응형이라는 것이다. 즉, 다음과 같이 새 속성을 추가하면
```
vm.b = 'hi';
```

`b` 가 변경되어도 화면이 갱신되지 않는다. 어떤 속성이 나중에 필요하다는 것을 알고 있으며, 빈 값이거나 존재하지 않은 상태로 시작한다면 아래와 같이 초기값을 지정할 필요가 있다.

```
data : {
    newTodoText: '',
    visitCount : 0,
    hideCompletedTodos: false,
    todos: [],
    error: null
}
```

여기서 유일한 예외는 `Object.freeze()` 를 사용하는 경우이다. 이는 기존 속성이 변경되는 것을 막아 반은성 시스템이 추적할 수 없다는 것을 의미한다.

```
<div id="app">
    <p>{{ foo }}</p>
    <!-- obj.foo 는 더이상 변하지 않는다 -->
    <button v-on:click="foo = 'baz'">Change it</button>
</div>
```
```
var obj = {
    foo : 'bar'
}

Object.freeze(obj)

new Vue({
    el: '#app',
    data: obj
})
```

Vue 인스턴스는 데이터 속성 이외에도 유용한 인스턴스 속성 및 메소드를 제공한다. 다른 사용자 정의 속성과 구분하기 위해 `$` 접두어를 붙였다.

```
var data = {
    a: 1
}

var vm = new Vue({
    el : '#example',
    data : data
})

vm.$data === data  // => true
vm.$el === document.getElementById('example')   // => true

vm.$watch('a', function(newVal, oldVal) {
    // `vm.a` 가 변경되면 호출된다.
})
```

---

## 인스턴스 라이프사이클 훅
각 Vue 인스턴스는 생성 될 때 일련의 초기화 단계를 거친다. 예를 들어, 데이터 관찰을 설정하고, 템플릿을 컴파일하고, 인스턴스를 DOM에 마운트하고, 데이터가 변경 될 때 DOM을 업데이트해야 한다. 또한 라이프 사이클 훅 (lifecycle hooks)라는 기능을 실행하여 사용자가 특정 단계에서 자신의 코드를 추가 할 수 있는 기회를 제공한다.

예를 들어, `created` 훅은 인스턴스가 생성된 후에 호출된다.
```
new Vue({
    data: {
        a: 1
    },
    created: function() {
        console.log('a is : ' + this.a)
    }
})

// => "a ais : 1"
```

인스턴스 라이프사이클의 여러 단계에서 호출될 다른 훅도 있다. 예를 들어, `mounted`, `updated`, `destroyed` 가 있다.

> options 속성이나 콜백에 `created: () => console.log(this.a)` 나 `vm.$watch('a', newValue => this.myMethod())` 와 같은 화살표 함수 사용을 지양하기 바란다.
> 화살표 함수들은 부모 컨텍스트에 바인딩되기 때문에, `this` 컨텍스트가 호출하는 Vue 인스턴스에서 사용할 경우 `Uncaught TypeError: Cannot read property of undefined`, `Uncaught TypeError: this.myMethod is not a function` 와 같은 오류가 발생하게 된다.