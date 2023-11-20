package testng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Linkverificationoftrivago {
	WebDriver driver;
	@BeforeTest
	public void settingup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void linkverification()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of a tags in trivago = "+li.size());
		for(WebElement links : li)
		{
			
			String mm = links.getAttribute("href");
		
			verifylinks(mm);
			
		}
	}

	private void verifylinks(String mm)  {
		try {
		URL u = new URL(mm);
		HttpURLConnection con = (HttpURLConnection)u.openConnection();
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println("Links with response code = "+mm);
		}
		else if(con.getResponseCode()==400)
		{
			System.out.println("Links with response code = "+mm);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	} 

}
