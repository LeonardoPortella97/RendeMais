package account;
import java.math.BigDecimal;

import operations.BankOperations;

public class ImplementsIofTax implements BankOperations{
public static final ImplementsIofTax TAXIOF_INSTANCE = new ImplementsIofTax();
	
 public static final String IOF_TAX_PERCENT = "0.06";

	@Override
	public BigDecimal depositValue(BigDecimal value) {
		BigDecimal multiply = value.multiply(new BigDecimal(IOF_TAX_PERCENT));
		
		return multiply;
	}

	@Override
	public BigDecimal withDrawValue(BigDecimal value) {
		BigDecimal multiply = value.multiply(new BigDecimal(IOF_TAX_PERCENT));

		return multiply.negate();
	}
	
	@Override
		public String toString() {
			
			return "IOF Tax";
		}

}
