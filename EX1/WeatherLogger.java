public class WeatherLogger {
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
