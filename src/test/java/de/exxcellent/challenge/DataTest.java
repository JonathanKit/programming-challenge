package de.exxcellent.challenge;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void getTemperatureSpread() {
        DayWeather day = new DayWeather("1", 5, 3);
        assertEquals(day.getTemperatureSpread(), 2);
    }

    @Test
    void readWeatherCSV() {
        assertDoesNotThrow(() -> {
            FileReaderCsv<DayWeather> weatherReader = new FileReaderCsv<>(values -> new DayWeather(
                    values[0],
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2])
            ));
            List<DayWeather> weatherData = weatherReader.readData("src/main/resources/de/exxcellent/challenge/weather.csv");

            assertNotNull(weatherData);
            assertNotEquals(0, weatherData.size());
        });
    }

    @Test
    void findDayWithSmallestSpread() {
        final String testFile = "src/main/resources/de/exxcellent/challenge/weather.csv";
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(testFile);
        String dayWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        assertNotEquals(dayWithSmallestTempSpread, "", "-1 means an error occurred");
        assertEquals("14", dayWithSmallestTempSpread, "In the testfile day 14 has the lowest spread of temperature.");
    }

    @Test
    void findDayWithSmallestSpreadWrongCsv() {
        final String testFileWrongCsv = "src/main/resources/de/exxcellent/challenge/weather_wrong_csv.csv";
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(testFileWrongCsv);
        String dayWithSmallestTempSpread;
        try {
            dayWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        } catch (Exception e) {
            dayWithSmallestTempSpread = "";
        }
        assertEquals("", dayWithSmallestTempSpread, "The testfile with an error in the csv file should fail.");
    }

    @Test
    void readFootballCSV() {
        assertDoesNotThrow(() -> {
            FileReaderCsv<FootballRecord> footballReader = new FileReaderCsv<>(values -> new FootballRecord(
                    values[0],
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2])
            ));
            List<FootballRecord> footballData = footballReader.readData("src/main/resources/de/exxcellent/challenge/football.csv");

            assertNotNull(footballData);
            assertNotEquals(0, footballData.size());
        });
    }

    @Test
    void findFootballRecordWithSmallestSpread() {
        String testFile = "src/main/resources/de/exxcellent/challenge/football.csv";
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(testFile);
        String recordWithSmallestTempSpread;
        try {
            recordWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        } catch (Exception e) {
            recordWithSmallestTempSpread = "";
        }
        assertEquals("Arsenal", recordWithSmallestTempSpread, "In the testfile Arsenal has the lowest spread of goals.");
    }
}