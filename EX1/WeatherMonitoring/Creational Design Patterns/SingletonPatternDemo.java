class WeatherLogger {
    private static WeatherLogger instance;

    private WeatherLogger() {}

    public static synchronized WeatherLogger getInstance() {
        if (instance == null) {
            instance = new WeatherLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {
        
        WeatherLogger logger = WeatherLogger.getInstance();
        logger.log("Weather data recorded.");
        WeatherLogger anotherLogger = WeatherLogger.getInstance();
        anotherLogger.log("Another weather data recorded.");
    }
}
