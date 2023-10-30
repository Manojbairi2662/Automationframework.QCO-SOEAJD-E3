package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2WithDDT {

	public static void main(String[] args) throws IOException 
	{
		//Step 1: Read all the necessary Data
		
		//read data from property file-common data
		FileInputStream fiso = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fiso);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//read data from excel-test data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver = null;
		
		//Step 2: Launch the Browser // Run Time Polymorphism - driver
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// step 2 : Load the application
		driver.get(URL);
		
		// step 3: Login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Step 4: Navigate to Organization LInk		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Step 5: Click on create Organization look up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 6: Organization name
		driver.findElement(By.xpath("//input[contains(@name,'accountname')]")).sendKeys(ORGNAME);
		
		//Step 7: Save
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		
		//Step 8: Validate
		String OrganizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(OrganizationHeader.contains(ORGNAME))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		// step 9: sign out
		WebElement ele = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions signout = new Actions(driver);
		signout.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		System.out.println("Signout Successful");
		
		
	}

}
