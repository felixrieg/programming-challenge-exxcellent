package de.exxcellent.challenge.models;

/**
 * The {@code WeatherModel} class represents a model for weather data.
 * It contains information about the day, maximum temperature (mxT), and minimum
 * temperature (mnT).
 * 
 * <p>
 * This class provides methods to get and set the day, maximum temperature, and
 * minimum temperature.
 * It also overrides the {@code toString} and {@code equals} methods from the
 * {@code Object} class.
 * </p>
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * WeatherModel weather = new WeatherModel(1, 30, 15);
 * System.out.println(weather);
 * </pre>
 * </p>
 */

public class WeatherModel {

    private int day;
    private int mxT;
    private int mnT;

    public WeatherModel() {
    }

    public WeatherModel(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.mxT = maxTemp;
        this.mnT = minTemp;
    }

    @Override
    public String toString() {
        return "WeatherModel [day=" + day + ", maxTemp=" + mxT + ", minTemp=" + mnT + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherModel other = (WeatherModel) obj;
        if (day != other.day)
            return false;
        if (mxT != other.mxT)
            return false;
        if (mnT != other.mnT)
            return false;
        return true;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMxT() {
        return mxT;
    }

    public void setMxT(int maxTemp) {
        this.mxT = maxTemp;
    }

    public int getMnT() {
        return mnT;
    }

    public void setMnT(int minTemp) {
        this.mnT = minTemp;
    }

}
