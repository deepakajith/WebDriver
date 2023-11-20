package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yahoo {
	ChromeDriver driver;
	
	@Before
	public void Startup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com");
	}
	@Test
	public void test1()
	{
		driver.findElement(By.name("p")).sendKeys("Indian Cricket Team",Keys.ENTER);
	}

}
