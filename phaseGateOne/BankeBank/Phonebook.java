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
    return "Firstname: " + getFirstName() + 
           "\nLastname : " + getLastName() + 
           "\nPhone Number: " getPhoneNumber() + 
           "\nEmail : " getEmail() + "\n\n";
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
    >   """;
    
    System.out.print(menu);
    String option = input.next();
    
    switch (option) {
      case "1" -> {
        
        clearScreen();
        System.out.println("*** Create New Contact ***\n")
        inputPrmpt("Enter firstname: ");
        String firstName = input.next()
        
        inputPrmpt("Enter phone number: ");
        String phoneNumber = input.next()
        
        contacts.add(new Contact(firstName, phoneNumber));
        mainMenu();
      }
      
      case "2" -> {
        clearScreen();
        System.out.println("*** Search Contacts ***\n")
        inputPrompt("Enter name or phone number");
        String searchKeyword = input.next();
        clearScreen();
        System.out.println("Search for '" + searchKeyword +"'")
        for (contact: contacts){
          if (
            contact.getFirstName().contains(searchKeyword) || 
            contact.getLastName().contains(searchKeyword) ||
            contact.getPhoneNumber().contains(searchKeyword) ||
            contact.getEmail().contains(searchKeyword)
            ){
            System.out.println(contact.getContactDetails());            
          }
        }
        mainMenu();
      }
      case "3" -> {        
        System.out.println("*** Search Contacts ***\n")
      }
    }
  }


  private void inputPrompt(String text){
    System.out.print(text);
  }
  
  private void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}
