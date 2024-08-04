package com.abr.sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.abr.base.BaseClass;

public class samplescrenshot  {
	
	
	static WebDriver driver;
	
	
	
	public static void main(String[] args) throws IOException {
		driver= new ChromeDriver();
	    driver.get("https://www.geeksforgeeks.org/split-string-java-examples");
		TakeScrrenshot(driver, "./ScreenShots/Screenshot1.png");
	}
	
	
	
	
		
		
			
	
public static void TakeScrrenshot(WebDriver driver,String fileWithPath) throws IOException {
	
    TakesScreenshot ts =(TakesScreenshot) driver;
   File src= ts.getScreenshotAs(OutputType.FILE);
   File destination= new File(fileWithPath);
    FileHandler.copy(src,destination);
    driver.quit();
}
}
