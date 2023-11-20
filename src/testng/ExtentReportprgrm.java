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

public class ExtentReportprgrm{
	
	WebDriver driver;
	String baseurl = "https://www.facebook.com";
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports exdend;
	
	@BeforeTest
	public void bftest()
	{
		reporter = new ExtentHtmlReporter("./Reports/fbtitle.html");
		reporter.config().setDocumentTitle("dtitle");
		reporter.config().setReportName("rname");
		reporter.config().setTheme(Theme.DARK);
		exdend = new ExtentReports();
		exdend.attachReporter(reporter);
		exdend.setSystemInfo("hostname", "localhost");
		exdend.setSystemInfo("os", "windows 11");
		exdend.setSystemInfo("tester name", "deepak");
		exdend.setSystemInfo("verified by", "rugma");
		exdend.setSystemInfo("browser", "chrome");
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void bfmethod()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void fbtitletest()
	{
		test = exdend.createTest("Fbtitleverification");
		String act = driver.getTitle();
		String exp = "Facebook – log in or sign up";
		Assert.assertEquals(exp, act);
		
	}
	
	
	@AfterTest
	public void aftest()
	{
		exdend.flush();
	}
	
	@AfterMethod
	public void afmethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test name failed is "+result.getName());
			test.log(Status.FAIL, "test cases failed is "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "test that is skipped"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "test result passes "+result.getName());
		}
		
	}
	
	
}