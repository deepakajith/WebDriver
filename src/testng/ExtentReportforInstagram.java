package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import junit.framework.Assert;

public class ExtentReportforInstagram {
	
	WebDriver driver;
	String baseurl = "https://www.instagram.com/";
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports exdend;
	
	@BeforeTest
	public void bftest()
	{
		reporter = new ExtentHtmlReporter("./Reports/insta.html");
		reporter.config().setDocumentTitle("dtitle");
		reporter.config().setReportName("rname");
		reporter.config().setTheme(Theme.DARK);
		exdend = new ExtentReports();
		exdend.attachReporter(reporter);
		exdend.setSystemInfo("hostname", "local host");
		exdend.setSystemInfo("os", "windows");
		exdend.setSystemInfo("Testername", "deepak");
		exdend.setSystemInfo("browser", "chrome");
		exdend.setSystemInfo("verified by", "rugma");
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void beforemthd()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void testt()
	{
		test=exdend.createTest("InstaExtentReports");
		String act1 = driver.getTitle();
		String exp1 = "Instagram";
		System.out.println(act1);
		Assert.assertEquals(exp1, act1);
		
		
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
			test.log(Status.FAIL, "Failed test is"+results.getTestName());
			test.log(Status.FAIL, "Failed test case is"+results.getThrowable());
		}
		else if(results.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Failed test is "+results.getTestName());
		}
		else if(results.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.FAIL, "Failed test name is "+results.getTestName());
		}
		
	}

}
