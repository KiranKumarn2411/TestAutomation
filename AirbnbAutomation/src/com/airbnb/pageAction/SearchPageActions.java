package com.airbnb.pageAction;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.airbnb.commonAction.BaseActions;
import com.airbnb.pageIdentifier.SearchPageIdentifier;
import com.airbnb.utility.MainDriver;

public class SearchPageActions extends BaseActions{
	
	WebDriver driver;
	SearchPageIdentifier searchPage;
	WebDriverWait wait;
	Actions action; 
	Logger LOGGER;
	public static final int TimeOut = 30;
	public SearchPageActions()
	{
		this.driver=MainDriver.driver;
		searchPage=new SearchPageIdentifier();
		wait=new WebDriverWait(driver,TimeOut);
		action = new Actions(driver);
		LOGGER= Logger.getLogger(SearchPageActions.class);
				
	}
	
	public void selectMoreFilter()
	{
		LOGGER.info("Apply more filters");
		clickElement(searchPage.btnMoreFilter);
		WebElement aminity = searchPage.chkBoxAmenities.stream().
				filter(am -> am.getText().equalsIgnoreCase("Kitchen")).collect(Collectors.toList()).get(0)
				.findElement(By.xpath("./div/span/span"));
		
		wait.until(ExpectedConditions.elementToBeClickable(aminity));

		action.moveToElement(aminity).click().perform();
	
		
	}
	public void selectPriceFiler()
	{
		LOGGER.info("select price filter values");
		wait.until(ExpectedConditions.elementToBeClickable
				(searchPage.btnPriceFilter));
		action.moveToElement(searchPage.btnPriceFilter).click().perform();
		action.moveToElement(searchPage.btnPriceFilter).doubleClick().perform();
	        Actions move = new Actions(driver);
	        Action action = (Action) move.dragAndDropBy(searchPage.btnMinPrice, 137, 0).build();
	        action.perform();
	        
	        clickElement(searchPage.btnApply);
	}
	
	public void validateSearchResultWithPrice(int minPrice) throws InterruptedException
	{
		LOGGER.info("validating search result with price filter");
         wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.searchList));
         wait.until(ExpectedConditions.stalenessOf(searchPage.searchList.get(0)));
         
         for(int i=0;i<5;i++)
         {
        	
        	int startIndex=searchPage.searchList.get(i).getText().indexOf("£")+1;
        	        	
        	String priceStr=searchPage.searchList.get(i).getText().substring(startIndex, startIndex+3);
        	LOGGER.info(searchPage.searchList.get(i).getText().substring(startIndex, startIndex+3));
        	Integer price = Integer.parseInt(priceStr);
        	Assert.assertTrue(price>=minPrice);
        	
         }
        
	}


}
