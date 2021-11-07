package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewView extends CreateAccounts{
	
	public static void verifyAccountsPage() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		Thread.sleep(3000);
		System.out.println("Accounts page is displayed for username");
		Thread.sleep(2000);
		
	}
	
	static void createNewView() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		Thread.sleep(2000);
		String createnewView=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("create new view page is displayed---> "+createnewView);
		System.out.println("Step 1. Enter View Name");
		driver.findElement(By.xpath("//div[@class='pbBody']//h3[contains(text(),'Step 1. Enter View Name')]"));
		driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//label[contains(text(),'View Name:')]"));
		WebElement viewname=driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//input[@id='fname']"));
		viewname.sendKeys(devViewName);
		waitForPageElementToVisible(viewname);
		driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//label[contains(text(),'View Unique Name:')]"));
		WebElement viewuniquename=driver.findElement(By.xpath("//div[@id='contentWrapper']//table[1]//input[@id='devname']"));
		viewuniquename.sendKeys(devViewUniqueName);
		waitForPageElementToVisible(viewuniquename);
		WebElement save=driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@name='save']"));
		save.click();
		Thread.sleep(3000);
		
		System.out.println("New view with viewname saved" +devViewName+ "is displayed on Accounts page");
			
	}
	
	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		verifyAccountsPage();
		createNewView();
		Thread.sleep(3000);
		quitBrowser();
		

	}

}
