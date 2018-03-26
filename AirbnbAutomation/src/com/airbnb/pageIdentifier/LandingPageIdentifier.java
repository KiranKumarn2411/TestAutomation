package com.airbnb.pageIdentifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.airbnb.utility.MainDriver;

public class LandingPageIdentifier {

	 public LandingPageIdentifier() {
		
		PageFactory.initElements(MainDriver.driver,
				this);
	}
	@FindBy(how = How.ID, using = "GeocompleteController-via-SearchBarV2-SearchBarV2")
	public WebElement editSearch;

	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']/span")
	public WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@data-veloute,'homes')]")
	public WebElement btnHomes;
	
	
}
