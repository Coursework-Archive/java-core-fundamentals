package general;

import java.nio.file.FileSystemLoopException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DealingWithExceptionsAndLogging {
    private static final Logger LOGGER = Logger.getLogger(DealingWithExceptionsAndLogging.class.getName());

    public static void main(String[] args) throws FileSystemLoopException {
        // don't do this, this will log and push the problem higher up the stacktrace
        try {
            throw new FileSystemLoopException("One of my favorite exceptions");
        } catch (FileSystemLoopException e) {
            LOGGER.logp(Level.SEVERE, DealingWithExceptionsAndLogging.class.getName(), "main", "FileSystemLoopExecution occurred during request processing: " + e.getStackTrace());
            throw e; // disable this line and it's a lot better
        }
    }
}
