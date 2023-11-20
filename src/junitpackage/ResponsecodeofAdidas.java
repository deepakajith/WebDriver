package junitpackage;


import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponsecodeofAdidas {
	
	ChromeDriver driver;
	String adidas="https://www.ebay.com";
	@Before
	public void startin()
	{
		driver = new ChromeDriver();
		driver.get(adidas);
		driver.manage().window().maximize();
	}
	@Test
	public void testin()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in adidas = "+li.size());
		for(WebElement link : li)
		{
			String one = link.getAttribute("href");
			
			verifylinks(one);
		}
	}
	private void verifylinks(String one) {
		try 
		{
			URL u = new URL(one);
			 HttpURLConnection con  = (HttpURLConnection)u.openConnection();
			 con.connect();
			 if(con.getResponseCode()==200)
			 {
				 System.out.println("Response code is 200 || Link is "+one);
			 }
			 else if(con.getResponseCode()==400)
			 {
				 System.out.println("Response code is 400 || Link is "+one);
			 }
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
