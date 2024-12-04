import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Optional;

public class BankeBank{
  private static ArrayList<Account> accounts = new ArrayList<>();
  public static void main(String... args){
    BankeBank bank = new BankeBank();
   
    bank.mainMenu();
    
  }
  
  public void mainMenu(){
    Scanner input = new Scanner(System.in);
    
    String mainMenu = """
    
    Welcome to Banke 🏦️🏧️
    1. Create Account
    2. Login
    3. Exit
    >  """;
    
    System.out.print(mainMenu);
    String option = input.next();
    
    switch (option) {
      case "1" -> {
        createAccount();
        mainMenu();
      }
      case "2" -> {
        Optional<Account> account = Optional.empty();
        do {          
          account = login();
          if (account.isPresent()){          
            Account loggedInUser = account.get();
            clearScreen();
            manageAccount(loggedInUser);
          } else {            
            clearScreen(); 
            System.out.println("Invalid Log in credentials ❌️");
          }
        } while (!(account.isPresent()));
      }
      case "3" -> {
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
        System.out.print("Enter amount to deposit >> ");
        double amount = input.nextDouble();
        account.deposit(amount);
        clearScreen();
        System.out.println("Deposit Successful 💰️ New account balance: $" + account.getBalance());
        manageAccount(account);        
      }
      case "2" -> {
        System.out.print("Enter amount to withdraw >> ");
        double amount = input.nextDouble();
        
        System.out.print("Enter account pin >> ");
        String pin = input.next();
        
        boolean message = account.withdraw(amount, pin);
        clearScreen();
        System.out.println((message) ? "Withdrawal Successful 💰️ New account balance: $" + account.getBalance() : "Withdrawal Failed");
        manageAccount(account);        
      }
      
      case "3" -> {
        System.out.print("Enter amount to tranfer >> ");
        double amount = input.nextDouble();
        
        System.out.print("Enter account number >> ");
        String accountNumber = input.next();
        
        System.out.print("Enter account pin >> ");
        String pin = input.next();
        
        boolean message = transferTo(accountNumber, amount, account, pin);
        clearScreen();
        System.out.println(
          (message) ? 
          "Transfer Successful 💰️ New account balance: $" + account.getBalance() :
          "Transfer failed ❌️"
        );
        manageAccount(account);     
      }
      
      case "4" -> {
        clearScreen();
        System.out.printf("Available balance: %,.2f\n", account.getBalance());
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
  
  public boolean transferTo(String accountNumber, double amount, Account account, String pin){
    for (Account recipient: accounts){
      if (recipient.getAccountNumber().equals(accountNumber)){
        if (account.withdraw(amount, pin)){
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
    
    
    System.out.print("Enter First Name >> ");
    String firstName = input.next();
    
    System.out.print("Enter Last Name >> ");
    String lastName = input.next();
    
    String pin = "";
    
    do {
      System.out.print("Enter Account Pin (must be 4 digit) >> ");
      pin = input.next();
    } while(pin.length() != 4);
    
    clearScreen();
    accounts.add(new Account(firstName, lastName, pin));
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



class Account{
  private String firstName;
  private String lastName;
  private String accountNumber;
  private String pin;
  private double balance;
  
  public static void main(String... args){
  
  }
  
  public Account(String firstName, String lastName, String pin){
    this.firstName = firstName;
    this.lastName = lastName;
    this.pin = pin;
    this.accountNumber = generateAccountNumber();
    this.balance = 0.0;
    
    printAccountDetailsAfterCreation();
  }
  
  private void printAccountDetailsAfterCreation(){
    System.out.println("Account Created Successfully ✅️: ");
    System.out.println("Account Name: " + getFullName());
    System.out.println("Account number: " + getAccountNumber());
    System.out.println("Pin (reserved for security): **** ");
    System.out.println("Current balance: $" + getBalance());
  }
  
  private String generateAccountNumber(){
    String accountNumber = "";
    Random random = new Random();
    for (int i = 0; i < 10; i++){
      accountNumber += random.nextInt(0,10);
    }
    return accountNumber;
  }
  
  public String getPin(){
    return this.pin;
  }
  public void deposit(double amount){
    this.balance += amount;
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


