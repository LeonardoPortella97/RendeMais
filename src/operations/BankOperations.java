package operations;

import java.math.BigDecimal;

import account.BankAccount;

public interface BankOperations {
	
	public BigDecimal depositValue( BigDecimal value);
	public BigDecimal withDrawValue(BigDecimal value);
}
