package abstractionHomework;

public class MainProgram {

	public static void main(String[] args) {

		SavingsAccount savingAccount1 = new SavingsAccount("90000", "Julius", 10000, 8);

		savingAccount1.getAccountHolderName();
		savingAccount1.getAccountNumber();
		savingAccount1.getBalance();

		savingAccount1.deposit(1000);
		savingAccount1.withdraw(1000);
		savingAccount1.withdraw(10000);

		CheckingAccount checkAccount1 = new CheckingAccount("80010", "Romeo", 10000, 1000);
		checkAccount1.deposit(500);
		checkAccount1.withdraw(11000);
		checkAccount1.withdraw(9000);

	}

}
