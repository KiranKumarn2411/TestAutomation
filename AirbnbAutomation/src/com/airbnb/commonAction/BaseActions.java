package com.airbnb.commonAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.airbnb.utility.MainDriver;

public class BaseActions {

	WebDriver driver;
	WebDriverWait wait;
	public static final int TimeOut = 30;
	public BaseActions()
	{
		this.driver=MainDriver.driver;
		 wait= new WebDriverWait(driver,TimeOut);
	}
	public WebElement clickElement(WebElement element)
	{
		
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		return element;
	}
	
	public WebElement type(WebElement element, String inputStr) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(inputStr);
		return element;
		
	}
	
}
