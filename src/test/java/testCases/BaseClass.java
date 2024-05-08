package testCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String lastname=readconfig.getLastName();
	public String email=readconfig.getEmail();
	public String password=readconfig.getPassword();
	public int date=readconfig.getDate();
	public int month=readconfig.getMonth();
	public int year=readconfig.getYear();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{			
		logger = Logger.getLogger("Banking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
			}
		else if(br.equals("firefox"))
			
		{

			WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
			}
		else if(br.equals("ie"))
		{

			WebDriverManager.iedriver().setup();
	        driver = new InternetExplorerDriver();
			}
		
		//driver.manage().timeouts().yWait(10,Timeouts.SECONDS);
		
		driver.get(baseurl);
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}	
	

