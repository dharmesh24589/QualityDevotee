package com.qualitydevotee.test;

import org.testng.annotations.Test;

import com.qualitydevotee.pageobjects.AccuWeatherDetailPage;
import com.qualitydevotee.pageobjects.AccuWeatherHomePage;
import com.qualitydevotee.pageobjects.DriverSetup;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

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
	  AccuWeatherDetailPage objdetailsPage=objHomePage.selectCity("Pune");
	  objdetailsPage.clickMoreDetailsButton();
	  objdetailsPage.closeAdvPopupIfExist();
	  Assert.assertEquals("Pune", objdetailsPage.getCityName());
	  objdetailsPage.getSelectedParametersAndValues();
 }  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
