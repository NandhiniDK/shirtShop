package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class basics 
{
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a") WebElement signIn;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	@FindBy(id="SubmitLogin") WebElement login;
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a") WebElement logout;
	 
	public basics(WebDriver driver2)
	{	
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	public void clickLogin(String userName,String password) 
	{
		signIn.click();
		email.sendKeys(userName);
		this.password.sendKeys(password);
		login.click();
		
	}
	
	public void logout()
	{
		logout.click();
	}

}
