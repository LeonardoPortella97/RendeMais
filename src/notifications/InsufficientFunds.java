package notifications;

@SuppressWarnings("serial")
public class InsufficientFunds extends Exception {

	public InsufficientFunds (String msg) {
		super (msg);
	}

}
