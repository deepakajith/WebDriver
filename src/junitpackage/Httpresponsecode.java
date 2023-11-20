package junitpackage;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Httpresponsecode {
	String baseurl = "https://www.ebay.com/";
	
	ChromeDriver driver;
	
	@Before
	public void Startt()
	{
		driver = new ChromeDriver();
		
		driver.get(baseurl);
	}
	@Test
	public void testt() throws Exception
	{
		URL u = new URL(baseurl);
		HttpURLConnection con =(HttpURLConnection)u.openConnection();
		System.out.println(con.getResponseCode());
		
	}

}
