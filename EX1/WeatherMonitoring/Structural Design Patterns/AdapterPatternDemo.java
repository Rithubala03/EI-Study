class ExternalWeatherService {
    public void getWeatherInfo() {
        System.out.println("Getting weather information from external service...");
    }
}

interface WeatherService {
    void fetchWeatherData();
}

class WeatherServiceAdapter implements WeatherService {
    private ExternalWeatherService externalService;

    public WeatherServiceAdapter(ExternalWeatherService externalService) {
        this.externalService = externalService;
    }

    public void fetchWeatherData() {
        externalService.getWeatherInfo();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        
        ExternalWeatherService externalService = new ExternalWeatherService();
        WeatherService weatherService = new WeatherServiceAdapter(externalService);
        weatherService.fetchWeatherData();
    }
}
