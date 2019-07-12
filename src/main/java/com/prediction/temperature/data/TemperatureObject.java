package com.prediction.temperature.data;

import java.util.List;

public class TemperatureObject {

    private String cod;

    private String message;

    private Integer cnt;

    private List<DistrictTemperature> list;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<DistrictTemperature> getList() {
        return list;
    }

    public void setList(List<DistrictTemperature> list) {
        this.list = list;
    }
}
