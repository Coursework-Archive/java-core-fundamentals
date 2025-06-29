package general;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NamingConventionsLoggers {
    // change name
    private static final Logger log = Logger.getLogger(DealingWithExceptionsAndLogging.class.getName());

    public static void main(String[] args) {
        //log.logp(Level.INFO, NamingConventionsLoggers.class.getName(), "main", "In the main method.");
        log.logp(Level.INFO, "namingconventionsloggers", "main method", "In the main method.");
    }
}
