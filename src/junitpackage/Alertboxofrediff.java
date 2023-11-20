package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertboxofrediff {
	
	ChromeDriver driver;
	String redifflink = "https://register.rediff.com/register/register.php?FormName=user_details";
	
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get(redifflink);
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		driver.findElement(By.xpath("//*[@id=\"Register\"]")).click();
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

}
