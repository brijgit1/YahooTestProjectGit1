package com.YahooTestBBS.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.YahooTestBBS.Base.TestBase;

public class HomePage extends TestBase {
	
	/*
	 * Objects Repository
	 */
	
@FindBy(xpath="//i[@id='uh-avatar']")
WebElement uhAvatar;

@FindBy(xpath="(//span[contains(text(),'Mail')])[1]")
WebElement mailSpan;

//Objects Initialisations
public HomePage(){
	PageFactory.initElements(driver, this);
}

//ethods at Home Page

public boolean verifyAvatar(){
	return uhAvatar.isDisplayed();
}

public MailInboxPage verifyNavigateToMail(){
	mailSpan.click();
	return new MailInboxPage();
}

}
