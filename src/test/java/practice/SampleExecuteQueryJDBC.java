package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver = new Driver();
	
		// step 1: Register the driver
		DriverManager.registerDriver(driver);
		
		// step 2: Get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Manoj*123");
		
		// step3: issue create statement
		Statement state = con.createStatement();
		
		// step4: execute a query
		ResultSet result = state.executeQuery("select * from empinfo;");
		while(result.next())
		{
			String value = result.getString(2);
			System.out.println(value);
		}
		
		//step5: close the database
		con.close();
		
	}

}
