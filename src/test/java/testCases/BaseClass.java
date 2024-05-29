package testCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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
	public String date=readconfig.getDate();
	public String month=readconfig.getMonth();
	public String year=readconfig.getYear();
	
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{			
		logger = Logger.getLogger("Banking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			logger.info("chrome is starting");
			//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
			
		{

			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
	        driver = new FirefoxDriver();
			}
		else if(br.equals("ie"))
		{

			//WebDriverManager.iedriver().setup();
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
	        driver = new InternetExplorerDriver();
			}
		
		Thread.sleep(30);
		driver.get(baseurl);
		driver.manage().window().maximize();
		logger.info("url is opening");
	
		
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
	
	
}	
	

