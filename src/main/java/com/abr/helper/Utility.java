package com.abr.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abr.dataprovider.ConfigReader;

public class Utility {
	
	
	
	
	public static WebElement clickAddbuttonElement(WebDriver driver, By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = null;
	    
	    try {
	        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        element.click();
	    } catch (Exception e) {
	        System.out.println("Unable to click--Use JavaScript---" + e.getMessage());
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", element);
	    }
	    
	    return element;
	}
	
	  public static WebElement getElement(WebDriver driver, By locator) {
		
			
			  int sleep= (Integer.parseInt(ConfigReader.getProperty("sleep")));
			  
			  sleep(sleep);
			 
	     
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  WebElement element =
	  wait.until(ExpectedConditions.elementToBeClickable(locator));
	  //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoad"))));

	 
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", element);
	  
		
		  if(ConfigReader.getProperty("highlightElement").equalsIgnoreCase("true")) {
		  highlightElement(driver, element); }
		 
	  
	  return element;
	  }
	 
	public static void highlightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);

		try 
		{
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}

		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);

	}

	public static void sleep(int seconds) {
		try 
		{
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

		}
	}

	public static void type(WebDriver driver, By locator, String value) {

		// please complete this method
		try 
		{
			driver.findElement(locator).sendKeys(value);

		} catch (Exception e) {
			System.out.println("Not able to type - Trying values using JavaScriptExecutor");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].value=arguments[1]", getElement(driver, locator), value);
		}

	}
	public static void Sendinput(WebDriver driver, By locator, String value) {
        try {
            driver.findElement(locator).sendKeys(value);
        } catch (Exception e) {
            System.out.println("Not able to type - Trying values using JavaScriptExecutor");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(locator);

            js.executeScript("arguments[0].value = arguments[1];", element, value);
        }
	}

	public static void type(WebDriver driver, WebElement element, String value) {
		try 
		{
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("Not able to type - Trying values using JavaScriptExecutor");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].value=arguments[1]", element, value);
		}

	}

	public static void clickElement(WebDriver driver, By locator) {

		// complete this method

	}

	public static void clickElement(WebDriver driver, WebElement ele) {
		
		highlightElement(driver, ele);
		
		try 
		{
			ele.click();

		} catch (Exception e) {
			try {
				System.out.println("JS Click Failed :Trying Click Using Actions Class Click");

				Actions act = new Actions(driver);

				act.moveToElement(ele).click().build().perform();

			} catch (Exception e1) {

				System.out.println("Normal Click Failed :Trying Click Using JavaScriptExecutor");

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click()", ele);
			}

		}

	}

	public static String captureCurrentDateAndTime() {
		String date = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());

		return date;
	}

	public static String captureScreenshotAsBase64(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String screenshot=ts.getScreenshotAs(OutputType.BASE64);
        return screenshot;
		
	}
	
	public static String DirectoryCreationTest () {
		boolean dirCreated = false;
		String userDir="./Screenshots2";
		File screenshotsDir = new File(userDir);

        // Check if the directory exists
        if (!screenshotsDir.exists()) {
            System.out.println("Directory does not exist, attempting to create it...");
             dirCreated = screenshotsDir.mkdirs(); // Use mkdirs() instead of mkdir()

            // Check if the directory was successfully created
            if (dirCreated) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create the directory. Check for permissions or path issues.");
            }
        } 
        else {
            System.out.println("Directory already exists.");
        }
        return userDir;
    }

	
	public static String CpatureScreenShotAsBas64CHPT(WebDriver driver) {
		String screenshot = "";
        TakesScreenshot ts = null;        
        try {
            ts = (TakesScreenshot) driver;
            screenshot = ts.getScreenshotAs(OutputType.BASE64);
            File screenshotsDir = new File("./Screenshots2");        
      	  FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File(screenshotsDir, "Screenshot_" + Utility.captureCurrentDateAndTime() + ".png"));

            System.out.println("Screenshot captured in Screenshots directory");
        } catch (WebDriverException e) {
            System.out.println("Could not take the Base64 screenshot " + e.getMessage());
            return screenshot; // Return empty string if the screenshot cannot be captured
        } catch (Exception e) {
            System.out.println("Unexpected error while taking Base64 screenshot " + e.getMessage());
            return screenshot; // Return empty string if the screenshot cannot be captured
        }
        return screenshot; 
       
    }

	public static void captureScreenshot(WebDriver driver) {

		try {
           		
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./Screenshots2/Screenshot_"+ Utility.captureCurrentDateAndTime()+ ".png"));

			System.out.println("Screenshot captured in Screenshots directory");

		} catch (WebDriverException e) {
			System.out.println("Could not take the screenshot " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Could not save the screenshot " + e.getMessage());
		}

	}

	public static void captureScreenshotOfWebElement(WebDriver driver, WebElement ele) {

		try {
			FileHandler.copy(ele.getScreenshotAs(OutputType.FILE),
					new File("./Screenshots/Screenshot_" + Utility.captureCurrentDateAndTime() + ".png"));

			System.out.println("Screenshot captured for webelement in Screenshots directory");

		} catch (WebDriverException e) {
			System.out.println("Could not take the screenshot " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Could not save the screenshot " + e.getMessage());
		}

	}

	public static void selectValueFromList(WebDriver driver, String xpathValue, String value) {

		List<WebElement> allValues = driver.findElements(By.xpath(xpathValue));

		for (WebElement ele : allValues) {
			if (ele.getText().equalsIgnoreCase(value)) {
				ele.click();

				break;
			}
		}

	}

	public static void selectValueFromList(WebDriver driver, By locator, String value) {

		List<WebElement> allValues = driver.findElements(locator);

		for (WebElement ele : allValues) {
			if (ele.getText().equalsIgnoreCase(value)) {
				ele.click();

				break;
			}
		}

	}
}
