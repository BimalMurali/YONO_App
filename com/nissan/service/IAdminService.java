package com.nissan.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nissan.model.Customer_Details;


@Component
public interface IAdminService {
	
	
	    //display all customer details
		public List<Customer_Details>getCustomer();
		
		//adding new customer
		public Customer_Details saveCustomer(Customer_Details customer);
		
		//udpating customer details
		public Customer_Details updateCustomer(Customer_Details customer,Customer_Details customerNew);
		
		//deleting customer details
		public void deleteCustomer(int acc_No);
		
		//display specific customer details
		public Customer_Details getCustomer(int accno);
		
	

}
