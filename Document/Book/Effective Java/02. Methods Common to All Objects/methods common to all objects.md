#모든 객체의 공통 메소드

Object 는 기본적으로는 계승해서 사용하도록 설계된 클래스이다. Object 에서 정의된 비-final 메소드는 `equals`, `hashCode`, `toString`, `clone`, `finalize` 에는 명시적인 일반 규약을 따라야 한다.


### equals 를 재정의할 때는 일반 규약을 따르라
equals 메소드를 재정의할 때 문제를 피하는 방법은 그냥 재정의 하지 않는 것이다. 다음과 같은 조건일 때는 재정의 하지 않아도 된다.

- 각각의 객체가 고유하다.
- 클래스에 "논리적 동일성" 검사 방법이 있건 없건 상관없다.
- 상위 클래스에서 재정의한 equals 가 하위 클래스에서 사용하기에도 적당하다.
- 클래스가 private 또는 package-private 로 선언되었고, equals 메소드를 호출할 일이 없다.

---

그렇다면 언제 Object.equals 를 재정의하는 것이 바람직할까?

- 객체 동일성이 아닌 논리적 동일성의 개념을 지원하는 클래스일 때
- 상위 클래스의 equals 가 하위 클래스의 필요를 충족하지 못할 때

---

그렇다면 위에서 말한 일반 규약이란 어떤 것이 있을까?

equals 메소드는 동치 관계를 구현하는데 다음과 같은 관계를 동치 관계라 한다.

- 반사성(reflexive) : null 이 아닌 참조 x 가 있을 때, x.equals(x) 는 true 를 반환한다.

- 대칭성(symmetric) : null 이 아닌 참조 x, y 가 있을 때, x.equals(y) 는 y.equlas(x) 가 true 일 때만 true 를 반환한다.

- 추이성(transitive) : null 이 아닌 참조 x, y, z 가 있을 때 x.equals(y)가 true 이고 y.equals(z) 가 true 이면 x.equals(z) 도 true 이다.

- 일관성(consistent) : null 이 아닌 참조 x 와 y가 있을 때, equals 를 통해 비교되는 정보에 아무 변화가 없다면, x.equals(y) 호출 결과는 호출 횟수에 상관없이 항상 같아야 한다.

- null 이 아닌 참조 x 에 대해서, x.equals(null) 은 항상 false 이다.

---

이 위의 equals 규약에 대해서 알아보았으니 조금 더 자세히 알아보자.

- 반사성(Reflexivity): 모든 객체는 자기 자신과 같아야 한다.
- 대칭성(Summetry): 두 객체에게 서로 같은지 물으면 같은 답이 나와야 한다.

```
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveSting(String s) {
        if(s == null)
            throw new NullPointException();

        this.s = s;
    }

    // 대칭성
    @Override 
    public boolean equals(Object o) {
        if(o instanceof CaseInsensitiveString) 
            return s.equalsIgnoreCase(
                ((CaseInsensitiveString) o).s);
            
        if(o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }
    ...
}
```

cis.equals(s) 는 true 지만, CaseInsensitiveString 의 equals 메소드는 String 객체에 대해 알지만 String 의 equals 는 CaseInsensitiveString 이 뭔지 몰라 s.equals(cis) 는 false 를 반환해 대칭성이 깨진다.

> equals 가 따라야 할 규약을 어기면, 그 객체를 만난 다른 객체들이 어떻게 행동할지 예측할 수 없게 된다.