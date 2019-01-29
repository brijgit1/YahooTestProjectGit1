package com.YahooTestBBS.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.YahooTestBBS.Base.TestBase;

public class ComposePage extends TestBase{
	
//Page Objects Repository
@FindBy(xpath="//input[@id='message-to-field']")
WebElement messageToField;

@FindBy(xpath="//input[@data-test-id='compose-subject']")
WebElement composeSubject;

@FindBy(xpath="//div[@data-test-id='rte']")
WebElement mailBodyField;

@FindBy(xpath="//button[@data-test-id='compose-send-button']")
WebElement sendBtn;

//Objects Initialization
public ComposePage(){
	PageFactory.initElements(driver, this);
}

//Page Methods
public void mailSend(String tomail, String mailSub, String mailbodytext){
	messageToField.sendKeys(tomail);
	composeSubject.sendKeys(mailSub);
	mailBodyField.sendKeys(mailbodytext);
	sendBtn.click();
	//After click on Send button, page return/remain at MailInboxPage
	
	
}


}
