class TemperatureSensorFactory extends SensorFactory {
    public WeatherSensor createSensor() {
        return new TemperatureSensor();
    }
}
