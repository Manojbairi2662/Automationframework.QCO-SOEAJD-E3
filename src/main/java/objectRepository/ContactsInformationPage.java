package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage //Rule 1
{
	//Rule 2 - Declaration
	@FindAll({@FindBy(xpath = "//span[@class='dvHeaderText']"),@FindBy(xpath = "//span[.='[ CON26 ] jag  -  Contact Information']")})
	private WebElement ContactHeaderText;
	
	//Rule 3: Initialization
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	public WebElement getContactHeaderText() 
	{
		return ContactHeaderText;
	}
	
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	//Business library
	public String getHeaderText()
	{
		return ContactHeaderText.getText();
	}
}
