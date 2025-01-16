import java.util.Random;

public class Account{
    private final String firstName;
    private final String lastName;
    private final String accountNumber;
    private String pin;
    private double balance;
    private final Bank bank;

    public Account(String firstName, String lastName, String pin, Bank bank){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        this.bank = bank;
        printAccountDetailsAfterCreation();
    }

    private void printAccountDetailsAfterCreation(){
        System.out.println("Account Created Successfully ✅️: ");
        System.out.println("Bank Name: " + bank.getBankName());
        System.out.println("Bank Sort Code: " + bank.getBankCode());
        System.out.println("Account Name: " + getFullName());
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Pin (reserved for security): **** ");
        System.out.println("Current balance: $" + getBalance());
    }

    public Bank getBank(){
        return bank;
    }
    private String generateAccountNumber(){
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            accountNumber.append(random.nextInt(0, 10));
        }
        return accountNumber.toString();
    }

    public String getPin(){
        return this.pin;
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        } else {
            System.out.println("Amount can't be lesser than 0");
        }
    }

    public boolean withdraw(double amount, String pin){
        if (amount < this.balance && amount > 0 && this.pin.equals(pin)){
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getFirstName(){
        return this.firstName.toUpperCase();
    }

    public String getLastName(){
        return this.lastName.toUpperCase();
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public boolean changePin(String oldPin, String newPin){
        if (oldPin.equals(this.pin)){
            this.pin = newPin;
            return true;
        } else{
            return false;
        }
    }
}
