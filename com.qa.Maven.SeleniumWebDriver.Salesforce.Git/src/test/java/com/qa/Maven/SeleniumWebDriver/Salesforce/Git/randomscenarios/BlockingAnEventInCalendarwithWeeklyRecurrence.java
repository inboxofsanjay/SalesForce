package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.randomscenarios;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class BlockingAnEventInCalendarwithWeeklyRecurrence extends BrowserUtility{
	
static void blockingcalendartime() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(4000);
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		waitForPageElementToVisible(driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a")));
		String currentusername=driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a")).getText();
		System.out.println("username edited in contact tab of profile page--->"+currentusername);
		if (currentusername.contains(userNameNavLabel)) {
			System.out.println("The calendar for first name and last name is displayed");
		}
		
		String currentdate=driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]//a")).getText();
		System.out.println("Todaysdate --->"+currentdate);
		
		driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]//a")).click();
		Thread.sleep(2000);
		String calendartext=driver.findElement(By.xpath("//h1[contains(@class,'pageType')]")).getText();
		System.out.println("Calendar for"+userNameNavLabel+ "is displayed" +calendartext);
		if (calendartext.contains(userNameNavLabel)) {
			System.out.println("Calendar for"+userNameNavLabel+ "is displayed" +calendartext);
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText().equalsIgnoreCase("New Event")) {
			System.out.println("Calendar New Event is displayed");
		}
		driver.findElement(By.xpath("//table[1]//tbody[1]//tr[2]//td[1]//label[contains(text(),'Subject')]"));
		
		Boolean subject=driver.findElement(By.xpath("//input[@id='evt5']")).isEnabled();
		if (subject=true) {
			System.out.println("By default subject field is enabled to take input");
		}
		
		driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]")).click();
		Thread.sleep(3000);
		ArrayList<String> windowTabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowTabs.size());
		System.out.println("Select Subject combobox opens");
		Thread.sleep(5000);
		driver.switchTo().window(windowTabs.get(1));
		System.out.println(driver.getCurrentUrl());		
		String selectcombobox=driver.findElement(By.xpath("//div[@class='bPageTitle']//div[@class='ptBody secondaryPalette']//h1[@class='pageDescription']")).getText();
		System.out.println(selectcombobox);
		if (selectcombobox.contains("Select a Subject below.")) {
			System.out.println("combobox window is displayed");
		}
		driver.findElement(By.xpath("//li[@class='listItem4']//a[contains(text(),'Other')]")).click();
		System.out.println("the parent window is displayed");
		driver.switchTo().window(windowTabs.get(0));
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		driver.findElement(By.xpath("//input[@id='StartDateTime_time']")).click();
		Thread.sleep(1000);
		waitForPageElementToVisible(driver.findElement(By.id("timePickerItem_32")));
		WebElement starttimepicker=driver.findElement(By.id("timePickerItem_32"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", starttimepicker);
		action.moveToElement(starttimepicker).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
		WebElement endtimepicker=driver.findElement(By.id("timePickerItem_38"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", endtimepicker);
		action.moveToElement(endtimepicker).click().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).click();
		driver.findElement(By.xpath("//img[@class='calRight']")).click();
		WebElement enddate=driver.findElement(By.xpath("//td[contains(text(),'29')]"));
		enddate.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//tr[@class='detailRow']//td//input[@id='IsRecurrence']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='recurrenceTable']//tbody//tr//td[1]//input[@id='rectypeftw']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).click();
		driver.findElement(By.xpath("//img[@class='calRight']")).click();
		Thread.sleep(1000);
		WebElement reccurrenceenddate=driver.findElement(By.xpath("//tr[@id='calRow3']//td[contains(text(),'14')]"));
		reccurrenceenddate.click();
		Thread.sleep(2000);
		
		WebElement eleSave=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleSave);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		Thread.sleep(4000);
		ArrayList<String> windowTabs1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowTabs1.size());
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(windowTabs1.get(1));
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(By.xpath("//div[@id='summary0']//tr[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='summary0']//tr[2]")).getText());
		driver.close();
		driver.switchTo().window(windowTabs1.get(0));
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		System.out.println("Calendar is displayed with selected time slot");
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(1000);
		blockingcalendartime();
		Thread.sleep(2000);
		quitBrowser();

	}

}
