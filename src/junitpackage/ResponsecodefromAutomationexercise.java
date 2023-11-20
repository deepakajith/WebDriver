package junitpackage;

import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponsecodefromAutomationexercise {
	
	ChromeDriver driver;
	String aelink = "https://automationexercise.com/";
	
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get(aelink);
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in ebay = "+li.size());
		for(WebElement links : li)
		{
			String one = links.getAttribute("href");
			Verifylinks(one);
		}
		
		
	}
	private void Verifylinks(String one) {
		try
		{
			URL u = new URL(one);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.connect();
			if(con.getResponseCode()== 200)
			{
				System.out.println("Response code is 200 || And the link is :"+one);
			}
			else if(con.getResponseCode() == 400)
			{
				System.out.println("Response code is 400 || And the link is: "+one);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
		
		
	}
	
		
		



