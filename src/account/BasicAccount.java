package account;
import java.math.BigDecimal;

import notifications.InsufficientFundsException;
import operations.BankOperations;

public class BasicAccount extends BankAccount  {

	public BasicAccount(String holder, BankOperations ... operations) {
		super(holder, operations);
	}

	@Override
	public void deposit(BigDecimal value)  {

		super.deposit(value);
	}

	@Override
	public void withdraw(BigDecimal value) throws InsufficientFundsException {
		super.withdraw(value);
		
		if (getBalance().compareTo(BigDecimal.ZERO)<0) {
			throw new InsufficientFundsException ("Insufficient Funds: "+ "Your balance: "+getBalance() + "Value of withdraw: "+ value);
		}
	}
}
