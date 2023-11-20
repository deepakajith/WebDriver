package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Verifybuttontitle{
	
	ChromeDriver driver;
	String link = "https://register.rediff.com/register/register.php?FormName=user_details";
	@Before
	public void starti()
	{
		driver = new ChromeDriver();
		driver.get(link);
	}
	@Test
	public void test() {
		String button = driver.findElement(By.xpath("//*[@id=\"Register\"]")).getAttribute("value");
		System.out.println(button);
		String expected = "Create my account >>";
		Assert.assertEquals(button, expected);
		
		System.out.println("text on the button is matched");
	
		
	}
	
	
}