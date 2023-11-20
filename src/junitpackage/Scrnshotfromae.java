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

import pkg.Pagesrc;

public class Scrnshotfromae {
	
	ChromeDriver driver;
	String aelink = "https://automationexercise.com/";
	
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get(aelink);
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D://ae3.png"));
		
		WebElement li = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/a[2]/button"));
		File src1 = li.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("./Screenshot/aescrnshot.png"));
	}

}
