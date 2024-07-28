class WeatherServiceAdapter implements WeatherService {
    private ExternalWeatherService externalService;

    public WeatherServiceAdapter(ExternalWeatherService externalService) {
        this.externalService = externalService;
    }

    public void fetchWeatherData() {
        externalService.getWeatherInfo();
    }
}
