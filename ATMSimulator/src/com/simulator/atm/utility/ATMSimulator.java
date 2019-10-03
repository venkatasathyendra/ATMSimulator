package com.simulator.atm.utility;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.simulator.atm.pojos.Currency;
import com.simulator.atm.pojos.Transaction;

public class ATMSimulator {

	
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		int inputAction ;
		Date timePeriod = null;
		Scanner menuFlag ;
		String flag = null;
		boolean flagSet = true;
		
		ATMOperationUtility atmOperations = new ATMOperationUtility();
		
		do {
			
			atmOperations.PrintMenuOptions();
			inputAction   =  scanner.nextInt();
			System.out.println(inputAction);
			menuFlag = atmOperations.ATMOperations(inputAction);
			flag = menuFlag.next();
			System.out.println("flag : "+flag);
			if (flag.equalsIgnoreCase("Yes")) {
				flagSet = false;
			}else {
				flagSet = true;
			}
			
		}while (!flagSet) ;
		
		System.out.println("End");
	}
	 

}
