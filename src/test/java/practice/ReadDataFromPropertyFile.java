package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		// step 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2: create object of Properties for java.util package
		Properties pro = new Properties();
		
		//step 3: Load the file input stream into properties
		pro.load(fis);
		
		//step 4: provide the key and read the value
		String value = pro.getProperty("browser");
		System.out.println(value);

	}

}
