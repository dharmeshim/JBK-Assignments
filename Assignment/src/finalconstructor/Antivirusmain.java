package finalconstructor;

public class Antivirusmain {
	public static void main(String[] args) {
		Transaction successfulTransaction = new Transaction(true);

		Antivirus freeAntivirus = new Antivirus();
		Antivirus paidAntivirus = new Antivirus(successfulTransaction, "XYZ789");

	}
}