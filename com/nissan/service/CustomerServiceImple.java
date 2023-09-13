package com.nissan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.repository.ICustomerRepository;

@Service

public class CustomerServiceImple implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepo;
	@Transactional

	@Override
	public void depositMoney(int amount, int accountNo) {
		// TODO Auto-generated method stub
		if(amount<50000)
			customerRepo.depositAmount(amount, accountNo);
		
	}
	@Transactional
	@Override
	public void withDraw(int withdrawAmount, int accountNo) {
		float bal = customerRepo.getBalance(accountNo);
		float minBal =  customerRepo.getMinBalance(accountNo);
		if(bal-minBal>withdrawAmount)
			customerRepo.withdraw(withdrawAmount, accountNo);	
	}
		

	@Override
	public int showBalance(int accountNo) {
		return (int) customerRepo.getBalance(accountNo);
	}

	@Override
	@Transactional
	public void transerMoney(int fromAcc, int toAcc, int amount) {
		float bal = customerRepo.getBalance(fromAcc);
		float minBal =  customerRepo.getMinBalance(fromAcc);
		if(bal-minBal>amount) {
			customerRepo.debitFrom(fromAcc, amount);
			customerRepo.creditTo(toAcc, amount);
		}
	}
		
	


}
