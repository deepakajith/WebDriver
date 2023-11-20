package testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Assertions {
	ChromeDriver driver;
	
	
	@BeforeTest
	public void nn()
	{
		
	
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void tst()
	{
		String act = driver.getTitle();
		System.out.println(act);
		
		String exp ="Facebook – log in or sign u";
		System.out.println(exp);
		Assert.assertEquals(exp, act);
	}

}
