package testng;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Windowhandling {
	
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports reports;
	
	
	@BeforeTest
	public void setUo()
	{
		reporter = new ExtentHtmlReporter("./Reports/windowhandling.html");
		reporter.config().setDocumentTitle("Window handling");
		reporter.config().setReportName("amazon window handling");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("host name", "local host");
		reports.setSystemInfo("os", "windows 11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("tested by", "deepak p a");
		
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_2kclp8mbdm_e&adgrpid=61666692631&hvpone=&hvptwo=&hvadid=678711881490&hvpos=&hvnetw=g&hvrand=4162281592062002383&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9040212&hvtargid=kwd-298441375121&hydadcr=14450_2371567");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@BeforeMethod
	public void bfmethod()
	{
		
	}
	
	
	@Test
	public void windowshandling()
	{
		test = reports.createTest("Amazon test");
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parentwindow = "+parentwindow);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobiles",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		Set<String> allotherwindows = driver.getWindowHandles();
		System.out.println(allotherwindows);
		for(String handles : allotherwindows)
		{
			if(!handles.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handles);
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)");
				driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
				
			}
			else
			{
				driver.close();
			}
				
		}
	}
	@AfterTest
	public void aftest()
	{
		reports.flush();
	}
	
	@AfterMethod
	public void afmethod(ITestResult result )
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getTestName());
			test.log(Status.FAIL, result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getTestName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getTestName());
		}
		
	}


}
