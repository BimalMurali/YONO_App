package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer_Details;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;

@RestController //@Controller+@Configuration
@RequestMapping("/api")

public class AdminController {
	
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtutil;

	
	//Adding customer
		@PostMapping("/customer")
		public ResponseEntity<APIResponse> addEmployee(@RequestBody Customer_Details customer,
				@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException{
//			jwtutil.verifyAdmin(auth);
			if(adminService.saveCustomer(customer)==null) {
					apiResponse.setData("Name can have only alphabets!!");
					apiResponse.setStatus(500);
					apiResponse.setError("Invalid Name");
					
					return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
			}
			apiResponse.setData("Customer added successfully");
			apiResponse.setStatus(200);
			
			return ResponseEntity
					.status(apiResponse.getStatus()).body(apiResponse);
			
		}
		//listing customers
		@GetMapping("/customer")
		public List<Customer_Details> getCustomers(@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException{
//			jwtutil.verifyAdmin(auth);
			return adminService.getCustomer();
		}
		
		//updating customer details
		@PutMapping("/customer/{accountNo}")
		public void updateCustomer(@PathVariable int accountNo, @RequestBody Customer_Details customer, 
				@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
//			jwtutil.verifyAdmin(auth);
			adminService.updateCustomer(adminService.getCustomer(accountNo),customer);
		}
		
		//deleting a customer
		@GetMapping("/customer/{accountNo}")
		public void deleteCustomer(@PathVariable int accountNo, @RequestHeader(value="authorization",defaultValue="")String auth)
				throws AccessDeniedException {
//			jwtutil.verifyAdmin(auth);
			adminService.deleteCustomer(accountNo);
		}
		
		//specific customer
//		@GetMapping("/findcustomer/{accno}")
//		public Customer_Details getOneCustomer(@PathVariable int accno, @RequestHeader(value="authorization",defaultValue="")String auth)
//				throws AccessDeniedException {
////			jwtutil.verifyAdmin(auth);
//			return adminService.getCustomer(accno);
//		}
	
}
