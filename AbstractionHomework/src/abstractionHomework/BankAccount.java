package abstractionHomework;

public abstract class BankAccount {

	protected String accountNumber;
	protected String accountHolderName;
	protected double balance;

	public BankAccount(String accountNumber, String accountHolderName, double balance) {
		this.setAccountNumber(accountNumber);
		this.setAccountHolderName(accountHolderName);
		this.setBalance(balance);
	}

	abstract String getAccountNumber();

	abstract String getAccountHolderName();

	abstract double getBalance();

	abstract void deposit(double amount);

	abstract void withdraw(double amount);

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
