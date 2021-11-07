package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class VerifyButtonsOnContacts extends createNewContact{
	
	static void verifyNewAndSaveButtonsOnContact() throws InterruptedException {
		
		createnewContact(); 
		
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]"));
		String contactedit=driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]")).getText();
		System.out.println("Contact Edit page---->"+contactedit);
		Thread.sleep(2000);
		System.out.println("Contact Information:");
		driver.findElement(By.xpath("//div[@id='head_1_ep']//h3[contains(text(),'Contact Information')]"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Contact Owner')]"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//td[contains(text(),'Arathi R')]")).isEnabled();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Last Name')]"));
		WebElement lastname=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[@id='name_lastcon2']"));
		lastname.sendKeys(newContactLastName);
		System.out.println("Last name is entered");
		waitForPageElementToVisible(lastname);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Account Name')]"));
		WebElement accountname=driver.findElement(By.xpath("//input[@id='con4']"));
		accountname.sendKeys(newContactACCTName);
		System.out.println("Account name is entered");
		waitForPageElementToVisible(accountname);
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		save.click();
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText().contains(newContactLastName)) {
			System.out.println("New contact name page is displayed" +newContactLastName+ "With Account Details");	
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
	
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		verifyNewAndSaveButtonsOnContact();
		quitBrowser();
	}

}
