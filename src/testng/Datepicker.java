package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepicker {
	
	WebDriver driver;
	
	@BeforeTest
	public void strting()
	{
		driver = new ChromeDriver();
		driver.get("https://www.trivago.in/en-IN/lm/hotels-mumbai-india?search=200-64981;dr-20231107-20231205");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testing()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[1]/fieldset/button[1]")).click();
		selectcheckinmethod("December 2023","25");
		selectcheckinmethod("December 2023","28");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[1]/button/span/span[2]/span[1]")).click();
		
	}

	private void selectcheckinmethod(String expmnth, String expdate) {
		while(true)
		{
		String mnth = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/h3")).getText();
		
		
		if(mnth.equals(expmnth))
		{
			System.out.println("Month is = "+mnth);
			break;
		}
		else
		{
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/button[2]/span")).click();
		}
		}
		
		List<WebElement>alldates = driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));
		for(WebElement dateelement : alldates)
		{
			String dt = dateelement.getText();
			System.out.println(dt);
			if(dt.equals(expdate))
			{
				dateelement.click();
				break;
			}
			//driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div/button[2]")).click();
		}
		
		
		
		
	}

}
