package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fb {
	ChromeDriver driver;
	
	@Before
	public void begin()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		}
	@Test
	public void Tesst()
	{
		List<WebElement> lists = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of links available in facebook = "+lists.size());
		System.out.println();
		
	
	for (WebElement link : lists) {
        System.out.println("Link Text: " + link.getText());
        System.out.println("URL: " + link.getAttribute("href"));
        System.out.println();
    }
	}
}

