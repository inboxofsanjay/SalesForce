package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin.BrowserUtility;

public class createNewContact extends BrowserUtility{
	
static void createnewContact() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
		List<WebElement> li_tab =driver.findElements(By.xpath("//ul[@id='tabBar']"));
		for(int count=0;count<li_tab.size();count++) {
		System.out.println(li_tab.get(count).getText());
		}
		
		System.out.println(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		Thread.sleep(5000);
		String contacts=driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).getText();
		System.out.println(contacts);
		System.out.println("Contacts home page is displayed");
		if (contacts.contains("Recent Contacts")) {
			System.out.println("Contacts home page is displayed");
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@name='new']"));
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@name='new']")).click();
		Thread.sleep(4000);
		String NewContact=driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		System.out.println("New Contact Page is displayed----> "+NewContact);
		if (NewContact.contains("New Contact")) {
			System.out.println("New Contact Page is displayed----> "+NewContact);
		}
		Thread.sleep(2000);
}

	static void contactEdit() throws InterruptedException {
	
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]"));
		String contactedit=driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//td[contains(@class,'pbTitle')]//h2[contains(@class,'mainTitle')]")).getText();
		System.out.println("Contact Edit page---->"+contactedit);
		Thread.sleep(2000);
		System.out.println("Contact Information:");
		driver.findElement(By.xpath("//div[@id='head_1_ep']//h3[contains(text(),'Contact Information')]"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Contact Owner')]"));
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//td[contains(text(),'Arathi R')]")).isEnabled();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Last Name')]"));
		WebElement lastname=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[@id='name_lastcon2']"));
		lastname.sendKeys(lastName);
		System.out.println("Last name is entered");
		waitForPageElementToVisible(lastname);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBody')]//div[3]//table[1]//label[contains(text(),'Account Name')]"));
		WebElement accountname=driver.findElement(By.xpath("//input[@id='con4']"));
		accountname.sendKeys(newAccountName);
		System.out.println("Account name is entered");
		waitForPageElementToVisible(accountname);
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", save);
		save.click();
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText().contains(lastName)) {
			System.out.println("New contact name page is displayed With contact Details");	
			}
	}



	public static void main(String[] args) throws InterruptedException {
	
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		createnewContact();
		contactEdit();
		Thread.sleep(3000);
		quitBrowser();
	}

}
