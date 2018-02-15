 package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Takescreenshot;

public class selectShortSleevePage 
{
	WebDriver driver;
	Takescreenshot screenshotObj=new Takescreenshot();
	
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[3]") WebElement tShirt;
	@FindBy(xpath=".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[2]/span")
	WebElement tShirtImg;
	@FindBy(id="quantity_wanted") WebElement quantity;
	@FindBy(className="icon-plus") WebElement quantityIncrease;
	@FindBy(name="Submit") WebElement addCart;
	@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span") WebElement continueShop;
	
	
	public selectShortSleevePage(WebDriver driver)
	{	
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void selectTshirt(int q) throws InterruptedException
	{
		//selectShortSleeve
		tShirt.click();
		jsClick(tShirtImg);
		
		//Increasing Quantity
		getQuantity(q);
		addCart.click();
		
		//GetScreenshot
		screenshotObj.screenshot("ShortSleeve Added",driver);
		continueShop.click();
		
		
	}

	private void getQuantity(int q)
	{
		for(int i=1;i<q;i++)
			quantityIncrease.click();
	}
	
	public void jsClick(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}

}
