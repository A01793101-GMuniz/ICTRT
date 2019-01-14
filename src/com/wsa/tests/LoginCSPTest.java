package com.wsa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.wsa.pages.LoginCSP;
import com.wsa.framework.MyTestNGBaseClass;
import com.wsa.framework.AutomationConstants;
import com.wsa.framework.DataDriver;
import com.wsa.framework.HashMapNew;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCSPTest extends MyTestNGBaseClass{
	
	@Test	
	public void validation() throws Throwable
	{
		//getData();
		oExtentTest = oExtentReport.startTest("Login CSP Test");
		
		//Validate home page
		LoginCSP obj= new LoginCSP(oDriver,oExtentReport,oExtentTest,dataMap);

		//Login
		Assert.assertTrue(obj.fLogin());
		
	}
}