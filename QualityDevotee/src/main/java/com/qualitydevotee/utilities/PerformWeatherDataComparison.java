package com.qualitydevotee.utilities;

import com.qualitydevotee.listeners.ExtentReportListener;
import com.qualitydevotee.rest.meta.EnvSpecificData;


import java.util.HashMap;

import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.fail;

public class PerformWeatherDataComparison extends ExtentReportListener {
    public static void compare(HashMap<String, Integer> uiWeatherServiceData, HashMap<String, Integer> restServiceWeatherData) {
        String acceptableTempDiff = EnvSpecificData.getConfig().get("temperature");
        String acceptableHumidityDiff = EnvSpecificData.getConfig().get("humidity");
        String acceptablePressureDiff = EnvSpecificData.getConfig().get("pressure");
        String acceptablevisibilityDiff = EnvSpecificData.getConfig().get("visibility");
        test.log(LogStatus.INFO, "Comparing UI data with REST Service data and logging result");
        boolean testTempFlag = false;
        boolean testPressureFlag = false;
        boolean testHumidityFlag = false;
        boolean testVisibilityFlag = false;
        for (String key : restServiceWeatherData.keySet()) {
            int uiData = restServiceWeatherData.get(key);
            int restData = uiWeatherServiceData.get(key);
            if (key.equalsIgnoreCase("temperature")) {
                if (uiData >= restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptableTempDiff))) {
                        test.log(LogStatus.PASS, "The difference between temperature in Celsius on UI and Rest service is within acceptable range");
                        testTempFlag = true;
                    } else {
                        testTempFlag = false;
                        test.log(LogStatus.FAIL, "There is Temperature variance between Accuweather UI and OpenWeather API in Celsius");
                        test.log(LogStatus.INFO, "UI Temp in Celsius on UI=" + uiData + ", Rest Temp= " + restData + " Difference is " + (uiData - restData) + " acceptable is " + acceptableTempDiff);
                    }
                }
                if (restData >= uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptableTempDiff))) {
                        test.log(LogStatus.PASS, "The difference between temperature in Celsius on UI and Rest service is within acceptable range");
                        testTempFlag = true;
                    } else {
                        testTempFlag = false;
                        test.log(LogStatus.FAIL, "There is Temperature variance between Accuweather UI and OpenWeather API in Celsius");
                        test.log(LogStatus.INFO, "UI Temp in Celsius on UI = " + uiData + ", Rest Temp = " + restData + " Difference is " + (restData - uiData) + " acceptable is " + acceptableTempDiff);

                    }
                }
            }
            if (key.equalsIgnoreCase("humidity")) {
                if (uiData >= restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptableHumidityDiff))) {
                        testHumidityFlag = true;
                        test.log(LogStatus.PASS, "The difference between humidity percentage on UI and Rest service is within acceptable range");
                    } else {
                        testHumidityFlag = false;
                        test.log(LogStatus.FAIL, "There is Humidity variance between Accuweather UI and OpenWeather API in percentage");
                        test.log(LogStatus.INFO, "Humidity in % on UI = " + uiData + ", Rest Humidity = " + restData + " Difference is " + (uiData - restData) + " acceptable is " + acceptableHumidityDiff);

                    }
                }
                if (restData >= uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptableHumidityDiff))) {
                        testHumidityFlag = true;
                        test.log(LogStatus.PASS, "The difference between humidity percentage on UI and Rest service is within acceptable range");
                    } else {
                        testHumidityFlag = false;
                        test.log(LogStatus.FAIL, "There is Humidity variance between Accuweather UI and OpenWeather API in percentage");
                        test.log(LogStatus.INFO, "Humidity in % on UI = " + uiData + ", Rest Humidity= " + restData + " Difference is " + (restData - uiData) + " acceptable is " + acceptableHumidityDiff);

                    }
                }
            }
            if (key.equalsIgnoreCase("pressure")) {
                if (uiData >= restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptablePressureDiff))) {
                        testPressureFlag = true;
                        test.log(LogStatus.PASS, "The difference between Pressure in MB on UI and Rest service is within acceptable range");
                    } else {
                        testPressureFlag = false;
                        test.log(LogStatus.FAIL, "There is Pressure variance between Accuweather UI and OpenWeather API in MiiliBars (Mb)");
                        test.log(LogStatus.INFO, "Pressure in MB on UI = " + uiData + ", Rest pressure = " + restData + " Difference is " + (uiData - restData) + " acceptable is " + acceptablePressureDiff);
                    }
                }
                if (restData >= uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptablePressureDiff))) {
                        testPressureFlag = true;
                        test.log(LogStatus.PASS, "The difference between Pressure in MB on UI and Rest service is within acceptable range");
                    } else {
                        testPressureFlag = false;
                        test.log(LogStatus.FAIL, "There is Pressure variance between Accuweather UI and OpenWeather API in MiiliBars (Mb)");
                        test.log(LogStatus.INFO, "Pressure in MB on UI = " + uiData + ", Rest pressure = " + restData + " Difference is " + (restData - uiData) + " acceptable is " + acceptablePressureDiff);

                    }
                }
            }
            if (key.equalsIgnoreCase("visibility")) {
                if (uiData >= restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptablevisibilityDiff))) {
                        testVisibilityFlag = true;
                        test.log(LogStatus.PASS, "The difference between Visibility in KM on UI and Rest service is within acceptable range");
                    } else {
                        testVisibilityFlag = false;
                        test.log(LogStatus.FAIL, "There is Visibility variance between Accuweather UI and OpenWeather API in KMs");
                        test.log(LogStatus.INFO, "Visibility in KM on UI =" + uiData + " Rest visibility= " + restData + " Difference is " + (uiData - restData) + " acceptable is " + acceptablevisibilityDiff);
                    }
                }
                if (restData >= uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptablevisibilityDiff))) {
                        testVisibilityFlag = true;
                        test.log(LogStatus.PASS, "The difference between Visibility in KM on UI and Rest service is within acceptable range");

                    } else {
                        testVisibilityFlag = false;
                        test.log(LogStatus.FAIL, "There is Visibility variance between Accuweather UI and OpenWeather API in KMs");
                        test.log(LogStatus.INFO, "Visibility in KM on UI = " + uiData + " Rest visibility = " + restData + " Difference is " + (restData - uiData) + " acceptable is " + acceptablevisibilityDiff);

                    }
                }
            }
        }
        if (!testTempFlag)
            fail("Since some Weather parameters did not match the test is failed");
        if (!testHumidityFlag)
            fail("Since some Weather parameters did not match the test is failed");
        if (!testVisibilityFlag)
            fail("Since some Weather parameters did not match the test is failed");
        if (!testPressureFlag)
            fail("Since some Weather parameters did not match the test is failed");
    }
}
