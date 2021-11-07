package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.randomscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class VerifyUserFirstNameAndLastName extends BrowserUtility{
	
	static void homepage() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		
		String userlabel=driver.findElement(By.xpath("//h2[contains(text(),'Recent Items')]")).getText();
		System.out.println("Recent Items----> "+userlabel);
		waitForPageElementToVisible(driver.findElement(By.xpath("//td[@id='content_wrap:mruTable:0:mruName']")));
		
		if (driver.findElement(By.id("content_wrap:mruTable:0:mruName")).getText().contains(userNameNavLabel)) {
			System.out.println("Home page is displayed with firstname:lastname");
		}
		driver.findElement(By.xpath("//td[@id='content_wrap:mruTable:0:mruName']//a")).click();
		Thread.sleep(3000);
		String home=driver.findElement(By.xpath("//div[contains(@class,'ptBody')]//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("user Home Page is displayed----> "+home);
	}
	
	static void profilepage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.id("userNav")));
		System.out.println(driver.findElement(By.id("userNav")).getAttribute("title"));
		System.out.println(driver.findElement(By.id("userNavLabel")).getText());
		System.out.println("User Menu drop down is available");
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		WebElement usermenubutton=driver.findElement(By.id("userNavButton"));
		action.moveToElement(usermenubutton).click().build().perform();
		Thread.sleep(3000);
		System.out.println("User Menu drop down is displayed");
		waitForPageElementToVisible(driver.findElement(By.linkText("My Profile")));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[contains(@class,'chatterBreadcrumbs')]")));
		String username=driver.findElement(By.id("tailBreadcrumbNode")).getAttribute("title");
		System.out.println(username);
		if (username.contains(userNameNavLabel)) {
			System.out.println("My Profile page is displayed");
		}
		System.out.println("User Name on Home page and My Profile page are same");
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		homepage();
		Thread.sleep(2000);
		profilepage(); 
		Thread.sleep(3000);
		quitBrowser();

	}

}
