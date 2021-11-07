package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.createoppurtunities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOpportunity extends OpportunitiesDropDown{
	
	static void createnewopportunity() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//input[@name='new']")).click();
		Thread.sleep(4000);
		String newOpportunity=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("New Opportunity Page is displayed----> "+newOpportunity);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]"));
		String opportunityedit=driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]")).getText();
		System.out.println("Opportunity Edit page---->"+opportunityedit);
		
		System.out.println("Opportunity Information:");
		driver.findElement(By.xpath("//div[@id='head_1_ep']//h3[contains(text(),'Opportunity Information')]"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Opportunity Owner')]"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//td[contains(text(),'Arathi R')]")).isEnabled();
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Opportunity Name')]"));
		WebElement opportunityname=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[@id='opp3']"));
		opportunityname.sendKeys(newOpportunityName);
		System.out.println("Opportunity name is entered");
		waitForPageElementToVisible(driver.findElement(By.id("opp4")));
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Account Name')]"));
		WebElement accountname=driver.findElement(By.xpath("//input[@id='opp4']"));
		accountname.sendKeys(newOpportunityACCTName);
		waitForPageElementToVisible(driver.findElement(By.xpath("//input[@id='opp9']")));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Close Date')]"));
		WebElement closedate=driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//input[@id='opp9']"));
		closedate.click();
		driver.findElement(By.xpath("//table[@id='datePickerCalendar']//tbody//tr[@id='calRow5']//td[contains(text(),'27')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Lead Source')]"));
		WebElement stage=driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//select[@id='opp11']"));
		Select dropdown=new Select(stage);
		dropdown.selectByVisibleText("Qualification");
		System.out.println("stage is selected for opportunity name");
		waitForPageElementToVisible(stage);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Stage')]"));
		WebElement leadsource=driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//select[@id='opp6']"));
		Select dropdown1=new Select(leadsource);
		dropdown1.selectByVisibleText("Web");
		System.out.println("Lead source is selected for opportunity name");
		waitForPageElementToVisible(leadsource);
		Thread.sleep(2000);
		
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		save.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")).click();
		if (driver.findElement(By.xpath("/tr[contains(@class,'dataRow even first')]//th[contains(@class,'')]//a")).getText().contains(newOpportunityName)) {
			System.out.println(driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//td[1]")).getText());
			System.out.println("New created opportunity is displayed");
		}
		
		System.out.println("New Opportunity name page is displayed" +newOpportunityName+ "With Opportunity Details");	
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		opportunities();
		createnewopportunity(); 
		Thread.sleep(1000);
		quitBrowser();

	}

}
