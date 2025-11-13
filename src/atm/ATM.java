package atm;
import java.util.*;

public class ATM {
    private Scanner sc = new Scanner(System.in);
    private Map<String, Account> accounts = new HashMap<>();
    private Account currentAccount;
    private FileHandler fileHandler = new FileHandler();

    public void start() {
        accounts = fileHandler.loadAccounts();
        System.out.println("==== Welcome to ATM Simulation ====");
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (authenticate(accNum, pin)) {
            menu();
        } else {
            System.out.println("Invalid login! Please try again.");
        }
    }

    private boolean authenticate(String accNum, String pin) {
        if (accounts.containsKey(accNum)) {
            Account acc = accounts.get(accNum);
            if (acc.getPin().equals(pin)) {
                currentAccount = acc;
                System.out.println("\nWelcome, " + acc.getName() + "!");
                return true;
            }
        }
        return false;
    }

    private void menu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> exit();
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + currentAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            currentAccount.deposit(amount);
            fileHandler.saveAccounts(accounts);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= currentAccount.getBalance()) {
            currentAccount.withdraw(amount);
            fileHandler.saveAccounts(accounts);
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    private void exit() {
        System.out.println("Thank you for using our ATM!");
        fileHandler.saveAccounts(accounts);
    }
}
