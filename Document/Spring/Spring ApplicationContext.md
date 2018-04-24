# Spring ApplicationContext

> `ApplicationContext` 는 어플리케이션에 설정 정보를 제공하기 위한 Spring 어플리케이션의 주요 인터페이스이다. 런타임 시 읽기 전용이지만 필요에 따라 다시 로드할 수 있으며 응용 프로그램을 지원할 수 있다. 많은 클래스가 `ApplicationContext` 인터페이스를 구현하여 다양한 구성 옵션과 어플리케이션 유형들을 허용한다.   
출처 : Spring Document

그리고 `ApplicationContext` 는 다음을 제공한다고 한다.
- 어플리케이션 컴포넌트에 접근하기 위한 Bean factory 메소드
- 파일 리소스를 일반적인 방식으로 로드하는 기능
- 등록된 리스너에게 이벤트를 게시하는 기능
- internationalization(국제화)를 지원해 메시지를 해결할 수 있는 기능
- 상위 컨텍스트로부터의 상속

여기서 `국제화를 지원해 메시지를 해결할 수 있는 기능` 은 사용자에 따른 지역적인 부분을 이야기하는 것 같다. 그 예로 언어가 될 수 있다.

> 참고로 대부분의 경우 개발자는 application context에 직접 접근할 필요가 없다고 한다.


### Access the application context
application context 에 대한 reference 를 얻기 위한 몇 가지 방법이 있다. 다음 예제와 같이 `ApplicationContextAware` 를 구현할 수 있다.
```
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class A implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
```

field injection 과 같은 다른 옵션들이 있지만, 이 기술은 이슈가 생기는 것을 잘 피할 수 있다.

application context 를 사용하여 bean 을 찾기 전에, 더 나은 기술을 먼저 사용한다.
```
@SpringBootApplication
public class Application {

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}
	...
}
```

위의 코드에서 bean 정의하는 곳에 두 개의 인자인. `RedisConnectionFactory` 와 `MessageListenerAdapter` 가 있다. 이 메소드는 필요성을 표성하고 Spring의 DI 컨테이너를 사용 가능한 것으로 가정하여 이를 제공한다. 하지만 ApplicationContext의 인스턴스와 직접 fetch를 할 수 있지만 이러한 솔루션은 Container API 에 너무 무거우며 , 필요하지는 않다.
