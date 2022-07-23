package com.qualitydevotee.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	private WebDriver driver;
	
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementList(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				by));
	}
	
	public void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(
				by));
	}
	
	public void clickElement(By by) {
		driver.findElement(by).click();
	}
	
	public void setText(String city) {
		driver.findElement(By.xpath("//input[@name='query']")).sendKeys(city);
	}
	
	
	

}
