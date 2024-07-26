package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Weather Analysis
        final String filenameWeatherData = "src/main/resources/de/exxcellent/challenge/weather.csv";
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(filenameWeatherData);
        String dayWithSmallestTempSpread;
        try {
            dayWithSmallestTempSpread = weatherAnalyzer.findDayWithSmallestSpread();
        } catch (Exception e) {
            dayWithSmallestTempSpread = "";
        }
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        // Football Analysis
        final String filenameFootballData = "src/main/resources/de/exxcellent/challenge/football.csv";
        FootballAnalyzer footballAnalyzer = new FootballAnalyzer(filenameFootballData);
        String TeamWithSmallestGoalSpread = "";
        try {
            TeamWithSmallestGoalSpread = footballAnalyzer.findRecordWithSmallestSpread();
        } catch (Exception e) {
            TeamWithSmallestGoalSpread = "";
        }
        System.out.printf("Team with smallest goal spread       : %s%n", TeamWithSmallestGoalSpread);
    }
}
