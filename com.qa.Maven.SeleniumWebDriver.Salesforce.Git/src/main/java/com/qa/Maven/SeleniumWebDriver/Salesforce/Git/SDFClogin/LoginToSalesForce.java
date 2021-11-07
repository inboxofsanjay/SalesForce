package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToSalesForce {
	
	public static WebDriver driver = null;
	
	public static String salesForceURL;
	public static String userName;
	public static String password;
	
	public static void launchBrowser(String sBrowser){
		
		if(sBrowser.startsWith("ch")) {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "\\Users\\arath\\eclipse\\com.qa.Maven.SeleniumWebDriver.Salesforce.Git\\chromedriver.exe");
		driver = new ChromeDriver();
		}
				
		else {
			System.out.println("You have not given browser type correctly");
		}
		
		driver.manage().window().maximize(); 
		driver.get(salesForceURL);
		System.out.println("SFDC loginpage is opened");
		
	}

	public static void quitBrowser(){
		driver.quit();
	}
	
	public static void waitForPageElementToVisible(WebElement eleToWait) {// passing formal parameter in method for explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
	}
	
	public static void loginToBrowser() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.id("logo")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		System.out.println(driver.findElement(By.xpath("//input[@id='username']")).isEnabled());
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
			
		driver.findElement(By.id("rememberUn")).isSelected();
		System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
	/*	driver.findElement(By.xpath("//label[@class='fl pr db tn3']"));
		driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("rememberUn")).isSelected();*/
		
		WebElement login =driver.findElement(By.id("Login"));
		login.click();
		
	}
	
	public static void getPropertyfromFile() {
		
		String sPath = System.getProperty("user.dir")+"\\src\\main\\java\\salesforce.properties";
		try {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(sPath);
		prop.load(fi);
		System.getProperties().putAll(prop);
		salesForceURL= System.getProperty("url");
		userName= System.getProperty("username");
		password= System.getProperty("password");
		
		}catch(Exception a) {
			System.out.println(a);
		}
	}
	

	public static void main(String[] args) throws Exception {
		
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		waitForPageElementToVisible(driver.findElement(By.id("userNavLabel")));
		if (driver.findElement(By.id("userNavLabel")).getText().contains("Arathi R")) {
			System.out.println("Home Page is dipslayed");
		}
		Thread.sleep(5000);
		quitBrowser();
	}

}
