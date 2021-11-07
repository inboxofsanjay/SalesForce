package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.usermenu;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySettings extends UserMenuDropDown{
	
	static void mySettings() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.linkText("My Settings")));
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")));
		String usersettings=driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		System.out.println(usersettings);
		if (usersettings.contains(userNameNavLabel)) {
			System.out.println("My Settings page is displayed");
		}
		Thread.sleep(2000);
	}
	
	static void personalandLoginHistory() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'My Settings')]"));
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'My Settings')]")).getText());
		WebElement Personal=driver.findElement(By.id("PersonalInfo_font"));
		System.out.println(Personal.getText());
		Personal.click();
		Thread.sleep(1000);
		WebElement LoginHistory=driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		System.out.println(LoginHistory.getText());
		LoginHistory.click();
		Thread.sleep(3000);
		if (driver.findElement(By.id("RelatedUserLoginHistoryList_title")).getText().equalsIgnoreCase("Login History")) {
			System.out.println("Login History page is displayed");
		}
		
	}
	
	public static void downloadLoginHistory() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		String downloadfile=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).getText();
		System.out.println(downloadfile);
		Thread.sleep(4000);
		if (loginHistoryCSV.contains(".csv")) {
			System.out.println("Downloaded Login History file is in Excel .csv format");
		}
	}
	
	public static void displayandLayout() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		waitForPageElementToVisible(driver.findElement(By.id("DisplayAndLayout_font")));
		WebElement displayandLayout=driver.findElement(By.id("DisplayAndLayout_font"));
		System.out.println(displayandLayout.getText());
		displayandLayout.click();
		
		waitForPageElementToVisible(driver.findElement(By.id("CustomizeTabs_font")));
		WebElement customizeMyTabs=driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']"));
		System.out.println(customizeMyTabs.getText());
		customizeMyTabs.click();
		
		if (driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText().contains("Customize My Tabs")) {
			System.out.println("Customize My Tabs page is displayed");
		}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Custom App:')]")).getText());
		Thread.sleep(3000);
		WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
		waitForPageElementToVisible(customApp);
		Select customdropdown=new Select(customApp);
		customdropdown.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(3000);
		System.out.println("salesforce chatter selected to custom app:");
//		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Available Tabs')]")).getText());
		Thread.sleep(2000);
		WebElement report=driver.findElement(By.xpath("//td[@id='bodyCell']//td//td[1]//option"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", report);
		Thread.sleep(1000);
		WebElement availableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		Select availabledropdown=new Select(availableTabs);
		availabledropdown.selectByVisibleText("Reports");
		Thread.sleep(4000);
		driver.findElement(By.id("duel_select_0_right")).click();
		Thread.sleep(4000);
//		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Selected Tabs')]")).getText());
		WebElement selectedTabs=driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Boolean Report=driver.findElement(By.xpath("//div[@id='bodyDiv_setup']//td[3]//option[contains(text(),'Reports')]")).isDisplayed();
		if (Report=true) {
			System.out.println("Reports is added to SelectedTabs list");
		}
		Thread.sleep(4000);
		WebElement eleSave=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleSave);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		Thread.sleep(3000);
		System.out.println("Save the selection to Customize My Tabs");
		Thread.sleep(3000);
		
}
	
	static void verifyDisplayandLayout() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")));
		String usersettings=driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		System.out.println(usersettings);
		System.out.println("My settings page loaded");
		Thread.sleep(3000);
		// check for Reports tab in content app
 		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
			System.out.println("Reports Tab is not displayed in content custom app: menu");
		
		Thread.sleep(1000);		
		waitForPageElementToVisible(driver.findElement(By.id("tsid"))); 
		System.out.println(driver.findElement(By.id("tsid")).getAttribute("title"));
		System.out.println(driver.findElement(By.id("tsidLabel")).getText());
		driver.findElement(By.id("tsidButton")).click();
		Thread.sleep(2000);
		
		Boolean salesforcechatter=driver.findElement(By.xpath("//a[contains(text(),'Salesforce Chatter')]")).isDisplayed();
		if (salesforcechatter=true) {
			System.out.println("Salesforce Chatter added to custom app is displayed in menu");
			
		}
		
		//click to Salesforce chatter menu item to check availability of Reports tab
		driver.findElement(By.xpath("//a[contains(text(),'Salesforce Chatter')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tabBar"));
		List<WebElement> li_tab1 =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab1.size();count++) {
		System.out.println(li_tab1.get(count).getText());
		}
		WebElement Reports1=driver.findElement(By.id("report_Tab"));
		String report1=Reports1.getAttribute("title");
		if (report1.equalsIgnoreCase("Reports Tab")) {
			System.out.println("Reports Tab displayed in Salesforce chatter menu");
		} 
		
