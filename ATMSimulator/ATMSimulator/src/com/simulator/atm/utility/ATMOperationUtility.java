package com.simulator.atm.utility;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.simulator.atm.ATMInterface;
import com.simulator.atm.pojos.Currency;
import com.simulator.atm.pojos.Transaction;

public class ATMOperationUtility implements ATMInterface {
	
	Currency currency = new Currency();
	
	static double closingBal = 0;
	public List<Transaction> txnLst = new ArrayList<Transaction>();
	
	int denominations[] = {50,20,20,20,10};
	
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
		
	   closingBal = closingBal + curr;
	   System.out.println("Available balance post deposit is : "+closingBal);
		return closingBal;
	}

	@Override
	public double withdraw(double curr) {
		
		closingBal = closingBal - curr;
		currency.setBalance(closingBal);
		if (closingBal <= 0) {
			System.out.println("Available Balance is Less than 0 - Please deposit amount");
		}
		//System.out.println("Available balance post withdraw is : "+currency.getBalance());
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
				System.out.println(tx.getTx_date() +"     |       " + tx.getTx_type() +"        |       "+ tx.getDollars() + "       |       " +tx.getBalance());
			}
		}
		
		return null;
	}

	@Override
	public double balance() {
		System.out.println("Available Balance is : "+closingBal);
		return closingBal;
	}
	
	public Scanner ATMOperations(int action) {
		
		Scanner scanner = new Scanner(System.in);
		Date timePeriod = null;
		double curr = 0 ;
		int notes = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDate now = LocalDate.now();  
		Transaction txn = new Transaction();
		int[] denominations = {10,20,20,50}; 
		 
		ATMOperationUtility atmOperations = new ATMOperationUtility();
		switch (action) 
		{
		
			case 1 : 
				System.out.println("Enter the amount which you wanted to Deposit : ");
				
				String nt = scanner.nextLine();
				System.out.println(nt);
				
				StringTokenizer st = new StringTokenizer(nt," ");
				List dollar_notes = new ArrayList();
				int i =0;
				
				while (st.hasMoreElements()) {
					String notesEntered =  st.nextToken();
					int digital_note = Integer.parseInt(notesEntered);
					dollar_notes.add(digital_note);
				}
				
				List lst = Arrays.asList(denominations); 
				
				for (Object key:dollar_notes) {
					System.out.println("Accepted :"+key);
					int keyElement = (int) key;
					notes = notes + keyElement;
					
					
				}
				System.out.println("Deposited Amount  :="+ notes);
				curr = atmOperations.deposit(notes);
				txn.setBalance(closingBal);
				txn.setTxn_amt(curr);
				txn.setDollars(notes);
				txn.setTx_type("Deposit");
				txn.setTx_date(now);
				txnLst.add(txn);
				//scanner.close();
				System.out.println("Closing Balance: after deposit :"+closingBal);
				break;
				
			case 2: 
				System.out.println("Enter the amount to withdraw  : ");
				notes = scanner.nextInt();
				curr = atmOperations.withdraw(notes);
				
				txn.setBalance(closingBal);
				txn.setTxn_amt(curr);
				txn.setDollars(notes);
				txn.setTx_type("Withdraw");
				txn.setTx_date(now);
				txnLst.add(txn);
				
				System.out.println("Closing Balance: after Withdraw :"+closingBal);
				
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
		
		System.out.println("Would you like to go back to Main Menu then Enter - Yes/No");
		scanner = new Scanner(System.in);
		
		return scanner;
	}
	
	

	
}
