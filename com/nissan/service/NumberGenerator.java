package com.nissan.service;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
	
		// to generate the account number
		public int getAccountNo() {
			Random random = new Random();
			return (int) (100000000L + (long) (random.nextDouble() * 900000000L));
		}

		//to generate the pin
		public int getPin() {
			 return (int) (Math.random() * 9000) + 1000;
		}
	}



