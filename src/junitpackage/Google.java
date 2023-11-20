package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	ChromeDriver driver;
	@Before
	public void firstsearch() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	@Test
	public void test1() {
		driver.findElement(By.name("q")).sendKeys("cricket",Keys.ENTER);
		
	}
	

}
