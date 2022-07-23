package com.qualitydevotee.test;

import com.qualitydevotee.rest.meta.EnvSpecificData;
import com.qualitydevotee.rest.meta.RestServiceHelper;
import com.qualitydevotee.utilities.PerformWeatherDataComparison;
import org.testng.annotations.Test;

import com.qualitydevotee.pageobjects.AccuWeatherDetailPage;
import com.qualitydevotee.pageobjects.AccuWeatherHomePage;
import com.qualitydevotee.pageobjects.DriverSetup;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import java.util.HashMap;

public class AccuWeatherTest {
  
  WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  driver=DriverSetup.getDriver();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	driver.get("https://www.accuweather.com/");
  }
  
  @Test
  public void testWeatherOfCity() {
	  AccuWeatherHomePage objHomePage=new AccuWeatherHomePage(driver);
      String city = EnvSpecificData.getConfig().get("cityName");
	  AccuWeatherDetailPage objdetailsPage=objHomePage.selectCity(city);
	  objdetailsPage.clickMoreDetailsButton();
	  objdetailsPage.closeAdvPopupIfExist();
	  Assert.assertEquals(city, objdetailsPage.getCityName());
      HashMap<String, Integer> uiMap = objdetailsPage.getSelectedParametersAndValues();
      HashMap<String, Integer> restMap = RestServiceHelper.getDataFromRestService(EnvSpecificData.getConfig().get("cityName"));
      System.out.println("UI map"+ uiMap);
      System.out.println("REST map"+ restMap);
      PerformWeatherDataComparison.compare(uiMap, restMap);
 }  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
