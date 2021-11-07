package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class Leads extends BrowserUtility{
	
static void leads() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Lead_Tab']//a[contains(text(),'Leads')]")));
		
		System.out.println(driver.findElement(By.xpath("//li[@id='Lead_Tab']//a[contains(text(),'Leads')]")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		Thread.sleep(5000);
		String leads=driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")).getText();
		System.out.println(leads);
		if (leads.contains("Recent Leads")) {
			System.out.println("Leads home page is displayed");
		}
		System.out.println("Leads home page is displayed");
		
		Boolean leadsdropdown=driver.findElement(By.xpath("//select[@id='fcf']")).isDisplayed();
		if (leadsdropdown=true) {
		System.out.println("Leads dropdown is available");}
		
		List<WebElement> li_leads=driver.findElements(By.xpath("//select[@id='fcf']//option"));
		for(int count=0;count<li_leads.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_leads.get(count).getText()+",");
		}
		System.out.println("All leads List available in dropdown");
		
		}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		leads();
		Thread.sleep(2000);
		quitBrowser();
	}

}
