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
import org.testng.annotations.BeforeTest;

public class ScrnshotofNike {
	
	ChromeDriver driver;
	@Before
	public void bf()
	{
		driver = new ChromeDriver();;
		driver.get("https://www.nike.com/in/air-force-1");
		driver.manage().window().maximize();
		
	}
	@Test
	public void testtt() throws IOException
	{
		WebElement li = driver.findElement(By.xpath("//*[@id=\"eca41190-c1db-4604-9bd4-4cb400c5075b\"]/div/div[2]/a[1]"));
		
		File Src1 = li.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Src1,new File("./Screenshot/webelemnt.png"));
	}
	
}