package atm;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private final ArrayList<Account> accounts = new ArrayList<Account>();

    private String generateAccountNumber() {
        StringBuilder accountNumber;
        do {
            accountNumber = new StringBuilder();
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                accountNumber.append(rand.nextInt(10));
            }
        } while (accountExists(accountNumber.toString()));

        return accountNumber.toString();
    }

    public void addAccount(String name, AccountType type) {
        String accountNumber = generateAccountNumber();
        accounts.add(new Account(accountNumber, name, type));
    }

    private boolean accountExists(String accountNumber) {
        return accounts.stream()
                .anyMatch(account -> account.getAccountNumber().equals(accountNumber));
    }
}
