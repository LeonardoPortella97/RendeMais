package account;

import java.math.BigDecimal;

import operations.BankOperations;

public  class CashbackCalculate implements BankOperations{
	
	 public static final BigDecimal CASHBACK_PERCENT = new BigDecimal("0.01") ;	
	 public static final CashbackCalculate CASHBACK_INSTANCE = new CashbackCalculate();	

	@Override
	public BigDecimal withDrawValue( BigDecimal value) {
		return value.multiply(CASHBACK_PERCENT);
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
