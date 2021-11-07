package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.randomscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class EditProfile extends BrowserUtility{
	
	static void homepage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		waitForPageElementToVisible(driver.findElement(By.xpath("//td[@id='content_wrap:mruTable:0:mruName']")));
		
		if (driver.findElement(By.id("content_wrap:mruTable:0:mruName")).getText().contains(userNameNavLabel)) {
			System.out.println("Home page is displayed with firstname:lastname");
		}
		driver.findElement(By.xpath("//td[@id='content_wrap:mruTable:0:mruName']//a")).click();
		Thread.sleep(3000);
		String home=driver.findElement(By.xpath("//div[contains(@class,'ptBody')]//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("user Home Page is displayed----> "+home);
	}
	
/*	static void editicon() throws InterruptedException {
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
		String recentitems=driver.findElement(By.xpath("//h2[@class='brandPrimaryFgr']")).getText();
		System.out.println(recentitems);
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		WebElement editicon=driver.findElement(By.xpath("//div[@id='mru0035w000034DUMy']//img[@class='mruIcon']"));
		action.moveToElement(editicon).build().perform();
		Thread.sleep(4000);
		WebElement contactPopUp=driver.findElement(By.xpath("//div[contains(@class,'pbHeader brandSecondaryBrd')]//h2[contains(@class,'mainTitle')][contains(text(),'Contact')]"));
		Boolean popup=contactPopUp.isDisplayed();
		System.out.println(contactPopUp.isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'pbHeader brandSecondaryBrd')]//h2[contains(@class,'mainTitle')][contains(text(),'Contact')]")).getText());
		if (popup=true) {
			System.out.println("Contact popup is displayed");
			System.out.println(driver.findElement(By.xpath("//td[contains(@class,'dataCol')][contains(text(),'R')]")).getText());
		}
	}*/
	
	static void editprofileicon() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("userNavLabel"));
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		WebElement usermenubutton=driver.findElement(By.id("userNavButton"));
		action.moveToElement(usermenubutton).click().build().perform();
		Thread.sleep(5000);
		System.out.println("User Menu drop down is displayed");
		waitForPageElementToVisible(driver.findElement(By.linkText("My Profile")));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'Contact')]"));
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Contact')]")).getText());
		
		WebElement EditProfile=driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
		System.out.println(driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img")).getAttribute("title"));
		Thread.sleep(3000);
		action.moveToElement(EditProfile).click().build().perform();
		Thread.sleep(5000);
		
	}
	static void editProfilePopUpWindow() {
		
		waitForPageElementToVisible(driver.findElement(By.id("contactInfoTitle")));
		if (driver.findElement(By.id("contactInfoTitle")).getText().equalsIgnoreCase("Edit Profile")) {
			System.out.println("Edit Profile popup window is displayed With Contact Tab and About Tab");
		}
	}

	static void contactTabiframe() {
		
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
//		System.out.println(driver.findElement(By.xpath("//title[contains(text(),'User Profile Contact Info Edit Page')]")).getAttribute("title"));
		
		Boolean contactTab=driver.findElement(By.id("contactTab")).isEnabled();
		Boolean aboutTab =driver.findElement(By.id("aboutTab")).isEnabled();
		System.out.println(contactTab);
		System.out.println(aboutTab);
		
		if ((contactTab=true) || (aboutTab=true)){
			System.out.println("Contact Tab is displayed with info");
			System.out.println("Contact Tab is displayed by default when Edit profile pop up window appears");
		
			System.out.println("About Tab is displayed with info");
			System.out.println("About Tab is displayed by default when Edit profile pop up window appears");
		}
	}
	
	static void aboutTabiframe() throws InterruptedException   {
		
		driver.findElement(By.id("aboutTab")).click();
		waitForPageElementToVisible(driver.findElement(By.id("lastName")));
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(editProfileLastName);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).getAttribute("value"));
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
		Thread.sleep(1000);
		System.out.println("contact Tab frame is closed");
		
	}
	
	static void verifyeditprofile() throws InterruptedException {
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[contains(@class,'chatterBreadcrumbs')]")));
		String username=driver.findElement(By.id("tailBreadcrumbNode")).getAttribute("title");
		System.out.println(username);
		if (username.contains(editProfileLastName)) {
			System.out.println("My edited Profile page is displayed");
		}
		waitForPageElementToVisible(driver.findElement(By.id("userNav")));
		driver.findElement(By.id("userNav"));
		System.out.println(driver.findElement(By.id("userNav")).getAttribute("title"));
		driver.findElement(By.id("userNav"));
		System.out.println(driver.findElement(By.id("userNavLabel")).getText());
		if (driver.findElement(By.id("userNavLabel")).getText().contains(editProfileLastName)) {
			System.out.println("Last name edited in profile is displayed on usermenu navigation");
		}
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		WebElement usermenubutton=driver.findElement(By.id("userNavButton"));
		action.moveToElement(usermenubutton).click().build().perform();
		System.out.println("user menus for edited profile name is displayed");
		
	}
	
static void verifyhomepage() throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
	driver.findElement(By.id("home_Tab")).click();
	
	waitForPageElementToVisible(driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a")));
	String currentusername=driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a")).getText();
	System.out.println("username edited in contact tab of profile page--->"+currentusername);
	}

public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		homepage();
		Thread.sleep(2000);
		editprofileicon();
		Thread.sleep(2000);
		editProfilePopUpWindow();
		contactTabiframe();
		aboutTabiframe();
		verifyeditprofile();
		Thread.sleep(4000);
		verifyhomepage();
	}

}
