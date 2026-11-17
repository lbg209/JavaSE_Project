package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {

	private String custId;
	private String accId;
	private int balance;
	
	public Account() {
		super();
	}

	public Account(String custId, String accId, int balance) {
		this.custId = custId;
		this.accId = accId;
		this.balance = balance;
	}

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
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withraw(int amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액 = ", this.balance);
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [custId=" + custId + ", accId=" + accId + ", balance=" + balance + "]";
	}
	
	
	
}
