package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.usermenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile extends UserMenuDropDown{

	static void myProfilemenu() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		waitForPageElementToVisible(driver.findElement(By.linkText("My Profile")));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[contains(@class,'chatterBreadcrumbs')]")));
		String username=driver.findElement(By.id("tailBreadcrumbNode")).getAttribute("title");
		System.out.println(username);
		if (username.contains(userNameNavLabel)) {
			System.out.println("My Profile page is displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[contains(text(),'Contact')]"));
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Contact')]")).getText());
		
		
		WebElement EditProfile=driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
		System.out.println(driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img")).getAttribute("title"));
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(EditProfile).click().build().perform();
		Thread.sleep(5000);
	}
	
	static void editProfilePopUpWindow() {
		
		waitForPageElementToVisible(driver.findElement(By.id("contactInfoTitle")));
		if (driver.findElement(By.id("contactInfoTitle")).getText().equalsIgnoreCase("Edit Profile")) {
			System.out.println("Edit Profile popup window is displayed With Contact Tab and About Tab");
		}
	}
		
	static void contactTabiframe() {
					
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
//		System.out.println(driver.findElement(By.xpath("//title[contains(text(),'User Profile Contact Info Edit Page')]")).getAttribute("title"));
		
		Boolean contactTab=driver.findElement(By.id("contactTab")).isEnabled();
		Boolean aboutTab =driver.findElement(By.id("aboutTab")).isEnabled();
		System.out.println(contactTab);
		System.out.println(aboutTab);
		
		if ((contactTab=true) || (aboutTab=true)){
			System.out.println("Contact Tab is displayed with info");
			System.out.println("Contact Tab is displayed by default when Edit profile pop up window appears");
		
			System.out.println("About Tab is displayed with info");
			System.out.println("About Tab is displayed by default when Edit profile pop up window appears");
		}
	}
		
	static void aboutTabiframe() throws InterruptedException   {
		
		driver.findElement(By.id("aboutTab")).click();
		waitForPageElementToVisible(driver.findElement(By.id("lastName")));
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).getAttribute("value"));
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
	}
	
	static void postLinkiframe() throws InterruptedException {
		
		waitForPageElementToVisible(driver.findElement(By.id("profileTab_sfdc.ProfilePlatformFeed")));
		System.out.println(driver.findElement(By.id("publisherAttachTextPost")).getAttribute("title"));
		driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		
		driver.findElement(By.xpath("//title[contains(text(),'Rich Text Editor, publisherRichTextEditor')]"));
		driver.findElement(By.xpath("//body[contains(@class,'chatterPublisherRTE')]")).sendKeys(postText);
		Thread.sleep(2000);
		
	}
	
	static void verifyPostText() throws InterruptedException {
		
//		share button outside the postLink iframe
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.id("publishersharebutton")).getAttribute("title"));
		driver.findElement(By.id("publishersharebutton")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("profileTab_sfdc.ProfilePlatformFeed")).getAttribute("title"));
		String sharetext=driver.findElement(By.xpath("//div[contains(@class,'cxfeeditemtextadditional')]//p")).getText();
		if (sharetext.equalsIgnoreCase(postText)) {
			System.out.println("Text posted is displayed on Feed Tab of (My Profile page)");
		}
	}
	
	
static void fileiframe() throws InterruptedException {
	
	waitForPageElementToVisible(driver.findElement(By.id("publisherAttachContentPost")));
	System.out.println(driver.findElement(By.id("publisherAttachContentPost")).getAttribute("title"));
	driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']")).click();
	Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.id("chatterLinkFileAction")));
		System.out.println(driver.findElement(By.id("chatterLinkFileAction")).getAttribute("title"));
		System.out.println(driver.findElement(By.id("chatterUploadFileAction")).getAttribute("title"));
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		Thread.sleep(5000);
		
		waitForPageElementToVisible(driver.findElement(By.id("chatterFile")));
		WebElement choosefile=driver.findElement(By.id("chatterFile"));
		choosefile.getAttribute("title");
		Actions action =new Actions(driver);
		action.click(choosefile).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("chatterFile")).sendKeys(chooseFile);
		Thread.sleep(2000);
		System.out.println("this is after choosing the file");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
		
		driver.findElement(By.xpath("//title[contains(text(),'Rich Text Editor, publisherRichTextEditor')]"));
		driver.findElement(By.xpath("//body[contains(@class,'chatterPublisherRTE')]")).sendKeys(filetext);
		Thread.sleep(2000);
		
	}
	
