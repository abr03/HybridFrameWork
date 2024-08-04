package com.abr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abr.helper.Utility;

public class HomePage {

	
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By welcomeMsg=By.xpath("//h4[contains(text(),'Welcome')]");
	
	private By manageOptions=By.xpath("//span[normalize-space()='Manage']");
	
	private By manageCourses=By.xpath("//a[normalize-space()='Manage Courses']");
	
	
	public String getWelcomeMessage()
	{
		String welcomeText=Utility.getElement(driver, welcomeMsg).getText();
		
		return welcomeText;
	}
	
	public ManageCourses clickOnManageCourses()
	{
		Utility.getElement(driver, manageOptions).click();
		Utility.getElement(driver, manageCourses).click();
		ManageCourses manageCourse= new ManageCourses(driver);
		//CoursePage course= new CoursePage(driver);
		return manageCourse;
	}
	
	
}
