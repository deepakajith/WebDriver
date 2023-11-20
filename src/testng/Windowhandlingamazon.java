package testng;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Windowhandlingamazon {
	WebDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/events/greatindianfestival?tag=googmantxtmob96-21&ascsubtag=_k_Cj0KCQiAuqKqBhDxARIsAFZELmJ9yPn9h-la52SH8V3W5awkgkgQDRIJjGnDnAubtDY6pj8xE7WCAaEaAliyEALw_wcB_k_");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void test()
	{
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Camera",Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		
		Set<String>allwindowhandles = driver.getWindowHandles();
		for(String handles : allwindowhandles)
		{
			if(!handles.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handles);
			}
			else
			{
				driver.switchTo().window(parentwindow);
			}
		}
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	}
	
}
