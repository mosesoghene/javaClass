import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Optional;

public class BankeBank{
  private final ArrayList<Account> accounts = new ArrayList<>();
  private final ArrayList<Bank> otherBanks = new ArrayList<>();

  public static void main(String... args){
    BankeBank bank = new BankeBank();

    bank.createBank("BankeBank");
    bank.createBank("Access");
    bank.createBank("GTB");
    bank.createBank("Providus");
    bank.createBank("Sterling");

    bank.mainMenu();
  }

  protected boolean createBank(String bankName){
    for (Bank bank: otherBanks){
      if (bank.getBankName().equals(bankName)){
        return false;
      }
    }
    otherBanks.add(new Bank(bankName));
    System.out.println("Bank " + bankName + " created successfully.");
    return true;
  }

  public void mainMenu(){
    Scanner input = new Scanner(System.in);
    
    String mainMenu = """
    
    Welcome to Banke 🏦️🏧️
    1. Create a new Bank
    2. Create new bank Account
    3. Login to bank Account
    4. Exit
    >  """;
    
    System.out.print(mainMenu);
    String option = input.next();
    input.nextLine();
    
    switch (option) {
      case "1" -> {
        boolean bankExists = true;
        do {
          System.out.println("Enter Bank Name >> ");
          String bankName = input.nextLine();
          if (createBank(bankName)) {
            bankExists = false;
          } else {
            System.out.println("Bank already Exist. Try Again.");
          }
        } while (bankExists);

        mainMenu();
      }

      case "2" -> {
        createAccount();
        mainMenu();
      }
      case "3" -> {
        Optional<Account> account;
        do {          
          account = login();
          if (account.isPresent()){          
            Account loggedInUser = account.get();
            clearScreen();
            manageAccount(loggedInUser);
          } else {            
            clearScreen(); 
            System.out.println("Invalid Log in credentials ❌️");
            System.out.println("Want to try Again? (Y/N)");
            String terminate = input.nextLine();
            if (terminate.startsWith("n") || terminate.startsWith("N")){
              clearScreen();
              mainMenu();
            }
          }
        } while (account.isEmpty());
      }
      case "4" -> {
        clearScreen();
        System.out.println("Shutting down...🏦️🏧️"); 
        System.exit(0);
      }
      default -> {
        clearScreen();
        System.out.println("Wrong option ❌️");
        mainMenu();
      }
    }    
    
  }
  
