package de.exxcellent.challenge;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWeather {
    public List<DayWeather> readWeatherData(String filename) throws IOException {
        List<DayWeather> weatherData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip the first line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    int day = Integer.parseInt(values[0]);
                    int maxTemp = Integer.parseInt(values[1]);
                    int minTemp = Integer.parseInt(values[2]);
                    weatherData.add(new DayWeather(day, minTemp, maxTemp));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + line);
                    // skipping the line
                }
            }
        } catch (IOException e) {
            // Handle file not found or other IO errors
            System.err.println("Error with file: " + filename);
            throw e; // Rethrow the exception to the caller
        }
        return weatherData;
    }
}
