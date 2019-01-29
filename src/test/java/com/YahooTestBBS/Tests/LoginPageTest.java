package com.YahooTestBBS.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YahooTestBBS.Base.TestBase;
import com.YahooTestBBS.Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
public LoginPageTest() throws IOException{
	super();
}

@BeforeMethod
public void setUp(){
	BrowserInitialisation();
	loginPage = new LoginPage();
}

@Test(priority=1)
public void verifyLoginPageTitle(){
	//System.out.println("Under verifyLoginPageTitle");
	Assert.assertEquals(loginPage.getLoginPageTitle(), "Yahoo");
}

@Test(priority=2)
public void VerifyLoginFeature(){
	loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	Assert.assertEquals(loginPage.getLoginPageTitle(), "Yahoo");

}

@AfterMethod
public void tearDown(){
	driver.quit();
	driver=null;
}

}
