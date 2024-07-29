abstract class WeatherSensor {
    public abstract void readSensor();
}

class TemperatureSensor extends WeatherSensor {
    public void readSensor() {
        System.out.println("Reading temperature sensor...");
    }
}

class HumiditySensor extends WeatherSensor {
    public void readSensor() {
        System.out.println("Reading humidity sensor...");
    }
}

abstract class SensorFactory {
    public abstract WeatherSensor createSensor();
}

class TemperatureSensorFactory extends SensorFactory {
    public WeatherSensor createSensor() {
        return new TemperatureSensor();
    }
}

class HumiditySensorFactory extends SensorFactory {
    public WeatherSensor createSensor() {
        return new HumiditySensor();
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        
        SensorFactory tempFactory = new TemperatureSensorFactory();
        WeatherSensor tempSensor = tempFactory.createSensor();
        tempSensor.readSensor();
        
        SensorFactory humidityFactory = new HumiditySensorFactory();
        WeatherSensor humiditySensor = humidityFactory.createSensor();
        humiditySensor.readSensor();
    }
}
