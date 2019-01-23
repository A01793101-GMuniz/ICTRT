package com.wsa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wsa.framework.CommonLib;
import com.wsa.framework.HashMapNew;
 

public class HomePage {

              private By button_subscriberTrouble = By.xpath("//a[@href='/ictrt/TicketCreate?TICKET_TYPE_ID=2']");
              private By button_networkTesting = By.xpath("//a[@href='/ictrt/TicketCreate?TICKET_TYPE_ID=3']");
              private By button_ticketSearch = By.linkText("Ticket Search");
              private By button_userAdminstration = By.linkText("User Administration");
              private By button_ticketQueue = By.linkText("Ticket Queue");
              private By button_tableMaintennace = By.linkText("Table Maintenance");   
              public WebDriver oDriver;
              public ExtentReports oExtentReports;
              public ExtentTest oExtentTest;
              public HashMapNew dictionary;            
              
              
              public HomePage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
                     this.oDriver = oDriver;
                     this.oExtentReports = oExtentReports;
                     this.oExtentTest = oExtentTest;
                     this.dictionary = dictionary;
              }

              public boolean fGoToSubscriberTrouble() throws InterruptedException{
                             oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_subscriberTrouble));                         

                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToSubscriberTrouble()|Report Subscriber Trouble link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToSubscriberTrouble()|Could not find Report Subscriber Trouble link");
                                return false;
                             }                          
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                             return true;
              }

             
              public boolean fGoToNetworkTesting() throws InterruptedException{
                             oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_networkTesting));                           
                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToNetworkTesting()|Request Network Testing link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToNetworkTesting()|Could not find Request Network Testing link");
                                return false;
                             }
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                             return true;
              }
           

              public boolean fGoToTicketSearch() throws InterruptedException{
                             oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_ticketSearch));                          
                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToTicketSearch()|Ticket Search link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToTicketSearch()|Could not find Ticket Search link");
                                return false;
                             }                           
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                              return true;
              }
             

              public boolean fGoToUserAdminstration() throws InterruptedException{
                             oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_userAdminstration));                           
                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToUserAdminstration()|User Adminstration link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToUserAdminstration()|Could not find User Adminstration link");
                                return false;
                             }                           
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                             return true;
              }

              public boolean fGoToTicketQueue() throws InterruptedException{
                             oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_ticketQueue));                           
                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToTicketQueue()|Ticket Queue link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToTicketQueue()|Could not find Ticket Queue link");
                                return false;
                             }
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                             return true;
              }

              public boolean fGoToTableMaintenance() throws InterruptedException{       
            	  			 oDriver.switchTo().frame(0);
                             WebDriverWait wait=new WebDriverWait(oDriver, 20);
                             WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(button_tableMaintennace));                          
                             if(e.isDisplayed()){
                                oExtentTest.log(LogStatus.INFO, "HomePage|fGoToTableMaintenance()|Table maintenance link is visible");
                             }else{
                                oExtentTest.log(LogStatus.FAIL, "HomePage|fGoToTableMaintenance()|Could not find Table maintenance link");
                                return false;
                             }                           
                             //Click on the link
                             e.click();
                             Thread.sleep(2000);
                             return true;
              }

}

 