static void verfiyfileupload() throws InterruptedException {
	
//	share button outside the fileLink iframe
	driver.switchTo().defaultContent();
	System.out.println(driver.findElement(By.id("publishersharebutton")).getAttribute("title"));
	driver.findElement(By.id("publishersharebutton")).click();
	Thread.sleep(3000);
	System.out.println(driver.findElement(By.id("profileTab_sfdc.ProfilePlatformFeed")).getAttribute("title"));
	String sharetext=driver.findElement(By.xpath("//div[contains(@class,'cxfeeditemtextadditional')]//p")).getText();
	if (sharetext.equalsIgnoreCase(filetext)) {
		System.out.println("File uploaded and Text posted is displayed on Feed Tab of (My Profile page)");
	}

}

	static void addYourPhoto() throws InterruptedException {
	
	Actions action=new Actions(driver);
	WebElement mouseHoverOnPhoto=driver.findElement(By.id("photoSection"));
	action.moveToElement(mouseHoverOnPhoto).build().perform();
	System.out.println("Mouse Hover on myprofile photo image and Add Photo link appears");
	
	driver.findElement(By.xpath("//a[@id='uploadLink']"));
	WebElement mouseHoveronAddPhoto=driver.findElement(By.linkText("Add Photo"));
	action.moveToElement(mouseHoveronAddPhoto).click().build().perform();
	
	waitForPageElementToVisible(driver.findElement(By.id("uploadPhoto")));
	System.out.println(driver.findElement(By.id("uploadPhotoTitle")).getText());
}
	
	static void uploadPhotoiframe() throws InterruptedException {
		
		WebElement photoframe=driver.findElement(By.id("uploadPhotoContentId")); 
		driver.switchTo().frame(photoframe);
		Thread.sleep(3000);
		WebElement choosephoto=driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		choosephoto.sendKeys(addPhoto);
		WebElement savePhoto=driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		savePhoto.click();
		Thread.sleep(6000);
			
//		driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
		Actions action=new Actions(driver);
		driver.findElement(By.xpath("//div[contains(@class,'imgCrop_dragArea')]"));
		action.dragAndDropBy(driver.findElement(By.xpath("//div[contains(@class,'imgCrop_handle imgCrop_handleNW')]")), 100, 20);
//		action.dragAndDropBy(Webelement, xOffset, yOffset)
		
		driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
		driver.switchTo().defaultContent();
		System.out.println("photo Uploaded successfully");
		
		Actions action1=new Actions(driver);
		System.out.println(driver.findElement(By.xpath("//a[@id='uploadLink']")).getText());
		action1.moveToElement(driver.findElement(By.xpath("//a[@id='uploadLink']"))).click().build().perform();
	}

	public static void main(String[] args) throws InterruptedException {
		getPropertyfromFile();
		launchBrowser("ch");
		loginToBrowser();
		userMenuDropDown();
		Thread.sleep(2000);
		myProfilemenu();
		Thread.sleep(3000);
		editProfilePopUpWindow();
		Thread.sleep(2000);
		contactTabiframe();
		Thread.sleep(3000);
		aboutTabiframe();
		Thread.sleep(3000);
		String username=driver.findElement(By.id("tailBreadcrumbNode")).getAttribute("title");
		System.out.println(username);
		if (username.contains(userNameNavLabel)) {
			System.out.println("User Profile page is displayed");
		}
		Thread.sleep(2000);
		postLinkiframe();
		verifyPostText();
		fileiframe();
		verfiyfileupload();
		Thread.sleep(2000);
		addYourPhoto(); 
		Thread.sleep(3000);
		uploadPhotoiframe(); 
		Thread.sleep(6000);
		quitBrowser();
		
		
	}

}
