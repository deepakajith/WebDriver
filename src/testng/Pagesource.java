package testng;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pagesource {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		driver = new ChromeDriver();
		driver.get(" https://www.godaddy.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void testt()
	{
		String acttitle = driver.getTitle();
		System.out.println(acttitle);
		String exptitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		if(acttitle.equals(exptitle))
		{
			System.out.println("Title verified");
		}
		
		else
		{
			System.out.println("Tile not verified");
		}
		String weburl = driver.getCurrentUrl();
		System.out.println(weburl);
		
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		if(pagesource.contains(acttitle))
		{
			System.out.println("contains title");
		}
		else
		{
			System.out.println("does not contain title");
		}
	}
	@AfterTest
	public void aftest()
	{
		driver.close();
	}

}
