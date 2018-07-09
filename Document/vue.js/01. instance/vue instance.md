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