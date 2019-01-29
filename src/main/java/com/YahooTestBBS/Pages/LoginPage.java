package com.YahooTestBBS.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.YahooTestBBS.Base.TestBase;

public class LoginPage extends TestBase{
	
/*
 * Object Repository
 */
@FindBy(xpath="//a[contains(@id,'uh-signin')]")
WebElement signInLink;

@FindBy(xpath="//input[@name='username'][@id='login-username']")
WebElement userIDText;

@FindBy(xpath="//input[contains(@type,'submit')]")
WebElement nextLink;

@FindBy(xpath="//input[@type='password'][@id='login-passwd']")
WebElement pwdText;

@FindBy(xpath="//button[@type='submit'][@id='login-signin']")
WebElement signInSubmit;

public LoginPage(){
	PageFactory.initElements(driver, this);
}
/*
 * Objects Methods
 */
public String getLoginPageTitle(){
	return driver.getTitle();
}

public HomePage login(String uname, String pwd){
	signInLink.click();
	userIDText.sendKeys(uname);
	nextLink.click();
	pwdText.sendKeys(pwd);
	signInSubmit.click();
	return new HomePage();
}


}
