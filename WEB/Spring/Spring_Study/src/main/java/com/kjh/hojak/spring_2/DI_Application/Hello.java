package com.kjh.hojak.spring_2.DI_Application;

public class Hello {
	String name;
	Printer printer;
	
	public Hello(){
		
	}
	
	public void print(){
		this.printer.print(sayHello());
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String sayHello() {
		return "Hello " +name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
