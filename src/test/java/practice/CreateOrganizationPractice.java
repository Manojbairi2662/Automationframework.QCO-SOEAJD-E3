package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateOrganizationPractice
{
	public static void main(String[] args) throws IOException 
	{
		//step 1: Create all the required objects
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		
		//step 2: Read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//step 3: launch the browser
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
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//step 4: Load the URL
		driver.get(URL);
		
		// step 5: Login to Application			
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		/*lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();*/
		
		
		//Step 6: Navigate to Organization LInk		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				
		//Step 7: Click on create Organization look up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 8: Create Organization with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
		//Step 9: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 9: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
		if(OrgHeader.contains(ORGNAME))
		{
		System.out.println(OrgHeader);
		System.out.println("PASS");
		}
		else
		{
		System.out.println("FAIL");
		}
		
		
		//Step 10: Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("logout successful");
		
				
	}

}
