package de.exxcellent.challenge.models;

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
