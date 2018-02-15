package config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class Takescreenshot 
{
	WebDriver driver;
	
	public void screenshot(String imgName, WebDriver driver)
	{
		try
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("Screenshot\\"+imgName+".png"));
		}
		catch(IOException e)
		{
		    System.out.println(e);
		}
	}

}
