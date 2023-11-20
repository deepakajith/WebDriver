package junitpackage;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Selectdropdown {
	
	ChromeDriver driver;
	@Before
	public void bf()
	{
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void testt() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"srchquery_tbox\"]")).sendKeys("Disha Patani",Keys.ENTER);
		driver.navigate().forward();
		
		
		
		
		
		
	}
	
	}


