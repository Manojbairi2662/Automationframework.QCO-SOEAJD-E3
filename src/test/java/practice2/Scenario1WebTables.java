package practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1WebTables {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("(//input[contains(@value,'Login')])[2]")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selectall']")).click();
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']")).click();
		
		//use only inputb or select id

	}

}
