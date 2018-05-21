package com.kjh.hojak.spring_1.ioc_3;

public class KiaMaker implements CarMaker {
	
	@Override
	public Car sell(Money money) {
		System.out.println("KiaMaker.sell : I got " + money.getAmount());
		
		Car car = new Car("Pride");
		System.out.println("KiaMaker.sell : I made " + car.getName());
		System.out.println("KiaMaker.sell : I sold " + car.getName());
		
		return car;
	}
}