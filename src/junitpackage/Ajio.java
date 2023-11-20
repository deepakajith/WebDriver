package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {
	
	ChromeDriver driver;
	
	@Before
	public void start123()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ajio.com");
	}
	@Test
	public void test134()
	{
		driver.findElement(By.name("searchVal")).sendKeys("men fashion",Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='appContainer']/div[1]/div/header/div/ul/li/span")).click();
		//driver.findElement(By.name("username")).sendKeys("8943902775",Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='login-modal']/div[1]/div/div[2]/div[2]/form/div/div/input")).sendKeys("4227",Keys.ENTER);
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of tags = "+li.size());
		driver.findElement(By.xpath("//*[@id='appContainer']/div/div/header/div[3]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='appContainer']/div/div/header/div[3]/div[2]/div[2]/a/div")).click();
		List<WebElement> lii = driver.findElements(By.tagName("div"));
		System.out.println("Total number of div tags = "+lii);
		System.out.println();
	}
	

}
