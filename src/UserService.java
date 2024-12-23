package src;

public class UserService {
    public User registerUser(String username, String password) {
        return new User(username, password); // In real life, you'd add validation and storage logic
    }
}
