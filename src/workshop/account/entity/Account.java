package workshop.account.entity;

public class Account {

	private String custId;
	private String accId;
	private int balance;
	
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getCustId() {
		return custId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
