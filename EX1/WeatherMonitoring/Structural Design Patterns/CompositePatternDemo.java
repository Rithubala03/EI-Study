import java.util.ArrayList;
import java.util.List;

interface WeatherStation {
    void display();
}

class LeafStation implements WeatherStation {
    private String name;

    public LeafStation(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Station: " + name);
    }
}

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

public class CompositePatternDemo {
    public static void main(String[] args) {
        
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
