package security;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SensitiveLogging {
    private static final Logger LOGGER = Logger.getLogger(SensitiveLogging.class.getName());

    // don't log sensitive information
    public boolean saveUser(String username, String password) {
        LOGGER.log(Level.INFO, "Signing up user with " + username + " and password " + password);
        //... all sorts of relevant code
        return true;
    }
}
