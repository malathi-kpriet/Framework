package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;


@SuppressWarnings("unused")
public class LoginPageTestCase extends BaseClass
{
	@Test
	public void loginTest() throws IOException 
	{
		logger.info("URL is opened");
		
		 pageObjects.LoginPage lp = new pageObjects.LoginPage(driver);
	
	
		logger.info("URL is opened");		
		

		lp.setRadioButton();
		
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setLastName(lastname);
		logger.info("Entered lastname");

		lp.setEmail(email);
		logger.info("Entered email");

		lp.setPassword(password);
		logger.info("Entered username");

		//lp.setDate(date);
		//logger.info("Entered date");

		//lp.setMonth(month);
		//logger.info("Entered month");

		//lp.setYear(year);
		//logger.info("Entered year");

		lp.setNewsLetter();
		logger.info("clicked newsletter");

		lp.Register();
		
		logger.info("clicked register");	
		
		
	}

}
