# Creating and Destroying Objects
객체의 생성과 삭제에 대해 살펴본다.


## 생성자 대신 정적 팩토리 메소드를 사용할 수 없는지 생각해보자

> 정적 팩토리 메소드 : 객체 생성을 캡슐화하는 기법. 객체를 생성하는 메소드를 만들고, static 으로 선언하는 기법이다. 그 예로 `valueOf` 메소드를 들 수 있다.

```
public static Boolean valueOf(boolean b) {
    // 삼항연산자
    return b ? Boolean.TRUE : Boolean.FALSE;
}

// 이렇게 반한된 Boolean 객체는 == 로 비교할 수 있다.
```

#### 장점
- 생성자와 달리 정적 팩토리 메소드에는 이름이 있음 (가독성 높아짐)
- 생성자와 달리 호출할 때마다 새로운 객체를 생성할 필요 없음
- 생성자와 달리 하위 자료형 객체를 반환할 수 있음
- 형인자 자료형 객체를 만들 때 편하다

#### 단점
- public, protected 로 선언된 생성자 없어서 하위 클래스를 못 만듦
- 다른 정적 메소드와 확연히 구분되지 않음

> 형인자 자료형 객체는 다음을 말한다. `Map<String, List<String>> m = new HashMap<String, List<String>();` 여기서 형인자를 연달아 두 번 사용하는데 Jdk 1.7 부터는 생성자를 호출할 때도 자료형 유추가 가능해서 정적 펙토림 메소드를 추가할 필요가 없어졌다.


- `valueOf` : 인자로 주어진 값과 같은 값을 갖는 객체를 반환. 형변환 메소드라고 한다
- `of` : `valueOf` 를 더 간단하게 쓴 것. EnumSet 덕분에 인기를 모음 이름
- `getInstance` : 인자에 기술된 객체를 반환하지만 같은 값을 갖지 않을 수도 있음. 싱글톤일 경우 인자없이 항상 같은 객체 반환
- `newInstance` : getInstance 와 같지만 호출할 때마다 다른 객체 반환
- `getType` : getInstance 와 같지만 반환될 객체의 클래스와 다른 클래스에 팩토리 메소드가 있을 때 사용. `Type` 은 팩토리 메소드가 반환할 객체의 자료형
- `newType` : `newInstance` 와 같지만, 반환될 객체의 클래스와 다른 클래스에 팩토리 메소드가 있을 때 사용. `Type` 은 팩토리 메소드가 반환할 객체의 자료형


> 검색해보니 정적 팩토리 메소드에 대해 비판적인 의견도 있다.  
> https://dzone.com/articles/constructors-or-static-factory-methods
---
