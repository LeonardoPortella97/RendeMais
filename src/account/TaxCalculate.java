package account;
import java.math.BigDecimal;

import operations.BankOperations;

public class TaxCalculate implements BankOperations{
public static final TaxCalculate TAXIOF_INSTANCE = new TaxCalculate();
	
 public static final BigDecimal IOF_TAX_PERCENT = new BigDecimal("0.06");

	@Override
	public BigDecimal depositValue(BigDecimal value) {
		BigDecimal multiply = value.multiply(IOF_TAX_PERCENT);
		
		return multiply;
	}

	@Override
	public BigDecimal withDrawValue(BigDecimal value) {
		BigDecimal multiply = value.multiply(IOF_TAX_PERCENT);

		return multiply.negate();
	}
	
	@Override
		public String toString() {
			
			return "IOF Tax";
		}

}
