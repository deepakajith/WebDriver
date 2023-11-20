package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Limeroad {
	
	ChromeDriver driver;
	
	@Before
	public void startupp()
	{
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/padee/OneDrive/Desktop/alertone.html");
	}
	@Test
	public void teststart()
	{
		 driver.findElement(By.xpath("//input[@type='button']")).click();
		 Alert a = driver.switchTo().alert();
		 a.dismiss();


	}

		
}

