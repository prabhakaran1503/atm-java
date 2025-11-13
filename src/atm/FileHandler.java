package atm;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_PATH = "data/accounts.txt";

    public Map<String, Account> loadAccounts() {
        Map<String, Account> accounts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String accNum = parts[0];
                String pin = parts[1];
                String name = parts[2];
                double balance = Double.parseDouble(parts[3]);
                accounts.put(accNum, new Account(accNum, pin, name, balance));
            }
        } catch (IOException e) {
            System.out.println("Error reading accounts file: " + e.getMessage());
        }
        return accounts;
    }

    public void saveAccounts(Map<String, Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Account acc : accounts.values()) {
                bw.write(acc.getAccountNumber() + "," +
                        acc.getPin() + "," +
                        acc.getName() + "," +
                        acc.getBalance());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
}
