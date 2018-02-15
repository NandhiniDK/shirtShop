package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configclass
{
	 File file;
	 FileInputStream fInputStream;
	 Properties property=new Properties();
			
	public Properties readProperty(String location)
	{	
		try
		{
			file=new File(location);
			fInputStream=new FileInputStream(file);
			property.load(fInputStream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return property;
	}
								
}
