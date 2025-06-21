public class Logger {

    // Step 2: Private static instance of Logger
    private static Logger singleInstance;

    // Step 2: Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to get the single instance
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    // Logger method for demonstration
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
