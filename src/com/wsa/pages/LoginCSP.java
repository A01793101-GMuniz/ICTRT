package com.wsa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginCSP {

	private By button_btnSubmit = By.name("btnSubmit");
	private By editBox_userid = By.name("userid");
	private By editBox_password = By.name("password");
	private By button_search = By.name("btnK");
	private By editBox_search = By.name("q");
	public WebDriver oDriver;

	public LoginCSP(WebDriver oDriver){
		this.oDriver = oDriver;
	}
	
	public boolean fTypeSearchText(String userid, String password)  throws InterruptedException{
		//oDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//oDriver.findElement(editBox_userid).sendKeys(userid);
		//oDriver.findElement(By.xpath("//input[contains(@name, 'userid')]")).sendKeys(userid);
		//oDriver.findElement(editBox_password).sendKeys(password);
		//oDriver.findElement(button_btnSubmit).sendKeys(Keys.RETURN);
		oDriver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait (oDriver, 20);
		WebElement TF_User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='userid']")));
		TF_User.sendKeys(userid);
		WebElement TF_Pwd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='password']")));
		TF_Pwd.sendKeys(password);
		WebElement TF_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='btnSubmit']")));
		TF_Button.click();
		oDriver.switchTo().defaultContent();
		oDriver.switchTo().frame(0);
		WebElement TF_Success = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='srv_successok']//input[@name='successOK']")));
		TF_Success.click();
		Thread.sleep(8000);
		//oDriver.close();
		
		oDriver.switchTo().frame(oDriver.findElement(By.name("home")));
        WebElement Report_SubscriberTrouble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/center[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[2]/font[1]")));
        Report_SubscriberTrouble.click();
        
        oDriver.findElement(By.xpath("//input[@name='Camel' and @value='Yes']")).click();
        new Select(oDriver.findElement(By.name("Location"))).selectByVisibleText("Alabama");
        //browser.findElement(By.xpath("//input[@name='Generation' and @value='3G']")).click();
        //browser.findElement(By.xpath("//input[@name='IssueID' and @value='3']")).click();
        WebElement Btn_Next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/a[1]")));
        Btn_Next.click();

		
		return true;
	}

}
