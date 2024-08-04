package com.abr.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	@DataProvider(name="LoginCredentials")
	public static Object[][] getLoginCredentials()
	{
		System.out.println("******** LOG:INFO- Setting up test data ********");
		
		Object[][]arr= ExcelReader.getDataFromExcel("LoginCredentials");
		
		System.out.println("******** LOG:INFO- Test data setup completed ********");
	
		return arr;
	}
	
	@DataProvider(name="NewUsersInfo")
	public static Object[][] getNewUserInfo()
	{
		System.out.println("******** LOG:INFO- Setting up test data ********");
		
		Object[][]arr= ExcelReader.getDataFromExcel("SignUpDetails");
		
		System.out.println("******** LOG:INFO- Test data setup completed ********");
	
		return arr;
	}
	
}
