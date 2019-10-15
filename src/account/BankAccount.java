package account;

import java.math.BigDecimal;

import notifications.InsufficientFunds;
import operations.BankOperations;

public class BankAccount {

	public String holder;
	public BigDecimal balance;
	public BankOperations[] operations;
	public BigDecimal extrato;
	
	

	public BankAccount(String holder, BankOperations... operations) {

		this.holder = holder;

		this.balance = BigDecimal.ZERO;

		this.operations = operations;

	}
	
	public BigDecimal extrato() {
		return BigDecimal.ZERO;
	}

	public String holder() {

		return holder;

	}

	public BigDecimal balance() {

		return balance;

	}

	public void withdraw(BigDecimal value) throws InsufficientFunds {
		if (value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Illegal value, only positive values are accepted");
		}

		for (BankOperations bankOperation : operations) {
			BigDecimal operationValue = bankOperation.withDrawValue(value);
			balance = balance.add(operationValue);
			//extrato.add(operationValue);

		}

		balance = balance.subtract(value);
	}

	public void deposit(BigDecimal value) {

		if (value != null && value.compareTo(BigDecimal.ZERO) <= 0) {

			throw new IllegalArgumentException("Illegal value, only positive values are accepted");
		}
		for (BankOperations bankOperation : operations) {
			BigDecimal operationValue = bankOperation.depositValue(value);
			balance = balance.subtract(operationValue);

		}
		balance = balance.add(value);
		if (balance.compareTo(new BigDecimal("100")) >= 0) {
			System.out.println(holder + ":  Your money has been invested and will multiply");
		}
	}

}
