package com.abr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abr.helper.Utility;

public class ManageCourses {
	
WebDriver driver;
	
	
	public ManageCourses(WebDriver driver) {
		this.driver=driver;
	}
	private By addNewCoursebtn= By.xpath("//button[normalize-space()='Add New Course']");
	private By chooseFilebtn=By.xpath("//input[@id='thumbnail']");
	private By courseName=By.xpath("//input[@id='name']");
	private By description=By.xpath("//textarea[@id='description']");
	private By price=By.xpath("//input[@id='price']");
	private By selectCategory=By.xpath("//div[text()='Select Category']");
	private By selectCourse=By.xpath("//button[normalize-space()='Playwright']");
	private By instructor=By.xpath("//input[@id='instructorNameId']");
	private By saveBtn=By.xpath("//button[normalize-space()='Save']");
	private By courseVerify= By.xpath("//td[normalize-space()='AWS']");
	
	public void selectAddNewCourse() {
	Utility.clickAddbuttonElement(driver, addNewCoursebtn).click();
	//Utility.getElement(driver, addNewCoursebtn).click();


	}
	
	
	public void addCourse(String filepathbtn,String course,String desc,String instruct,String coursePrice)
	{
	
		Utility.getElement(driver, chooseFilebtn).sendKeys(filepathbtn);
		Utility.getElement(driver, courseName).sendKeys(course);
		Utility.getElement(driver, description).sendKeys(desc);
		Utility.getElement(driver, instructor).sendKeys(instruct);
		Utility.getElement(driver, price).sendKeys(coursePrice);
		Utility.getElement(driver, selectCategory).click();
	    Utility.getElement(driver, selectCourse).click();
	    Utility.getElement(driver, saveBtn).click();
		
		
	}
	public boolean checkCoursePresence()
	{
		boolean coursePresence=Utility.getElement(driver, courseVerify).isDisplayed();
		
		return coursePresence;
	}

}