package testng;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuruswitchtoothertabthroughNAV{
	
	
	WebDriver driver;
	
	@BeforeTest
	public void tstt()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void stt()
	{
		 driver.get("https://demo.guru99.com/popup.php");
		 String parent = driver.getWindowHandle();
		 System.out.println(driver.getTitle());
		 driver.findElement(By.xpath("/html/body/p/a")).click();
		 
		 Set<String> allwindows = driver.getWindowHandles();
		 for(String handle : allwindows)
		 {
			 if(!handle.equalsIgnoreCase(parent))
			 {
				 driver.switchTo().window(handle);
				 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("deepak@gmail.com",Keys.ENTER);
				 driver.close();
				
			 }
		 }
	}
	
}