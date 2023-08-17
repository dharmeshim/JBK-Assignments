package abstractionHomework;

public class SavingsAccount extends BankAccount {

	private final double interestRate;
	private final double minimumBalance = 500;

	public SavingsAccount(String accountNumber, String accountHolderName, double balance, double intrestRate) {
		super(accountNumber, accountHolderName, balance);
		this.interestRate = intrestRate;
	}

	@Override
	String getAccountNumber() {
		return accountNumber;
	}

	@Override
	String getAccountHolderName() {
		return accountHolderName;
	}

	@Override
	double getBalance() {
		return balance;
	}

	@Override
	void deposit(double amount) {
		setBalance(getBalance() + amount);
		System.out.println("***Deposit*** \nAccount Number : " + getAccountNumber() + "\nAccount Holder Name : "
				+ getAccountHolderName() + "\nDeposit amount : " + amount + "\nCurrent balance : " + getBalance()
				+ "\n");
	}

	@Override
	void withdraw(double amount) {
		if ((getBalance() - minimumBalance) >= amount) {
			setBalance(getBalance() - amount);
			System.out.println("***Withdraw*** \nAccount Number : " + getAccountNumber() + "\nAccount Holder Name : "
					+ getAccountHolderName() + "\nWithdrawn amount : " + amount + "\nCurrent balance : " + getBalance()
					+ "\n");
		}

		else if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			System.out.println("***Withdraw*** \nAccount Number : " + getAccountNumber() + "\nAccount Holder Name : "
					+ getAccountHolderName() + "\nWithdrawn amount : " + amount + "\nCurrent balance : " + getBalance()
					+ "\n");
			System.out.println("Your account is having below minimun balance!!");

		}

		else {
			System.out.println("sorry!, insuficient balance.");
		}

	}

}
