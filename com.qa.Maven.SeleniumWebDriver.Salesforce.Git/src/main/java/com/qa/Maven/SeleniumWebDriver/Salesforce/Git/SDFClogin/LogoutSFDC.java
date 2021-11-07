package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutSFDC extends BrowserUtility{
	
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
		Thread.sleep(3000);
		System.out.println("Successfully logged out of salesforce page");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
		if (driver.findElement(By.id("password")).isDisplayed()) {
			System.out.println("Successfully logged out of salesforce page and Salesforce Login page is displayed");
		}
		System.out.println("Salesforce Login page is displayed");
		driver.findElement(By.xpath("//a[@id='clear_link']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username")))).isEnabled();
	}
	
	

	public static void main(String[] args) throws Exception {
		getPropertyfromFile();
		//readPropertyExcelFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(2000);
		logoutToBrowser();
		Thread.sleep(3000);
		quitBrowser();
		

	}

}
