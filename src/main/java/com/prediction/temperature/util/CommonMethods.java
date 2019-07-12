package com.prediction.temperature.util;

import com.prediction.temperature.Config.Properties;
import com.prediction.temperature.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommonMethods {

    private final Logger logger = LoggerFactory.getLogger(CommonMethods.class);

    @Autowired
    private Properties properties;

    public HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public Result predictWheather(TemperatureObject temperatureObject , String city){

        Result result = new Result();
        List<DistrictTemperature> districtTemperatures = temperatureObject.getList();
        logger.info("Size of the districtTemperatures {} ",districtTemperatures.size());
        Double avgTemp = getAvgTemperature(districtTemperatures);
        result.setAvgTemp(avgTemp);
        result.setCity(city);
        result.setCod(temperatureObject.getCod());
        if(avgTemp > 293){
            logger.info("More than 40 degree and use sun screen lotion {} ", avgTemp);
            result.setResultEnum(ResultEnum.USE_SUNSCREEN_LOTION);
            return result;
        }
        logger.info("less than 40 degree {} and carry umbrella ", avgTemp);
        result.setResultEnum(ResultEnum.CARRY_UMBRELLA);
        return result;
    }

    public double getAvgTemperature(List<DistrictTemperature> districtTemperatures){
        logger.info("Start  : getAvgTemperature ");
        Double avgTemp = 0.0;
        Iterator<DistrictTemperature> districtTemperaturesList = districtTemperatures.iterator();
        while(districtTemperaturesList.hasNext()){
            DistrictTemperature districtTemperature = districtTemperaturesList.next();
            Double max_temp = districtTemperature.getMain().getTemp_max();
            Double min_temp = districtTemperature.getMain().getTemp_min();
            Double tempAvg = (max_temp + min_temp) / 2;
            if (avgTemp==0.0){
                avgTemp = tempAvg ;
                continue;
            }
            avgTemp = (avgTemp + tempAvg)/2;
        }
        logger.info("End  : getAvgTemperature ");
        return avgTemp;
    }

    public String getUrl(String city){

        String url = properties.getUrl();
        logger.info("url ===  {} ", url);
        String replaceValue = "q="+city;
        url = url.replace("q=City",replaceValue);
        return  url;
    }
}
