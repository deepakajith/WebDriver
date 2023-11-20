package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookthroughxpath {
	ChromeDriver driver;
	@Before
	public void startin()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	@Test
	public void test1()
	{
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("deepakajith");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Deepak@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//a[@accesskey='8']")).click();
		
	}

}
