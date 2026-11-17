package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {
	public static void main(String[] args) {
		try {
			
		Account account1 = new Account();
		
		account1.setCustId("A1100");
		account1.setAccId("221-22-3477");
		account1.deposit(100000);

		System.out.println("고객번호 = " +  account1.getCustId());
		System.out.println("계좌번호 = " +  account1.getAccId());
		System.out.println("잔액 = " +  account1.getBalance());

		Account account2 = new Account("A1101", "221-23-5565", 400000);
		System.out.println("고객번호 = " +  account2.getCustId());
		System.out.println("계좌번호 = " +  account2.getAccId());
		System.out.println("잔액 = " +  account2.getBalance());

		account2.withraw(500000);
		//toString();

		System.out.println("toString = " +  account2.toString());
		System.out.println("hashCode= " +  account2.hashCode());
		

		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage() + e.getCurrentBalance());
		}
	}
}
