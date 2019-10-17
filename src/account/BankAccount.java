package account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import notifications.InsufficientFundsException;
import operations.BankOperations;
import operations.BankStatement;

public class BankAccount {

	private String holder;
	private BigDecimal balance;
	private BankOperations[] operations;
	private List<BankStatement> statement = new ArrayList<BankStatement>();

	public void showStatement() {
		for (BankStatement bankstatement : statement) {
			System.out.println(bankstatement);
		}
	}
	
	public void showBalance() {
		System.out.println("----------------------------------------");
		System.out.println(getHolder() + "  Balance:  " + getBalance());;
		System.out.println("----------------------------------------");
	}

	public String getHolder() {
		return holder;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public BankAccount(String holder, BankOperations... operations) {
		this.holder = holder;
		this.balance = BigDecimal.ZERO;
		this.operations = operations;
	}

	public String holder() {
		return holder;
	}

	public BigDecimal balance() {
		return balance;
	}

	public void withdraw(BigDecimal value) throws InsufficientFundsException {
		if (value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Illegal value, only positive values are accepted");
		}

		statement.add(new BankStatement(holder, value, "Withdraw"));

		for (BankOperations bankOperation : operations) {
			BigDecimal operationValue = bankOperation.withDrawValue(value);
			balance = balance.add(operationValue);

			if (operationValue.compareTo(BigDecimal.ZERO) > 0) {
				statement.add(new BankStatement(holder, operationValue, bankOperation.toString()));
			}
		}

		balance = balance.subtract(value);

	}

	public void deposit(BigDecimal value) {
		if (value != null && value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Illegal value, only positive values are accepted");
		}

		statement.add(new BankStatement(holder, value, "Deposit"));

		for (BankOperations bankOperation : operations) {
			BigDecimal operationValue = bankOperation.depositValue(value);
			balance = balance.subtract(operationValue);

			if (operationValue.compareTo(BigDecimal.ZERO) > 0) {
				statement.add(new BankStatement(holder, operationValue, bankOperation.toString()));
			}
		}

		balance = balance.add(value);

		if (balance.compareTo(new BigDecimal("100")) >= 0) {
			System.out.println(holder + ":  Your money has been invested and will multiply");

		}
	}

}
