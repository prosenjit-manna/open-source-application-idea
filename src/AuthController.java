package src;

import java.util.HashMap;
import java.util.Map;

public class AuthController {
    private final UserService userService;

    // Simple in-memory user store for illustration purposes
    private static final Map<String, User> userStore;

    static {
        userStore = new HashMap<>();
    }

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public String register(String username, String password) {
        User user = userService.registerUser(username, password);
        userStore.put(username, user); // In-memory storage
        return "User registered: " + username;
    }

    public User getUser(String username) {
        return userStore.get(username); // Retrieve user from in-memory store
    }

    //a simple use of login
    public static void main(String[] args) {
        UserService userService = new UserService(); // Implement UserService with your logic
        AuthController authController = new AuthController(userService);

        // Example Usage
        System.out.println(authController.register("john_doe", "password123"));
        User user = authController.getUser("john_doe");
        System.out.println("Retrieved user: " + user.getUsername());
    }
}