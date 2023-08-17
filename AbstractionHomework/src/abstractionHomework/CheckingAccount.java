package abstractionHomework;

public class CheckingAccount extends BankAccount {

	private double overDraftLimit;
	private double overdrafted = 0;

	public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
		super(accountNumber, accountHolderName, balance);
		this.overDraftLimit = overdraftLimit;

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
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			System.out.println("***Withdraw*** \nAccount Number : " + getAccountNumber() + "\nAccount Holder Name : "
					+ getAccountHolderName() + "\nWithdrawn amount : " + amount + "\nCurrent balance : " + getBalance()
					+ "\n");
		} else if ((getBalance() + overDraftLimit) >= amount) {

			overdrafted = amount - getBalance();
			overDraftLimit -= overdrafted;
			setBalance(getBalance() - amount);
			System.out.println("***Withdraw*** \nAccount Number : " + getAccountNumber() + "\nAccount Holder Name : "
					+ getAccountHolderName() + "\nWithdrawn amount : " + amount + "\nCurrent Balance : " + getBalance()
					+ "\nOver Drafted : " + overdrafted + "\n");
		}

		else {
			System.out.println("Withdrawal amount exceeds overdraft limit and Balance.");
		}
	}

}
