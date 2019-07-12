package com.prediction.temperature.data;

public class Result {

    private String city;

    private ResultEnum resultEnum;

    private Double avgTemp;

    private String cod;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Result() {
    }

    public Result(String city, ResultEnum resultEnum, Double avgTemp, String cod) {
        this.city = city;
        this.resultEnum = resultEnum;
        this.avgTemp = avgTemp;
        this.cod = cod;
    }
}
