package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	@Test
	public void Login() {
		driver.findElement(By.name("email")).sendKeys("deepak@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Deepak@12345");
		//driver.findElement(By.name("login")).click();
		
	}

	
}
