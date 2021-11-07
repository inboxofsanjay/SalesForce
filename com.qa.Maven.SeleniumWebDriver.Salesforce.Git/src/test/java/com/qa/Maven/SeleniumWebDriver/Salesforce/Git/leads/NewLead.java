package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLead extends Leads{
	
	static void newlead() throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		String leads=driver.findElement(By.xpath("//h3[contains(text(),'Recent Leads')]")).getText();
		System.out.println(leads);
		System.out.println("Leads home page is displayed");
		driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
		Thread.sleep(4000);
		String newLead=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("New Lead Page is displayed----> "+newLead);
		if (newLead.contains("New Lead")) {
			System.out.println("New Lead Page is displayed----> "+newLead);
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]"));
		String leadedit=driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]")).getText();
		System.out.println("Lead Edit page---->"+leadedit);
		if (leadedit.contains("Lead Edit")) {
			System.out.println("Lead Edit page---->"+leadedit);
		}
		
		System.out.println("Lead Information:");
		driver.findElement(By.xpath("//div[@id='head_1_ep']//h3[contains(text(),'Lead Information')]"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Lead Owner')]"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//td[contains(text(),'Arathi R')]")).isEnabled();
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Last Name')]"));
		WebElement lastname=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[@id='name_lastlea2']"));
		lastname.sendKeys(leadName);
		System.out.println("last name is entered");
		waitForPageElementToVisible(lastname);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Company')]"));
		WebElement company=driver.findElement(By.xpath("//input[@id='lea3']"));
		company.sendKeys(Company);
		waitForPageElementToVisible(company);
		
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		save.click();
		Thread.sleep(3000);
		
		System.out.println("New Lead name page is displayed" +leadName+ "With Lead Details");	
		
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		leads();
		newlead(); 
		Thread.sleep(2000);
		
		quitBrowser();

	}

}
