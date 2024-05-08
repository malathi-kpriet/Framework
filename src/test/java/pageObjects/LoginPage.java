package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class LoginPage {

	public static void main(String[] args) {        
		
		//pagefactory-design pattern ,to initialize the web elements in page object
		//code maintainability,readability,data to be encapsulated
		
	}
		public LoginPage(WebDriver rdriver)
		{
		 WebDriver ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
		}
		
		@FindBy(name="id_gender")
		WebElement MrRadioButton;
		
		@FindBy(id="customer_firstname")
		WebElement CustFirstName;
		
		@FindBy(id="customer_lastname")
		WebElement CustLastName;
		
		@FindBy (id="email")
		WebElement Email;
		
		@FindBy(id="passwd")
		WebElement EnterPassword;
		
		
		@FindBy(id = "days")
		private WebElement EnterDate;

		public Select selectDateDropdown() {
		    return new Select(EnterDate);
		}

		@FindBy(id = "month")
		private WebElement EnterMonth;

		public Select selectMonthDropdown() {
		    return new Select(EnterMonth);
		}

		@FindBy(id = "year")
		private WebElement EnterYear;

		public Select selectYearDropdown() {
		    return new Select(EnterYear);
		}

		@FindBy(id="newsletter")
		WebElement NewsLetter;
		
		@FindBy(linkText="Register")
		WebElement ClickRegister;
		
		

		
		//methods
		
		public void setRadioButton()
		{
			MrRadioButton.click();
		}
		
		public void setUserName(String uname)
		{
			CustFirstName.sendKeys(uname);
		}
		
		public void setLastName(String lname)
		{
			CustLastName.sendKeys(lname);
		}
		
		public void setEmail(String email)
		{
			Email.sendKeys(email);
		}
		
		public void setPassword(String password)
		{
			EnterPassword.sendKeys(password);
		}
		public void setDate(CharSequence[] date)
		{
		  EnterDate.sendKeys(date);	
		}
		
		public void setMonth(CharSequence[] month)
		{
			EnterMonth.sendKeys(month);
		}
		public void setYear(CharSequence[] year)
		{
			EnterYear.sendKeys(year);
		}
		public void setNewsLetter()
		{
			NewsLetter.click();
		}
		public void Register()
		{
			ClickRegister.click();
		}	
	}
		
		
		
		
	


