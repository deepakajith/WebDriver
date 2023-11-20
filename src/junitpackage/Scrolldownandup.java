package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolldownandup {
	
	ChromeDriver driver;
	String baselinks = "https://www.rediff.com/";
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get(baselinks);
		driver.manage().window().maximize();
	}
	@Test
	public void testing() throws InterruptedException
	
	
	{
		Thread.sleep(3000);
		JavascriptExecutor one =(JavascriptExecutor)driver;
		one.executeScript("window.scrollBy(0,900)");
	}

}
