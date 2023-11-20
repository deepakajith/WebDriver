package testng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice{
	
	ChromeDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tst() throws Exception
	{
		WebElement search = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		File src = search.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/ebay69.png"));
		
	}

	
	}
	
