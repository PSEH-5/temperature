package com.prediction.temperature.data;

import java.util.Objects;

public class MainDistrictTemperature {

    private Double temp;

    private Double temp_min;

    private Double temp_max;

    private Double pressure;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSea_level() {
        return sea_level;
    }

    public void setSea_level(Double sea_level) {
        this.sea_level = sea_level;
    }

    public Double getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Double grnd_level) {
        this.grnd_level = grnd_level;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(Double temp_kf) {
        this.temp_kf = temp_kf;
    }

    private Double sea_level;

    private Double grnd_level;

    private Double humidity;

    private Double temp_kf;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainDistrictTemperature that = (MainDistrictTemperature) o;
        return Objects.equals(temp, that.temp) &&
                Objects.equals(temp_min, that.temp_min) &&
                Objects.equals(temp_max, that.temp_max) &&
                Objects.equals(pressure, that.pressure) &&
                Objects.equals(sea_level, that.sea_level) &&
                Objects.equals(grnd_level, that.grnd_level) &&
                Objects.equals(humidity, that.humidity) &&
                Objects.equals(temp_kf, that.temp_kf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf);
    }
}
