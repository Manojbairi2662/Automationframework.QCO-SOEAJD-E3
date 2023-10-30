package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnaliser 
{
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void analyserpractice()
	{
		Assert.fail();
		System.out.println("Hello");
	}

}
