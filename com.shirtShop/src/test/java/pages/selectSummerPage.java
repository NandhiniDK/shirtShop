package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.Takescreenshot;

public class selectSummerPage
{
	
	WebDriver driver;
	Takescreenshot screenshotObj=new Takescreenshot();

	
	@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span") WebElement continueShopping;
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[2]/a") WebElement dresses;
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a") WebElement summerDress;
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a") WebElement casualDress;
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a") WebElement eveningDress;
	@FindBy(xpath=".//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]/span") WebElement img;
	@FindBy(id="quantity_wanted") WebElement quantity;
	@FindBy(xpath=".//*[@id='add_to_cart']/button") WebElement addCart;
	@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span") WebElement checkOut;
	@FindBy(xpath=".//*[@id='product_1_1_0_51436']/td[2]/p/a") WebElement itemName;
	@FindBy(xpath=".//*[@id='1_1_0_51436']/i") WebElement delete;
	@FindBy(xpath=".//*[@id='center_column']/p[2]/a[1]/span") WebElement placeOrder;
	@FindAll({@FindBy(id="product_1_1_0_51436")}) private List<WebElement> tblRow;
	@FindBy(name="processAddress") WebElement address;
	@FindBy(name="cgv") WebElement agreement;
	@FindBy(name="processCarrier") WebElement shipping;
	@FindBy(xpath=".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a") WebElement pay;
	@FindBy(xpath=".//*[@id='cart_navigation']/button") WebElement confirm;
	@FindBy(xpath=".//*[@class='box']/p/strong") WebElement verify;
	
	
	public selectSummerPage(WebDriver driver)
	{	
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void selectSummerDress(String category)
	{

		selectCategory(category);
	}
	
	
	//Selecting Summer Dress
	public void selectCategory(String type)
	{
	
		Actions mouse=new Actions(driver);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		
		mouse.moveToElement(dresses).build().perform();
		if(type.equalsIgnoreCase("Casual Dresses"))
		 casualDress.click();
		else if(type.equalsIgnoreCase("Evening Dresses"))
			eveningDress.click();
		else
			summerDress.click();
		
		//Select Dress
		jsClick(img);
		
		//Increasing Quantity
		quantity.clear();
		quantity.sendKeys("10");
		
		//capture after summerDress quantity increase to 10
		screenshotObj.screenshot("SummerDress Added",driver);
		
		
		jsClick(addCart);
		checkOut.click();
		
	    //Delete Faded T-shirt
		List<WebElement> rw=tblRow;
        for(int i=1;i<=rw.size();i++)
        {
	       	String col=driver.findElement(By.xpath(".//tbody/tr["+i+"]/td[2]")).getText();
	       	if(col.contains("Faded Short Sleeve T-shirts"))
	       	{
	       		jsClick(driver.findElement(By.xpath(".//tbody/tr["+i+"]//td//following-sibling::a[@id='1_1_0_51436']")));
	       	}
        }
        
        //capture after delete faded T-shirt
        screenshotObj.screenshot("Faded T-shirt Deleted",driver);
        
        jsClick(placeOrder);
        
        //Address Confirmation
        jsClick(address);
        
        //Agree Agreement and Proceeding
        jsClick(agreement);
        jsClick(shipping);
        
        //Confirm Payment type and Proceeding
        jsClick(pay);
        jsClick(confirm);
        
        //Confirmation
        Assert.assertEquals(verify.getText(), "Your order on My Store is complete.");
		
		screenshotObj.screenshot("End of Purchase",driver);
		
		
		
	}
	
	public void jsClick(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}
	


	

}
