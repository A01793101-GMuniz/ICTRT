package com.wsa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

import com.wsa.pages.LoginCSP;
import com.wsa.pages.HomePage;
import com.wsa.pages.ReportSubscriberTrouble;
import com.wsa.pages.RequestNetworkTesting;
import com.wsa.pages.TableMaintenance;
import com.wsa.framework.MyTestNGBaseClass;
import com.wsa.framework.AutomationConstants;
import com.wsa.framework.DataDriver;
import com.wsa.framework.HashMapNew;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableMaintenanceTest extends MyTestNGBaseClass {
	@Parameters({"Action"})
	@Test	
  public void Validation() throws Throwable {
		//getData();
		oExtentTest = oExtentReport.startTest("Login CSP Test");
				
		//Validate home page
		LoginCSP obj= new LoginCSP(oDriver,oExtentReport,oExtentTest,dataMap);

		//Login
		AssertJUnit.assertTrue(obj.fLogin());				
		HomePage obj1 = new HomePage(oDriver,oExtentReport,oExtentTest,dataMap);
		
		AssertJUnit.assertTrue(obj1.fGoToTableMaintenance());
		
		TableMaintenance obj2 = new TableMaintenance(oDriver,oExtentReport,oExtentTest,dataMap);
		
		AssertJUnit.assertTrue(obj2.fVendorMapping());
		AssertJUnit.assertTrue(obj2.fHelpText());
		AssertJUnit.assertTrue(obj2.fGenerations());
		AssertJUnit.assertTrue(obj2.fIssues());
		AssertJUnit.assertTrue(obj2.fFields());
		AssertJUnit.assertTrue(obj2.fSelects());
		
  }
}
