package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[] args) throws Throwable 
	{
	
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("(//input[contains(@value,'Login')])[2]")).click();	
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("bairi");
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	     
	    Thread.sleep(2000);
	    //get window handle
	    String parent = driver.getWindowHandle();
		
	    //handle child window
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}	    
		// address of element in child window
		driver.findElement(By.xpath("//a[text()='QspidersOnline']")).click();
		
		
		Thread.sleep(2000);
		// return parent window
		driver.switchTo().window(parent);
		// address of element in parent window
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
        driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		
		WebElement SignOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(SignOut).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}

