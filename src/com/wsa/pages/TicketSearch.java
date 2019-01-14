package com.wsa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wsa.framework.CommonLib;
import com.wsa.framework.HashMapNew;

public class TicketSearch {
	
	public WebDriver oDriver;
	public ExtentReports oExtentReports;
	public ExtentTest oExtentTest;
	public HashMapNew dictionary;
	
	public TicketSearch(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver = oDriver;
		this.oExtentReports = oExtentReports;
		this.oExtentTest = oExtentTest;
		this.dictionary = dictionary;
	}
	
	public boolean fCreateUser() throws InterruptedException{
		String UserID = dictionary.get("USERID");
		String strUserGroup = dictionary.get("USERGROUP");
		String strFirstName = dictionary.get("FIRSTNAME");
		String strMiddleName = dictionary.get("MIDDLENAME");
		String strLastName = dictionary.get("LASTNAME");
		String strEmail = dictionary.get("EMAIL");
		String strPhone = dictionary.get("PHONE");
		String strCompany = dictionary.get("COMPANY");
			
		 if(UserID.equalsIgnoreCase("TR0001") ) {	
			 try {
				WebDriverWait wait = new WebDriverWait(oDriver, 20);
			
				
				//First screen
				WebElement button_CreateUser = oDriver.findElement(By.linkText("Create User"));
				wait.until(ExpectedConditions.elementToBeClickable(button_CreateUser));
				button_CreateUser.click();
				Thread.sleep(2000);
				
				//Second screen
				new Select(oDriver.findElement(By.name("group"))).selectByVisibleText(strUserGroup);
				WebElement button_Next = oDriver.findElement(By.linkText("Next >>"));
				wait.until(ExpectedConditions.elementToBeClickable(button_Next));
				button_Next.click();
				Thread.sleep(2000);
				
				//Third screen
				new Select(oDriver.findElement(By.name("group"))).selectByVisibleText(strUserGroup);
				new Select(oDriver.findElement(By.name("companyID"))).selectByVisibleText(strCompany);
				//new Select(oDriver.findElement(By.name("companyID"))).selectByVisibleText("Bakcell LLC (092)");
				
				WebElement txt_FirstName = oDriver.findElement(By.xpath("//input[@name='firstName' and @maxlength='40']"));
				WebElement txt_MiddleName = oDriver.findElement(By.xpath("//input[@name='middleName' and @maxlength='40']"));
				WebElement txt_LastName = oDriver.findElement(By.xpath("//input[@name='lastName' and @maxlength='40']"));
				WebElement txt_Phone = oDriver.findElement(By.xpath("//input[@name='phone' and @maxlength='40']"));
				WebElement txt_Email = oDriver.findElement(By.xpath("//input[@name='email' and @maxlength='70']"));
				
				txt_FirstName.sendKeys(strFirstName);
				txt_MiddleName.sendKeys(strMiddleName);
				txt_LastName.sendKeys(strLastName);
				txt_Phone.sendKeys(strPhone);
				txt_Email.sendKeys(strEmail);
				
				WebElement button_createUser2 = oDriver.findElement(By.linkText("Create User"));
				wait.until(ExpectedConditions.elementToBeClickable(button_createUser2));
				button_createUser2.click();
				}catch (Exception e) {
					System.out.println("Exception:Create user screen,  " + e);
					oExtentTest.log(LogStatus.FAIL, "User Administration Create user: Exception."+ e);
			        return false;
				}
		 } else if(UserID.equalsIgnoreCase("KB0004") || UserID.equalsIgnoreCase(" jm0007")) {
			 try {
					WebDriverWait wait = new WebDriverWait(oDriver, 20);
				
					
					//first screen
					WebElement button_CreateUser = oDriver.findElement(By.linkText("Create User"));
					button_CreateUser.click();
					Thread.sleep(2000);
					
				    //Second screen
					new Select(oDriver.findElement(By.name("group"))).selectByVisibleText(strUserGroup);
		
					WebElement txt_FirstName = oDriver.findElement(By.xpath("//input[@name='firstName' and @maxlength='40']"));
					WebElement txt_MiddleName = oDriver.findElement(By.xpath("//input[@name='middleName' and @maxlength='40']"));
					WebElement txt_LastName = oDriver.findElement(By.xpath("//input[@name='lastName' and @maxlength='40']"));
					WebElement txt_Phone = oDriver.findElement(By.xpath("//input[@name='phone' and @maxlength='40']"));
					WebElement txt_Email = oDriver.findElement(By.xpath("//input[@name='email' and @maxlength='70']"));
					
					txt_FirstName.sendKeys(strFirstName);
					txt_MiddleName.sendKeys(strMiddleName);
					txt_LastName.sendKeys(strLastName);
					txt_Phone.sendKeys(strPhone);
					txt_Email.sendKeys(strEmail);
					
					WebElement button_createUser2 = oDriver.findElement(By.linkText("Create User"));
					wait.until(ExpectedConditions.elementToBeClickable(button_createUser2));
					button_createUser2.click();
					}catch (Exception e) {
						System.out.println("Exception:Create user screen,  " + e);
						oExtentTest.log(LogStatus.FAIL, "User Administration Create user: Exception."+ e);
						
						return false;
					}
			 
		 
		 } else {
				System.out.println("Invalid User, check Calendar.xlsx for correct users. \n");
				oExtentTest.log(LogStatus.FAIL, "User Administration Create user: Check Calendar.xlsx for correct users.");
	 }
	return true;
	}
	
	public boolean fSearchUser() throws InterruptedException{
		String strUserID = dictionary.get("USERID");
		String strUserGroup = dictionary.get("USERGROUP");
		String strFirstName = dictionary.get("FIRSTNAME");
		String strLastName = dictionary.get("LASTNAME");
		
		try {
			WebDriverWait wait = new WebDriverWait(oDriver, 20);
			
			WebElement button_Clear = oDriver.findElement(By.linkText("Clear"));
			wait.until(ExpectedConditions.elementToBeClickable(button_Clear));
			button_Clear.click();
			Thread.sleep(1000);
			
			WebElement txt_FirstName = oDriver.findElement(By.xpath("//input[@name='firstName' and @maxlength='20']"));
			WebElement txt_LastName = oDriver.findElement(By.xpath("//input[@name='lastName' and @maxlength='20']"));
			WebElement txt_UserID = oDriver.findElement(By.xpath("//input[@name='PARM1' and @maxlength='20']"));
			
			new Select(oDriver.findElement(By.name("group"))).selectByVisibleText(strUserGroup);
			
			txt_FirstName.sendKeys(strFirstName);
			txt_LastName.sendKeys(strLastName);
			txt_UserID.sendKeys(strUserID);

			WebElement button_Go = oDriver.findElement(By.linkText("Go"));
			wait.until(ExpectedConditions.elementToBeClickable(button_Go));
			button_Go.click();
			Thread.sleep(2000);			
			}catch (Exception e) {
				System.out.println("Exception:Search user screen,  " + e);
				oExtentTest.log(LogStatus.FAIL, "User Administration Create user: Exception." + e);
				return false;
			}
				
		return true;
	}
	
	}
