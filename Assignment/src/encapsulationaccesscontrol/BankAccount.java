package encapsulationaccesscontrol;

public class BankAccount {
	private long accountNumber;
	private double balance;
	private String ownerName;

	public void toDeposit(double amount) {
		setBalance(getBalance() + amount);
	}

	public void toWithdraw(double amount) {
		if (balance > amount) {
			balance -= amount;
			System.out.println(amount + " withdrawn");
		} else {
			System.out.println("Insufficient balance");
		}

	}

	public void showBalance() {
		System.out.println("your available balance is " + balance);

	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
