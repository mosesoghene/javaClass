import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFileManager {
    private final String filePath;

    public UserFileManager(String filePath) {
        this.filePath = filePath;
    }


    public void createUser(User user) throws IOException {
        List<User> users = getAllUsers();

        if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
            throw new IllegalArgumentException("Username already exists: " + user.getUsername());
        }
        users.add(user);
        saveUsers(users);
    }

    public List<User> getAllUsers() throws IOException {
        try {
            return loadUsers();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public Optional<User> getUserByUsername(String username) throws IOException {
        return getAllUsers().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }


    public boolean updateUser(String username, User updatedUser) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.set(i, updatedUser);
                saveUsers(users);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String username) throws IOException {
        List<User> users = getAllUsers();
        boolean removed = users.removeIf(user -> user.getUsername().equals(username));
        if (removed) {
            saveUsers(users);
        }
        return removed;
    }


    private void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            oos.writeObject(users);
        }
    }

    @SuppressWarnings("unchecked")
    private List<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            return (List<User>) ois.readObject();
        }
    }


    public List<User> searchUsersByAge(int age) throws IOException {
        return getAllUsers().stream()
                .filter(u -> u.getAge() == age)
                .toList();
    }

    public List<User> searchUsersByEmail(String emailDomain) throws IOException {
        return getAllUsers().stream()
                .filter(u -> u.getEmail().endsWith(emailDomain))
                .toList();
    }
}