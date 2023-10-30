package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNg
 * @author Manoj
 *
 */
public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+ "Test script execution started");
	
		//create a test script - recognise each @Test
		test = report.createTest(testScriptName);
	}

	public void onTestSuccess(ITestResult result) 
	{		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+ "Passed");
		
		//Log the success
		test.log(Status.PASS, testScriptName+ "==Pass==");
	}

	public void onTestFailure(ITestResult result)
	{		
		//Screenshot
		//Exception for failure
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+ "Failed");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//Log for failure
		test.log(Status.FAIL, testScriptName+ "== Fail==");
		test.log(Status.INFO, result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName + new JavaUtility().getSystemDate(); 
		WebDriverUtility w = new WebDriverUtility();
		
		try 
		{
			String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	public void onTestSkipped(ITestResult result) 
	{				
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"Skipped");
		
		//Execution for skipped
		System.out.println(result.getThrowable());
		
		//log for Skip
		test.log(Status.SKIP, testScriptName+" == skipped ==");
		test.log(Status.INFO, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
			
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution started");
		
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.STANDARD);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("vtiger execution report");
		
		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Report Name", "Manoj");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution finished");
		
		//Report Generation
		report.flush();
	}

}
