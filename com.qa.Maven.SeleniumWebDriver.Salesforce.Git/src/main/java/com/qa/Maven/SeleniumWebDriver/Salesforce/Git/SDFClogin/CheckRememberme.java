package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckRememberme extends LoginToSalesForce{
	
	public static void loginToBrowser() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.id("logo")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		System.out.println(driver.findElement(By.xpath("//input[@id='username']")).isEnabled());
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
			
		driver.findElement(By.id("rememberUn")).isSelected();
		System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
		driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("rememberUn")).isSelected();
		System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
		System.out.println(driver.findElement(By.xpath("//label[@class='fl pr db tn3']")).getText());
		
		WebElement login =driver.findElement(By.id("Login"));
		login.click();
		
	}
	
	public static void logoutToBrowser() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println(driver.findElement(By.id("userNav")).getAttribute("title"));
		System.out.println(driver.findElement(By.id("userNavLabel")).getText());
		Actions action=new Actions(driver);
		WebElement usermenubutton=driver.findElement(By.id("userNavButton"));
		action.moveToElement(usermenubutton).click().build().perform();
		
		Thread.sleep(1000);
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		waitForPageElementToVisible(driver.findElement(By.id("userNavLabel")));
		String username=driver.findElement(By.id("userNavLabel")).getText();
		if (driver.findElement(By.id("userNavLabel")).getText().contains(username)) {
			System.out.println("Salesforce Home Page is dipslayed");
		}
		Thread.sleep(3000);
		
		logoutToBrowser();
		System.out.println("You have logged out of Salesforce");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//input[@id='username']")).isDisplayed());
		boolean Username=driver.findElement(By.xpath("//input[@id='username']")).isEnabled();
		if (Username=true) {
			System.out.println("Input for Username field is disabled");
			System.out.println("Login salesforce page is displayed with " +userName+ " auto-populated");
		}
		boolean Rememberme=driver.findElement(By.id("rememberUn")).isSelected();
		
		if (Rememberme=true) {
			System.out.println("Remember Me is selected for this user name "+Rememberme);
		} 
		Thread.sleep(5000);
		quitBrowser();
	}

}
