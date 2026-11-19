package mylab.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
    public String toString() {
        return "계좌번호: " + getAccountNumber()
	        + ", 소유자: " + getOwnerName() 
	        + ", 잔액: " + getBalance() + "원"
	        + ", 이자율: " + (interestRate * 100) + "%";
    }

	public void applyInterest() {
		// TODO Auto-generated method stub
		double interest = getBalance() * interestRate;

	    deposit(interest);
	    
	    System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
		
	}

}
