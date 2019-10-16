package account;

import java.math.BigDecimal;

import operations.BankOperations;

public  class ImplementsCashBack implements BankOperations{
	
	 public static final String CASHBACK_PERCENT = "0.01";	
	 public static final ImplementsCashBack CASHBACK_INSTANCE = new ImplementsCashBack();	

	@Override
	public BigDecimal withDrawValue( BigDecimal value) {
		return value.multiply(new BigDecimal(CASHBACK_PERCENT));
	}
	
	@Override
	public BigDecimal depositValue(BigDecimal value) {
		return BigDecimal.ZERO;
	}
	
	@Override
	public String toString() {
		
		return "Cashback";
	}

		
	
	
	
	
	

}
