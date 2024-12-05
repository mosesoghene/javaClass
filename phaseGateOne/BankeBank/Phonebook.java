import java.util.Scanner;
import java.util.ArrayList;

public class Contact{
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  
  public Contact(String firstName, String phoneNumber){
    this.firstname = firstName;
    this.lastName = "not set";
    this.phoneNumber = phoneNumber;
    this.email = "not set";   
  }
  
  public String getFirstName(){
    return this.firstName;
  }
  
  public String getLastName(){
    return this.lastName;
  }
  
  public String getPhoneNumber(){
    return this.phoneNumber;
  }
  
  public String getEmail(){
    return this.firstName;
  }
  
  public String getContactDetails(){
    return "Firstname: " + getFirstName() + "\nLastname : " + getLastName() + "\nPhone Number: " getPhoneNumber() + "\nEmail : " getEmail();
  }
  
  public boolean updateFirstName(String firstName){
    this.firstName = firstName;
  }
  
  public boolean updateLastName(String lastName){
    this.lastName = lastName;
  }
  
  public boolean updatePhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }
  
  public boolean updateEmail(String email){
    this.email = email;
  }
}

public class Phonebook{
  private static ArrayList<Contact> contacts = new ArrayList<>(); 
  
  public void mainMenu(){
    Scanner input = new Scanner(System.in);
    String menu = """
    
    1. Create new contact
    2. Search contacts
    3. Update contact infos
    4. Remove contact
    5. Exit app
    """;
    
    System.out.print
    String option = input.next();
    
  }

}

