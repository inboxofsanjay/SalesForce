package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.randomscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class CustomizeMyTabs extends BrowserUtility{

	static void allTabs_CustomizeMyTab() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		System.out.println("Home page for "+ userNameNavLabel +"is displayed");
		
		driver.findElement(By.xpath("//li[@id='AllTab_Tab']"));
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		String allTabs=driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		System.out.println(allTabs);
		System.out.println("All Tabs page is displayed");
		WebElement customizeMyTabs=driver.findElement(By.xpath("//td[@class='bCustomize']//input[@name='customize']"));
		System.out.println(customizeMyTabs.getAttribute("title"));
		driver.findElement(By.xpath("//td[@class='bCustomize']//input[@name='customize']")).click();
		waitForPageElementToVisible(driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")));
		String customtabpage=driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		System.out.println("Custom My Tabs page is displayed: "+customtabpage);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@id='bodyDiv_setup']//td[3]//option"));
		WebElement selectedTabs=driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Select selecteddropdown=new Select(selectedTabs);
		selecteddropdown.selectByVisibleText("Subscriptions");
		Thread.sleep(4000);
		driver.findElement(By.id("duel_select_0_left")).click();
		Thread.sleep(4000);
		System.out.println("Subscriptions removed from selected tabs");
		
		driver.findElement(By.xpath("//td[@id='bodyCell']//td//td[1]//option"));
		Thread.sleep(1000);
		WebElement availableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		WebElement Subscriptions=driver.findElement(By.xpath("//td[@id='bodyCell']//td//td[1]//option[contains(text(),'Subscriptions')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", Subscriptions);
		Boolean Subscription=driver.findElement(By.xpath("//td[@id='bodyCell']//td//td[1]//option[contains(text(),'Subscriptions')]")).isDisplayed();
		if (Subscription=true) {
			System.out.println("Subscriptions is added to Available tabs");
		}
		Thread.sleep(4000);
		WebElement eleSave=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleSave);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		Thread.sleep(3000);
		System.out.println("Save the Subscriptions to Available list Customize My Tabs");
		Thread.sleep(3000);
		
		List<WebElement> li_tab1 =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab1.size();count++) {
		System.out.println(li_tab1.get(count).getText());
		}
		Thread.sleep(2000);
	}



	public static void main(String[] args) throws InterruptedException {
	
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		allTabs_CustomizeMyTab();
		Thread.sleep(3000);
		quitBrowser();
	}

	}


