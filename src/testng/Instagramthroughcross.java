package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Instagramthroughcross {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void bf(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else
		{
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		
	}
	
	@Test
	public void test()
	{
		
		driver.get("https://www.instagram.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("ThrivinginCHAOS");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("69",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
	
	}

}
