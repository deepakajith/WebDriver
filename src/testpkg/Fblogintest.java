package testpkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.Fbcreatepage;
import pagepkg.Fbloginpage;

public class Fblogintest {
	
	WebDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tsttt()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Fbloginpage ob = new Fbloginpage(driver);
		ob.setValues("deepak@gmail.com", "deepak@stellar");
		ob.login();
		
		driver.navigate().back();
		
		
		Fbcreatepage ob1 = new Fbcreatepage(driver);
		ob1.cpage();
		ob1.gestart();
		
	}
	
	

}
