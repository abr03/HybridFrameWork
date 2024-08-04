package com.abr.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.abr.dataprovider.ConfigReader;
import com.abr.factory.BrowserFcatory;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void Setup() {
	driver=BrowserFcatory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));
		
	}
	
	
	@AfterTest
	public void TearDown() {
		
	BrowserFcatory.closeAllSession(driver);
	}

}
