package testng;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Disablenotifi {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get("C:\\Users\\padee\\OneDrive\\Desktop\\alertone.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void notificationtest()
	{
//		ChromeOptions cp = new ChromeOptions();
//		cp.addArguments("--disable-notifications");
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

}
