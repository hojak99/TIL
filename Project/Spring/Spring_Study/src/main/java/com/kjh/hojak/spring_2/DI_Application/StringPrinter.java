package com.kjh.hojak.spring_2.DI_Application;

public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();
	
	@Override
	public void print(String message) {
		this.buffer.append(message);
	}
	
	@Override
	public String toString() {
		return this.buffer.toString();
	}
}
