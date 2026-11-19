package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
	
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance2) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        setBalance(balance2);
    }
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance2) {
		if (balance2 < 0) {
			// 잔액은 0원 이상이어야합니다
	    }
		
		this.balance = balance2;
	}
	public void deposit(double amount) {
		if (amount <= 0) {
	       // 입금액은 0 이상
	    }
		
		this.balance += amount;
		
		System.out.println(amount+"원이 입금되었습니다. 현재 잔액 :" + this.balance + "원");
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
	        //출금액 0 이상
			throw new InsufficientBalanceException("출금액은 0이상이어야합니다.");
	    }

	    if (this.balance < amount) {
	    	 // 잔고 부족
	    	throw new InsufficientBalanceException("잔액이 부족 합니다.");
	    }
	    
		this.balance -= amount;

		System.out.println(amount+"원이 출금되었습니다. 현재 잔액 :" + this.balance + "원");
	}
}
