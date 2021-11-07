package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.SDFClogin;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
		public static WebDriver driver = null;
		
		public static String salesForceURL;
		public static String userName;
		public static String password;
		public static String emailID;
		public static String forgotPassword;
		public static String passwordResetmsg;
		public static String un;
		public static String resendemail;
		public static String userNameInvalid;
		public static String passwordInvalid;
		public static String userNameNavLabel;
		public static String lastName;
		public static String postText;
		public static String chooseFile;
		public static String filetext;
		public static String addPhoto;
		public static String loginHistoryCSV;	
		public static String newAccountName;
		public static String devViewName;
		public static String devViewUniqueName;
		public static String devViewNameEdit;
		public static String devViewUniqueNameEdit;
		public static String from;
		public static String to;
		public static String newOpportunityName;
		public static String newOpportunityACCTName;
		public static String leadName;
		public static String Company;
		public static String invalidViewName;
		public static String invalidViewUniqueName;
		public static String newContactLastName;
		public static String newContactACCTName;
		public static String editProfileLastName;
		public static String ReportName;
		public static String ReportUniqueName;
		
		public static void launchBrowser(String sBrowser){
			
			if(sBrowser.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "\Users\arath\eclipse\com.qa.Maven.SeleniumWebDriver.Salesforce.Git\chromedriver.exe");
			driver = new ChromeDriver();
			}
					
			else {
				System.out.println("You have not given browser type correctly");
			}
			
			driver.manage().window().maximize(); 
			driver.get(salesForceURL); 
			System.out.println("Salesforce loginpage is opened");
		}

		public static void quitBrowser(){
			driver.quit();
		}
		
		public static void waitForPageElementToVisible(WebElement eleToWait) {// passing formal parameter in method for explicit wait
			WebDriverWait wait = new WebDriverWait(BrowserUtility.driver, 60);
			wait.until(ExpectedConditions.visibilityOf(eleToWait));
		}

		
		public static void loginToBrowser() {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			waitForPageElementToVisible(driver.findElement(By.id("logo")));
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
			System.out.println(driver.findElement(By.xpath("//input[@id='username']")).isEnabled());
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
				
			driver.findElement(By.id("rememberUn")).isSelected();
			System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
			driver.findElement(By.id("rememberUn")).click();
			driver.findElement(By.id("rememberUn")).isSelected();
			System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
			WebElement Rememberme=driver.findElement(By.xpath("//label[@class='fl pr db tn3']"));
			String sRememberme=Rememberme.getText();
			System.out.println(sRememberme);
			
			WebElement Login =driver.findElement(By.id("Login"));
			Login.click();
					
		}
		
		public static void readPropertyExcelFile() {
			
			String sFile = System.getProperty("user.dir")+"\\src\\main\\java\\salesforce.xls";
			
			try {
				FileInputStream fi = new FileInputStream(sFile);
				HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
//				HSSFWorkbook myExcelBook = new HSSFWorkbook(fi);
				HSSFSheet myExcleSheet = myExcelBook.getSheet("TestData");
				
				HSSFRow credentials = myExcleSheet.getRow(1);
				salesForceURL=credentials.getCell(0).getStringCellValue();
			    userName=credentials.getCell(1).getStringCellValue();
			    password=credentials.getCell(2).getStringCellValue();
			    System.out.println(salesForceURL);
				System.out.println(userName);
				System.out.println(password);
	
				myExcelBook.close();
				
			}catch(Exception a) {
				System.out.println(a);
			}
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
			emailID=System.getProperty("emailid");
			forgotPassword = System.getProperty("forgotpsswd");
			passwordResetmsg = System.getProperty("psswdresetmsg");
			un= System.getProperty("un");
			resendemail=System.getProperty("resendtheemail");
			userNameInvalid= System.getProperty("invalidusername");
			passwordInvalid= System.getProperty("invalidpassword");
			userNameNavLabel=System.getProperty("userNavLabel");
			lastName=System.getProperty("lastName");
			postText=System.getProperty("postandsharetxt");
			chooseFile=System.getProperty("chatterFile");
			filetext=System.getProperty("thisfile");
			addPhoto=System.getProperty("uploadInputFile");
			loginHistoryCSV=System.getProperty("loginhistory");
			newAccountName=System.getProperty("accountname");
			devViewName=System.getProperty("viewname");
			devViewUniqueName=System.getProperty("viewuniquename");
			devViewNameEdit=System.getProperty("editviewname");
			devViewUniqueNameEdit=System.getProperty("editviewuniquename");
			from=System.getProperty("pickfromdate");
			to=System.getProperty("picktodate");
			newOpportunityName=System.getProperty("opportunityname");
			newOpportunityACCTName=System.getProperty("opportunityaccountname");
			leadName=System.getProperty("leadname");
			Company=System.getProperty("company");
			invalidViewName=System.getProperty("invalidviewname");
			invalidViewUniqueName=System.getProperty("invalidviewuniquename");
			newContactLastName=System.getProperty("contactlastName");
			newContactACCTName=System.getProperty("contactaccountname");
			editProfileLastName=System.getProperty("editlastName");
			ReportName=System.getProperty("reportname");
			ReportUniqueName=System.getProperty("reportuniquename");
			
			
			}catch(Exception a) {
				System.out.println(a);
			}
		}
		
		public static void main(String [] args) throws Exception {
			getPropertyfromFile();
			//readPropertyExcelFile();
			launchBrowser("ch");
			loginToBrowser();
			Thread.sleep(3000);
			quitBrowser();
		}
		
		 
		
		
	}


