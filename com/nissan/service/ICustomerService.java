package com.nissan.service;

import org.springframework.stereotype.Component;

@Component
public interface ICustomerService {
	
	//method for depositing money
	public  void depositMoney(int amount,int acc_No);
	
	//method for withdraw money
	public void withDraw(int withdrawAmount, int acc_No);
	
	//method for showing balance
	public int showBalance(int acc_No);
	
	//method for transerfing money from one account to another
	public void transerMoney(int fromAcc, int toAcc, int amount);
	
	
}
