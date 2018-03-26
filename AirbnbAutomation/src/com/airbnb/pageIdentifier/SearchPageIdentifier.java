package com.airbnb.pageIdentifier;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.airbnb.utility.MainDriver;

public class SearchPageIdentifier {
	
	public SearchPageIdentifier()
	{
		PageFactory.initElements(MainDriver.driver,
				this);
	}
	

	@FindBy(how = How.XPATH, 
			using = "//button[contains(@aria-controls,'menuItemComponent-dynamicMoreFilters')]")
	public WebElement btnMoreFilter;
	
	@FindBy(how = How.XPATH, using = "//label[contains(@for,'amenities')]")
	public List<WebElement> chkBoxAmenities;
	
	@FindBy(how = How.XPATH, 
			using = "//button[contains(@aria-controls,'menuItemComponent-price_range')]")
	public WebElement btnPriceFilter;
	
	@FindBy(how = How.XPATH, 
			using = "//button[contains(@aria-label,'Minimum Price')]")
	public WebElement btnMinPrice;
	
	@FindBy(how = How.XPATH, 
			using = "//span[@data-action='save']/button")
	public WebElement btnApply;
	
	@FindBy(how = How.XPATH, 
			using = "//div[@class='_1yarz4r']")
	public List<WebElement> searchList;


}
