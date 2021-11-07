package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CreateAccountReport extends CreateNewView{
	
	public static void createAccountReport() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[@id='toolsContent']//h3[contains(text(),'Reports')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		Thread.sleep(3000);
		String unsavedreport=driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText();
		System.out.println("Unsaved Report page is displayed----> "+unsavedreport);
		Thread.sleep(2000);
		
	}
	
	public static void unsavedreport() throws InterruptedException {
		driver.findElement(By.id("ext-gen20")).click();
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']")));
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@class='x-combo-list-item'][contains(text(),'Created Date')]")));
		driver.findElement(By.xpath("//div[@class='x-combo-list-item'][contains(text(),'Created Date')]")).click();
		Thread.sleep(1000);
		

//		WebElement fromdate=driver.findElement(By.xpath("//input[@id='ext-comp-1042']"));
		driver.findElement(By.id("ext-gen152")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='x-btn-mc']//button[contains(text(),'Today')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ext-gen154")).click();
//		driver.findElement(By.xpath("//table[@id='ext-gen270']//td[@class='x-date-right']")).click();
		Thread.sleep(1000);
		WebElement button=driver.findElement(By.xpath("//td[@class='x-btn-mc']//button[contains(text(),'Today')][1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//table//tr[@class='x-toolbar-left-row']//td[2]")).getText());
		waitForPageElementToVisible(driver.findElement(By.xpath("//table[2]//thead[1]//tr[1]")));
		
		List<WebElement> li_row1 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[1]"));
		for(int count=0;count<li_row1.size();count++) { 
		System.out.println(li_row1.get(count).getText()+",");
		}
		List<WebElement> li_row2 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[2]"));
		for(int count=0;count<li_row2.size();count++) {
		System.out.println(li_row2.get(count).getText()+",");
		}
		List<WebElement> li_row3 =driver.findElements(By.xpath("//table[2]//thead[1]//tr[3]"));
		for(int count=0;count<li_row3.size();count++) {
		System.out.println(li_row3.get(count).getText()+",");
		}
		
	Thread.sleep(4000);
	driver.findElement(By.xpath("//table[@id='saveReportBtn']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//span[@class='x-window-header-text']"));
	String savereportwindow=driver.findElement(By.xpath("//span[@class='x-window-header-text']")).getText();
	System.out.println(savereportwindow);
	WebElement reportName=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
	reportName.sendKeys(ReportName);
	WebElement reportUniqueName=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
	reportUniqueName.sendKeys(ReportUniqueName);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//table[@id='dlgSaveReport']//td[@class='x-btn-mc']//button")).click();
	Thread.sleep(3000);
	if (driver.findElement(By.xpath("//div[contains(@class,'bPageTitle')]//h1[contains(@class,'noSecondHeader pageType')]")).getText().trim().contains(ReportName)) {
		System.out.println("Reports page is displayed with"+ReportName);
	}
}
	

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		verifyAccountsPage();
		createAccountReport();
		unsavedreport();
		Thread.sleep(5000);
		quitBrowser();
	}

}
