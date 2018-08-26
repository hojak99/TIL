# 계산된 속성과 감시자

## 계산된 속성
템플릿 내에서 사용하는 표현식은 매우 편리하지만 단순한 연산에만 사용해야 한다. 너무 많은 로직을 템플릿에 넣으면 유지보수가 어려워질 수 있다.

```
<div id="example">
    {{ message.split('').reverse().join('') }}
</div>
```

뭔가 길고 복잡하다. computed property 를 사용해야 한다고 한다.

---

### 기본 예제
```
<div id="example">
    <p>원본 메시지 : "{{ message }}"</p>
    <p>뒤집히도록 계산된 메시지 : "{{ reverseMessage }}"</p>
</div>
```
```
var vm = new Vue({
    el: '#example',
    data: {
        message : '안녕하세요'
    },
    computed : {
        reversedMessage : function() {
            return this.message.split('').reverse().join('')
        }
    }
})
```
```
원본 메시지 : "안녕하세요"
뒤집히도록 계산된 메시지 : "요세하녕안"
```

여기서 우리는 computed property 인 `reversedMessage` 를 선언했다. 여기서 제공되는 함수는 `vm.reversedMessage` 속성에 대한 getter 함수로 사용된다.

```
console.log(vm.reversedMessage)     // => '요세하녕안'
vm.message = 'Goodbye'
console.log(vm.reversedMessage)     // => 'eybdooG'
```

`vm.reversedMessage` 의 값은 항상 `vm.message` 의 값에 의존한다.

일반 속성처럼 템플릿의 computed property 에 데이터 바인딩을 할 수 있다. Vue 는 `vm.reversedMessage` 가 `vm.message` 에 의존하는 것을 알고 있기 때문에 `vm.message` 가 바뀔 때 `vm.reversedMessage` 에 의존하는 바인딩을 모두 업데이트한다. 