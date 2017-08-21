package com.kjh.hojak.spring_1.annotation;


/**
 *	Mutable Class : 상태 값이 변경되는 클래스로, 일반적으로 Bean에 등록하지 않고 사용한다.
 */
public class Money {
	private int amount;
	
	public Money(){
		
	}
	
	public Money(int amount){
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
