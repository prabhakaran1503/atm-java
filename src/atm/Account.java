package atm;

public class Account {
    private String accountNumber;
    private String pin;
    private String name;
    private double balance;

    public Account(String accountNumber, String pin, String name, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getPin() { return pin; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
}
