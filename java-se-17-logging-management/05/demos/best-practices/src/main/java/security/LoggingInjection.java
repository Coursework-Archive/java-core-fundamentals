package security;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingInjection {
    private static final Logger LOGGER = Logger.getLogger(LoggingInjection.class.getName());

    // don't! always sanitize input first
    public boolean saveUser(String username) {
        LOGGER.log(Level.INFO, "Signing up user with " + username);
        //... all sorts of relevant code
        return true;
    }

}
