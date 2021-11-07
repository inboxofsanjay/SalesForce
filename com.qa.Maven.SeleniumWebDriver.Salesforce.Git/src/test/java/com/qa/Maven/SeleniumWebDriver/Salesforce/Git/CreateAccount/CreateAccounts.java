package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;



public class CreateAccounts extends BrowserUtility{
	
	static void addAccountToHomePage() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
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
		driver.findElement(By.xpath("//td[@id='bodyCell']//td//td[1]//option"));
		Thread.sleep(1000);
		WebElement availableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		Select availabledropdown=new Select(availableTabs);
		availabledropdown.selectByVisibleText("Accounts");
		Thread.sleep(4000);
		driver.findElement(By.id("duel_select_0_right")).click();
		Thread.sleep(4000);
		WebElement selectedTabs=driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Boolean Accounts=driver.findElement(By.xpath("//div[@id='bodyDiv_setup']//td[3]//option[contains(text(),'Accounts')]")).isDisplayed();
		if (Accounts=true) {
			System.out.println("Accounts is added to SelectedTabs list");
		}
		Thread.sleep(4000);
		WebElement eleSave=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleSave);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]")).click();
		Thread.sleep(3000);
		System.out.println("Save the Accounts to Customize My Tabs");
		Thread.sleep(3000);
		
		List<WebElement> li_tab1 =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab1.size();count++) {
		System.out.println(li_tab1.get(count).getText());
		}
		Thread.sleep(2000);
	}

	static void createNewAccount() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")));
		driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@class='pbTitle']//h3[contains(text(),'Recent Accounts')]"));
		String accounts=driver.findElement(By.xpath("//td[@class='pbTitle']//h3[contains(text(),'Recent Accounts')]")).getText();
		System.out.println(accounts);
		if (accounts.equalsIgnoreCase("Recent Accounts")) {
			System.out.println("Accounts page is displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@name='new']"));
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@name='new']")).click();
		Thread.sleep(4000);
		String Newaccount=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("NewAccount Page is displayed----> "+Newaccount);
		
		if (Newaccount.equalsIgnoreCase("New Account")) {
			System.out.println("NewAccount Page is displayed----> "+Newaccount);
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]"));
		String accountedit=driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]")).getText();
		System.out.println("Account Edit page---->"+accountedit);
		
		System.out.println("Account Information:");
		driver.findElement(By.xpath("//div[@id='head_1_ep']//h3[contains(text(),'Account Information')]"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Account Owner')]"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//td[contains(text(),'Arathi R')]")).isEnabled();
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Account Name')]"));
		WebElement accountname=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[@id='acc2']"));
		accountname.sendKeys(newAccountName);
		System.out.println("Account name is entered");
		waitForPageElementToVisible(accountname);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Type')] "));
		WebElement Type=driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//select[@id='acc6']"));
		Select dropdown=new Select(Type);
		dropdown.selectByVisibleText("Technology Partner");
		System.out.println("Type is selected for account name");
		waitForPageElementToVisible(Type);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", Type);
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[7]//table[1]//label[contains(text(),'Customer Priority')]"));
		System.out.println("Additonal Information: ");
		WebElement customerpriority=driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[7]//table[1]//select[@id='00N5w00000Hb73d']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", customerpriority);
		Select dropdown1=new Select(customerpriority);
		dropdown1.selectByVisibleText("High");
		waitForPageElementToVisible(customerpriority);
		Thread.sleep(2000);
		
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		save.click();
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText().contains(newAccountName)) {
		System.out.println("New Account name page is displayed With Account Details");	
		}
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		addAccountToHomePage();
		createNewAccount();
		Thread.sleep(3000);
		quitBrowser();
	}

}
