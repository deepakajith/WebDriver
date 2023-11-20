package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chrmenotif {
	
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	
	@Test
	public void tst()
	{
		driver.get("https://www.justdial.com");
	}

}