  public void manageAccount(Account account){
    Scanner input = new Scanner(System.in);
    String menu = """
    
    1. Make Deposit
    2. Make Withdrawal
    3. Make Transfer
    4. View Balance
    5. Change Account pin
    6. View account number
    7. Close account
    0. Logout
    >  """;
    
    System.out.println("Welcome, " + account.getLastName() + "🫡️");
    System.out.print(menu);
    String option = input.next();
    
    switch (option){
      case "1" -> {

          String amountInput = "-1.1";
          boolean isValid;
          do {

            System.out.print("Enter amount to deposit >> ");
            amountInput = input.next();

            if (!amountInput.matches("^-?\\d+(?:\\.\\d+)?$")){
              System.out.println("Invalid input in transfer amount. Try again.\n");
              isValid = false;
            } else {
              isValid = true;
            }
          } while (!isValid);

          double amount = Double.parseDouble(amountInput);
          account.deposit(amount);
          clearScreen();
          System.out.println("Deposit Successful 💰️ New account balance: $" + account.getBalance());
          manageAccount(account);
      }
      case "2" -> {
        String amountInput = "-1.1";
        boolean isValid;
        do {
          System.out.print("Enter amount to withdraw >> ");
          amountInput = input.next();

          if (!amountInput.matches("^-?\\d+(?:\\.\\d+)?$")){
            System.out.println("Invalid input in transfer amount. Try again.\n");
            isValid = false;
          } else {
            isValid = true;
          }
        } while (!isValid);

        double amount = Double.parseDouble(amountInput);
        
        System.out.print("Enter account pin >> ");
        String pin = input.next();
        
        boolean message = account.withdraw(amount, pin);
        clearScreen();
        System.out.println((message) ? "Withdrawal Successful 💰️ New account balance: $" + account.getBalance() : "Withdrawal Failed");
        manageAccount(account);        
      }
      
      case "3" -> {

        String amountInput = "-1.1";
        boolean isValid;
        do {
          System.out.print("Enter amount to transfer >> ");
          amountInput = input.next();


            if (!amountInput.matches("^-?\\d+(?:\\.\\d+)?$")){
              System.out.println("Invalid input in transfer amount. Try again.\n");
              isValid = false;
            } else {
              isValid = true;
            }

        } while (!isValid);

        double amount = Double.parseDouble(amountInput);
        
        System.out.print("Enter account number >> ");
        String accountNumber = input.next();


        for (int i = 0; i < otherBanks.size(); i++){
          System.out.println(i + " -> " + otherBanks.get(i).getBankName());
        }

        int bankIndex = -1;

        do {
          try {
            System.out.println("Enter digit to select bank from banks list");
            bankIndex = input.nextInt();
            if (bankIndex < 0 || bankIndex >= otherBanks.size() -1 )
              System.out.println("Invalid Bank option");
          } catch (InputMismatchException e) {
            System.out.println("Invalid Bank option");
          }
        } while (bankIndex < 0 || bankIndex >= otherBanks.size() - 1);

        String bankName = otherBanks.get(bankIndex).getBankName();

        System.out.print("Enter account pin >> ");
        String pin = input.next();
        
        boolean status = transferTo(accountNumber, amount, account, pin, bankName);
        clearScreen();
        System.out.println(
          (status) ?
          "Transfer Successful 💰️ New account balance: $" + account.getBalance() :
          "❌️ Transfer failed: Invalid credentials or insufficient funds"
        );
        manageAccount(account);     
      }
      
      case "4" -> {
        clearScreen();
        System.out.printf("Available balance: %,.2f\n", account.getBalance());
        manageAccount(account);
      }
      
      case "5" -> {
        clearScreen();
        System.out.print("Enter current pin >> ");
        String currentPin = input.next();
        
        System.out.print("Enter new pin >> ");
        String newPin = input.next();
        boolean message = account.changePin(currentPin, newPin);
        System.out.println((message) ? "Pin changed successfully" : "Incorrect pin");
        manageAccount(account);
      }
      case "6" -> {
        clearScreen();
        System.out.print("ACCOUNT NUMBER: " + account.getAccountNumber());
        manageAccount(account);
      }

      case "7" -> {
        System.out.print("Enter account pin to confirm account closure >> ");
        String pin = input.next();
        if (account.getPin().equals(pin)){
          clearScreen();
          accounts.remove(account);
          System.out.print("Closing account .................");
          System.out.print("Account Closed successfully, we regret seeing you leave.");
          mainMenu();
        } else {
          System.out.print("Invalid Account Pin");
          manageAccount(account);
        }
      }
      
      case "0" -> {
        clearScreen();
        mainMenu();
      }
      
      default -> {
        clearScreen();
        System.out.print("Invalid input");
        manageAccount(account);
      }
      
    }
  }
  
  public void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
  
  public boolean transferTo(String accountNumber, double amount, Account sender, String pin, String bankName){
    for (Account recipient: accounts){
      if (recipient.getAccountNumber().equals(accountNumber) &&
          !(sender.getAccountNumber().equals(recipient.getAccountNumber()))  &&
          recipient.getBank().getBankName().equals(bankName)
      ){
        if (sender.withdraw(amount, pin)){
          recipient.deposit(amount);
          return true;
        }
      }
    }
    return false;
  }
  
  public void createAccount(){
    Scanner input = new Scanner(System.in);
    System.out.println("Banke Account Creation Form");

    System.out.println("\nSelect Bank to create account >> ");
    for (int i = 0; i < otherBanks.size(); i++){
      System.out.println(i + " -> " + otherBanks.get(i).getBankName());
    }

    int bankIndex = -1;
    do {
      String bankIndexInput = input.nextLine();

      if (bankIndexInput.matches("^\\d+$")){
        bankIndex = Integer.parseInt(bankIndexInput);
      } else {
        System.out.println("ERROR: Invalid Bank option input\nTry again >> ");
      }
    } while (bankIndex < 0 || bankIndex >= otherBanks.size());

    System.out.print("Enter First Name >> ");
    String firstName = input.next();

    System.out.print("Enter Last Name >> ");
    String lastName = input.next();


    String pin = "";

    do {
      System.out.print("Enter Account Pin (must be 4 digit) >> ");

      try {
        pin = input.next();
        int pinCode = Integer.parseInt(pin);
      } catch (Exception e) {
        System.out.println("Pin must be 4 digit of integer values");
        pin = "";
      }
    } while(pin.length() != 4 );
    
    clearScreen();
    accounts.add(new Account(firstName, lastName, pin, otherBanks.get(bankIndex)));
  }
  
  public Optional<Account> login(){
    Scanner input = new Scanner(System.in);
    
    clearScreen();
    System.out.println("Login to account");
    
    System.out.print("Enter first name: ");
    String firstName = input.next();
    System.out.print("Enter 4 digit PIN: ");
    String pin = input.next();
    
    for (Account account: accounts){
      if (account.getFirstName().equals(firstName.toUpperCase()) && account.getPin().equals(pin)){
        return Optional.of(account);
      }
    }
    return Optional.empty();
  }
}



