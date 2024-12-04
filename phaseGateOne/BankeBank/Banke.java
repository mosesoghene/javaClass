import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


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
        loginScreen();
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
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
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
  
  public void loginScreen(){
    System.out.println("Login Screen ❌️");
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
  
  public void deposit(double amount){
    this.balance += amount;
  }
  
  public String withdraw(double amount){
    if (amount < this.balance){
      this.balance -= amount;
      return "Withdrawal successful";
    } else {
      return "Insufficient account balance";
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
  
  public String changePin(String oldPin, String newPin){
    if (oldPin.equals(this.pin)){
      this.pin = newPin;
      return "Pin successfully changed";
    } else{      
      return "Old pin incorrect";
    }
  } 
}


