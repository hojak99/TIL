package com.kjh.hojak.spring_2.DI_annotation;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinter implements Printer{
	@Override
	public void print(String message) {
			System.out.println(message);
	}
}
