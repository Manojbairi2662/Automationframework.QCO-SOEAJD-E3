package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// comment
/* multi line comment*/

/**
 * This class consist of generic methods to read data from
 * property file
 * @author Manoj
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method will read data from property file and return the value
	 * caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}

}
