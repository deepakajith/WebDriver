package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class YahooExtentReport {
	WebDriver driver;
	String baseurl = "https://in.search.yahoo.com/?fr2=inr";
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extendd;
	
	@BeforeTest
	public void bftst()
	{
		reporter = new ExtentHtmlReporter("./Reports/yahhoo.html");
		reporter.config().setDocumentTitle("Yahoo Website");
		reporter.config().setReportName("Yahoo title report");
		extendd = new ExtentReports();
		extendd.attachReporter(reporter);
		extendd.setSystemInfo("hostname", "local host");
		extendd.setSystemInfo("os", "windows 11");
		extendd.setSystemInfo("browser", "chrome");
		extendd.setSystemInfo("tested by", "deepak p a");
		driver = new ChromeDriver();
		
	}
	@BeforeMethod
	public void bftest()
	{
		driver.get(baseurl);
	}
	@Test
	public void testt()
	{
		test = extendd.createTest("Yahoo Title Verification");
		String act = driver.getTitle();
		String exp = "Yahoo Search - Web Search";
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
	@AfterTest
	public void aftest()
	{
		extendd.flush();
	}
	@AfterMethod
	public void afmethod(ITestResult results)
	{
		if(results.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test that is failed"+results.getTestName());
			test.log(Status.FAIL, "Test case that is failed"+results.getThrowable());
		}
		else if(results.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,results.getTestName());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, results.getTestName());
		}
	}

}
