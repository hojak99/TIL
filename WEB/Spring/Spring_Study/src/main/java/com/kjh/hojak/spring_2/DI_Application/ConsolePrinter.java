package com.kjh.hojak.spring_2.DI_Application;

public class ConsolePrinter implements Printer{
	@Override
	public void print(String message) {
			System.out.println(message);
	}
}
