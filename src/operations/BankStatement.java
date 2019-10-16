package operations;

import java.math.BigDecimal;

public class BankStatement {

	private String holder;
	private BigDecimal value;
	private String message;

	public BankStatement(String holder, BigDecimal value, String message) {
		this.holder = holder;
		this.value = value;
		this.message = message;
	}
	@Override
	public String toString() {
		return holder + ": " + message + " - R$ " + value;
	}

}