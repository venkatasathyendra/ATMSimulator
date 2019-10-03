package com.simulator.atm.pojos;

import java.util.Date;

public class Transaction {
	 private double dollars;
	 private Date tx_date;
	 private String tx_type;
	 private double closing_balance;
	 	 

	public double getDollars() {
		return dollars;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	public String getTx_type() {
		return tx_type;
	}

	public void setTx_type(String tx_type) {
		this.tx_type = tx_type;
	}

	public Date getTx_date() {
		return tx_date;
	}

	public void setTx_date(Date tx_date) {
		this.tx_date = tx_date;
	}

	public double getBalance() {
		return closing_balance;
	}

	public void setBalance(double balance) {
		this.closing_balance = balance;
	}
	 

}
