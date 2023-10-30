package practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupFeatureDate {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		//driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		// Navigate to From Elements
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Hyd");
		driver.findElement(By.xpath("(//p[.='Hyderabad, India'])[1]")).click();
		
		Thread.sleep(1000);
		
		// Navigate to Destination Element
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Del");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		// Navigate to departure
		//driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		// Navigate to any future Date date in calendar
		Thread.sleep(1000);
		
	    for(;;)//1 2 3 4 5 
		{
			try 
			{ 
				//not visible - exception - visible - click()
				driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click();  // No such element exception
				break;
			} 
			catch (Exception e) 
			{
				//click on next month
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
			}
		}
	}

}