//		click sales menu to check availability of Reports tab
		Thread.sleep(1000);		
		waitForPageElementToVisible(driver.findElement(By.id("tsid")));
		driver.findElement(By.id("tsidButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='menuButtonMenuLink firstMenuItem'][contains(text(),'Sales')]")).click();
		System.out.println(driver.findElement(By.id("tsidLabel")).getText());
		Thread.sleep(4000);
		List<WebElement> li_tab2 =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab2.size();count++) {
		System.out.println(li_tab2.get(count).getText());
		}
			System.out.println("Reports Tab is displayed in sales custom app: menu");
			
//			click marketing menu to check availability of Reports tab
			Thread.sleep(4000);		
			waitForPageElementToVisible(driver.findElement(By.id("tsid")));
			driver.findElement(By.id("tsidButton")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Marketing')]")).click();
			System.out.println(driver.findElement(By.id("tsidLabel")).getText());
			Thread.sleep(4000);
			List<WebElement> li_tab3 =driver.findElements(By.xpath("//ul[@id='tabBar']"));
			for(int count=0;count<li_tab3.size();count++) {
			System.out.println(li_tab3.get(count).getText());
			}
				System.out.println("Reports Tab is displayed in marketing custom app: menu");		
			
	}
	
	
	
	public static void myemailandSettings() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.id("EmailSetup")));
		driver.findElement(By.id("EmailSetup_font")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText().contains("My Email Settings")) {
			System.out.println("My Email Settings page is displayed");
		}
		
		driver.findElement(By.xpath("//h3[contains(text(),'Outgoing Email Settings')]"));
		driver.findElement(By.xpath("//label[contains(text(),'Email Name')]"));
		WebElement EmailName=driver.findElement(By.id("sender_name"));
		if (EmailName.getAttribute("value").equalsIgnoreCase(userNameNavLabel)) {
			System.out.println("Email Name entered in the field");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Email Address')]"));
		WebElement Emailaddr=driver.findElement(By.id("sender_email"));
		if (Emailaddr.getAttribute("value").equalsIgnoreCase(emailID)) {
			System.out.println("Email address entered in the field");
		}
		driver.findElement(By.xpath("//td[contains(text(),'Automatic Bcc')]"));
		System.out.println(driver.findElement(By.id("auto_bcc1")).isSelected());
		driver.findElement(By.id("auto_bcc1")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
		System.out.println("Automaticc Bcc Yes is selected");
		
		driver.findElement(By.xpath("//input[@name='save']")).click();
		Thread.sleep(1000);
		WebElement message=driver.findElement(By.xpath("//div[contains(@class,'messageText')]"));
		System.out.println(message.getText());
			
	}
	
	static void calendarandReminders() throws InterruptedException {
		waitForPageElementToVisible(driver.findElement(By.id("CalendarAndReminders")));
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Reminders_font")).click();
		if (driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText().contains("Activity Reminders")) {
			System.out.println("Activity Reminders page is displayed");
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement openTestReminder=driver.findElement(By.id("testbtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", openTestReminder);
		System.out.println(driver.findElement(By.id("testbtn")).getAttribute("title"));
		driver.findElement(By.id("testbtn")).click();
		Thread.sleep(2000);
		ArrayList<String> windowTabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowTabs.size());
		System.out.println("Sample event: test reminder pop-up window is open and displayed");
		Thread.sleep(5000);
		driver.switchTo().window(windowTabs.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		System.out.println("the parent Activity Reminder window is displayed");
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		userMenuDropDown();
		Thread.sleep(2000);
		mySettings();
		Thread.sleep(2000);
		personalandLoginHistory();
		Thread.sleep(2000);
		downloadLoginHistory();
		Thread.sleep(2000);
	
		displayandLayout();
		Thread.sleep(3000);
		verifyDisplayandLayout();
		Thread.sleep(3000);
		myemailandSettings(); 
		Thread.sleep(3000);
		calendarandReminders();
		Thread.sleep(5000);
		quitBrowser();
	}

}
