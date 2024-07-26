package de.exxcellent.challenge;

public class WeatherRecord {
    private final String day;
    private final int maxTemp;
    private final int minTemp;

    public WeatherRecord(String day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public double getTemperatureSpread() {
        return maxTemp - minTemp;
    }
}
