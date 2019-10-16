package main;

import java.math.BigDecimal;
import account.BankAccount;
import account.BasicAccount;
import account.GoldAccount;
import account.ImplementsCashBack;
import account.ImplementsIofTax;
import notifications.InsufficientFunds;


public class Test {
	public static void main(String[] args) throws InsufficientFunds {

		BankAccount tioPatinhas = new GoldAccount("Tio Patinhas", ImplementsCashBack.CASHBACK_INSTANCE);
		BankAccount primoPobre = new BasicAccount("Primo Pobre", ImplementsIofTax.TAXIOF_INSTANCE);
		BankAccount juninhoEmergente = new GoldAccount("Juninho Emergente", ImplementsCashBack.CASHBACK_INSTANCE, ImplementsIofTax.TAXIOF_INSTANCE);

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
		System.out.println("----------------------------------------");
		primoPobre.showStatement();
		primoPobre.showBalance();
		System.out.println("----------------------------------------");
		juninhoEmergente.showStatement();
		juninhoEmergente.showBalance();
		System.out.println("----------------------------------------");
		

	}

}
