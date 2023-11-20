package testng;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingdotcomDatepicker {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforett()
	{
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
				
	}
	
	@Test
	public void startingtest()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[2]/div")).click();
		
		checkindateselected("November 2023","12");
	}

	private void checkindateselected(String expmnth, String expdate) {
		
		while(true)
		{
			String mnth = driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[2]/h3")).getText();
			if(mnth.equals(expmnth))
			{
				System.out.println(mnth);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/button[2]")).click();
			}
		}
		//List<WebElement>alldates = driver.findElements(By.xpath(""))
		
		
	}

}
