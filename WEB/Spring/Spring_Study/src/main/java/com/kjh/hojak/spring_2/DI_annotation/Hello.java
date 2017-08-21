package com.kjh.hojak.spring_2.DI_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("Spring")
	String name;
	
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	public Hello(){
		
	}
	
	public void print(){
		this.printer.print(sayHello());
	}
	
	public String getName() {
		return name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public String sayHello() {
		return "Hello " +name;
	}
	
//	public void setPrinter(Printer printer) {
//		this.printer = printer;
//	}
}
