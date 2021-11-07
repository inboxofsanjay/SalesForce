package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.createoppurtunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpportunityReports extends CreateNewOpportunity{
	
	static void opportunitypipeline() throws InterruptedException {
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[@id='toolsContent']//h3[contains(text(),'Reports')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		Thread.sleep(3000);
		String OpportunityPipeline=driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")).getText();
		System.out.println("OpportunityPipeline Report page is displayed----> "+OpportunityPipeline);
		if (OpportunityPipeline.contains("Opportunity Pipeline")) {
			System.out.println("OpportunityPipeline Report page is displayed----> "+OpportunityPipeline);
		}
		Thread.sleep(2000);
	}
		
	static void stuckopportunities() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")));
		System.out.println(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		Thread.sleep(3000);
		String stuckopportunities=driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")).getText();
		System.out.println("stuck opportunities Report page is displayed----> "+stuckopportunities);
		if (stuckopportunities.contains("Stuck Opportunities")) {
			System.out.println("stuck opportunities Report page is displayed----> "+stuckopportunities);
		}
		Thread.sleep(2000);
		
	}
	
static void quarterlySummary() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")));
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		Thread.sleep(3000);
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[@id='toolsContent']//h3[contains(text(),'Quarterly Summary')]")));
		WebElement interval=driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select dropdown=new Select(interval);
		dropdown.selectByVisibleText("Next FQ");
		System.out.println("interval selected for quarterly summary");
		waitForPageElementToVisible(interval);
		Thread.sleep(2000);
		
		WebElement include=driver.findElement(By.xpath("//select[@id='open']"));
		Select dropdown1=new Select(include);
		dropdown1.selectByVisibleText("Open Opportunities");
		System.out.println("include selected for quarterly summary");
		waitForPageElementToVisible(include);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[contains(@class,'opportunitySummary')]//input[contains(@name,'go')]")).click();
		Thread.sleep(3000);
		String opportunityreport=driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")).getText();
		System.out.println("opportunity report page with summary is displayed----> "+opportunityreport);
		if (opportunityreport.contains("Opportunity Report")) {
			System.out.println("opportunity report page with summary is displayed----> "+opportunityreport);
		}
		Thread.sleep(2000);
	}
	
	static void closedOpportunities() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")));
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Closed Opportunities')]")).click();
		Thread.sleep(3000);
		String closedOpportunities=driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")).getText();
		System.out.println("closed Opportunities Report page is displayed----> "+closedOpportunities);
		Thread.sleep(2000);
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		opportunities();
		opportunitypipeline();
		stuckopportunities();
		quarterlySummary(); 
		closedOpportunities();
		quitBrowser();
	}

}
