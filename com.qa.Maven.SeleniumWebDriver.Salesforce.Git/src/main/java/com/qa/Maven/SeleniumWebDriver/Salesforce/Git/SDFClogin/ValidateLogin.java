package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateLogin extends BrowserUtility{

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		waitForPageElementToVisible(driver.findElement(By.id("logo")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		driver.findElement(By.id("username")).sendKeys(userNameInvalid);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(passwordInvalid);
		Thread.sleep(2000);
		
		WebElement Login =driver.findElement(By.id("Login"));
		Login.click();
		
		Thread.sleep(2000);
		WebElement error=driver.findElement(By.id("error"));
		String errormsg=error.getText();
		System.out.println(errormsg);
		
		if (errormsg.contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) 
		{
		System.out.println("Validated Login Error Message: Passed");	
		}else {
			System.out.println("Validated Login Error Message: Failed");
		}

		Thread.sleep(3000);
		quitBrowser();
	}

}
