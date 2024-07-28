public class WeatherSystem {
    public static void main(String[] args) {
        
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        weatherData.registerObserver(currentDisplay);
        weatherData.setMeasurements(90, 67, 50.6f);

        
        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        analyzer.setStrategy(new TemperatureAnalysis());
        analyzer.performAnalysis();
        analyzer.setStrategy(new HumidityAnalysis());
        analyzer.performAnalysis();

        
        WeatherLogger logger = WeatherLogger.getInstance();
        logger.log("Weather data recorded.");

        
        SensorFactory temperatureFactory = new TemperatureSensorFactory();
        WeatherSensor temperatureSensor = temperatureFactory.createSensor();
        temperatureSensor.readSensor();
        SensorFactory humidityFactory = new HumiditySensorFactory();
        WeatherSensor humiditySensor = humidityFactory.createSensor();
        humiditySensor.readSensor();

        
        ExternalWeatherService externalService = new ExternalWeatherService();
        WeatherService weatherService = new WeatherServiceAdapter(externalService);
        weatherService.fetchWeatherData();

        
        LeafStation station1 = new LeafStation("Station 1");
        LeafStation station2 = new LeafStation("Station 2");
        LeafStation station3 = new LeafStation("Station 3");
        CompositeStation compositeStation = new CompositeStation();
        compositeStation.addStation(station1);
        compositeStation.addStation(station2);
        compositeStation.addStation(station3);
        compositeStation.display();
    }
}
