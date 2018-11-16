package com.wsa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.wsa.pages.LoginCSP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class LoginCSPTest {
	public WebDriver driver;
	
	@Test
	public void f() throws InterruptedException {
		String userid = "kb0004";
		String password = "123123a";
		LoginCSP obj= new LoginCSP(driver);
		Assert.assertTrue(obj.fTypeSearchText(userid, password));
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Browsers/chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		//Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		//Launch
		driver.get("http://zlt12824.vci.att.com:8500/ictrt/");
		//driver.get("https://www.google.com/");
		//Thread.sleep(6000);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the driver
		//driver.quit();
	}

}
