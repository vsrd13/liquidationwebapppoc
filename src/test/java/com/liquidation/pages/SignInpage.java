package com.liquidation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liquidation.runner.LiquidationRunner;

public class SignInpage extends LiquidationRunner{
	
	@FindBy(xpath="//span[contains(text(),'Sign In')]")
	public static WebElement signLink;
	
	@FindBy(xpath="//h4[contains(text(),'Sign in now, to continue buying, selling and managing your auctions.')]")
	public static WebElement signPageText;
	
	@FindBy(name="j_username")
	public static WebElement signUsername;
	
	@FindBy(name="j_password")
	public static WebElement signPassword;
	
	@FindBy(id="loginEnter")
	public static WebElement signBtn;
	
	
	@FindBy(linkText="My Account")
	public static WebElement myAccountLink;
	
	public SignInpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String signpageTitle()
	{
		return driver.getTitle();
	}
	
	public void signPage()
	{
		signLink.click();
		
		Assert.assertEquals("Sign in now, to continue buying, selling and managing your auctions.",signPageText.getText());
		signUsername.sendKeys(config.getProperty("username"));
		signPassword.sendKeys(config.getProperty("password"));
		signBtn.click();
		
		
	}
	
	public boolean signPageconfirmation()
	{
		 return myAccountLink.isDisplayed();
	}
	

}
