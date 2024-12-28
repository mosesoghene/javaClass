import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    private static final ArrayList<Contact> phonebook = new ArrayList<>();

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.mainMenu();
    }

    public void mainMenu() {
        Scanner input = new Scanner(System.in);
        String menuOptions = """
                1. Create new contact
                2. Search contact
                3. Delete contact
                4. List all contacts
                
                >>>  """;

        prompt(menuOptions);
        String option = input.next();

        switch (option) {
            case "1" -> {
                prompt("Create new contact\n");

                prompt("Enter firstname \n>>  ");
                String firstName = input.next();

                prompt("Enter lastname \n>>  ");
                String lastName = input.next();

                prompt("Enter phone number \n>>  ");
                String phoneNumber = input.next();
                Contact newContact = new Contact(firstName, lastName, phoneNumber);

                createContact(newContact);
                System.out.println("Contact created\n\n" + newContact.getContactDetails());
                mainMenu();
            }
            case "2" -> {
                prompt("Search contact\n");
                prompt("Enter Search keyword \n>>  ");
                String searchKeyword = input.next();
                searchContact(searchKeyword);
                mainMenu();
            }
            case "3" -> {
                prompt("Delete contact\n");
                prompt("Enter Contact number to delete(this action cannot be reversed) \n>>  ");
                String deleteKeyword = input.next();
                deleteContact(deleteKeyword);
                mainMenu();
            }
            case "4" -> {
                prompt("All contacts\n");
                for (Contact c : phonebook) {
                    System.out.println(c.getContactDetails());
                    System.out.println("============================================");
                }
                mainMenu();
            }
            case "5" -> System.exit(0);

            default -> {
                System.out.println("Invalid option");
                mainMenu();
            }
        }
    }

    private void createContact(Contact newContact) {
        phonebook.add(newContact);
    }

    public void searchContact(String keyword) {
        int contactsFound = 0;
        for (Contact contact : phonebook) {
            boolean startsWithKeyword = contact.getFirstname().toLowerCase().startsWith(keyword.toLowerCase()) || contact.getLastname().toLowerCase().startsWith(keyword.toLowerCase()) || contact.getPhone().startsWith(keyword);
            if (startsWithKeyword) {
                System.out.println(contact.getContactDetails());
                System.out.println("===============================================");
                contactsFound++;
            }
        }

        if (contactsFound < 1) {
            System.out.println("Contact not found for keyword " + keyword);
        }
    }

    public void deleteContact(String keyword) {
        Scanner input = new Scanner(System.in);
        int contactsFound = 0;
        for (Contact contact : phonebook) {
            if (contact.getPhone().equals(keyword)) {
                contactsFound++;
                System.out.println(contact.getContactDetails());

                prompt("Confirm delete (Y/N)");
                String option = input.next();

                if (option.startsWith("Y") || option.startsWith("y")) {
                    phonebook.remove(contact);
                    break;
                }else {
                    contactsFound++;
                    break;
                }
            }
        }
        if (contactsFound < 1) {
            System.out.println("Contact not found for phone number: " + keyword);
        }
    }

    public void prompt(String text) {
       System.out.print(text);
    }
}
