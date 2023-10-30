package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		String Browser = pUtil.readDataFromPropertyFile("browser");
		System.out.println(Browser);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organization", 4, 3);
		System.out.println(data);
		
		
		JavaUtility jUtil = new JavaUtility();
		int R = jUtil.getRandomNumber();
		System.out.println(R);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
	}

}
