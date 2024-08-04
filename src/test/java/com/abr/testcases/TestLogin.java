package com.abr.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.abr.base.BaseClass;
import com.abr.dataprovider.ConfigReader;
import com.abr.dataprovider.CustomDataProvider;
import com.abr.factory.BrowserFcatory;
import com.abr.helper.Utility;
import com.abr.pages.HomePage;
import com.abr.pages.LoginPage;
import com.abr.pages.ManageCourses;

public class TestLogin extends BaseClass {
	 
	//WebDriver driver;
	@Test (priority =1, dataProvider="LoginCredentials",dataProviderClass = CustomDataProvider.class)
	public void LoginApp(String username, String Password) {

		LoginPage loginPage= new LoginPage(driver);
		Utility.captureScreenshot(driver);
	    HomePage Home=loginPage.loginToApplicationAsAdminUser(username, Password);
		
		
        Assert.assertTrue(Home.getWelcomeMessage().equalsIgnoreCase("Welcome Admin Manager to Learn Automation Courses"),"Welcome message did not appear");
		Utility.captureScreenshot(driver);

        Home.clickOnManageCourses();
		Utility.captureScreenshot(driver);
		
	
		//manage.addCourse(Password, Password, Password, username, Password);
		 

	}

}
