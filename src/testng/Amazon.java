package testng;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mobile phones",Keys.ENTER);
		String parent = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		
		
		Set<String> child = driver.getWindowHandles();
		for(String handles : child)
		{
			if(!handles.equalsIgnoreCase(parent))
			{
				driver.switchTo().window(handles);
				//driver.close();
				driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
			}
		}
		
		
	}

}
