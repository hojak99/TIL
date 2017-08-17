package com.kjh.hojak.ioc_3;

public class TestClient {
	public static void main(String[] args){
		
		CarMaker kia = new KiaMaker();
		
		OrderManager manager = new OrderManager();
		manager.setMaker(kia);
		manager.order();
	}
}
