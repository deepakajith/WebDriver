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

public class Linksverificationofsaucedemo {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void linkVerificationtest()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in saucedemo = "+li.size());
		for(WebElement links :li)
		{
			String one = links.getAttribute("href");
			verifylinks(one);
		}
	}

	private void verifylinks(String one) {
		try
		{
			URL u = new URL(one);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.connect();
			if(con.getResponseCode()==200)
			{
				System.out.println("The links with response code 200 = "+one);
			}
			else if(con.getResponseCode()==400)
			{
				System.out.println("The links with response code 400 ="+one );
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
