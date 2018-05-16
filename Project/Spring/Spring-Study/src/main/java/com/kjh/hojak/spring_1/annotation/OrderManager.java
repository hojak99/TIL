package com.kjh.hojak.spring_1.annotation;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 클래스의 용도를 구분하기 쉽게 하기 위해서 @Component 를 확장해서 새로운 애노테이션을 만들었다.
// @Service 사용할 때 id 를 지정하지 않으면 클래스 이름을 id로 사용하며 이 때 id는 소문자로 시작한다 (id : orderMaker)
@Service
public class OrderManager {
	
	@Inject
	@Named("hyndai")
	private CarMaker maker;
	
	// 자료형을 찾아서 주입하며 필드변수, 생성자, 메소드에 사용이 가능
	@Autowired
	public void order(){
		Money money = new Money(1000);
		System.out.println("OrderManager.order : I made " + money.getAmount());
		System.out.println("OrderManager.order : I payed " + money.getAmount());
		
		Car car = maker.sell(money);
		System.out.println("OrderManager.order : I received " + car.getName());
	}
	
	@Resource
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
}
