package com.kjh.hojak.spring_1.ioc_1;

public class OrderManager {
	private HyundaiMaker maker;
	
	public OrderManager(){
		maker = new HyundaiMaker();
	}
	
	public void order(){
		Money money = new Money(1000);
		System.out.println("OrderManager.order : I made " + money.getAmount());
		System.out.println("OrderManager.order : I payed " + money.getAmount());
		
		Car car = maker.sell(money);
		System.out.println("OrderManager.order : I received " + car.getName());
	}
}
