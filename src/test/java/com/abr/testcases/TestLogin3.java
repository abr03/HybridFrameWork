package com.abr.testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.abr.base.BaseClass;
import com.abr.dataprovider.ConfigReader;
import com.abr.dataprovider.CustomDataProvider;
import com.abr.factory.BrowserFcatory;
import com.abr.pages.HomePage;
import com.abr.pages.LoginPage;
import com.abr.pages.ManageCourses;
import com.abr.pages.SignupPage;

public class TestLogin3 extends BaseClass {
	 
	//WebDriver driver;
	@Test(priority = 1,dataProvider="NewUsersInfo",dataProviderClass = CustomDataProvider.class)
	public void createNewUser(String uname,String emailAddress,String pass,String interest,String gender,String stateValue,String hobby)
	{
		LoginPage login=new LoginPage(driver);
		
		SignupPage signup=login.clickOnNewUserLink();
			
		signup.createNewUser(uname, emailAddress, pass, interest, gender, stateValue, hobby);
		
		Assert.assertTrue(signup.isConfirmMessageDisplayed(),"User creation failed");
		
		
	}

}
