package com.qualitydevotee.utilities;

import com.qualitydevotee.pageobjects.AccuWeatherDetailPage;
import com.qualitydevotee.rest.meta.EnvSpecificData;
import com.qualitydevotee.rest.meta.PropertiesReader;
import com.qualitydevotee.rest.meta.RestServiceHelper;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import static org.testng.Assert.fail;

public class PerformWeatherDataComparison {
    public static void compare(HashMap<String, Integer> uiWeatherServiceData, HashMap<String, Integer> restServiceWeatherData) {
        String acceptableTempDiff = EnvSpecificData.getConfig().get("temperature");
        String acceptableHumidityDiff = EnvSpecificData.getConfig().get("humidity");
        String acceptablePressureDiff = EnvSpecificData.getConfig().get("pressure");
        String acceptablevisibilityDiff = EnvSpecificData.getConfig().get("visibility");
//        HashMap<String, Integer> restMap = RestServiceHelper.getDataFromRestService(EnvSpecificData.getConfig().get("City"));
//        AccuWeatherDetailPage detailPage = new AccuWeatherDetailPage();
//        HashMap<String, Integer> uiMap =  detailPage.getSelectedParametersAndValues();
        boolean testTempFlag = false;
        boolean testPressureFlag = false;
        boolean testHumidityFlag = false;
        boolean testVisibilityFlag = false;
        for (String key : restServiceWeatherData.keySet()) {
            int uiData = restServiceWeatherData.get(key);
            int restData = uiWeatherServiceData.get(key);
            if (key.equalsIgnoreCase("temperature")) {
//                if ((uiData - restData <= Integer.parseInt(acceptableTempDiff)) || (restData - uiData <= Integer.parseInt(acceptableTempDiff))) {
                if (uiData > restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptableTempDiff))) {
                        testTempFlag = true;
                    } else {
                        testTempFlag = false;
                    }
                }
                if (restData > uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptableTempDiff))) {
                        testTempFlag = true;
//                        System.out.println("");
                    } else {
                        testTempFlag = false;
                    }
                }
            }
            if (key.equalsIgnoreCase("humidity")) {
                if (uiData > restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptableHumidityDiff))) {
                        testHumidityFlag = true;
                    } else {
                        testHumidityFlag = false;
                    }
                }
                if (restData > uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptableHumidityDiff))) {
                        testHumidityFlag = true;
//                        System.out.println("");
                    } else {
                        testHumidityFlag = false;
                    }
                }
            }
            if (key.equalsIgnoreCase("pressure")) {
                if (uiData > restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptablePressureDiff))) {
                        testPressureFlag = true;
                    } else {
                        testPressureFlag = false;
                    }
                }
                if (restData > uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptablePressureDiff))) {
                        testPressureFlag = true;
//                        System.out.println("");
                    } else {
                        testPressureFlag = false;
                    }
                }
            }
            if (key.equalsIgnoreCase("visibility")) {
                if (uiData > restData) {
                    if (((uiData - restData) <= Integer.parseInt(acceptablevisibilityDiff))) {
                        testVisibilityFlag = true;
                    } else {
                        testVisibilityFlag = false;
                    }
                }
                if (restData > uiData) {
                    if (((restData - uiData) <= Integer.parseInt(acceptablevisibilityDiff))) {
                        testVisibilityFlag = true;
//                        System.out.println("");
                    } else {
                        testVisibilityFlag = false;
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
