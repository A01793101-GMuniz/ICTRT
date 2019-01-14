package com.wsa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.wsa.pages.LoginCSP;
import com.wsa.pages.HomePage;
import com.wsa.pages.ReportSubscriberTrouble;
import com.wsa.pages.RequestNetworkTesting;
import com.wsa.framework.MyTestNGBaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wsa.framework.AutomationConstants;
import com.wsa.framework.DataDriver;
import com.wsa.framework.HashMapNew;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequestNetworkTestingTest extends MyTestNGBaseClass{
	@Test		
	public void validation() throws Throwable
	{
		//getData();
		oExtentTest = oExtentReport.startTest("Login CSP Test");
		
		//Validate home page
		LoginCSP obj= new LoginCSP(oDriver,oExtentReport,oExtentTest,dataMap);

		//Login
		AssertJUnit.assertTrue(obj.fLogin());
		
		HomePage obj1 = new HomePage(oDriver,oExtentReport,oExtentTest,dataMap);
		
		AssertJUnit.assertTrue(obj1.fGoToNetworkTesting());
		
		
		RequestNetworkTesting obj2 = new RequestNetworkTesting(oDriver,oExtentReport,oExtentTest,dataMap);
		
		AssertJUnit.assertTrue(obj2.fCreateTicket1());
		AssertJUnit.assertTrue(obj2.fCreateTicket2());
		AssertJUnit.assertTrue(obj2.fCreateTicket3());
	}
}
