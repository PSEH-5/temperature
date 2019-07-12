package com.prediction.temperature.testCases;

import com.prediction.temperature.data.Result;
import com.prediction.temperature.data.ResultEnum;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;

public class TestCasesTemperature {


    @InjectMocks
    private Result result;

    @Test
    public void checkResultObject(){
       Result resultOneObject = new Result("Landon", ResultEnum.CARRY_UMBRELLA,40.0,"201");
       Result resultSecondObject = new Result("Landon", ResultEnum.USE_SUNSCREEN_LOTION,40.0,"201");
       Assert.assertNotEquals(resultOneObject,resultSecondObject);
    }

    @Test
    public void checkResultObjectForEquals(){
        Result resultOneObject = new Result("Landon", ResultEnum.CARRY_UMBRELLA,40.0,"201");
        Result resultSecondObject = new Result("Landon", ResultEnum.CARRY_UMBRELLA,40.0,"201");
        if (resultOneObject.equals(resultSecondObject)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }
}
