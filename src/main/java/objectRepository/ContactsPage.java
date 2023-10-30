package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage  //Rule 1
{
	//Rule 2 - Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	//Rule 3: Initialization
	public ContactsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	// Business Library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}

	
	
}
