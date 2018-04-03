package com.kjh.hojak.spring_2.DI_annotation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:annot.xml")
public class HelloBeanAnnotTest {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void test(){
		Hello hello = context.getBean("hello", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
		
		System.out.println(hello.sayHello());
	}

}
