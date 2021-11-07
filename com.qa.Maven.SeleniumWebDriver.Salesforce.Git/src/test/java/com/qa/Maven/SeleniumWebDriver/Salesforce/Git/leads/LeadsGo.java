package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsGo extends Leads{
	
	static void leadsViewandGo() {
		
		WebElement todayslead=driver.findElement(By.xpath("//select[@id='fcf']"));
		List<WebElement> li_leads=driver.findElements(By.xpath("//select[@id='fcf']//option"));
		for(int count=0;count<li_leads.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_leads.get(count).getText()+",");
		}
		Select dropdown=new Select(todayslead);
		dropdown.selectByVisibleText("Today's Leads");
		System.out.println("TodaysLead page is displayed");
		
		WebElement unreadLead=driver.findElement(By.xpath("//select[@id='fcf']"));
		List<WebElement> li_unreadleads=driver.findElements(By.xpath("//select[@id='fcf']//option"));
		for(int count=0;count<li_unreadleads.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_unreadleads.get(count).getText()+",");
		}
		Select dropdown1=new Select(unreadLead);
		dropdown1.selectByVisibleText("My Unread Leads");
		System.out.println("My Unread Leads page is displayed");
		
	}
	
	static void logoutbrowser() throws InterruptedException {
		
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
	
	static void verifydefaultLeadsView() throws InterruptedException {
		logoutbrowser();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement Login =driver.findElement(By.id("Login"));
		Login.click();
		Thread.sleep(1000);
		leads();
		Thread.sleep(1000);
		WebElement myundreadleads=driver.findElement(By.xpath("//select[@id='fcf']"));
		Boolean leadsdropdown=driver.findElement(By.xpath("//select[@id='fcf']")).isDisplayed();
		if (leadsdropdown=true) {
		System.out.println("Leads dropdown is available");}
		
		List<WebElement> li_leads=driver.findElements(By.xpath("//select[@id='fcf']//option"));
		for(int count=0;count<li_leads.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_leads.get(count).getText()+",");
		}
		System.out.println("Displays the recent last selected view from leads drop down as DEFAULT");
		
		driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]")).click();
		System.out.println("My unread Leads page is displayed");
			
	}
	
	


	public static void main(String[] args) throws InterruptedException {
		
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		leads();
		Thread.sleep(2000);
		leadsViewandGo();
		Thread.sleep(3000);
		verifydefaultLeadsView();
		Thread.sleep(3000);
		quitBrowser();
		
	}

}
