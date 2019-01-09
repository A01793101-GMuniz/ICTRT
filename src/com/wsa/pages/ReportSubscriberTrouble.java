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

public class ReportSubscriberTrouble {

	private By generation = By.xpath("//*[contains(@name, 'Generation')]");
	
	public WebDriver oDriver;
	public ExtentReports oExtentReports;
	public ExtentTest oExtentTest;
	public HashMapNew dictionary;
	
	public ReportSubscriberTrouble(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver = oDriver;
		this.oExtentReports = oExtentReports;
		this.oExtentTest = oExtentTest;
		this.dictionary = dictionary;
	}
	
	public boolean fCreateTicket1() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		String strGeneration = dictionary.get("GENERATION");
		String strCamel = dictionary.get("CAMEL");
		String strLocation = dictionary.get("LOCATION");
		String strIssueType = dictionary.get("ISSUE_TYPE");
				
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(generation));
		
		if(e.isDisplayed()){
			List<WebElement> radio_generations  = oDriver.findElements(By.xpath("//input[@name='Generation' and @type='radio']"));
			List<WebElement> radio_camels = oDriver.findElements(By.xpath("//input[@name='Camel' and @type='radio']"));
			
			for (int i=0; i < radio_generations.size(); i++){
				WebElement radio_generation = radio_generations.get(i);
				String value = radio_generation.getAttribute("value");
				//System.out.println("values from RadioButton = " + value);
				
				if(value.equalsIgnoreCase(strGeneration)){
					radio_generation.click();
				}
			}
			
			for (int i=0; i < radio_camels.size(); i++){
				WebElement radio_camel = radio_camels.get(i);
				String value = radio_camel.getAttribute("value");
		
				if(value.equalsIgnoreCase(strCamel)){
					radio_camel.click();
				}
			}			
		    
			oExtentTest.log(LogStatus.PASS, "Subscriber Trouble: Geneartion Radio buttons are displaying !!");
		}else{
			oExtentTest.log(LogStatus.FAIL, "Subscriber Trouble: Geneartion Radio buttons are not displaying!!");
			return false;
		}
		
		new Select(oDriver.findElement(By.name("Location"))).selectByVisibleText(strLocation);
		
		Thread.sleep(5000);
		List<WebElement> chk_issueIDs  = oDriver.findElements(By.xpath("//input[@name='IssueID' and @type='checkbox']"));
		for (int i=0; i < chk_issueIDs.size(); i++){
			WebElement chk_issueID = chk_issueIDs.get(i);
			String value = chk_issueID.getAttribute("value");
			WebElement span_issue = chk_issueID.findElement(By.xpath("//input[@name='IssueID' and @type='checkbox' and @value='" + value +
					          "']//following-sibling::span"));
			
			//System.out.println("values from check boxes = " + value);
			//System.out.println("Issue = " + span_issue.getText());
			
			if(strIssueType.equals(span_issue.getText())){
				chk_issueID.click();
				System.out.println("Issue Type= " + strIssueType + ", issue in span= " + span_issue.getText() + ", Clicked");
			}
		}
		
		WebElement button_next = oDriver.findElement(By.linkText("Next >>"));
		button_next.click();
		Thread.sleep(2000);
		
		return true;
	}
	
	public boolean fCreateTicket2() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		String strIssueType = dictionary.get("ISSUE_TYPE");

		try {
			String strKeyDescription = "Description";
			String strDescription = dictionary.get(strKeyDescription);
			WebElement table = oDriver.findElement(By.xpath("//table[@class='formlayout']"));
			
			if (strIssueType.equalsIgnoreCase("MO Call") || strIssueType.equalsIgnoreCase("MT Call") || strIssueType.equalsIgnoreCase("MO SMS")) {
				String strKeyAllAttempts = "All Attempts";
				String strKeyFaultMsg = "Fault Message";
				
				String strAllAttempts =  dictionary.get(strKeyAllAttempts);
				
				String strFaultMsg = dictionary.get(strKeyFaultMsg);
				
				//WebElement select_allAttempts = table.findElement(By.xpath("//tr/td/select"));
				new Select(table.findElement(By.xpath("//tr/td/select"))).selectByVisibleText(strAllAttempts); 
				WebElement textarea_faultMsg = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyFaultMsg + "')]"
											+ "/parent::td//following-sibling::td/span/textarea"));
				
				if (strIssueType.equalsIgnoreCase("MO Call")){
					String strKeyBNumber = "B-Number";
					String strBNumber = dictionary.get(strKeyBNumber);
					WebElement txt_bNumber = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyBNumber + "')]"
											+ "/parent::td//following-sibling::td/input[@type='text']"));
					txt_bNumber.sendKeys(strBNumber);
				}
				
				textarea_faultMsg.sendKeys(strFaultMsg);
				
			} else if (strIssueType.equalsIgnoreCase("Registration")) {
				
			}
			
			WebElement textarea_description = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyDescription + "')]"
											+ "/parent::td//following-sibling::td/span/textarea"));
			textarea_description.sendKeys(strDescription);
			
			WebElement button_next = oDriver.findElement(By.linkText("Next >>"));
			wait.until(ExpectedConditions.elementToBeClickable(button_next));
			Thread.sleep(5000);
			button_next.click();
			
		}catch (Exception e) {
			System.out.println("Exception: Subscriber Trouble Ticket Screen 2, " + e);
			return false;
		}

		return true;
	}
	
	public boolean fCreateTicket3() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		String strIssueType = dictionary.get("ISSUE_TYPE");
		
		try {
			String strKeyMSISDN = "MSISDN";
			String strKeyIMSI = "IMSI";
			String strKeyVLR = "VLR";
			String strKeyContactSubscriber = "Contact Subscriber";
			String strMSISDN = dictionary.get(strKeyMSISDN);
			String strIMSI = dictionary.get(strKeyIMSI);
			String strVLR = dictionary.get(strKeyVLR);
			String strContactSubscriber = dictionary.get(strKeyContactSubscriber);
			
			WebElement table = oDriver.findElement(By.xpath("//table[@class='formlayout']"));
			WebElement txt_MSISDN = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyMSISDN + "')]"
								     + "/parent::td//following-sibling::td/input[@type='text' and @maxlength='20']"));
			WebElement txt_IMSI = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyIMSI + "')]"
				     				 + "/parent::td//following-sibling::td/input[@type='text']"));
			WebElement txt_VLR = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyVLR + "')]"
    				 				 + "/parent::td//following-sibling::td/input[@type='text']"));
			
			/*
			if (strIssueType.equalsIgnoreCase("MO Call")){
				String strKeyBNumber = "B-Number";
				String strBNumber = dictionary.get(strKeyBNumber);
				WebElement txt_bNumber = table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyBNumber + "')]"
										+ "/parent::td//following-sibling::td/input[@type='text']"));
				txt_bNumber.sendKeys(strBNumber);
			}*/
			
			txt_MSISDN.sendKeys(strMSISDN);
			txt_IMSI.sendKeys(strIMSI);
			txt_VLR.sendKeys(strVLR);
			
			new Select(table.findElement(By.xpath("//tr/td/a[contains(@href, '" + strKeyContactSubscriber + "')]"
									 + "/parent::td//following-sibling::td/select"))).selectByVisibleText(strContactSubscriber);
			
			WebElement button_submit = oDriver.findElement(By.linkText("Submit Ticket"));
			wait.until(ExpectedConditions.elementToBeClickable(button_submit));
			Thread.sleep(5000);
			button_submit.click();
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println("Exception: Subscriber Trouble Ticket Screen 3,  " + e);
			return false;
		}
				
				
		return true;
	}
}
