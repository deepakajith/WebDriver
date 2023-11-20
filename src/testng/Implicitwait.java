package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Implicitwait {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void bftestt()
	{
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a")).click();
		WebElement mousehower = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]"));
		Actions act = new Actions(driver);
		act.contextClick(mousehower);
		act.perform();
	}

}
