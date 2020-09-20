package com.bank.files;

import java.util.Random;

public class AccountNumberGenerator {
	public static  String generateAccountNumber()
	{
		String numbers = "0123456789";
		Random rndm = new Random();
		String accountNumber = "BNK";
		int i;
		for(i=0;i<4;i++)
		{
			accountNumber += numbers.charAt(rndm.nextInt(numbers.length()));
		}
		return accountNumber;	
	}
}
