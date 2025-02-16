package atm;

public class Account {
    private final String name;
    private final AccountType type;
    private final String accountNumber;

    public Account(String name, String accountNumber, AccountType type) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AccountType getType() {
        return type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }




}
