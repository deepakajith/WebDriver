package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Rediff_Practicing {
	
	ChromeDriver driver;
	@Before
	public void startingtest() 
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void testingproject()
	{
		String one = driver.getTitle();
		System.out.println(one);
		String two = driver.getCurrentUrl();
		System.out.println(two);
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of div tags in rediff.com = "+li.size());
		
	
		WebElement sel = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
		Select se = new Select(sel);
		se.selectByIndex(01);
		}
	}


