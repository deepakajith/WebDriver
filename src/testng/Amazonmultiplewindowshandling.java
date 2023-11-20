package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazonmultiplewindowshandling {
	WebDriver driver;
	
	@BeforeTest
	public void bgtet()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void ll()
	{
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobile Phones",Keys.ENTER);
		String tit = driver.getTitle();
		System.out.println(tit);
		String exp = "Amazon.com : Mobile Phones";
		if(tit.equalsIgnoreCase(exp)) 
		{
			System.out.println("title verified");
			
		}
		else
		{
			System.out.println("title not verified");
		}
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
	}

}
