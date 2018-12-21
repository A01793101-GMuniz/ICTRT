package ICTRT_Automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Table_Maintenance {

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
    public void TableMaintenance() throws InterruptedException {
			 browser.switchTo().frame(0);
			 //store value of original window for later use
			 String winHandleBefore = browser.getWindowHandle();
			 System.out.println(winHandleBefore);
			 
			 WebElement Table_maintenance = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/center[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]/img[1]")));
			 Table_maintenance.click();
			 WebElement Tab_generations = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/ul[1]/li[3]/a[1]")));
			 Tab_generations.click();
			 Thread.sleep(3000);
			 
			 browser.switchTo().frame(browser.findElement(By.xpath("/html[1]/body[1]/div[1]/iframe[3]")));
			 /*
			 //Cambiar a segunda pagina de tabla
			 WebElement Btn_next2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/a[2]")));
			 Btn_next2.click();
			 */
			 Thread.sleep(1000);
			 
			Actions action = new Actions(browser);
			WebElement DD_Gen = browser.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]"));
			action.contextClick(DD_Gen).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			
			
			 WebElement Dd_AddGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/ul[1]/li[1]/a[1]")));
			 Dd_AddGen.click();
			 
			 //pop_up window
			 Thread.sleep(3000);	
			 //browser.switchTo().window("Generation");
			 //browser.switchTo().alert().sendKeys("999");
			 //String  handle= browser.getWindowHandle();
			 
			 //To change to generation popup window
			 for (String handle : browser.getWindowHandles()) {
				 
				   browser.switchTo().window(handle);
			 }
			 
			 //Add generation
			 WebElement TF_Generation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")));
			 TF_Generation.sendKeys("5G test");
			 WebElement Btn_SaveClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]/form[1]/input[4]")));
			 Btn_SaveClose.click();
			 /*
			 for (String handle : browser.getWindowHandles()) {
				 
				   browser.switchTo().window(handle);
			 }
			 
			*/
			 
			// Return to main screen
		   //browser.switchTo().defaultContent();
		   //browser.switchTo().window("ICTRT"); 
			 browser.switchTo().window(winHandleBefore);
			 //browser.switchTo().frame(browser.findElement(By.xpath("/html[1]/frameset[1]/frame[1]")));
			 browser.switchTo().frame(0);
			 browser.switchTo().frame(0);
			
			 // si cambia a la ventana original ictrt
				String title = browser.getTitle();
				System.out.println(title);
				
				/*		
				WebElement Tab_generation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/ul[1]/li[3]/a[1]")));
				Tab_generation.click();
				Tab_generation.click();
				Thread.sleep(1000);
				*/
				
				
			 //no lo encuentra
			 browser.switchTo().frame(browser.findElement(By.xpath("/html[1]/body[1]/div[1]/iframe[3]")));
				//browser.switchTo().frame(browser.findElement(By.id("StdWebTab-0-tab-2")));
			//browser.switchTo().frame(browser.findElement(By.xpath("/html[1]/body[1]/div[1]/iframe[@id=\"StdWebTab-0-tab-2\"]")));
		
			
			 
			 /*
			//click next on table,  lo encuentra pero el ciclo busca en la primera pagina 
			 Thread.sleep(2000);
			 WebElement Btn_next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/a[2]")));
			 Btn_next.click();
			*/
		
			 String sRowValue = "999";
			 
			 for (int i=1;i<11;i++){
			 String sValue = null;
			 sValue = browser.findElement(By.xpath(" /html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[" + i + "]/td[2]")).getText();
			 System.out.println(sValue);
			 	if(sValue.equalsIgnoreCase("5G test")){
				 //WebElement DD_Gendel = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[" + i + "]/td[2]"))));
			 		WebElement DD_Gendel = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[" + i + "]/td[1]/span[1]"))));
			 		System.out.println("Entre");
				 //action.contextClick(DD_Gendel).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			 		DD_Gendel.click();
			 		int d = i +10; 
			 		WebElement Dd_DelGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/ul[" + d +"]/li[2]/a[1]")));
			 		Dd_DelGen.click();
				 	for (String handle : browser.getWindowHandles()) {
					 
					   browser.switchTo().window(handle);
				 	}
				 	
				 	 WebElement Btn_ConfDel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]/form[1]/input[4]")));
					 Btn_ConfDel.click();
				 
				 	}		 
			 	else System.out.println("Please check,  insertion of Generation 999 missing");
			 }
			
			
			
			/*
			WebElement DD_Gendel = browser.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]"));
			action.contextClick(DD_Gendel).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			 
			WebElement Dd_DelGen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html[1]/body[1]/ul[31]/li[2]/a[1]")));
			 Dd_DelGen.click();
			 */
			 
			
			
  }
		  
  @AfterTest
  public void afterTest() throws InterruptedException {
  Thread.sleep(10000);
   //browser.close();
			}

  }

