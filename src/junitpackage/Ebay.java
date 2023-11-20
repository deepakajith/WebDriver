package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {
	ChromeDriver driver;

	@Before
	public void startup() {
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");

	}
	@Test
	public void testone()
	{
		driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("mobiles");
		driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
		driver.findElement(By.xpath("//*[@id='s0-53-17-6-3-4[0]-3-2-1-list']/li[2]/div/a/div")).click();
		driver.findElement(By.xpath("//*[@id='x-refine__group__0']/ul/li/ul/li/a/i")).click();
		String org = driver.getTitle();
		System.out.println(org);
		driver.findElement(By.xpath("//*[@id='x-refine__group_1__0']/ul/li[3]/div/a/div/span/input")).click();
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in ebay="+li.size());
		
	}

}
