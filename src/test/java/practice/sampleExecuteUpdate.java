package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sampleExecuteUpdate {

	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new Driver();
	
		// step 1: Register the driver
		DriverManager.registerDriver(driver);
		
		// step 2: Get the connection with database-- provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Manoj*123");
		
		// step 3: issue create statement
		Statement state = con.createStatement();
		
		// step 4: execute a query -- provide table name
		//String query = "insert into empinfo(name,address,id) values('kumar','Hanamkonda',4);";
		String query = "insert into empinfo values('Spiderman','Hyderabd',5);";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data added successfully");
		}
		
		//Step 5: close db
		con.close();
		

	}

}
