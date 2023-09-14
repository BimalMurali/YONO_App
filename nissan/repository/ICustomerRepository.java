package com.nissan.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer_Details;
@Repository
@Component
public interface ICustomerRepository extends CrudRepository<Customer_Details, Integer>{
	
	
//	//to deposit amount to account
	@Modifying
//	@Query("UPDATE com.nissan.model.Customer_Details SET balance=balance+?1 WHERE accountNo=?2")
	@Query("UPDATE Customer_Details a SET a.balance = a.balance + :amount WHERE a.accountNo = :accountNo")
	public void depositAmount(int amount, int accountNo);
	
	//to get the balance of user
	@Query("SELECT balance FROM com.nissan.model.Customer_Details WHERE accountNo=?1")
	public int getBalance(int accountNo);
	
	//to get the minimum balance of an account
	@Query("SELECT minimumBalance FROM com.nissan.model.Customer_Details WHERE accountNo=?1")
	public int getMinBalance(int accountNo);
	
	//to withdraw amount from an account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer_Details SET balance=balance-?1 WHERE accountNo=?2")
	public void withdraw(int amount, int accountNo);

	//to debit money from account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer_Details SET balance=balance-?2 WHERE accountNo=?1")
	public void debitFrom(int fromAcc, int amount);
	
	//to credit money into account
	@Modifying
	@Query("UPDATE com.nissan.model.Customer_Details SET balance=balance+?2 WHERE accountNo=?1")
	public void creditTo(int toAcc, int amount);
 }
