package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Uploadfile {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void bftet()
	{
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
	}
	@Test
	public void tst()
	{
		WebElement up = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
		up.sendKeys("D:\\S10 Project\\images");
		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		WebElement snd = driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
		System.out.println("Text displayed on the button = " +snd.getText());
		String exp = "send";
		if(exp.equalsIgnoreCase(snd.getText()))
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("not verified");
		}
		driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();
	}

}
