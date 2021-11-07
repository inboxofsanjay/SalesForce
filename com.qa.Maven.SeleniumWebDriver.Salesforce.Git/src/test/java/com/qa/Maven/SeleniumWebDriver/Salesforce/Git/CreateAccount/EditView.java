package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditView extends CreateNewView{
	
	public static void verifyAccountsPage() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		Thread.sleep(3000);
		System.out.println("Accounts page is displayed for username");
		Thread.sleep(2000);
		
	}
		
	static void editexisitingview() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement newviewname=driver.findElement(By.xpath("//select[@id='fcf']"));
		Boolean viewname=driver.findElement(By.xpath("//select[@id='fcf']//option[contains(text(),'Arathi Ram')]")).isDisplayed();
		if (viewname=true) {
			System.out.println("New View with viewname is displayed in Accounts page"+devViewName);
		}
		System.out.println("New View with viewname is displayed in Accounts page");
		Select dropdown=new Select(newviewname);
		dropdown.selectByValue("00B5w00000D9DNR");
		System.out.println("View name is selected for edit"+devViewName);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		Thread.sleep(4000);
		String Editview=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("EditView Page is displayed----> "+Editview);
		
		if (Editview.equalsIgnoreCase("Edit View")) {
			System.out.println("EditView Page is displayed----> "+Editview);
		}
		
		Thread.sleep(4000);
		System.out.println("Step 1. Enter View Name");
		driver.findElement(By.xpath("//div[@class='pbBody']//h3[contains(text(),'Step 1. Enter View Name')]"));
		driver.findElement(By.xpath("//div[@class='pbSubbody']//table[1]//label[contains(text(),'View Name:')]"));
		WebElement editviewname=driver.findElement(By.xpath("//div[@class='pbSubbody']//table[1]//input[@id='fname']"));
		editviewname.clear();
		editviewname.sendKeys(devViewNameEdit);
		waitForPageElementToVisible(editviewname);
		driver.findElement(By.xpath("//div[@class='pbSubbody']//table[1]//label[contains(text(),'View Unique Name:')]"));
		WebElement editviewuniquename=driver.findElement(By.xpath("//div[@class='pbSubbody']//table[1]//input[@id='devname']"));
		editviewuniquename.clear();
		editviewuniquename.sendKeys(devViewUniqueNameEdit);
		waitForPageElementToVisible(editviewuniquename);
		
		WebElement filter= driver.findElement(By.xpath("//strong[contains(text(),'Filter By Additional Fields (Optional):')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", filter);
		WebElement field=driver.findElement(By.xpath("//select[@id='fcol1']"));
		Select dropdown1=new Select(field);
		dropdown1.selectByVisibleText("Account Name");
		waitForPageElementToVisible(field);
	
		WebElement operator=driver.findElement(By.xpath("//select[@id='fop1']"));
		Select dropdown2=new Select(operator);
		dropdown2.selectByVisibleText("contains");
		waitForPageElementToVisible(operator);
		
		WebElement value=driver.findElement(By.xpath("//input[@id='fval1']"));
		value.sendKeys("a");
		Thread.sleep(4000);
		
		WebElement availablefields=driver.findElement(By.xpath("//div[@id='colselector']//table[@class='layout']//select[@id='colselector_select_0']//option"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", availablefields);
		
		WebElement availablefieldslist=driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
		Select availabledropdown=new Select(availablefieldslist);
		availabledropdown.selectByVisibleText("Account Number");
		Thread.sleep(4000);
		driver.findElement(By.id("colselector_select_0_right")).click();
		Thread.sleep(4000);
		
		WebElement selectedfieldslist=driver.findElement(By.xpath("//select[@id='colselector_select_1']"));
		Boolean accountnumber=driver.findElement(By.xpath("//select[@id='colselector_select_1']//option[contains(text(),'Account Number')]")).isDisplayed();
		if (accountnumber=true) {
			System.out.println("Account number is added to SelectedFields list");
		}
		Thread.sleep(4000);
		WebElement save=driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@name='save']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@name='save']")).click();
		Thread.sleep(3000);
	}

	
	static void verifyeditview() {
		
		WebElement editviewname=driver.findElement(By.xpath("//select[@id='fcf']"));
		Boolean viewname=driver.findElement(By.xpath("//select[@id='fcf']//option[contains(text(),'Venugopalan')]")).isDisplayed();
		if (viewname=true) {
			System.out.println("Editedviewname is displayed in Accounts page"+devViewNameEdit);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		verifyAccountsPage();
		editexisitingview();
		Thread.sleep(3000);
		verifyeditview();
		Thread.sleep(5000);
		quitBrowser();
		
	}

}
