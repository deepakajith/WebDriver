package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	ChromeDriver driver;
	@Before
	public void Starting() 
	{
		driver = new ChromeDriver();
		driver.get("https://www.reddit.com");
	}
	@Test
	public void Test1()
	{
		driver.findElement(By.id("navbar-menu-button")).click();
		driver.findElement(By.name("q")).sendKeys("Kerala Blasters");
	}

}
