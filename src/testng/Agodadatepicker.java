package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Agodadatepicker {
	
	WebDriver driver;
	
	@BeforeTest
	public void tsts()
	{
		driver = new ChromeDriver();
		driver.get("https://www.agoda.com/?ds=kdAMTSQcq%2BgGf0TP");
		driver.manage().window().maximize();
	}
	
	@Test
	public void start()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"check-in-box\"]/div/div/div/div[1]")).click();
		getcheckin("December 2023","25");
		
	}

	
	private void getcheckin(String expmonth, String expdate) {
		
		while(true)
		{
			String mnth = driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[6]/div/div/div[1]/div/div[2]/div[1]/div[1]")).getText();
			if(mnth.equals(expmonth))
			{
				System.out.println(mnth);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[6]/div/div/div[1]/div/div[1]/div[2]/button")).click();
				
			}
		}
		List <WebElement> alldays = driver.findElements(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[6]/div/div/div[1]/div/div[2]/div[1]/div[3]"));
		for(WebElement days : alldays)
		{
			String d = days.getText();
			System.out.println(d);
			
			if(d.equals(expdate))
			{
				days.click();
				break;
			}
		}
		
		
	}

}
