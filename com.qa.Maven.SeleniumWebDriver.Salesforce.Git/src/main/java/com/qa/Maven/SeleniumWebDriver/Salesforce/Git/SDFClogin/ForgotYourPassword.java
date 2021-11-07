package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ForgotYourPassword extends BrowserUtility{
	
	public static void forgotYourPasswordLink() throws Exception{
		
		waitForPageElementToVisible(driver.findElement(By.id("logo")));
		waitForPageElementToVisible(driver.findElement(By.id("username")));
		WebElement ForgotYourPassword=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		Thread.sleep(1000);
		ForgotYourPassword.click();
	}	
	public static void forgotYourPasswordPage() throws Exception {	
		waitForPageElementToVisible(driver.findElement(By.id("header")));
		if (driver.findElement(By.xpath("//h2[@id='header']")).getText().trim().equalsIgnoreCase("Forgot Your Password")) 
		{
			System.out.println("Forgot Your PassWord page is displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("un")).sendKeys(un);
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
	}
	
	public static void passwordResetMsg() throws Exception {
		
		waitForPageElementToVisible(driver.findElement(By.id("header")));
		Thread.sleep(1000);
		
		if (driver.findElement(By.xpath("//h2[@id='header']")).getText().trim().equalsIgnoreCase("Check Your Email")) 
		{
			System.out.println("Check Your Email Message is displayed");
		}
		
		String msg1=driver.findElement(By.xpath("//div[@class='message']//p[1]")).getText();
		String msg2=driver.findElement(By.xpath("//div[@class='message']//p[2]")).getText();
		String msg3=driver.findElement(By.xpath("//div[@class='message']//p[3]")).getText();
		
		if (msg1.equalsIgnoreCase("We’ve sent you an email with a link to finish resetting your password.")) {
			System.out.println(msg1);
		}
		Thread.sleep(2000);
		if (msg2.equalsIgnoreCase("Can’t find the email? Try checking your spam folder.")) {
			System.out.println(msg2);
		}
		Thread.sleep(2000);
		if (msg3.equalsIgnoreCase("If you still can’t log in, have us resend the email or contact your Salesforce administrator.")) 
		{
			System.out.println(msg3);
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("resend the email")).click(); 
		Thread.sleep(3000);
			
//		driver.get(resendemail);
		forgotYourPasswordPage();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Return to Login")).click();
		System.out.println("Salesforce Login Page is displayed");
	}

	public static void main(String[] args) throws Exception {
		
		
		getPropertyfromFile();
		launchBrowser("ch");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		forgotYourPasswordLink();
		Thread.sleep(3000);
		forgotYourPasswordPage();
		Thread.sleep(3000);
		passwordResetMsg();
		Thread.sleep(3000);
		quitBrowser();
		

	}

}
