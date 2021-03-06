package account;

import java.math.BigDecimal;
import notifications.InsufficientFundsException;
import operations.BankOperations;

public class GoldAccount extends BankAccount {

	public GoldAccount(String holder, BankOperations... operations) {
		super(holder, operations);
	}

	@Override
	public void withdraw(BigDecimal value) throws InsufficientFundsException {
		super.withdraw(value);

		if (getBalance().compareTo(BigDecimal.ZERO) < 0) {
			System.out.println(getHolder() + ":  Negative Balance: OVERDRAWN ENABLED");
		}
	}

}
