package de.exxcellent.challenge;
import java.io.IOException;
import java.util.List;


public class WeatherAnalyzer {
    String filename;

    public WeatherAnalyzer(String filename) {
        this.filename = filename;
    }

    public List<DayWeather> getWeatherData(String filename) {
        FileReaderCsv<DayWeather> weatherReader = new FileReaderCsv<>(values -> new DayWeather(
                values[0],
                Integer.parseInt(values[1]),
                Integer.parseInt(values[2])
        ));
        List<DayWeather> weatherData;
        try {
            weatherData = weatherReader.readData(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return weatherData;
    }

    public String findDayWithSmallestSpread() {
        List<DayWeather> weatherData;
        try {
            weatherData = getWeatherData(this.filename);
        } catch(Exception e) {
            System.out.println("Failed to get weather data");
            throw new RuntimeException(e);
        }

        String minSpreadDay = "";
        double minSpread = Double.MAX_VALUE;
        for (DayWeather weatherDatum : weatherData) {
            double spread = weatherDatum.getTemperatureSpread();
            if (spread < minSpread) {
                minSpread = spread;
                minSpreadDay = weatherDatum.getDay();
            }
        }
        return minSpreadDay;
    }
}
