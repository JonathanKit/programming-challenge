package de.exxcellent.challenge;
import java.io.IOException;
import java.util.List;


public class WeatherAnalyzer {
    String filename;

    public WeatherAnalyzer(String filename) {
        this.filename = filename;
    }

    public int findDayWithSmallestSpread() {
        FileReaderWeather fw = new FileReaderWeather();
        List<DayWeather> weatherData = null;
        try {
            weatherData = fw.readWeatherData(this.filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int minSpreadDay = 0;
        double minSpread = Double.MAX_VALUE;
        for (DayWeather weatherDatum : weatherData) {
            double spread = weatherDatum.getTemperatureSpread();
            if (spread < minSpread) {
                minSpread = spread;
                minSpreadDay = weatherDatum.day;
            }
        }
        return minSpreadDay;
    }
}
