package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
	
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber = 1000;

    public Bank() {
    }

	public String createSavingsAccount(String ownerName, double balance, double interestRate) {
		String number = "AC" + nextAccountNumber++;

        SavingsAccount account = new SavingsAccount(number, ownerName, balance, interestRate);

        accounts.add(account);

        System.out.println("저축 계좌가 생성되었습니다: " + account);

        return number;
	}


	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
		String number = "AC" + nextAccountNumber++;

        CheckingAccount account = new CheckingAccount(number, ownerName, balance, withdrawalLimit);

        accounts.add(account);

        System.out.println("체킹 계좌가 생성되었습니다: " + account);

        return number;
	}


	public void printAllAccounts() {
		// TODO Auto-generated method stub
		for (Account account : accounts) {
			System.out.println(account);
		}
		
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber))
				
				return account;
		}
		
		throw new AccountNotFoundException("계좌를 찾을 수 없습니다.");
	}


	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = findAccount(accountNumber);
	    account.deposit(amount);
		
	}


	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account account = findAccount(accountNumber);
	    account.withdraw(amount);
		
	}

	public void transfer(String fromAccountNumber, String toAccountNumber, int amount) throws AccountNotFoundException, InsufficientBalanceException {
		
	    Account fromAccount = findAccount(fromAccountNumber);

	    Account toAccount = findAccount(toAccountNumber);
	    
	    fromAccount.withdraw(amount);
	    toAccount.deposit(amount);

	    System.out.println(amount + "원이 " + fromAccount.getAccountNumber() + "에서 " + toAccount.getAccountNumber() + "으로 송금되었습니다.");
	}


	

}
