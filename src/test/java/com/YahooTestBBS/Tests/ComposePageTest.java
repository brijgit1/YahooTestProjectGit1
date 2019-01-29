package com.YahooTestBBS.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.YahooTestBBS.Base.TestBase;
import com.YahooTestBBS.Pages.ComposePage;
import com.YahooTestBBS.Pages.HomePage;
import com.YahooTestBBS.Pages.LoginPage;
import com.YahooTestBBS.Pages.MailInboxPage;

import testUtils.TestUtilities;

public class ComposePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MailInboxPage mailInboxPage;
	ComposePage composePage;
	String sheetName="mail";

	public ComposePageTest(){
		super();
	}
	
@BeforeMethod
public void setUp(){
	BrowserInitialisation();
	loginPage=new LoginPage();
	homePage=new HomePage();
	mailInboxPage=new MailInboxPage();
	composePage=new ComposePage();
	homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	mailInboxPage=homePage.verifyNavigateToMail();
	composePage=mailInboxPage.verifyCompose();
}

@Test(dataProvider="dp")
public void verifyMailSend(String tomail, String mailSub, String mailbodytext){
	composePage.mailSend(tomail, mailSub, mailbodytext);
}

@DataProvider
public Object[][] dp(){
	Object[][] dataFromxls= TestUtilities.xlsDataReader(sheetName);
	return dataFromxls;
}

@AfterMethod
public void tearDown(){
	driver.close();
	driver=null;
}
}
