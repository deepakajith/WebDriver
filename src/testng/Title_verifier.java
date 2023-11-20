package testng;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Title_verifier {
	WebDriver driver;

	@Before
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.maliekalheritance.com/");
	}
	@Test
	public void tst()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}

}
