package inputData;

import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class data 
{
	public static ArrayList<String> readData(String location) throws FilloException 
	{
	
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(location);
		
		String queryString="Select * from Sheet1";
		Recordset rs=connection.executeQuery(queryString);
		
		ArrayList<String> loginList=new ArrayList<String>();
		String userName=null;
		String password=null;
		while(rs.next())
		{
			userName=rs.getField("UserName");
			password=rs.getField("Password");
			loginList.add(userName);
			loginList.add(password);
		}
		
		rs.close();
		connection.close();
		
		return loginList;
	}

}
