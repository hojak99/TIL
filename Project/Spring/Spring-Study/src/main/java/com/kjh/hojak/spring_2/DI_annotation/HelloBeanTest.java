package com.kjh.hojak.spring_2.DI_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:/beans.xml");
		
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		Printer printer = (Printer) context.getBean("stringPrinter");
		System.out.println(printer.toString());
		
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		
		System.out.println(hello == hello2);
	}

}
