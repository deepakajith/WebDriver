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
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extendreportsofnew {
	
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports exdend;
	
	@BeforeTest
	public void bftest()
	{
		reporter = new ExtentHtmlReporter("./Reports/fp.html");
		reporter.config().setDocumentTitle("fp Document");
		reporter.config().setReportName("fp Reports");
		reporter.config().setTheme(Theme.DARK);
		
		exdend = new ExtentReports();
		exdend.attachReporter(reporter);
		exdend.setSystemInfo("hostname","localhost");
		exdend.setSystemInfo("os","windows 11");
		exdend.setSystemInfo("browser","chrome");
		exdend.setSystemInfo("tested by","deepak p a");
		exdend.setSystemInfo("verified by","rugma");
		driver = new ChromeDriver();
	}
	@BeforeMethod
	public void bfmthd()
	{
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		test = exdend.createTest("Flipkart Title Verification");
		String act = driver.getTitle();
		System.out.println(act);
		String exp = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(act, exp);
	}
	@AfterTest
	public void aftest()
	{
		exdend.flush();
	}
	@AfterMethod
	public void afmthd(ITestResult results)
	{
		if(results.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Name of test that is failed"+results.getTestName());
			test.log(Status.FAIL, "Test cases failed is "+results.getThrowable());
		}
		else if (results.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,results.getTestName());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,results.getTestName());
		}
	}

}
