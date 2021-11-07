package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.usermenu;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevelopersConsole extends UserMenuDropDown{
	
	static void developerConsole() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	waitForPageElementToVisible(driver.findElement(By.linkText("Developer Console")));
	driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();
	
	Thread.sleep(5000);
	ArrayList<String> windowTabs = new ArrayList<String>(driver.getWindowHandles());
	System.out.println(windowTabs.size());
	System.out.println("Developer Console (New Window) on chrome browser opens and displayed");
	Thread.sleep(5000);
	driver.switchTo().window(windowTabs.get(1));
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(2000);
	driver.close();
	driver.switchTo().window(windowTabs.get(0));
	System.out.println("Switch to default salesforce home page window: home page is displayed");
	System.out.println(driver.getCurrentUrl());
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		userMenuDropDown();
		Thread.sleep(2000);
		developerConsole();
		Thread.sleep(4000);
		quitBrowser();

	}

}
