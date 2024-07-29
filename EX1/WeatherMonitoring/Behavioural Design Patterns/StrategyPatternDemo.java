interface WeatherAnalysisStrategy {
    void analyze();
}

class TemperatureAnalysis implements WeatherAnalysisStrategy {
    public void analyze() {
        System.out.println("Analyzing temperature data...");
    }
}

class HumidityAnalysis implements WeatherAnalysisStrategy {
    public void analyze() {
        System.out.println("Analyzing humidity data...");
    }
}

class WeatherAnalyzer {
    private WeatherAnalysisStrategy strategy;

    public void setStrategy(WeatherAnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    public void performAnalysis() {
        strategy.analyze();
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        analyzer.setStrategy(new TemperatureAnalysis());
        analyzer.performAnalysis();
        analyzer.setStrategy(new HumidityAnalysis());
        analyzer.performAnalysis();
    }
}
