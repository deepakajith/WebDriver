package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemo {
	ChromeDriver driver;
	@Before
	public void Settingup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.blazedemo.com/register");
	}
	@Test
	public void Testone()
	{
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Visa");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deepak@123");
		driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("Deepak@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	

}
