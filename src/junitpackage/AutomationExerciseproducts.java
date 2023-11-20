package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationExerciseproducts {
	
	ChromeDriver driver;
	
	@Before
	public void bb()
	{
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void tt() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Deepak Krishna");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("mailofsai@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"review\"]")).sendKeys("This website is full of ads");
		driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();
		
		
	}

}
