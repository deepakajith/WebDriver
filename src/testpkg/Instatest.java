package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.Instapage;

public class Instatest
{
	WebDriver driver;
	
	@BeforeTest
	public void nft()
	{
		
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
	}
	@Test
	public void tst()
	{
		Instapage ob = new Instapage(driver);
		ob.setvalues("deepakajith@gmail.com", "Deepak0989009");
		ob.login();
	}
}