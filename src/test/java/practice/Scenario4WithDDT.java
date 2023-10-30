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
import org.openqa.selenium.support.ui.Select;

public class Scenario4WithDDT {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		FileInputStream fiso = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fiso);
		String ORGNAME = wb.getSheet("Organization").getRow(7).getCell(2).getStringCellValue();
		String INDUSTRY = wb.getSheet("Organization").getRow(7).getCell(3).getStringCellValue();
		String TYPE = wb.getSheet("Organization").getRow(7).getCell(4).getStringCellValue();
		
		WebDriver driver = null;
		
		if (BROWSER.equalsIgnoreCase("Edge")) 
		{
			driver = new EdgeDriver();
			System.out.println(BROWSER+" lanuched");
		}
		else if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			System.out.println(BROWSER+" lanuched");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" lanuched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		WebElement DropdownIndustry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sl = new Select(DropdownIndustry);
		sl.selectByVisibleText(INDUSTRY);
		
		WebElement DropdownType = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sel = new Select(DropdownType);
		sel.selectByValue(TYPE);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) 
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		WebElement MouseOver = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions as = new Actions(driver);
		as.moveToElement(MouseOver).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		System.out.println("Signout Successful");
		

	}

}
