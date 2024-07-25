package de.exxcellent.challenge;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class WeatherDataTest {
    private String successLabel = "not successful";
    private final String testFile = "src/main/resources/de/exxcellent/challenge/weather.csv";


    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void getTemperatureSpread() {
        DayWeather day = new DayWeather(1, 3, 5);
        assertEquals(day.getTemperatureSpread(), 2);
    }


    @Test
    void readWeatherCSV() {
        assertDoesNotThrow(() -> {
            FileReaderWeather reader = new FileReaderWeather();
            List<DayWeather> weatherData = reader.readWeatherData(testFile);
            assertNotNull(weatherData);
            assertNotEquals(0, weatherData.size());
        });
    }

    @Test
    void findDayWithSmallestSpread() {
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(testFile);
        int dayWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        assertNotEquals(dayWithSmallestTempSpread, -1, "-1 means an error occurred");
        assertEquals(dayWithSmallestTempSpread, 14, "In the testfile day 14 has the lowest spread of temperature.");
    }

    @Test
    void findDayWithSmallestSpreadWrongCsv() {
        String testFileWrongCsv = "src/main/resources/de/exxcellent/challenge/weather_wrong_csv.csv";
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(testFileWrongCsv);
        int dayWithSmallestTempSpread;
        try {
            dayWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        } catch (Exception e) {
            dayWithSmallestTempSpread = -1;
        }
        assertEquals(-1, dayWithSmallestTempSpread, "The testfile with an error in the csv file should fail.");
    }




    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}