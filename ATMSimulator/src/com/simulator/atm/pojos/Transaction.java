package com.simulator.atm.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
	 private double dollars;
	 private LocalDate tx_date;
	 private String tx_type;
	 private double closing_balance;
	 private double txn_amt;
	 	 

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

	public LocalDate getTx_date() {
		return tx_date;
	}

	public void setTx_date(LocalDate now) {
		this.tx_date = now;
	}

	public double getBalance() {
		return closing_balance;
	}

	public void setBalance(double balance) {
		this.closing_balance = balance;
	}

	public double getTxn_amt() {
		return txn_amt;
	}

	public void setTxn_amt(double txn_amt) {
		this.txn_amt = txn_amt;
	}
	 

}
