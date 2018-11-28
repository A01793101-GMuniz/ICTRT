package ICTRT_Automation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Request_Network_Testing {
	
	public static String usr,pwd,brw;
	WebDriver browser;
	WebDriverWait wait;
  @BeforeTest
	  public void beforeTest() throws FileNotFoundException {
		  File file = new File("C:\\Users\\Carlosja\\Documents\\Eclipse\\ICTRT\\src\\credentials.txt");
		  Scanner scn = new Scanner (file);
		  String [] udata = new String[3];
		  for(int i = 0; scn.hasNextLine(); i++) {
				udata[i]= scn.nextLine();
			}
			usr = udata[0];
			pwd = udata[1];
			brw = udata[2];
		if(brw.equals("1")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlosja\\Documents\\Eclipse\\ChromeWebDriver\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		}
		else if (brw.equals("2")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Carlosja\\Documents\\Eclipse\\GeckoDriver\\32\\geckodriver.exe");
			browser = new FirefoxDriver();
		}
		else
			System.out.println("Invalid Browser, Please check properties file \n");
		}
  @Test(priority=0)
	public void Login() throws InterruptedException {
		browser.get("http://zlt12824.vci.att.com:8500/ictrt/");
		browser.manage().window().maximize();
		String user = usr; //"KB0004"; JM0007
		browser.switchTo().frame(0);
		wait = new WebDriverWait (browser,20);
		WebElement TF_User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='userid']")));
		TF_User.sendKeys(user);
		WebElement TF_Pwd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='password']")));
		TF_Pwd.sendKeys (pwd); //("123123a");
		WebElement TF_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lrrFormId']//input[@name='btnSubmit']")));
		TF_Button.click();
		browser.switchTo().defaultContent();
		browser.switchTo().frame(0);
		WebElement TF_Success = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='srv_successok']//input[@name='successOK']")));
		TF_Success.click();
		Thread.sleep(3000);
  }
  
  @Test (priority=1)
  public void RequestNetwork() throws InterruptedException {
	  	browser.switchTo().frame(0); //browser.findElement(By.name("home"))
		WebElement Req_nt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/center[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/img[1]")));
		Req_nt.click();
		//First ticket screen
		browser.findElement(By.xpath("//input[@name='Camel' and @value='Yes']")).click();
	    browser.findElement(By.name("Location")).click();
	    new Select(browser.findElement(By.name("Location"))).selectByVisibleText("Alabama");
	    browser.findElement(By.name("Location")).click();
	    browser.findElement(By.xpath("//input[@name='Generation' and @value='4G.']")).click();
	    Thread.sleep(5000);
	    browser.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[3]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]")).click();
	    WebElement Btn_next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/a[1]")));
	    Btn_next.click();
	    //Second ticket screen
	    WebElement TF_Description = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[2]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/textarea[1]")));
		TF_Description.sendKeys ("test");
		WebElement Btn_Next2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[3]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[3]/tbody[1]/tr[1]/td[1]/a[1]")));
		Btn_Next2.click();
		//Third screen ticket
		WebElement TF_MSISDN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[3]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]")));
		TF_MSISDN.sendKeys ("999999999999999");
		WebElement TF_IMSI = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[3]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[6]/input[1]")));
		TF_IMSI.sendKeys ("999999999999999");
		WebElement Btn_SubmitTicket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[4]/tbody[1]/tr[1]/td[1]/a[1]")));
		Btn_SubmitTicket.click();
  }
  
  @AfterTest
	public void afterTest() throws InterruptedException {
	  Thread.sleep(10000);
	  browser.close();
	}
}
