package com.kjh.hojak.spring_1.ioc_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {
	public static void main(String[] args){
		
//		CarMaker kia = new KiaMaker();
//		
//		OrderManager manager = new OrderManager();
//		manager.setMaker(kia);
//		manager.order();
		
		// ClassPathXmlApplication 의 기본 경로는 "src/main/resources" 경로이다. 
		ApplicationContext context = new ClassPathXmlApplicationContext("car-context.xml");
		
		// manager 라는 id 를 가진 Bean 을 얻어온다.
		OrderManager manager = context.getBean("manager", OrderManager.class);
		manager.order();
	}
}
