package testng;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Aone {
	
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void tstt()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total available links in ebay = "+li.size());
		for(WebElement lin : li)
		{
			String one = lin.getAttribute("href");
			verifylinks(one);
		}
		
	}
	private void verifylinks(String one) {
		try {
			URL u = new URL(one);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.connect();
			if(con.getResponseCode()==200)
			{
				System.out.println("The links of response code 200 are "+one);
			}
			else if(con.getResponseCode()==400)
			{
				System.out.println("The links with response code 400 are "+one);
			}
			
			
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		
	}

	@AfterTest
	public void aftest()
	{
		driver.close();
	}

}
