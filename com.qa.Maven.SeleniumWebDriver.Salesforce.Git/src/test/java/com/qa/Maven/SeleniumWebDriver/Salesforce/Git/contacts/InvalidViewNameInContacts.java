package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidViewNameInContacts extends createNewContact{
	
	static void verifyCreateNewView() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		Thread.sleep(3000);
		System.out.println("Contacts page is displayed for username");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		Thread.sleep(2000);
		String createnewView=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("create new view page is displayed---> "+createnewView);
		if (createnewView.contains("Create New View")) {
			System.out.println("create new view page is displayed---> "+createnewView);
		}
		System.out.println("Step 1. Enter View Name");
		driver.findElement(By.xpath("//div[@class='pbBody']//h3[contains(text(),'Step 1. Enter View Name')]"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//label[contains(text(),'View Unique Name:')]"));
		WebElement viewuniquename=driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//input[@id='devname']"));
		viewuniquename.sendKeys(invalidViewUniqueName);
		waitForPageElementToVisible(viewuniquename);
		Thread.sleep(2000);
		WebElement save=driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@name='save']"));
		save.click();
		Thread.sleep(3000);
		
		String error=driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText();
		System.out.println("Error message when only viewuniquename is entered and view name not entered--->"+error);
		if (error.contains("You must enter a value")) {
			System.out.println("Error message when only viewuniquename is entered and view name not entered--->"+error);
		}

	}	
		static void verifyInvalidViewAndViewUniqueName() throws InterruptedException {
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
			
			waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			Thread.sleep(3000);
			System.out.println("Contacts page is displayed for username");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			Thread.sleep(2000);
			String createnewView=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
			System.out.println("create new view page is displayed---> "+createnewView);
			if (createnewView.contains("Create New View")) {
				System.out.println("create new view page is displayed---> "+createnewView);
			}
			System.out.println("Step 1. Enter View Name");
			driver.findElement(By.xpath("//div[@class='pbBody']//h3[contains(text(),'Step 1. Enter View Name')]"));
			Thread.sleep(3000);
			WebElement viewname=driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//input[@id='fname']"));
			viewname.sendKeys(invalidViewName);
			waitForPageElementToVisible(viewname);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//label[contains(text(),'View Unique Name:')]"));
			WebElement viewuniquename=driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//input[@id='devname']"));
			viewuniquename.sendKeys(invalidViewUniqueName);
			waitForPageElementToVisible(viewuniquename);
			Thread.sleep(2000);
			WebElement cancel=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='cancel']"));
			cancel.click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			String myContactsview=driver.findElement(By.xpath("//select[@id='fcf']//option")).getText();
			if (myContactsview.contains("ABCD")) {
				System.out.println("contact view name is displayed in View list--->"+invalidViewName);
			}else {
				System.out.println("contact view name is not displayed in View list--->"+invalidViewName);
			}

	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(2000);
		verifyCreateNewView();
		Thread.sleep(3000);
		verifyInvalidViewAndViewUniqueName();
		Thread.sleep(2000);
		quitBrowser();

	}

}
