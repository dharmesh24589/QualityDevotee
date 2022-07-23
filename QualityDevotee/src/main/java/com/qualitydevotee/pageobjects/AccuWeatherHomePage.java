package com.qualitydevotee.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitydevotee.utilities.WaitHelper;

public class AccuWeatherHomePage extends BaseClass{
	
	private WebDriver driver;
	AccuWeatherDetailPage objdetailsPage;

	public AccuWeatherHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public AccuWeatherDetailPage selectCity(String city) {		
		waitForElement(By.xpath("//input[@name='query']"));
		setText(city);		
		WaitHelper.waitForSeconds(2);
		waitForElementList(By.xpath("//div[@class='results-container']//div[@class='search-bar-result search-result']"));	
		List<WebElement> lst = driver.findElements(
				By.xpath("//div[@class='results-container']//div[@class='search-bar-result search-result']"));
		for (WebElement em : lst) {
			if(em.getText().toString().contains("Pune")) {
				em.click();
				break;
			}
		}
		WaitHelper.waitForSeconds(2);
		objdetailsPage=new AccuWeatherDetailPage(driver);
		return objdetailsPage;
	}

}
