package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyContactsView extends createNewContact{
	
	static void myContactsView() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		Thread.sleep(6000);
		String contacts=driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).getText();
		System.out.println(contacts);
		System.out.println("Contacts home page is displayed");
		if (contacts.contains("Recent Contacts")) {
			System.out.println("Contacts home page is displayed");
		}
		System.out.println("Contacts page is displayed for username");
		Thread.sleep(3000);
		WebElement myContacts=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select dropdown=new Select(myContacts);
		dropdown.selectByVisibleText("My Contacts");
		Thread.sleep(3000);
		if (myContacts.getText().contains("My Contacts")) {
			System.out.println("My Contacts page is displayed in View");
		}
		System.out.println("My Contacts page is displayed");
	}
	
	static void viewContactInRecentContacts() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	
		Thread.sleep(3000);
		Actions action=new Actions(driver);
			
		WebElement contactlink=driver.findElement(By.xpath("//tr[contains(@class,'dataRow odd')]//th[contains(@class,'')]//a[contains(text(),'R')]"));
		waitForPageElementToVisible(contactlink);
		action.click(contactlink).build().perform();
		Thread.sleep(4000);
		System.out.println("New view with viewname saved" +lastName+ "is displayed on contacts page");
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		myContactsView();
		Thread.sleep(3000);
//		viewContactInRecentContacts();
		Thread.sleep(3000);
		quitBrowser();

	}

}
