package com.nissan.model;


import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerDetails")
public class Customer_Details {
	@Id	
	
	private int accountNo;
	
	
	@Column(name="customerName",nullable=false,length=60)
	private String customerName;
	
	@Column(name="accountType",nullable=false,length=60)
	private String accountType;
	
	@Column(name="balance",nullable=false,length=60)
	private long balance;
	
	@Column(name="minimumBalance",nullable=false,length=60)
	private long minimumBalance;

	@Column(name="emailId",nullable=false,length=60)
	private String emailId;

	@Column(name="atmPin",nullable=false,length=60)
	private long atmPin;
	
	
	
	@Column(name="mobileNumber",nullable=false,length=60)
	private long mobileNumber;
	
	
	private boolean isActive=true;




	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	


	

	public Customer_Details() {
	}


	public long getAccountNo() {
		
		return this.accountNo;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(long minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAtmPin() {
		return atmPin;
	}

	


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public void setAtmPin(long atmPin) {
		this.atmPin = atmPin;
	}


	@Override
	public String toString() {
		return "Customer_Details [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType="
				+ accountType + ", balance=" + balance + ", minimumBalance=" + minimumBalance + ", emailId=" + emailId
				+ ", atmPin=" + atmPin + ", mobileNumber=" + mobileNumber + ", isActive=" + isActive + "]";
	}


	


	

	
		
	
	



}
