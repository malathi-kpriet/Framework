package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import pageObjects.LoginPage;


@SuppressWarnings("unused")
public class LoginPageTestCase extends BaseClass
{
	private static final boolean True = false;

	@Test
	public void loginTest() throws IOException, InterruptedException 
	{
		logger.info("URL is opened");
		
		 pageObjects.LoginPage lp = new pageObjects.LoginPage(driver);
	
	
		logger.info("URL is opened");		
		Thread.sleep(300);
		
        lp.ClickSignin();
        logger.info("Clicked sign in");
        
		lp.setEmail1(email);
		logger.info("Entered email");
		
		lp.ClickCreate();
		logger.info("Clicked on Create Account");
		
		Thread.sleep(3000);
		
		lp.setRadioButton();
		logger.info("Clicked radiobutton");
		
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setLastName(lastname);
		logger.info("Entered lastname");

		Thread.sleep(3000);

		lp.setPassword(password);
		logger.info("Entered password");
		Thread.sleep(3000);
		
		boolean setPassword = True;
		if (setPassword) {
		    logger.info("Password set successfully");
		} else {
		    captureScreen(driver, "password");
		    logger.info("Setting password failed");
		}
		

		lp.setDate(date);
		logger.info("Entered date");
		Thread.sleep(300);

		lp.setMonth(month);
		logger.info("Entered month");
		Thread.sleep(300);

		lp.setYear(year);
		logger.info("Entered year");
        Thread.sleep(300);
        
		lp.setNewsLetter();
		logger.info("clicked newsletter");
		Thread.sleep(300);
		
		//lp.Register();
		//logger.info("clicked register");	
		//Thread.sleep(300);
		
		
	}

}
