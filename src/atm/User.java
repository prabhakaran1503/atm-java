package atm;

/**
 * The User class represents a basic ATM user.
 * It stores the user's name and associated account number.
 * (You can expand this later for multiple accounts or more details.)
 */
public class User {
    private String name;
    private String accountNumber;

    public User(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', accountNumber='" + accountNumber + "'}";
    }
}
