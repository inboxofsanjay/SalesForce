package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginErrorMessage{

	public static void loginErrorMessage() throws InterruptedException {
		
		BrowserUtility.waitForPageElementToVisible(BrowserUtility.driver.findElement(By.id("logo")));
		BrowserUtility.waitForPageElementToVisible(BrowserUtility.driver.findElement(By.id("username")));
		System.out.println(BrowserUtility.driver.findElement(By.xpath("//input[@id='username']")).isEnabled());
		BrowserUtility.driver.findElement(By.id("username")).sendKeys(BrowserUtility.userName);
		BrowserUtility.driver.findElement(By.id("password")).sendKeys(BrowserUtility.password);
		Thread.sleep(2000);
		BrowserUtility.driver.findElement(By.id("password")).clear();
		Thread.sleep(1000);
		System.out.println("password field is empty");
		WebElement Login =BrowserUtility.driver.findElement(By.id("Login"));
		Login.click();
	}
	
	
	public static void main(String[] args) throws InterruptedException  {
		BrowserUtility.getPropertyfromFile();
		BrowserUtility.launchBrowser("ch");
		Thread.sleep(2000);
		loginErrorMessage();
		BrowserUtility.waitForPageElementToVisible(BrowserUtility.driver.findElement(By.id("error")));
		WebElement loginErr=BrowserUtility.driver.findElement(By.id("error"));
		String error= loginErr.getText();
		System.out.println("Login Page Error message ---->"+error);
		
		if (error.equalsIgnoreCase("Please enter your password.")) {
			System.out.println("Test ID: Login Error Message - 1: Pass");
		} else {
			System.out.println("Test ID: Login Error Message - 1: Fail");
		}
		Thread.sleep(2000);
		BrowserUtility.quitBrowser();
	
	}

}
