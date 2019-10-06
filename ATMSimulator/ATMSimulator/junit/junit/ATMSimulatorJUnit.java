package com.simulator.atm.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.simulator.atm.utility.ATMOperationUtility;
import com.simulator.atm.utility.ATMSimulator;

public class ATMSimulatorJUnit {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		@Test
	    public void negativeBalances() throws Exception {
			ATMOperationUtility wrongNotes = new ATMOperationUtility();
			result = wrongNotes.deposit(60);
	        assertThat(result, is(5L));
	    }
		
		@Test
		public void wrongCurrencyNotes() throws Exception {
			ATMOperationUtility negativeBalances = new ATMOperationUtility();
			result = negativeBalances.withdraw(200);
	        assertThat(result, is(5L));
		}	
		
	}

}
