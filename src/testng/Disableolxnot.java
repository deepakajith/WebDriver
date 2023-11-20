package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Disableolxnot {
	WebDriver driver;
	@BeforeTest
	public void beftest()
	{
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/en-in");
		driver.manage().window().maximize();
	}
	@Test
	public void testt()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions op = new ChromeOptions(); 
		op.addArguments("--disable-notifications");
	}

}
