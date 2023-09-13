package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Customer_Details;
import com.nissan.repository.IAdminRepository;

@Service

public class AdminServiceImple implements IAdminService {
	@Autowired 
	private Validation validation;
	
	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private NumberGenerator generator;

	//list all customers
	public List<Customer_Details> getCustomer() {
		// TODO Auto-generated method stub
		return (List<Customer_Details>) adminRepo.findAll();
	}

	//to add customers
		public Customer_Details saveCustomer(Customer_Details customer) {
			customer.setAtmPin(generator.getPin());
			customer.setAccountNo(generator.getAccountNo());
			if(validation.isNameValid(customer.getCustomerName())
//					&&validation.isNumberValid(customer.getMobileNumber())
				&&validation.isAccountValid(String.valueOf(customer.getAccountNo()))) {
				return adminRepo.save(customer);
			}
			return null;
		}

		//delete a customer
		@Transactional
		@Override
		public void deleteCustomer(int accountNo) {
			adminRepo.deleteCustomer(accountNo);
		}
	

		//update customer details
		@Override
		public Customer_Details updateCustomer(Customer_Details customer, Customer_Details customerNew) {
			customer.setMobileNumber(customerNew.getMobileNumber());
			customer.setEmailId(customerNew.getEmailId());
			if(validation.isNameValid(customer.getCustomerName())) {
				return adminRepo.save(customer);
			}
			return adminRepo.save(customer);
		}
		//to get a specific customer
//		public Customer_Details getCustomer(int accountNo) {
//			return adminRepo.findById(accountNo).orElseThrow(()->
//			new RuntimeException("Customer not found for account number"));	
//			}

		@Override
		public Customer_Details getCustomer(int accno) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
