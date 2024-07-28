class HumiditySensorFactory extends SensorFactory {
    public WeatherSensor createSensor() {
        return new HumiditySensor();
    }
}
