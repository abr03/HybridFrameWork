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
import com.abr.pages.ManageCourses;

public class TestLogin2 extends BaseClass {
	 
	//WebDriver driver;
	@Test(priority = 1,dataProvider = "LoginCredentials",dataProviderClass = CustomDataProvider.class)
	public void loginApp(String username,String password)
	{
		SoftAssert softAssert = new SoftAssert();

	    LoginPage login = new LoginPage(driver);
	    HomePage home = login.loginToApplicationAsAdminUser(username, password);
	    
	    // First assertion
	    softAssert.assertTrue(home.getWelcomeMessage().contains("Welcome"), "Welcome msg did not appear");
		/*
		 * CoursePage managecourse = home.clickOnManageCourses();
		 * managecourse.clickAddNewCourse();
		 */

	    // Second assertion
	    softAssert.assertTrue(true, "Passed");

	    // Assert all to collate results
	    softAssert.assertAll();
		
		
	}

}
