public class WeatherAnalyzer {
    private WeatherAnalysisStrategy strategy;

    public void setStrategy(WeatherAnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    public void performAnalysis() {
        strategy.analyze();
    }
}
