package com.simulator.atm.utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.simulator.atm.ATMInterface;
import com.simulator.atm.pojos.Currency;
import com.simulator.atm.pojos.Transaction;

public class ATMOperationUtility implements ATMInterface {
	
	Currency currency = new Currency();
	Transaction txn = new Transaction();
	double closingBal = 0;
	public List<Transaction> txnLst;
	
	public void PrintMenuOptions() {
		
		System.out.println(" ATM - Simulator - Choose the options");
		System.out.println("---------------------------------------------------------");
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Display Balance");
		System.out.println("4.Mini Statement");
		System.out.println("5.Exit");
		System.out.println("----------Select the Option from the Menu above-------------  ");
	}
	

	
	public Transaction txn_record(Transaction tx){
		return null;
	}
	
	@Override
	public double deposit(double curr) {
		
	    currency.setBalance(curr);
		System.out.println("Available balance post deposit is : "+currency.getBalance());
		
		return currency.getBalance();
	}

	@Override
	public double withdraw(double curr) {
		
		closingBal = currency.getBalance() - curr;
		
		System.out.println("curr bal in withdraw"+currency.getBalance());
		System.out.println("with draw amt : "+closingBal);
		currency.setBalance(closingBal);
		System.out.println("Available balance post withdraw is : "+currency.getBalance());
		return closingBal;
	}

	@Override
	public List<Transaction> min_statement(List<Transaction> lst, Date timePeriod) {
		System.out.println("------------------------Mini Statement---------------------------------");
		System.out.println("Date Time    |     Transaction Date   |    Amount    |   Closing-Balance");
		System.out.println("------------------------------------------------------------------------");
		if (lst == null) {
			System.out.println(" Nothing");
		}else 
		{
			for (Transaction tx : lst) {
				System.out.println(tx.getTx_date() + tx.getTx_type() + tx.getBalance() );
			}
		}
		
		return null;
	}

	@Override
	public double balance() {
		System.out.println("Available Balance is : "+currency.getBalance());
		return currency.getBalance();
	}
	
	public Scanner ATMOperations(int action) {
		
		Scanner scanner = new Scanner(System.in);
		Date timePeriod = null;
		double curr = 0 ;
		double notes = 0;
			
		ATMOperationUtility atmOperations = new ATMOperationUtility();
		switch (action) 
		{
		
			case 1 : 
				System.out.println("Enter the amount which you wanted to Deposit : ");
				notes = scanner.nextDouble();
				if (notes == 0.0)
				{
					System.out.println("0.0 not accepted for Deposit; Please enter valid amount");
					break;
				}
				
				curr = atmOperations.deposit(notes);
				currency.setBalance(curr);

//				txn.setBalance(curr);
//				txn.setDollars(notes);
//				txn.setTx_type("Deposit");
//				txn.setTx_date(new Date("12/09/2019"));
//				txnLst.add(txn);
				
				break;
				
			case 2: 
				System.out.println("Enter the amount to withdraw  : ");
				notes = scanner.nextDouble();
				curr = atmOperations.withdraw(notes);
				currency.setBalance(curr);
//				txn.setBalance(curr);
//				txn.setDollars(notes);
//				txn.setTx_type("Withdraw");
//				txn.setTx_date(new Date());
//				txnLst.add(txn);
				
				break;
			case 3: 
				atmOperations.balance();
				break;
			case 4 : 
				atmOperations.min_statement(txnLst, timePeriod);
				break;
				
			default:
				System.out.println("Would you like to go back to Main Menu - Y/N");
				scanner = new Scanner(System.in);
				 
		}
		
		System.out.println("Would you like to go back to Main Menu - Y/N");
		scanner = new Scanner(System.in);
		
		return scanner;
	}
	
	

	
}
