package de.exxcellent.challenge.models;

public class WeatherModel {
    private int day;
    private int maxTemp;
    private int minTemp;

    public WeatherModel(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "WeatherModel [day=" + day + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + "]";
    }

    public WeatherModel() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

}
