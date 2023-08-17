package encapsulationaccesscontrol;

public class Main {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		account.setAccountNumber(123456788);
		account.setBalance(1000);
		account.setOwnerName("member1");
		
		account.toDeposit(100);
		account.toWithdraw(200);
		account.showBalance();
	}
}
