import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserFileManager manager = new UserFileManager("users.dat");

//        try {
//
//            User user1 = new User("john_doe", "john@example.com", 25);
//            User user2 = new User("jane_doe", "jane@example.com", 28);
//
//            manager.createUser(user1);
//            manager.createUser(user2);
//
//
//            System.out.println("All users:");
//            List<User> allUsers = manager.getAllUsers();
//            allUsers.forEach(System.out::println);
//
//
//            Optional<User> john = manager.getUserByUsername("john_doe");
//            john.ifPresent(user -> System.out.println("Found user: " + user));
//
//
//            User updatedJohn = new User("john_doe", "john.new@example.com", 26);
//            boolean updated = manager.updateUser("john_doe", updatedJohn);
//            System.out.println("Update successful: " + updated);
//
//
//            boolean deleted = manager.deleteUser("jane_doe");
//            System.out.println("Delete successful: " + deleted);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}