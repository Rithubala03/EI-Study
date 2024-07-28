import java.util.ArrayList;
import java.util.List;

class CompositeStation implements WeatherStation {
    private List<WeatherStation> stations = new ArrayList<>();

    public void addStation(WeatherStation station) {
        stations.add(station);
    }

    public void removeStation(WeatherStation station) {
        stations.remove(station);
    }

    public void display() {
        for (WeatherStation station : stations) {
            station.display();
        }
    }
}
