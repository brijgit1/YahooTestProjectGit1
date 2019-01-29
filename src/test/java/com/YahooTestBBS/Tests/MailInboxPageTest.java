package com.YahooTestBBS.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YahooTestBBS.Base.TestBase;
import com.YahooTestBBS.Pages.HomePage;
import com.YahooTestBBS.Pages.LoginPage;
import com.YahooTestBBS.Pages.MailInboxPage;

public class MailInboxPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MailInboxPage mailInboxPage;
public MailInboxPageTest(){
	super();
}

@BeforeMethod
public void setUp(){
	BrowserInitialisation();
	loginPage=new LoginPage();
	homePage=new HomePage();
	mailInboxPage=new MailInboxPage();
	homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	mailInboxPage=homePage.verifyNavigateToMail();
	
}

@Test(priority=1)
public void verifyNavigateToMail(){
	mailInboxPage=homePage.verifyNavigateToMail();
}

@AfterMethod
public void tearDown(){
	driver.quit();
	driver=null;
}
	

}
