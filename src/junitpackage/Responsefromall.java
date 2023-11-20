package junitpackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Responsefromall{

	ChromeDriver driver;
	String ajiolink = "https://www.ajio.com/";
	
	
	@Before
	public void starttin() {
		driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get(ajiolink);
	}
	
	@Test
	public void testin()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of available links in ajio = "+li.size());
		for(WebElement links : li)
		{
			String one = links.getAttribute("href");
			Verifyalllinks(one);
		}
	}

	private void Verifyalllinks(String one) {
		try {
		URL u = new URL(one);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		con.connect();
		if(con.getResponseCode() == 400) 
		{
			System.out.println("Response code is 400 || Link="+con);
			
		}
		else if(con.getResponseCode()==200)
		{
			System.out.println("Response code is 200 || Link = "+con);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
	}

	

	
	
}