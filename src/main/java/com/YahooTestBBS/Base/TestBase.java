package com.YahooTestBBS.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import testUtils.SelListner;

public class TestBase {
	static public Properties prop;
	static public WebDriver driver;
	static public EventFiringWebDriver efwdriver;
	static public SelListner selListner;
	public TestBase(){
		FileInputStream fis;
			
			try {
				prop=new Properties();
				fis = new FileInputStream("C:\\Users\\Dell\\workspace\\SeleniumProject_Marse\\YahooTestProject\\src\\main\\java\\com\\YahooTestBBS\\Config\\Config.properties");
				try {
					prop.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
public void BrowserInitialisation(){
	//This method is to select Browsers
	String browserType=prop.getProperty("browser");
	if(browserType.contains("chrome") && (driver==null)){
		System.setProperty(prop.getProperty("sysPropChromeName"), prop.getProperty("sysPropChromeVal"));
		driver=new ChromeDriver();
		
	}
	//Below code is to have WebDriver actions listner implementation
	efwdriver=new EventFiringWebDriver(driver);
	selListner=new SelListner();
	efwdriver.register(selListner);
	driver=efwdriver;
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	
	
}
	
	

}
