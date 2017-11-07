## Closer 
``클로저는 외부함수에 있는 변수에 접근할 수 있는 내부함수를 말함.``

간단하게 클로저는 이런 것이다~ 라고 할 수 있는 코드는 다음과 같다.

<pre><code>
function init() {  
    var name = "hojak";         // name 은 init 에 의해 생성된 지역변수
    function displayName() {    // displayName()은 내부함수이며 클로저이다
        alert(name);            // 외부함수에서 선언된 변수를 사용한다
    }
    displayName();
}
init();
</code></pre>

init() 함수를 보면 displayName() 함수에서 init() 함수의 지역변수인 name 을 사용하고 있다. 내부 함수는 외부 함수에 접근할 권한을 가지고 있기 때문에 displayName() 함수는 외부 함수인 init() 에서 선언한 name 변수에 접근할 수 있는 것이다. 

이제 다음과 같은 예제를 보자.
<pre><code>
function makeFunc() {
    var name = "hojak";
    function displayName() {
        alert(name);
    }
    return displayName;
}

var myFunc = makeFunc();
myFunc();
</code></pre>

이 코드에서는 동작하는 코드이다. 우선, 몇몇 프로그래밍 언어에서는 함수 안의 지역 변수들은 그 함수가 수행되는 기간동안에만 존재한다. 그래서 makeFunc() 함수가 실행이 끝나면 name 변수에 더 이상 접근할 수 없게 될 줄 알았지만 코드는 정상적으로 hojak 을 alert 를 띄운다.

이 이유는 자바스크립트의 함수가 클로저를 형성하기 때문인데, 위와 같은 환경에서는 클로저가 생성된 시점의 범위 내에 있는 모든 지역 변수로 구성된다. 

이렇게 makeFunc() 함수를 호출해 displayName() 함수를 반환 받은 myFunc 이 잘 작동되는 이유는, myFunc는 makeFunc가 실행될 때 생성된 displayName 함수의 인스턴스에 대한 참조이기 때문이라고 한다. 솔직히 나도 알듯 말듯 하다.

---

위에서 봤던 코드의 개념에 대해서 좀 더 알아보는 코드이다.
<pre><code>
function makeAdder(x) {
    return function(y) {
        return x+y;
    };
}

var add5 = makeAdder(5);        // 클로저
var add10 = makeAdder(10);      // 클로저

console.log(add5(2));           // 7
console.log(add10(2));          // 12
</code></pre>

다음과 같이 '7'과 '12'가 출력이 될 것이다. 

> 위의 코드에서 <code>console.log(add5);</code>이렇게 하면 어떻게 출력을 할까? 란 궁금증이 생겼다. 직접 해보았는데 'NaN' 을 출력한다.
---

다른 내용들도 더 있다.
- 클로저를 이용해서 private 메소드 흉내내기


하지만 여기까지 하겠다.
<br><br>
<br><br>
> 출처 : MDN web docs - closer