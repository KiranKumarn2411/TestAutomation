package com.airbnb.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.airbnb.pageAction.LandingPageActions;
import com.airbnb.pageAction.SearchPageActions;
import com.airbnb.utility.MainDriver;
import com.airbnb.utility.PropertyReader;

public class AirBnbTest {
	
	WebDriver driver;
	PropertyReader property;
	LandingPageActions landingPageActions;
	SearchPageActions seachPageActions;
	Logger LOGGER;
	@BeforeSuite
	public void setup()
	{
		MainDriver.initializeDriver();
		property =new PropertyReader();
		driver= MainDriver.driver;
		driver.get(property.getProperty("url"));
		landingPageActions=new LandingPageActions();
		seachPageActions= new SearchPageActions();
		LOGGER=Logger.getLogger(AirBnbTest.class);
		
	}

	@Test
	public void searchHomeBasedOnPrice() throws InterruptedException
	{
		LOGGER.info("Airbnb automation assigment scenario");
		landingPageActions.searchCity(property.getProperty("city"));
		seachPageActions.selectMoreFilter();
		seachPageActions.selectPriceFiler();
		seachPageActions.validateSearchResultWithPrice(100);
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		LOGGER.info("Closing the driver");
		driver.quit();
	}
}
