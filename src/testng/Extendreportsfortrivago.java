package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class Extendreportsfortrivago {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports exdend;
	
	@BeforeTest
	public void beforemthd()
	{
		reporter = new ExtentHtmlReporter("./Reports/trivago.html");
		reporter.config().setDocumentTitle("trivago doc");
		reporter.config().setReportName("trivago report");
		reporter.config().setTheme(Theme.DARK);
		exdend = new ExtentReports();
		exdend.attachReporter(reporter);
		exdend.setSystemInfo("os", "windows 11");
		exdend.setSystemInfo("browser", "chrome");
		exdend.setSystemInfo("tested by", "Deepak p a");
		exdend.setSystemInfo("verified by", "rugma");
		exdend.setSystemInfo("institute", "luminar");
	}
	@BeforeMethod
	public void bfmthd()
	{
		driver = new ChromeDriver();
		driver.get("https://www.trivago.in/en-IN/lm/hotels-mumbai-india?search=200-64981");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void startintest()
	{
		test = exdend.createTest("TRIVAGO TEST");
		String actual = driver.getTitle();
		String expected = "Mumbai Hotels | Find & compare great deals on trivago";
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	
		
	}
	@AfterTest
	public void aftest()
	{
		exdend.flush();
	}
	@AfterMethod
	public void afmethod(ITestResult results)
	{
		if(results.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,results.getName());
			test.log(Status.FAIL, results.getThrowable());
		}
		else if(results.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, results.getName());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, results.getName());
		}
		
	}

}
