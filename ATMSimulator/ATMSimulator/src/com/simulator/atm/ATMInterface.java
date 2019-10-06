package com.simulator.atm;

import java.util.Date;
import java.util.List;

import com.simulator.atm.pojos.Currency;
import com.simulator.atm.pojos.Transaction;

public interface ATMInterface {
	
	public double withdraw(double curr);
	public double balance();
	public List<Transaction> min_statement(List<Transaction> lst, Date timePeriod);
	double deposit(double curr);
	
	
}
