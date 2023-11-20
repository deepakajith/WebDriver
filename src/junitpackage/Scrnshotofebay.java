package junitpackage;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Scrnshotofebay {
	
	ChromeDriver driver;
	@Before
	public void begining()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test2() throws Exception
	{
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/div[3]/header/div[1]/div[3]/a[1]/svg"));
		File src1 = search.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1,new File("./Screenshot/search.png"));
	}

}
