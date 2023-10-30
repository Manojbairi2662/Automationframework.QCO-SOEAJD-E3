package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility//Rule 1
{
	//Rule 2 - Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignoutLnk;
	
	//Rule 3: Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductLnk() {
		return ProductLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignoutLnk;
	}
	
	//Business Library
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganization()
	{
		OrganizationLink.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOncontactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, AdministratorImg);
		Thread.sleep(1000);
		SignoutLnk.click();
	}
}
	


