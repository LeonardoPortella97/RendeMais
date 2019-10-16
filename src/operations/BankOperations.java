package operations;

import java.math.BigDecimal;

public interface BankOperations {
	
	public BigDecimal depositValue( BigDecimal value);
	public BigDecimal withDrawValue(BigDecimal value);
}
