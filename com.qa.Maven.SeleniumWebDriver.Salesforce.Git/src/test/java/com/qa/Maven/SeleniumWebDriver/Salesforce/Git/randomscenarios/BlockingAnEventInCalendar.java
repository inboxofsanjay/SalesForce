package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.randomscenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class BlockingAnEventInCalendar extends BrowserUtility{
	
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
		if (calendartext.contains(userNameNavLabel)) {
			System.out.println("Calendar for"+userNameNavLabel+ "is displayed" +calendartext);
		}
		System.out.println("Calendar for"+userNameNavLabel+ "is displayed" +calendartext);
		
		driver.findElement(By.xpath("//a[contains(text(),'8:00 AM')]")).click();
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
		WebElement starttimepicker=driver.findElement(By.id("timePickerItem_40"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", starttimepicker);
		action.moveToElement(starttimepicker).click().build().perform();
		Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.xpath("//input[@id='EndDateTime_time']")));
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
		WebElement endtimepicker=driver.findElement(By.id("timePickerItem_42"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", endtimepicker);
		action.moveToElement(endtimepicker).click().build().perform();
		Thread.sleep(5000);
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")));
		WebElement eleSave=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[contains(@name,'save')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleSave);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		Thread.sleep(4000);
		
		ArrayList<String> windowTabs1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowTabs1.size());
		Thread.sleep(2000);
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
		Actions action1=new Actions(driver); //div[contains@class,'multiLineEventBlock dragContentPointer')]
		driver.findElement(By.id("p:f:j_id25:j_id69:29:hh"));
		WebElement eventblockbusy=driver.findElement(By.id("p:f:j_id25:j_id69:29:hh"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eventblockbusy);
		action1.moveToElement(eventblockbusy).build().perform();
		Thread.sleep(3000);
		String blockevent=driver.findElement(By.xpath("//h2[contains(@class,'mainTitle')][contains(text(),'Event Detail')]")).getText();
		if (blockevent.contains("Event Detail")) {
			System.out.println("Blocked Event Details are displayed");
			}
		List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'pbBody')]//td[2]//a"));
		for(int count=0;count<list.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(list.get(count).getText()+",");
		}
		System.out.println("Blocked Event details are displayed");
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
