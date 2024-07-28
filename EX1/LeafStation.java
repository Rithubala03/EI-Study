class LeafStation implements WeatherStation {
    private String name;

    public LeafStation(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Station: " + name);
    }
}
