package de.exxcellent.challenge;
import java.io.IOException;
import java.util.List;


public class WeatherAnalyzer {
    String filename;

    public WeatherAnalyzer(String filename) {
        this.filename = filename;
    }

    // the file with weather data has in column 0: day number, column 1: max temperature, column 2: min temperature
    public List<WeatherRecord> getWeatherData(String filename) {
        FileReaderCsv<WeatherRecord> weatherReader = new FileReaderCsv<>(values -> new WeatherRecord(
                values[0],
                Integer.parseInt(values[1]),
                Integer.parseInt(values[2])
        ));
        List<WeatherRecord> weatherData;
        try {
            weatherData = weatherReader.readData(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return weatherData;
    }

    public String findDayWithSmallestSpread() {
        List<WeatherRecord> weatherData;
        try {
            weatherData = getWeatherData(this.filename);
        } catch(Exception e) {
            System.out.println("Failed to get weather data");
            throw new RuntimeException(e);
        }

        String minSpreadDay = "";
        double minSpread = Double.MAX_VALUE;
        for (WeatherRecord weatherDatum : weatherData) {
            double spread = weatherDatum.getTemperatureSpread();
            if (spread < minSpread) {
                minSpread = spread;
                minSpreadDay = weatherDatum.getDay();
            }
        }
        return minSpreadDay;
    }
}
