package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("(//input[contains(@value,'Login')])[2]")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'accountname')]")).sendKeys("QspidersOnline");
		
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		
		Thread.sleep(2000);
		
		WebElement SignOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(SignOut).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

	}

}
