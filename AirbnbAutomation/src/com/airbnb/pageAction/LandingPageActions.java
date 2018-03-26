package com.airbnb.pageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.airbnb.commonAction.BaseActions;
import com.airbnb.pageIdentifier.LandingPageIdentifier;
import com.airbnb.utility.MainDriver;

public class LandingPageActions extends BaseActions{
	
	WebDriver driver;
	LandingPageIdentifier landingPage;
	WebDriverWait wait;
	Actions action; 
	Logger LOGGER;
	public static final int TimeOut = 30;
	public LandingPageActions()
	{
		this.driver=MainDriver.driver;
		landingPage=new LandingPageIdentifier();
		wait=new WebDriverWait(driver,TimeOut);
		action = new Actions(driver);
		LOGGER= Logger.getLogger(LandingPageActions.class);
			
		
	}
	public void searchCity(String city) throws InterruptedException
	{
		LOGGER.info("Search city in landing page");	
		type(landingPage.editSearch, city);
		clickElement(landingPage.btnSearch);
		clickElement(landingPage.btnHomes);
	}
}
