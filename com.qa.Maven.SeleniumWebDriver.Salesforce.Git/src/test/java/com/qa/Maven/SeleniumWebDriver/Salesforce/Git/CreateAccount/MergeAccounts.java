package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeAccounts extends CreateNewView{
	
	static void mergeAccounts() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Tools')]"))));
		WebElement tools=driver.findElement(By.xpath("//h3[contains(text(),'Tools')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", tools);
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		waitForPageElementToVisible(driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")));
		String mergeMyAccounts=driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]")).getText();
		System.out.println(mergeMyAccounts);
		if (mergeMyAccounts.contains("Merge My Accounts")) {
			System.out.println("Merge MY Accounts page is displayed");
		}
		System.out.println("Merge MY Accounts page is displayed");
		String selectrecordstomerge=driver.findElement(By.xpath("//h2[contains(text(),'Step 1. Select the records to merge')]")).getText();
		System.out.println(selectrecordstomerge);
		driver.findElement(By.id("srch")).sendKeys(newAccountName);
		Thread.sleep(3000);
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[@name='srchbutton']")));
		driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[@name='srchbutton']")).click();
		System.out.println("By default first two or threee records are selected for merging");
		waitForPageElementToVisible(driver.findElement(By.xpath("//input[@id='cid0']")));
		driver.findElement(By.xpath("//input[@id='cid0']")).isSelected();
		driver.findElement(By.xpath("//input[@id='cid1']")).isSelected();
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='goNext']")).click();
		Thread.sleep(2000);
		System.out.println("Merge MY Accounts page is displayed");
		waitForPageElementToVisible(driver.findElement(By.xpath("//h2[contains(text(),'Step 2. Select the values to retain')]")));
		String selectvaluestomerge=driver.findElement(By.xpath("//h2[contains(text(),'Step 2. Select the values to retain')]")).getText();
		System.out.println(selectvaluestomerge);
		if (selectvaluestomerge.contains("Step 2. Select the values to retain")) {
			System.out.println("Merge MY Accounts page is displayed with selected account details");
		}
		System.out.println("select the values to be retained in merged record");
		Thread.sleep(2000);
		WebElement merge=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", merge);
		
		System.out.println("click Merge to save the selected values in merged record");
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']")).click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		String Accountspage=driver.findElement(By.linkText("Accounts")).getAttribute("title");
		System.out.println(Accountspage);
		System.out.println("Accounts page displays the new merged account record");
		if (driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//th")).getText().contains(newAccountName)) {
			System.out.println("Accounts page displays the new merged account record");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		verifyAccountsPage();
		mergeAccounts();
		Thread.sleep(3000);
		quitBrowser();
	}

}
