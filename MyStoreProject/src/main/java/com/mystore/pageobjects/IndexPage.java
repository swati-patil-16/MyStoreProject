package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import com.mystore.utility.Log;
import com.mystore.actiondriver.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass{

    Log log;
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		Action.fluentWait(driver, signInBtn, 10);
		Action.click(driver, signInBtn);
		Log.info("Clicked on Sign in Button");
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		Log.info("Logo is Displayed");
		return Action.isDisplayed(driver, myStoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=driver.getTitle();
		Log.info("Title of the page is"+ myStoreTitle);
		return myStoreTitle;
		
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.scrollbyVisibilityOfElement(driver, searchButton);
		Action.click(driver, searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	



}