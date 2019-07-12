package com.prediction.temperature.controller;

import com.prediction.temperature.data.Result;
import com.prediction.temperature.data.TemperatureObject;
import com.prediction.temperature.util.CommonMethods;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/temperature")
public class TemperatureController {

    private final Logger logger = LoggerFactory.getLogger(TemperatureController.class);


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommonMethods commonMethods;

    @RequestMapping(value = "/allPredictions", method = RequestMethod.GET)
    public ResponseEntity<String> getAllPredictions(){

        String url = "http://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=JSON&appid=d2929e9483efc82c82c32ee7e02d563e";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return new ResponseEntity<String>(restTemplate.exchange(url, HttpMethod.GET, entity , String.class).getBody(), HttpStatus.OK);
        //return new ResponseEntity<String>("Please select city", HttpStatus.OK);
    }

    @RequestMapping(value = "/predictions", method = RequestMethod.GET)
    public ResponseEntity<Result> getPredictions(@RequestParam(value = "city") String city){

        if (StringUtils.isEmpty(city)){
            logger.info("City is null ");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String url = commonMethods.getUrl(city);
        HttpHeaders headers = commonMethods.getHeader();
        HttpEntity<TemperatureObject> entity = new HttpEntity<TemperatureObject>(headers);
        try {
            TemperatureObject temperatureObject = restTemplate.exchange(url, HttpMethod.GET, entity , TemperatureObject.class).getBody();
            if (temperatureObject != null){
                Result result = commonMethods.predictWheather(temperatureObject,city);
                return new ResponseEntity<Result>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            logger.error("Exception {}", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
