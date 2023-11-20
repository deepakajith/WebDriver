package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redifflogocheck {
	ChromeDriver driver;
	
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
	}
	@Test
	public void test()
	{
		boolean logo = driver.findElement(By.xpath("//img[@title='Rediff.com']")).isDisplayed();
		if(logo)
		{
			System.out.println("logo is displayed");
		}
		else
		{
			System.out.println("logo not displayed");
		}
		
		
	}

}
