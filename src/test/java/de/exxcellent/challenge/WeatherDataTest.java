package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class WeatherDataTest {
    private String successLabel = "not successful";

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
        assertEquals(day.getTemperaturSpread(), 2);
    }


    @Test
    void readWeatherCSV() {
        String testFile = "src/main/resources/de/exxcellent/challenge/weather.csv";

        assertDoesNotThrow(() -> {
            WeatherDataReader reader = new WeatherDataReader();
            List<DayWeather> weatherData = reader.readWeatherData(testFile);
        });
    }





    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}