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
		
		@FindBy(className="login")
		WebElement ClickSign;
		
		@FindBy(id="email_create")
		WebElement Email1;
		
		@FindBy(xpath="//*[@id=\"SubmitCreate\"]/span/i")
		WebElement Create;
		
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

		

		@FindBy(id = "months")
		private WebElement EnterMonth;

		
		@FindBy(id = "years")
		private WebElement EnterYear;

		
		@FindBy(id="newsletter")
		WebElement NewsLetter;
		
		//@FindBy(partialLinkText="Register")
		//WebElement ClickRegister;
		
		

		
		//methods
		
		public void ClickSignin()
		{
			ClickSign.click();
		}
		
		public void setEmail1(String email)
		{
			Email1.sendKeys(email);
		}
		
		public void ClickCreate()
		{
			Create.click();
		}
		
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
		public void setDate(String date) {
		    EnterDate.sendKeys(date);
		}

		public void setMonth(String month)
		{
			EnterMonth.sendKeys(month);
		}		
		public void setYear(String year)
		{
			//Select selectDateDropdown = new Select(EnterYear);
		    //selectDateDropdown.selectByVisibleText(String.valueOf(year));
			EnterYear.sendKeys(year);
		}
		
		public void setNewsLetter()
		{
			NewsLetter.click();
		}
		//public void Register()
		//{
			//ClickRegister.click();
		//}
		
	}
		
		
		
		
	


