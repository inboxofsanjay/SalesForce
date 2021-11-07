package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.createoppurtunities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class OpportunitiesDropDown extends BrowserUtility{
	
	static void opportunities() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")));
		
		System.out.println(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")).getAttribute("title"));
		driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")).click();
		Thread.sleep(4000);
		String opportunities=driver.findElement(By.xpath("//h3[contains(text(),'Recent Opportunities')]")).getText();
		System.out.println(opportunities);
		if (opportunities.contains("Recent Opportunities")) {
			System.out.println("Opportunities home page is displayed");
		}
		System.out.println("Opportunities home page is displayed");
		
		Boolean opportunitiesdropdown=driver.findElement(By.xpath("//select[@id='fcf']")).isDisplayed();
		if (opportunitiesdropdown=true) {
		System.out.println("Opportunties dropdown is available");	
		}
		/*WebElement viewOpportunities=driver.findElement(By.xpath("//select[@id='fcf']//option[contains(text(),'Opportunities')]"));
		if (viewOpportunities.getText().contains("My Opportunities")) {
			System.out.println("Opportunities dropdown is available");
		}*/
		
		List<WebElement> li_opportunities=driver.findElements(By.xpath("//select[@id='fcf']//option"));
		for(int count=0;count<li_opportunities.size();count++) { // row1size =4, 0,1,2,3
		System.out.println(li_opportunities.get(count).getText()+",");
		}
		System.out.println("All opportunities List available in dropdown");
	}
	
	public static void main(String [] args) throws Exception {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		opportunities();
		Thread.sleep(3000);
		quitBrowser();
	}
	

}
