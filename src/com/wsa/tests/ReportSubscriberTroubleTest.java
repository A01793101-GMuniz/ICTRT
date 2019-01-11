package com.wsa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.wsa.pages.LoginCSP;
import com.wsa.pages.HomePage;
import com.wsa.pages.ReportSubscriberTrouble;
import com.wsa.framework.MyTestNGBaseClass;
import com.wsa.framework.AutomationConstants;
import com.wsa.framework.DataDriver;
import com.wsa.framework.HashMapNew;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportSubscriberTroubleTest extends MyTestNGBaseClass{
	@Parameters({"Action"})
	@Test	
	public void validation(String sAction) throws Throwable
	{
		oExtentTest = oExtentReport.startTest(sAction);
		
		//Validate the login page
		LoginCSP obj= new LoginCSP(oDriver,oExtentReport,oExtentTest,dataMap);

		//Login
		Assert.assertTrue(obj.fLogin());
		
		HomePage obj1 = new HomePage(oDriver,oExtentReport,oExtentTest,dataMap);
		
		Assert.assertTrue(obj1.fGoToSubscriberTrouble());
		
		ReportSubscriberTrouble obj2 = new ReportSubscriberTrouble(oDriver,oExtentReport,oExtentTest,dataMap);
		
		Assert.assertTrue(obj2.fCreateTicket1());
		Assert.assertTrue(obj2.fCreateTicket2());
		Assert.assertTrue(obj2.fCreateTicket3());
	}
}
