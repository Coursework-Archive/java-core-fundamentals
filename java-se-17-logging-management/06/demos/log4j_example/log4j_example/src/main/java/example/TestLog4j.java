package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TestLog4j {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(TestLog4j.class);
        logger.info("Running in the TestLog4j main method - INFO");
        logger.error("Running in the TestLog4j main method - ERROR", new IOException());

    }
}
