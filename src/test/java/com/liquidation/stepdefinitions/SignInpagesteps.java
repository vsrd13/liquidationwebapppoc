package com.liquidation.stepdefinitions;

import com.cucumber.listener.Reporter;
import com.liquidation.pages.SignInpage;
import com.liquidation.runner.LiquidationRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SignInpagesteps extends LiquidationRunner {

	SignInpage signpage;

	@Given("^user to navigate to Liquidation\\.com web Application URL$")
	public void user_to_navigate_to_Liquidation_com_web_Application_URL() throws Throwable {
		
		driver.navigate().to(config.getProperty("siteUrl"));

		Reporter.addStepLog("navigated to the URL:" + config.getProperty("siteUrl"));

		Assert.assertEquals("Wholesale Lots and Surplus Auctions Online | Liquidation.com", driver.getTitle());

	}

	@When("^user click on SignIn link and enters username and password for signin$")
	public void user_click_on_SignIn_link_and_enters_username_and_password_for_signin() throws Throwable {

		signpage = new SignInpage();

		signpage.signPage();

	}

	@Then("^Confirm the user successfully signed in$")
	public void confirm_the_user_successfully_signed_in() throws Throwable {

		Assert.assertTrue("My Account Link is Displayed..!", signpage.signPageconfirmation());
		Reporter.addStepLog("Succesfully signed in as a user" + config.getProperty("username"));

	}

}
