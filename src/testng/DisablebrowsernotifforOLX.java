package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DisablebrowsernotifforOLX {
	
	WebDriver driver;
	
	@BeforeTest
	public void bdf()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--disable-notifications");
		driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
	}
	
	@Test
	public void tst()
	{
		driver.get("https://www.olx.in/en-in");
	}

}
