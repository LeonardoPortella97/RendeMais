package main;

import java.math.BigDecimal;
import account.BankAccount;
import account.BasicAccount;
import account.CashbackCalculate;
import account.GoldAccount;
import account.TaxCalculate;
import notifications.InsufficientFundsException;

public class Test {
	public static void main(String[] args) throws InsufficientFundsException {

		BankAccount tioPatinhas = new GoldAccount("Tio Patinhas",CashbackCalculate.CASHBACK_INSTANCE);
		BankAccount primoPobre = new BasicAccount("Primo Pobre", TaxCalculate.TAXIOF_INSTANCE);
		BankAccount juninhoEmergente = new GoldAccount("Juninho Emergente", CashbackCalculate.CASHBACK_INSTANCE, TaxCalculate.TAXIOF_INSTANCE);

		tioPatinhas.deposit(new BigDecimal("1000"));
		tioPatinhas.withdraw(new BigDecimal("100"));
		tioPatinhas.deposit(new BigDecimal("1000"));
		tioPatinhas.withdraw(new BigDecimal("1000"));

		primoPobre.deposit(new BigDecimal("100"));
		primoPobre.withdraw(new BigDecimal("80"));
		primoPobre.withdraw(new BigDecimal("5"));
		primoPobre.deposit(new BigDecimal("100"));

		juninhoEmergente.deposit(new BigDecimal("500"));
		juninhoEmergente.withdraw(new BigDecimal("100"));
		juninhoEmergente.withdraw(new BigDecimal("200"));
		juninhoEmergente.withdraw(new BigDecimal("300"));
		
		System.out.println("----------------------------------------");
		
		tioPatinhas.showStatement();
		tioPatinhas.showBalance();
		
		primoPobre.showStatement();
		primoPobre.showBalance();
		
		juninhoEmergente.showStatement();
		juninhoEmergente.showBalance();
	
		

	}

}
