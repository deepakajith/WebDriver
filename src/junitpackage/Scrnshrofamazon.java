package junitpackage;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Scrnshrofamazon {
	
	ChromeDriver driver;
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
	@Test
	public void test() throws IOException
	{
		WebElement li = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
		File src1 = li.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("./Screenshot/amazon1.png"));
	}

}
