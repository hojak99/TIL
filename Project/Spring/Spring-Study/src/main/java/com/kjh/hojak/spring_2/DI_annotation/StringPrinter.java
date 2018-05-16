package com.kjh.hojak.spring_2.DI_annotation;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
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
