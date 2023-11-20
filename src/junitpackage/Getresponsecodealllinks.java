package junitpackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getresponsecodealllinks {
	String link = "https://www.rediff.com/";
	ChromeDriver driver;
	
	@Before
	public void stt()
	{
		driver = new ChromeDriver();
		driver.get(link);
	}
	@Test
	public void testttt()
	{
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in rediff.com = "+li.size());
		for(WebElement links : li)
		{
			String one = links.getAttribute("href");
			verifylink(one);
		}
		
	}
	private void verifylink(String one) {
		try {
			URL u = new URL(one);
			HttpURLConnection con =(HttpURLConnection)u.openConnection();
			con.connect();
			
			if(con.getResponseCode()==200)
			{
				System.out.println("Response code is 200  "+one);
			}
			else if(con.getResponseCode()==400)
			{
				System.out.println("response code is 400  "+one);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	

}
