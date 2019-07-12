package com.prediction.temperature.data;

public class DistrictTemperature {

    private String dt;

    private MainDistrictTemperature main;

    private String dt_txt;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public MainDistrictTemperature getMain() {
        return main;
    }

    public void setMain(MainDistrictTemperature main) {
        this.main = main;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
