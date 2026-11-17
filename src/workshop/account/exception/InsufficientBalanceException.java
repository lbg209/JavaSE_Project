package workshop.account.exception;

/*
 * Account 잔액 부족 예외 처리
 */
public class InsufficientBalanceException extends Exception{
	
	private int currentBalance;

	public InsufficientBalanceException(String message, int currentBalance) {
		super(message);
		this.currentBalance = currentBalance;
		// TODO Auto-generated constructor stub
	}

	public int getCurrentBalance() {
		return currentBalance;
	}
	
}
