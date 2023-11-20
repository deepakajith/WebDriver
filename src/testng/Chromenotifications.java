package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chromenotifications {
	
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		ChromeOptions optn = new ChromeOptions();
		optn.addArguments("--disable-notifications");
		driver= new ChromeDriver(optn);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		driver.get("https://www.justdial.com/");
	}

}
