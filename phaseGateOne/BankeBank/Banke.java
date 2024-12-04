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
