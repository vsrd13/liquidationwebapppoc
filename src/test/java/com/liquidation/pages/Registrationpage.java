package com.liquidation.pages;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.liquidation.runner.LiquidationRunner;
import com.liquidation.utils.ReadExcelData;

public class Registrationpage extends LiquidationRunner {

	Select countryselect;
	Select stateselect;
	
	public ReadExcelData readExcelData;
	
	Random rand = new Random();

	/*
	 * Registration Page factory Class
	 */

	@FindBy(xpath = "//div[@class='customer-info']/div[1]")
	public static WebElement accountInformationtext;

	@FindBy(xpath = "//div[@class='customer-info']/div[1]")
	public static WebElement businessInformationtext;

	@FindBy(xpath = "//div[@class='customer-info']/div[1]")
	public static WebElement Preferencestext;

	@FindBy(linkText = "Register")
	public static WebElement registerLink;

	@FindBy(id = "username")
	public static WebElement userName;

	@FindBy(id = "email")
	public static WebElement email;

	@FindBy(id = "confirmEmail")
	public static WebElement verifyEmail;

	@FindBy(id = "firstname")
	public static WebElement firstName;

	@FindBy(id = "lastname")
	public static WebElement lastName;

	@FindBy(id = "country")
	public static WebElement country;

	@FindBy(id = "address")
	public static WebElement addressLine1;

	@FindBy(id = "city")
	public static WebElement city;

	@FindBy(name = "states_dropdown")
	public static WebElement state;

	@FindBy(id = "postalCode")
	public static WebElement postalCode;

	@FindBy(id = "phone")
	public static WebElement phonenumber;

	@FindBy(id = "additionalInfo.accountActivation1")
	public static WebElement passwordActivationcheckbox;

	@FindBy(xpath = "//input[@id='additionalInfo.businessType2']")
	public static WebElement typeofBusinessradioButton;

	@FindBy(xpath = "//input[@id='liquidation_background1-acf4a39d-918e-454e-8ed4-2807f5f16761']")
	public static WebElement experienceradioButton;

	@FindBy(xpath = "//input[@id='lcom_category_email_subscriptions_types0-acf4a39d-918e-454e-8ed4-2807f5f16761']")
	public static WebElement clothingandaccessoriesCheckBox;

	@FindBy(xpath = "//input[@id='lcom_special_email_subscriptions_types0-acf4a39d-918e-454e-8ed4-2807f5f16761']")
	public static WebElement specialAlertsCheckBox;

	@FindBy(xpath = "//input[@id='lcom_email_consent0-acf4a39d-918e-454e-8ed4-2807f5f16761']")
	public static WebElement liquidationcomEmailCommunicationradioBtn;

	@FindBy(xpath = "//div[@class='modal-header']/h3")
	public static WebElement popupBoxText;

	@FindBy(xpath = "//button[@class='btn btn-large btn-primary submitRegistration']")
	public static WebElement iagreeTermsandConditionsBtn;

	@FindBy(xpath = "//input[@id='submit_melissa']")
	public static WebElement alertSubmitBtn;

	@FindBy(xpath = "//div[@class='span8']/h1/label")
	public static WebElement confirmationText;

	public Registrationpage() {
		PageFactory.initElements(driver, this);
		readExcelData = new ReadExcelData();
	}

	public void clickonRegistrationLink() {
		registerLink.click();
	}

	public String registrationpageTitle() {
		return driver.getTitle();
	}

	public void registrationForm() {

		accountInformationtext.isDisplayed();
		System.out.println(accountInformationtext.getText());
		userName.clear();
		System.out.println("***************username :" + readExcelData.readData("Username"));
		userName.sendKeys(readExcelData.readData("Username") + rand.nextInt());
		email.clear();
		
		email.sendKeys(readExcelData.readData("Email") + rand.nextInt() + "@gmail.com");
		
		System.out.println("*******Email" + email.getAttribute("value"));
		verifyEmail.clear();
		verifyEmail.sendKeys( email.getAttribute("value"));
		firstName.clear();
		firstName.sendKeys(readExcelData.readData("Firstname"));
		lastName.clear();
		lastName.sendKeys(readExcelData.readData("LastName"));

		countryselect = new Select(country);
		
		System.out.println("Country Selected:" + country.getAttribute("value"));

		if (country.getAttribute("value") == readExcelData.readData("Country")) {
			System.out.println("Contry Selected as: " + country.getAttribute("value"));

		} else {
			countryselect.selectByVisibleText(readExcelData.readData("Country1"));
			System.out.println("Country Selected:" + country.getAttribute("value"));
		}

		addressLine1.clear();
		addressLine1.sendKeys(readExcelData.readData("Address Line1"));
		city.clear();
		city.sendKeys(readExcelData.readData("City"));
		stateselect = new Select(state);

		if (state.getAttribute("value") == readExcelData.readData("State")) {
			System.out.println("State Selected as: " + state.getAttribute("value"));
		} else {
			stateselect.selectByVisibleText(readExcelData.readData("State"));
			System.out.println("State Selected as: " + state.getAttribute("value"));
		}
		postalCode.clear();
		postalCode.sendKeys(readExcelData.readData("Postalcode"));
		phonenumber.clear();
		phonenumber.sendKeys(readExcelData.readData("Phone"));

		if (passwordActivationcheckbox.isSelected() == true) {
			System.out.println("Email Temporary Password Activation Method is selected..!");
		} else {
			passwordActivationcheckbox.click();
			System.out.println("Email Temporary Password Activation Method is selected..!");
		}

		businessInformationtext.isDisplayed();

		if (typeofBusinessradioButton.isSelected() == true) {
			System.out.println("Type of Business is selected as End User..!");
		} else {
			typeofBusinessradioButton.click();
			System.out.println("Type of Business is selected as End User..!");
		}

		Preferencestext.isDisplayed();

		if (experienceradioButton.isSelected() == false) {
			experienceradioButton.click();
			System.out.println("New to Liquidation.com checkBox is selected..!");
		} else {
			System.out.println("New to Liquidation.com checkBox is selected..!");
		}

		if (clothingandaccessoriesCheckBox.isSelected() == true) {
			System.out.println("Clothing and Accessories CheckBox email subscription category is selected..!");
		} else {
			clothingandaccessoriesCheckBox.click();

			System.out.println("Clothing and Accessories CheckBox email subscription category is selected..!");
		}

		if (specialAlertsCheckBox.isSelected() == true) {
			System.out.println("Special Alerts discounts is selected..!");
		} else {
			specialAlertsCheckBox.click();
			System.out.println("Special Alerts discounts is selected..!");
		}

		if (liquidationcomEmailCommunicationradioBtn.isSelected() == true) {
			System.out.println("Yes, I would like to receive email communications from Liquidation.com is selected..!");
		} else {
			liquidationcomEmailCommunicationradioBtn.click();
			System.out.println("Yes, I would like to receive email communications from Liquidation.com is selected..!");

		}

		iagreeTermsandConditionsBtn.click();

		alertSubmitBtn.click();

		Assert.assertEquals("You're almost there!", confirmationText.getText());

		System.out.println("Registration confirmation message: " + confirmationText.getText());

	}

}
