package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtil;

@RestController //@Controller+@Configuration
@RequestMapping("/api")

public class CustomerController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtutil;
		

		
		//to deposit money
//		@PutMapping("/deposit/{amount}&{accountNo}")
		public void depositMoney(@PathVariable int amount, @PathVariable int accountNo,
				@RequestHeader(value="authorization",defaultValue="")String auth)
				throws AccessDeniedException { 
			jwtutil.verify(auth);
			customerService.depositMoney(amount,accountNo);
		}
		
	
		
		
		//to withdraw money
		@PutMapping("/withdraw/{withdrawAmount}&{accountNo}")
		public void withdrawMoney(@PathVariable int withdrawAmount, @PathVariable int accountNo,
				@RequestHeader(value="authorization",defaultValue="")String auth)
				throws AccessDeniedException  {
			jwtutil.verify(auth);
			customerService.withDraw(withdrawAmount, accountNo);
		}
		
		//to check balance
		@GetMapping("/balance/{accountNo}")
		public float getBalance(@PathVariable int accountNo, 
				@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException   {
			jwtutil.verify(auth);
			return customerService.showBalance(accountNo);
		}
		
		//transfer
		@GetMapping("/transfer/{fromAcc}&{toAcc}&{amount}")
		public void transfer(@PathVariable int fromAcc, @PathVariable int toAcc, @PathVariable int amount,
				@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException  {
			jwtutil.verify(auth);
			customerService.transerMoney(fromAcc, toAcc, amount); 
		}
	

}
