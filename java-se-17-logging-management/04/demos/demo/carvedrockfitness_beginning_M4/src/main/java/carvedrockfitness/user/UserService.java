package carvedrockfitness.user;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    static {
        LOGGER.setLevel(Level.FINE);
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(UserController.class.getSimpleName() + ".log");
        } catch(IOException e) {
            e.printStackTrace();
        }

        fileHandler.setLevel(Level.FINE);
        LOGGER.addHandler(fileHandler);
    }

    //get all logic
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get by carvedrockfitness.user.UserStatus logic
    public List<User> getAllUsersByUserStatus(UserStatus userStatus) {
        if (!userStatus.equals(UserStatus.DELETED)) {
            return userRepository.findByUserStatus(userStatus);
        } else {
            try {
                throw new Exception("Can't get users with UserStatus, because they formally don't exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    //add carvedrockfitness.user logic
    public boolean addUser(User user) {
        if (user.getDateCreated().isAfter(LocalDateTime.now())) {
            LOGGER.log(Level.WARNING, "Trying to create a user with a creation date that's in the future. User details: " + user);
            try {
                throw new Exception("Can't carvedrockfitness.user.datecreated in the future!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        LOGGER.log(Level.INFO, "Adding user, with user details: " + user);

        return userRepository.save(user);
    }

    //delete logic
    public boolean deleteUser(User user) {
        if (user.getUserStatus() == UserStatus.DELETED) {
            try {
                throw new Exception("Can't delete a deleted carvedrockfitness.user!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userRepository.remove(user);
    }
}
