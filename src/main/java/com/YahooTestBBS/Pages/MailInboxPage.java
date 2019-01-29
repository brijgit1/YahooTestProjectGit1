package com.YahooTestBBS.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.YahooTestBBS.Base.TestBase;

public class MailInboxPage extends TestBase{

	//Objects Repository
@FindBy(xpath="//a[contains(text(),'Compose')]")
WebElement composeLink;

//Initialization of Page objects
public MailInboxPage(){
	PageFactory.initElements(driver, this);
}


//Page Objects Methods
public ComposePage verifyCompose(){
	composeLink.click();
	return new ComposePage();
}

}
