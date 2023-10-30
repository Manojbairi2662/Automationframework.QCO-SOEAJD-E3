package practice2;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupCurrentDate {

	public static void main(String[] args) throws Throwable 
	{
		Date d = new Date();
		String dateNow = d.toString();
		System.out.println(dateNow);
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		
		
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
		
		// Navigate to desired date in calender
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		                             //div[@aria-label='Sat Sep 30 2023']
		
	}

}
