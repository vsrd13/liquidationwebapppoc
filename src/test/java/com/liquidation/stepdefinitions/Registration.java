package com.liquidation.stepdefinitions;

import org.junit.Assert;

import com.cucumber.listener.Reporter;
import com.liquidation.pages.Registrationpage;
import com.liquidation.runner.LiquidationRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Registration extends LiquidationRunner{
	
	Registrationpage registrationpage;
	
	
	@Given("^I want to navigate to Liquidation\\.com web Application URL$")
	public void i_want_to_navigate_to_Liquidation_com_web_Application_URL() throws Throwable {
		
		 
	    
		Reporter.addStepLog("navigated to the URL:" + config.getProperty("siteUrl"));
		
		Assert.assertEquals("Wholesale Lots and Surplus Auctions Online | Liquidation.com", driver.getTitle());
		 Reporter.addStepLog("Liquidation.com Page Title: " + driver.getTitle());
		
		
	}

	@When("^I want to click on Register link$")
	public void i_want_to_click_on_Register_link() throws Throwable {
		
		registrationpage = new Registrationpage();
		registrationpage.clickonRegistrationLink();
		Reporter.addStepLog("Clicked on Register link.");
	    
	}

	
	@Then("^user navigates to the Liquidation\\.com registertation page and verify the title$")
	public void user_navigates_to_the_Liquidation_com_and_verify_the_title() throws Throwable {
	   
		
		 Assert.assertEquals("Register | Liquidity Services", registrationpage.registrationpageTitle());
		 Reporter.addStepLog("Registration Page Title is: " + registrationpage.registrationpageTitle());
	}

	@And("^enter the details for completing the user registration process$")
	public void enter_the_details_for_completing_the_user_registration_process() throws Throwable {
		registrationpage.registrationForm();
		Reporter.addStepLog("user auccessfully entered details fro registration process...!");
	}


}
