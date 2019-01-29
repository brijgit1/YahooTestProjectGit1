package com.YahooTestBBS.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YahooTestBBS.Base.TestBase;
import com.YahooTestBBS.Pages.HomePage;
import com.YahooTestBBS.Pages.LoginPage;
import com.YahooTestBBS.Pages.MailInboxPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MailInboxPage mailInboxPage;
public HomePageTest(){
	super();
}

@BeforeMethod
public void setup(){
	BrowserInitialisation();
	loginPage=new LoginPage();
	homePage=new HomePage();
	mailInboxPage=new MailInboxPage();
	homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	
}

@Test(priority=1)
public void verifyAvatarTest(){
	Assert.assertTrue(homePage.verifyAvatar());
}

@Test(priority=2)
public void verifyMailspanClick(){
	mailInboxPage=homePage.verifyNavigateToMail();
}

@AfterMethod
public void tearDown(){
	driver.quit();
	driver=null;
}

}
