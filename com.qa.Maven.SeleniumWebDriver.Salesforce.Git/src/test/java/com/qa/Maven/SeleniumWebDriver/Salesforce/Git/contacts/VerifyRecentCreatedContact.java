package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyRecentCreatedContact extends createNewContact{
	
	static void verifyRecentlyAddedContactview() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='tabBar']"))));
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		Thread.sleep(3000);
		System.out.println("Contacts page is displayed for username");
		Thread.sleep(2000);
		String recentitems=driver.findElement(By.xpath("//td[contains(@class,'pbTitle')]//h3[contains(text(),'Recent Contacts')]")).getText();
		System.out.println("RecentContact displayed on page---->"+recentitems);
		Thread.sleep(3000);
		WebElement Recentlycreated=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select dropdown=new Select(Recentlycreated);
		waitForPageElementToVisible(Recentlycreated);
		dropdown.selectByVisibleText("Recently Created");
		Thread.sleep(3000);
		System.out.println("Recently Contacts page is displayed");
		waitForPageElementToVisible(Recentlycreated);
		
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		
		WebElement contactlink=driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a"));
		waitForPageElementToVisible(contactlink);
		action.click(contactlink).build().perform();
		Thread.sleep(4000);
		System.out.println("New view with viewname saved as " +lastName+ " is displayed on contacts page");
	
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		Thread.sleep(3000);
		verifyRecentlyAddedContactview();
		Thread.sleep(3000);
		quitBrowser();

	}

}
