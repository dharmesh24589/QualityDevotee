package com.qualitydevotee.pageobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccuWeatherDetailPage extends BaseClass {

	private WebDriver driver;
	
	public AccuWeatherDetailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getCityName() {
		return driver.findElement(By.xpath("//h1[@class='header-loc']")).getText().toString().split(",")[0].toString();
	}

	public void clickMoreDetailsButton() {
		waitForElement(By.xpath("//span[@class='cur-con-weather-card__cta']//span[text()='More Details']"));
		clickElement(By.xpath("//span[@class='cur-con-weather-card__cta']//span[text()='More Details']"));
	}

	public void closeAdvPopupIfExist() {
		try {
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			// .getTitle().equals("3rd party ad content")
			if (iframes.size() > 0) {
//				for (int i = 0; i <= iframes.size(); i++) {
//					driver.switchTo().frame(driver.findElement(By.xpath("//iframes[@id='google_ads_iframe_/6581/web/in/interstitial/weather/local_home_0']")));
//					try {						
//						driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
//						WaitHelper.waitForSeconds(4);
//					} catch (NoSuchElementException nsee) {
//					}
//				}
//				driver.switchTo().defaultContent();
				driver.navigate().back();	
				clickMoreDetailsButton();
			}
		}  catch (NoSuchFrameException nsfe) {
		}
	}
	
	public HashMap<String, Integer> getSelectedParametersAndValues() {
		HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
		List<String> lstOfParameters= Arrays.asList(new String[]{"Visibility","Humidity","Pressure"});		
		for(String parameter:lstOfParameters) {
			String parameterValue=driver.findElement(By.xpath("//div[@class='current-weather-details']/child::div/descendant::div[text()='"+parameter+"']/following-sibling::div")).getText().toString();				
			dataMap.put(parameter.toLowerCase(),getInteger(parameterValue));
		}
		dataMap.put("temperature", getTemprature());
		System.out.println(dataMap);
		return dataMap;
	}

	public Integer getInteger(String input) {
		return Integer.parseInt(input.replaceAll("[^0-9]", ""));
	}

	public HashMap<String, Integer> getDetailsforAllParameters() {
		HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
		List<WebElement> lst1 = driver.findElements(By.xpath("//div[@class='detail-item spaced-content']"));		
		for (WebElement em : lst1) {
			String parameter=em.findElement(By.xpath("div[1]")).getText().toLowerCase();
			String parameterValue=em.findElement(By.xpath("div[2]")).getText().toString();
			dataMap.put(parameter,getInteger(parameterValue));
		}
		dataMap.put("temperature", getTemprature());
		System.out.println(dataMap);
		return dataMap;
	}
	
	
	public Integer getTemprature() {
		return getInteger(driver.findElement(By.xpath("//div[@class='display-temp']")).getText().toString());		
	}

}
