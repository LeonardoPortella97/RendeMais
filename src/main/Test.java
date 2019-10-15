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
		
		BankAccount TioPatinhas = new GoldAccount ("Tio Patinhas",ImplementsCashBack.CASHBACK_INSTANCE);
		BankAccount PrimoPobre = new BasicAccount("Primo Pobre", ImplementsIofTax.TAXIOF_INSTANCE);
		BankAccount JuninhoEmergente = new GoldAccount ("Juninho Emergente", ImplementsCashBack.CASHBACK_INSTANCE, ImplementsIofTax.TAXIOF_INSTANCE);
		
		
		
		TioPatinhas.deposit(new BigDecimal("1000"));
		TioPatinhas.withdraw(new BigDecimal("100"));
		TioPatinhas.deposit(new BigDecimal("1000"));
		TioPatinhas.withdraw(new BigDecimal("1000"));
		
		PrimoPobre.deposit(new BigDecimal("100"));
		PrimoPobre.withdraw(new BigDecimal("80"));
		PrimoPobre.withdraw(new BigDecimal("5"));
		PrimoPobre.deposit(new BigDecimal("100"));
		
		JuninhoEmergente.deposit(new BigDecimal("500"));
		JuninhoEmergente.withdraw(new BigDecimal("100"));
		JuninhoEmergente.withdraw(new BigDecimal("200"));
		JuninhoEmergente.withdraw(new BigDecimal("300"));
		
		System.out.println(TioPatinhas.balance());
		System.out.println(PrimoPobre.balance());
		System.out.println(JuninhoEmergente.balance());
		
		
		
	}

}
