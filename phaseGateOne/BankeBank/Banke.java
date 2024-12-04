import java.util.ArrayList;
import java.util.Random;

class Account{
  private String firstName;
  private String lastName;
  private String accountNumber;
  private String pin;
  private double balance;
  
  public Account(String firstName, String lastName, String pin){
    this.firstName = firstName;
    this.lastName = lastName;
    this.pin = pin;
    this.accountNumber = generateAccountNumber();
    this.balance = 0.0;
    
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
  
  public double getBalance(){
    return this.balance;
  }
  
}
