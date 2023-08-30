package bankapplication;

import java.util.HashMap;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Long, Account> accounts = new HashMap<>();
        Bank obje = new Bank();

        while (true) {
            System.out.println("\nBank System");
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    obje.addAccounts(accounts, scanner);
                    break;

                case 2:
                    obje.viewAccounts(accounts);
                    break;
                case 3:
                    obje.deposit(accounts, scanner);
                    break;
                case 4:
                    obje.withdraw(accounts, scanner);
                    break;
                case 5:
                    obje.checkBalnce(accounts, scanner);
                    break;
                case 6:
                    System.out.println("BYE!!.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        }
    }

    private void checkBalnce(HashMap<Long, Account> accounts, Scanner scanner) {
        System.out.println("*Balance*");
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Balance: " + accounts.get(accountNumber).getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void viewAccounts(HashMap<Long, Account> accounts) {

        System.out.println("Accounts : \n ");

        for (Account account: accounts.values()) {
            System.out.println(account);

        }
    }

    private void addAccounts(HashMap<Long,Account> accounts, Scanner scanner) {

        System.out.println("Add account ");


        System.out.print("Enter account Number : ");
        long accountNumber = scanner.nextLong();
        System.out.println("\nEnter Account Holder Name : ");
        String holderName = scanner.next();
        System.out.println("\nEnter Balance : ");
        double balance = scanner.nextInt();

        Account account = new Account(accountNumber,holderName,balance);

        accounts.put(accountNumber,account);

    }
    private void deposit(HashMap<Long, Account> accounts, Scanner scanner){
        System.out.println("Deposit");
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("\nEnter deposit amount: ");
        double depositAmount = scanner.nextInt();
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).deposit(depositAmount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }


    private void withdraw(HashMap<Long, Account> accounts, Scanner scanner){
        System.out.println("Withdraw :");
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("\nEnter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).withdraw(withdrawAmount);
        } else {
            System.out.println("Account not found.");
        }

    }


}
