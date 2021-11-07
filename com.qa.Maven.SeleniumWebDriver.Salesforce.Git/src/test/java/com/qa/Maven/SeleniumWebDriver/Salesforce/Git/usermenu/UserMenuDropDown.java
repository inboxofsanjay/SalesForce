package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.usermenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class UserMenuDropDown extends BrowserUtility{
	
	
	public static void userMenuDropDown() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println(driver.findElement(By.id("userNav")).getAttribute("title"));
		System.out.println(driver.findElement(By.id("userNavLabel")).getText());
		System.out.println("User Menu drop down is available");
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		WebElement usermenubutton=driver.findElement(By.id("userNavButton"));
		action.moveToElement(usermenubutton).click().build().perform();
		Thread.sleep(5000);
		System.out.println("User Menu drop down is displayed");
		System.out.println(driver.findElement(By.linkText("My Profile")).getAttribute("title"));
		System.out.println(driver.findElement(By.linkText("My Settings")).getAttribute("title"));
		System.out.println(driver.findElement(By.linkText("Developer Console")).getAttribute("title"));
		System.out.println(driver.findElement(By.xpath("//a[@class='menuButtonMenuLink'][contains(text(),'Switch')]")).getAttribute("title"));
		System.out.println(driver.findElement(By.linkText("Logout")).getAttribute("title"));
		}

	public static void main(String[] args) throws InterruptedException {
		
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		waitForPageElementToVisible(driver.findElement(By.id("userNavLabel")));
		if (driver.findElement(By.id("userNavLabel")).getText().contains(userNameNavLabel)) {
			System.out.println("Salesforce Home Page is dipslayed");
		}
		userMenuDropDown(); 
		Thread.sleep(2000);
		quitBrowser();
		
	}

}
