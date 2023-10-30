package practice;

import org.testng.annotations.Test;

public class TestNgPriority 
{
	// priority means: which program execute first
	@Test(priority=-3)
	public void demo()
	{
		System.out.println("Hi demo1");
	}
	@Test (priority=1)
	public void demo2()
	{
		System.out.println("Hello demo2");
	}
	@Test (priority=-5)
	public void Demo3()
	{
		System.out.println("Hello demo3");
	}

}
