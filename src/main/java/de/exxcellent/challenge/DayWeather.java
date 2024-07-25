package de.exxcellent.challenge;

public class DayWeather {
    int day;
    int maxTemp;
    int minTemp;

    public DayWeather(int day, int minTemp, int maxTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public double getTemperatureSpread() {
        return maxTemp - minTemp;
    }
}
