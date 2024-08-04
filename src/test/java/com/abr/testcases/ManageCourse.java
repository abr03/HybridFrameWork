package com.abr.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.abr.base.BaseClass;
import com.abr.pages.HomePage;
import com.abr.pages.LoginPage;
import com.abr.pages.ManageCourses;

public class ManageCourse extends BaseClass {
	
	@Test(priority = 1)
	public void createCourse()
	{
		LoginPage login= new LoginPage(driver);
		
		HomePage home=login.loginToApplicationAsAdminUser("admin@email.com","admin@123");
	
		ManageCourses course=home.clickOnManageCourses();
		course.selectAddNewCourse();
		//course.addCourse(System.getProperty("C://Users//akbhaska//Desktop//Screenshot 2024-08-01 150332.png")+"/TestData/CourseThumbnail.png","AWS","AWS course","Mukesh","10000");
		//course.checkCoursePresence();
		//course.clickAddNewCourse();
		//Assert.assertTrue(course.checkCoursePresence());
		
		// take data from excel and pass as argument
		
	}
	
	@Test(priority=2, enabled = false)
	public void deactivateCourse()
	{
		
		// complete this method
	}
	
	@Test(priority=3,dependsOnMethods = "deactivateCourse", enabled  =false)
	public void activatedCourse()
	{
		// complete this method
		
	}
	
	@Test(priority=4,dependsOnMethods = "createCourse",enabled = false)
	public void deletCourse()
	{
		
		// complete this method
	}



}
