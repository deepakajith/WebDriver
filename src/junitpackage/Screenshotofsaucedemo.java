package junitpackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotofsaucedemo {
	WebDriver driver;
	
	@Before
	public void startup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void screenshotofsaucedemo() throws Exception
	{
		WebElement button = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		File src1 = button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("D:\\Luminar\\loginsauce.png"));
	}
}
