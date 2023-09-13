package com.nissan.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer_Details;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer_Details, Integer>{
	
	
//	//to deposit amount to account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?1 WHERE accNo=?2")
	public void depositAmount(int amount, int accNo);
	
	//to get the balance of user
	@Query("SELECT balance FROM com.nissan.model.Customer WHERE accNo=?1")
	public float getBalance(int accNo);
	
	//to get the minimum balance of an account
	@Query("SELECT minBalance FROM com.nissan.model.Customer WHERE accNo=?1")
	public float getMinBalance(int accNo);
	
	//to withdraw amount from an account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?1 WHERE accNo=?2")
	public void withdraw(int amount, int accNo);

	//to debit money from account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE accNo=?1")
	public void debitFrom(int fromAcc, int amount);
	
	//to credit money into account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE accNo=?1")
	public void creditTo(int toAcc, int amount);
 }
