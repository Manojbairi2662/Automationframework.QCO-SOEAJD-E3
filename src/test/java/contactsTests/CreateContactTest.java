package contactsTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass
{
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws IOException, InterruptedException
	{
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
		//Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickOncontactsLink();
		Reporter.log("Click on create contact");
		
		//Step 7: Click on Create contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Click on create contact loog up image ");
		
		//Step 8: Create Contact with Organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created successfully");
		
		//Step 9: Validation
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String contactHeader = cip.getHeaderText();
		Reporter.log("Header Captured");
		
		//Assert.fail();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("Header validation");
		
		System.out.println(contactHeader);
		
}
	@Test
	public void demo()
	{
		System.out.println("Demo");
	}
}
