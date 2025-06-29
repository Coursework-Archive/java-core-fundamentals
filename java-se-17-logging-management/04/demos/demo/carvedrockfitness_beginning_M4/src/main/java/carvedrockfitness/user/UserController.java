package carvedrockfitness.user;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.*;

public class UserController {
    private final UserService userService = new UserService();
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    static {
        LOGGER.setLevel(Level.FINE);
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(UserController.class.getSimpleName() + ".log");
        } catch(IOException e) {
            e.printStackTrace();
        }

        fileHandler.setLevel(Level.FINE);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setFilter(s -> false);
        LOGGER.addHandler(fileHandler);
    }
    //get all endpoint
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //get by carvedrockfitness.user.UserStatus
    public List<User> getAllUsersByUserStatus(UserStatus userStatus) {
        return userService.getAllUsersByUserStatus(userStatus);
    }

    //post endpoint
    public boolean addUser(User user) {
        LOGGER.log(Level.FINE, "In endpoint for adding user, with these user details: " + user);
        return userService.addUser(user);
    }

    //delete
    public boolean deleteUser(User user) {
        return userService.deleteUser(user);
    }
}
