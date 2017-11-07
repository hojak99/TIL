## String

String 을 생성하는 방법으로 2가지가 존재한다.
<pre><code>
String str = "hojak";
String str2 = new String("hojak");

System.out.println(str);        // hojak
System.out.println(str2);       // hojak
</code></pre>

각각의 생성 방식의 차이는 무엇일까?

먼저, 이 두 가지 차이점을 알기 위해서는 메모리 관점에서 보아야 할 것 같다.   

간단하게 설명하자면   
<code>String str = "hojak";</code> 는 Heap 내의 String constant pool 이란 곳에 저장한다. 또한, 이미 존재하는 문자열이 있을 경우 그 저장된 배열의 인덱스 번호를 가리키게 되어 있다.  
<code>String str2 = new String("hojak);</code> 은 일반적인 객체 생성과 같다. 그래서 Heap 내에 해당 객체의 레퍼런스 주소를 가지고 있다. 

다음의 코드를 보며 좀 더 이해하도록 하자.
<pre><code>
String str = "hojak";
String str2 = "hojak";

String str3 = new String("hojak");
String str4 = new String("hojak");

System.out.println(str == str2);	// true
System.out.println(str == str3);	// false
System.out.println(str3 == str4);	// false
</code></pre>

---

여기서 이제 equals, == 를 차이를 알아야 한다.

위와 같은 코드에서도 알 수 있듯이,   
== 는 객체의 주소값을 비교하는 것이고, equals 는 객체의 값을 비교하는 것이다. 

보통 나는 객체의 값을 비교하기 때문에 equals 를 많이 사용한다.