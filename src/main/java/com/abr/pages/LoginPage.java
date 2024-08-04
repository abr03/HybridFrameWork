package com.abr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abr.base.BaseClass;
import com.abr.helper.Utility;

public class LoginPage {
	

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	private By signUpLink=By.xpath("//a[normalize-space()='New user? Signup']");

	private By username=By.xpath("//input[@placeholder='Enter Email']");
	
	private By password=By.name("password1");

	private By loginButton=By.className("submit-btn");
		

	public SignupPage clickOnNewUserLink()
	{
		Utility.getElement(driver, signUpLink).click();
		
		SignupPage signup=new SignupPage(driver);
		
		return signup;
	}
		
	public HomePage loginToApplicationAsAdminUser(String user,String pass)
	
	{	
	//	Utility.getElement(driver, username).sendKeys(user);
		Utility.Sendinput(driver, username, user);
		
		Utility.Sendinput(driver, password, pass);
		
		Utility.getElement(driver, loginButton).click();
		
		HomePage home=new HomePage(driver);
		
		return home;
		
	}
	
}
