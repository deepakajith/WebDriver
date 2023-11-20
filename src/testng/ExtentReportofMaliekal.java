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

public class ExtentReportofMaliekal {
	
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports exdend;
	
	@BeforeTest
	public void bft()
	{
		reporter = new ExtentHtmlReporter("./Reports/maliekal.html");
		reporter.config().setDocumentTitle("Maliekal Heritance");
		reporter.config().setReportName("Maliekal Heritance Report");
		reporter.config().setTheme(Theme.DARK);
		exdend = new ExtentReports();
		exdend.attachReporter(reporter);
		exdend.setSystemInfo("Host Name", "Local Host");
		exdend.setSystemInfo("Tested By", "Deepak P A");
		exdend.setSystemInfo("Verified By", "Rugma Libin");
		exdend.setSystemInfo("OS", "Windows 11");
		exdend.setSystemInfo("Browser", "Chrome");
		driver = new ChromeDriver();
	}
	@BeforeMethod
	public void bfm()
	{
		driver.get("https://www.maliekalheritance.com/");
	}
	@Test
	public void tst()
	{
		test = exdend.createTest("Maliekal Heritance Test");
		String act = driver.getTitle();
		String exp = "Maliekal Heritance – Beach Resort in Cherai";
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
	@AfterTest
	public void aftest()
	{
		exdend.flush();
	}
	@AfterMethod
	public void afm(ITestResult results)
	{
		if(results.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, results.getTestName());
			test.log(Status.FAIL, results.getThrowable());
		}
		else if(results.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, results.getTestName());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, results.getTestName());
		}
		
	}

}
