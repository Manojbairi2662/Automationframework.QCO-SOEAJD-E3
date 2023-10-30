package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{
	@Test
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(false, true); //1==1
		
		
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step1");
		System.out.println("step 2");
		
		sa.assertEquals(false, true);
		System.out.println("step 3");
		System.out.println("step 4");
		
		Assert.assertEquals(0, 0);
		
		sa.assertEquals("A", "A");
		
		sa.assertAll();

	}	

}
