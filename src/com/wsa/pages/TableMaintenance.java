package com.wsa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wsa.framework.HashMapNew;

public class TableMaintenance {
	public WebDriver oDriver;
	public ExtentReports oExtentReports;
	public ExtentTest oExtentTest;
	public HashMapNew dictionary;
	
	public TableMaintenance (WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver = oDriver;
		this.oExtentReports = oExtentReports;
		this.oExtentTest = oExtentTest;
		this.dictionary = dictionary;		
	}
	
	public boolean fVendorMapping () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		oDriver.switchTo().frame(0);
		WebElement drdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("companyID")));
		Select select = new Select(drdown);
		String OriginalCTS;
		
		if (drdown.isDisplayed()) {
			select.selectByVisibleText(dictionary.get("OPTIONS"));
			oDriver.findElement(By.linkText("Go")).click();
			WebElement CTSText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctsVendorID")));
			
			
			if (CTSText.isDisplayed()) {
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Vendor Mapping", "Searching for Company Name Success");
				OriginalCTS = CTSText.getAttribute("value");
				CTSText.clear();
				CTSText.sendKeys("CHANGED7854");
				oDriver.findElement(By.linkText("Save")).click();
				String upd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/center"))).getText();
				
				
				if (upd.contains("updated")) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Vendor Mapping", "Change CTS value Success");
					oDriver.findElement(By.linkText("Go")).click();
					
					WebElement CTSText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctsVendorID")));
					CTSText2.clear();
					CTSText2.sendKeys(OriginalCTS);
					oDriver.findElement(By.linkText("Save")).click();
					upd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/center"))).getText();
					
					
					if (upd.contains("updated")) 
						oExtentTest.log(LogStatus.PASS,"Table Maintenance - Vendor Mapping", "Change CTS to original value Success");
					else
						oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Vendor Mapping", "Change CTS to original value Failed");
					}
				
				
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Vendor Mapping", "Change CTS value Failed");
				}
				
			else 
				oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Vendor Mapping", "Searching for Company Name Failed. Not such company on records");
		}		
		
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Vendor Mapping", "Page not loading correctly");
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}
	
	public boolean fHelpText () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		/*Thread.sleep(2000);
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);*/
		oDriver.switchTo().frame(0);
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
		oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
		Thread.sleep(2000);
		WebElement Tab_Help = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[contains(text(), 'Help Text')]")));
		Tab_Help.click();
		oDriver.switchTo().frame(1);
		WebElement drdownht =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("helpID")));
		Select selectht = new Select(drdownht);
		
		if (drdownht.isDisplayed()) {
			selectht.selectByVisibleText(dictionary.get("TITLE"));
			oDriver.findElement(By.linkText("Go")).click();
			WebElement txtarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("text")));
			if(txtarea.isDisplayed()) {
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Help Text", "Select Title success");
				txtarea.sendKeys(Keys.CONTROL, Keys.END);
				txtarea.sendKeys("Memin Added");
				oDriver.findElement(By.linkText("Save")).click();
				String upd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/center"))).getText();
				
				if (upd.contains("updated")) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Help Text", "Change Title value Success");
					//oDriver.findElement(By.linkText("Go")).click();
				}
				
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Help Text", "Change Title failed, No changes saved");
			}
			else
				oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Help Text", "Select Title failed, No Text area displayed");
				
		}
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Help Text", "Select Title failed, Page not loaded correctly");
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}
	
	public boolean fGenerations () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		/*Thread.sleep(2000);
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);*/
		oDriver.switchTo().frame(0);
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
		oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
		Thread.sleep(2000);
		WebElement Tab_Gen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[contains(text(), 'Generations')]")));
		Tab_Gen.click();
		String MainWindow = oDriver.getWindowHandle();
		oDriver.switchTo().frame(2);
		WebElement GenMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Results0\"]/tbody/tr/td/span")));
		//oDriver.switchTo().
		if(GenMenu.isDisplayed()){
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Generations tab opened correctly");
				GenMenu.click();
				WebElement EditMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]")));
				if(EditMenu.isDisplayed()) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Open Generation Edit Menu");
					EditMenu.click();
					Set<String> wins = oDriver.getWindowHandles();
					Iterator<String> i = wins.iterator();
					while(i.hasNext()) {
						String ChildWindow = i.next();
						if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
							oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Edit Pop Up opened correctly");
							oDriver.switchTo().window(ChildWindow);
							WebElement GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='NAME']")));
							if (GeneTxt.isDisplayed()) {
								oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Changing Generation Value");
								String GenBefore = GeneTxt.getAttribute("Value");
								GeneTxt.clear();
								GeneTxt.sendKeys("2MGEN");
								WebElement SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
								SaveGen.click();
								oDriver.switchTo().window(MainWindow);
								/************************* In Case of Using Chrome *************************************************/
								/*Thread.sleep(2000);
								oDriver.switchTo().defaultContent();
								Thread.sleep(2000);
								oDriver.switchTo().frame(0);
								Thread.sleep(2000);
								oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
								oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
								Thread.sleep(2000);
								oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-2']")));
								Thread.sleep(2000);*/
								/**************************************************************************************************/
								WebElement GenMenuMod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='2MGEN']/../td/span")));
								if (GenMenuMod.isDisplayed()) {
									GenMenuMod.click();
									WebElement EditMenu2 = oDriver.findElement(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]"));
									if (EditMenu2.isDisplayed()) {
										oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Generation Changed correctly");
										EditMenu2.click();
										Set<String> wins2 = oDriver.getWindowHandles();
										Iterator<String> i2 = wins2.iterator();
										while(i2.hasNext()) {
											String ChildWindow2 = i2.next();
											if(!MainWindow.equalsIgnoreCase(ChildWindow2)) {
												oExtentTest.log(LogStatus.PASS,"Table Maintenance - Generations", "Reverting Generation changes");
												oDriver.switchTo().window(ChildWindow2);
												GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='NAME']")));
												GeneTxt.clear();
												GeneTxt.sendKeys(GenBefore);
												SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
												SaveGen.click();
												oDriver.switchTo().window(MainWindow);
											}
											else
												oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Change Back Generation Error! Changes not Reverted");
										}//While End 
									}
									else
										oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Edit Button Not Clicked");
								}
								else
									oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Change Generation Error! Record changed not found");
							}
							else
								oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Select Generation TextBox failed, Page not loaded correctly");
						}
						else
							oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Pop up Window did not open");
					}//While End
				}
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Select Edit button failed, Page not loaded correctly or no generations present");
			}
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Generations", "Select generation record failed, Page not loaded correctly or no generations present");
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}
	
	public boolean fIssues() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		/*Thread.sleep(2000);
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);*/
		oDriver.switchTo().frame(0);
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
		oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
		Thread.sleep(2000);
		WebElement Tab_Iss = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[contains(text(), 'Issues')]")));
		Tab_Iss.click();
		oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-3']")));
		String MainWindow = oDriver.getWindowHandle();
		System.out.println(MainWindow);
		WebElement GenMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Results0\"]/tbody/tr/td/span")));
		//oDriver.switchTo().
		if(GenMenu.isDisplayed()){
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Issues tab opened correctly");
				GenMenu.click();
				WebElement EditMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]")));
				if(EditMenu.isDisplayed()) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Open Issues Edit Menu");
					EditMenu.click();
					Set<String> wins = oDriver.getWindowHandles();
					Iterator<String> i = wins.iterator();
					while(i.hasNext()) {
						String ChildWindow = i.next();
						if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
							oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Edit Pop Up opened correctly");
							oDriver.switchTo().window(ChildWindow);
							WebElement GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='NAME']")));
							if (GeneTxt.isDisplayed()) {
								oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Changing Generation Value");
								String GenBefore = GeneTxt.getAttribute("Value");
								GeneTxt.clear();
								GeneTxt.sendKeys("7G Auto");
								WebElement SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
								SaveGen.click();
								oDriver.switchTo().window(MainWindow);
								/************************* In Case of Using Chrome *************************************************/
								/*Thread.sleep(2000);
								oDriver.switchTo().defaultContent();
								Thread.sleep(2000);
								oDriver.switchTo().frame(0);
								Thread.sleep(2000);
								oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
								oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
								Thread.sleep(2000);
								oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-3']")));
								Thread.sleep(2000);*/
								/**************************************************************************************************/
								WebElement GenMenuMod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='7G Auto']/../td/span")));
								if (GenMenuMod.isDisplayed()) {
									GenMenuMod.click();
									WebElement EditMenu2 = oDriver.findElement(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]"));
									if (EditMenu2.isDisplayed()) {
										oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Issues Changed correctly");
										EditMenu2.click();
										Set<String> wins2 = oDriver.getWindowHandles();
										Iterator<String> i2 = wins2.iterator();
										while(i2.hasNext()) {
											String ChildWindow2 = i2.next();
											if(!MainWindow.equalsIgnoreCase(ChildWindow2)) {
												oExtentTest.log(LogStatus.PASS,"Table Maintenance - Issues", "Reverting Issues changes");
												oDriver.switchTo().window(ChildWindow2);
												GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='NAME']")));
												GeneTxt.clear();
												GeneTxt.sendKeys(GenBefore);
												SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
												SaveGen.click();
												oDriver.switchTo().window(MainWindow);
											}
											else
												oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Change Back Issues Error! Changes not Reverted");
										}//While End 
									}
									else
										oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Edit Button Not Clicked");
								}
								else
									oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Change Issues Error! Record changed not found");
							}
							else
								oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Select Issues TextBox failed, Page not loaded correctly");
						}
						else
							oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Pop up Window did not open");
					}//While End
				}
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Select Edit button failed, Page not loaded correctly or no Issues present");
			}
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Issues", "Select Issues record failed, Page not loaded correctly or no Issues present");
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}
	
	public boolean fFields() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		/*Thread.sleep(2000);
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);*/
		oDriver.switchTo().frame(0);
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
		oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
		Thread.sleep(2000);
		WebElement Tab_Fld = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[contains(text(), 'Fields')]")));
		Tab_Fld.click();
		oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-4']")));
		String MainWindow = oDriver.getWindowHandle();
		System.out.println(MainWindow);
		WebElement GenMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Results0\"]/tbody/tr/td/span")));
		//oDriver.switchTo().
		if(GenMenu.isDisplayed()){
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Fields tab opened correctly");
				GenMenu.click();
				WebElement EditMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]")));
				if(EditMenu.isDisplayed()) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Open Fields Edit Menu");
					EditMenu.click();
					Set<String> wins = oDriver.getWindowHandles();
					Iterator<String> i = wins.iterator();
					while(i.hasNext()) {
						String ChildWindow = i.next();
						if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
							oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Edit Pop Up opened correctly");
							oDriver.switchTo().window(ChildWindow);
							WebElement GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LABEL']")));
							if (GeneTxt.isDisplayed()) {
								oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Changing Field Label Value");
								String GenBefore = GeneTxt.getAttribute("Value");
								GeneTxt.clear();
								GeneTxt.sendKeys("MGAUTO");
								WebElement SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
								SaveGen.click();
								oDriver.switchTo().window(MainWindow);
								/************************* In Case of Using Chrome *************************************************/
								/*Thread.sleep(2000);
								oDriver.switchTo().defaultContent();
								Thread.sleep(2000);
								oDriver.switchTo().frame(0);
								Thread.sleep(2000);
								oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
								oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
								Thread.sleep(2000);
								oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-4']")));
								Thread.sleep(2000);*/
								/**************************************************************************************************/
								WebElement GenMenuMod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='MGAUTO']/../td/span")));
								if (GenMenuMod.isDisplayed()) {
									GenMenuMod.click();
									WebElement EditMenu2 = oDriver.findElement(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]"));
									if (EditMenu2.isDisplayed()) {
										oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Field Label Changed correctly");
										EditMenu2.click();
										Set<String> wins2 = oDriver.getWindowHandles();
										Iterator<String> i2 = wins2.iterator();
										while(i2.hasNext()) {
											String ChildWindow2 = i2.next();
											if(!MainWindow.equalsIgnoreCase(ChildWindow2)) {
												oExtentTest.log(LogStatus.PASS,"Table Maintenance - Fields", "Reverting Field changes");
												oDriver.switchTo().window(ChildWindow2);
												GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LABEL']")));
												GeneTxt.clear();
												GeneTxt.sendKeys(GenBefore);
												SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
												SaveGen.click();
												oDriver.switchTo().window(MainWindow);
											}
											else
												oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Change Back Field Label Error! Changes not Reverted");
										}//While End 
									}
									else
										oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Edit Button Not Clicked");
								}
								else
									oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Change Fields Label Error! Record changed not found");
							}
							else
								oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Select Fields TextBox failed, Page not loaded correctly");
						}
						else
							oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Pop up Window did not open");
					}//While End
				}
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Select Edit button failed, Page not loaded correctly or no Fields present");
			}
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Fields", "Select Fields record failed, Page not loaded correctly or no Fields present");
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}
	
	
	public boolean fSelects() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(oDriver, 20);
		/*Thread.sleep(2000);
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);*/
		oDriver.switchTo().frame(0);
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
		oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
		Thread.sleep(2000);
		oDriver.findElement(By.xpath("//ul/li/a[contains(text(), 'Selects')]")).click();
		oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-5']")));
		String MainWindow = oDriver.getWindowHandle();
		//System.out.println(MainWindow);
		WebElement GenMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Results0\"]/tbody/tr/td/span")));
		if(GenMenu.isDisplayed()){
				oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Selects tab opened correctly");
				GenMenu.click();
				WebElement EditMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]")));
				if(EditMenu.isDisplayed()) {
					oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Open Selects Edit Menu");
					EditMenu.click();
					Set<String> wins = oDriver.getWindowHandles();
					Iterator<String> i = wins.iterator();
					while(i.hasNext()) {
						String ChildWindow = i.next();
						if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
							oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Edit Pop Up opened correctly");
							oDriver.switchTo().window(ChildWindow);
							WebElement GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='SELECT_VALUE']")));
							if (GeneTxt.isDisplayed()) {
								oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Changing Select Value");
								String GenBefore = GeneTxt.getAttribute("Value");
								GeneTxt.clear();
								GeneTxt.sendKeys("3712");
								WebElement SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
								SaveGen.click();
								oDriver.switchTo().window(MainWindow);
								/************************* In Case of Using Chrome *************************************************/
								/*Thread.sleep(2000);
								oDriver.switchTo().defaultContent();
								Thread.sleep(2000);
								oDriver.switchTo().frame(0);
								Thread.sleep(2000);
								oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']"));
								oDriver.switchTo().frame(oDriver.findElement(By.xpath("/html/frameset/frame[@name='home']")));
								Thread.sleep(2000);
								oDriver.switchTo().frame(oDriver.findElement(By.cssSelector("iframe[id='StdWebTab-0-tab-5']")));
								Thread.sleep(2000);*/
								/**************************************************************************************************/
								WebElement GenMenuMod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='3712']/../td/span")));
								if (GenMenuMod.isDisplayed()) {
									GenMenuMod.click();
									WebElement EditMenu2 = oDriver.findElement(By.xpath("//ul[contains(@style, 'block')]/.//a[contains(text(), 'Edit')]"));
									if (EditMenu2.isDisplayed()) {
										oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Select Label Changed correctly");
										EditMenu2.click();
										Set<String> wins2 = oDriver.getWindowHandles();
										Iterator<String> i2 = wins2.iterator();
										while(i2.hasNext()) {
											String ChildWindow2 = i2.next();
											if(!MainWindow.equalsIgnoreCase(ChildWindow2)) {
												oExtentTest.log(LogStatus.PASS,"Table Maintenance - Selects", "Reverting Selects changes");
												oDriver.switchTo().window(ChildWindow2);
												GeneTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='SELECT_VALUE']")));
												GeneTxt.clear();
												GeneTxt.sendKeys(GenBefore);
												SaveGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save' and @type='submit']")));
												SaveGen.click();
												oDriver.switchTo().window(MainWindow);
											}
											else
												oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Change Back Selects Label Error! Changes not Reverted");
										}//While End 
									}
									else
										oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Edit Button Not Clicked");
								}
								else
									oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Change Selects Label Error! Record changed not found");
							}
							else
								oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Select Selects TextBox failed, Page not loaded correctly");
						}
						else
							oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Pop up Window did not open");
					}//While End
				}
				else
					oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Select Edit button failed, Page not loaded correctly or no Fields present");
			}
		else
			oExtentTest.log(LogStatus.FAIL,"Table Maintenance - Selects", "Select Selects record failed, Page not loaded correctly or no Fields present");
		
		oDriver.switchTo().defaultContent();
		Thread.sleep(2000);
		return true;
	}

} // End of Class

