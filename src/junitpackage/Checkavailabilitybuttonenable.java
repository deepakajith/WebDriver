package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkavailabilitybuttonenable {
	
	ChromeDriver driver;
	
	@Before
	public void start() {
		driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
	}
	@Test
	public void test3() {
		WebElement ca = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]"));
		boolean a= ca.isEnabled();
		if(a)
		{
			System.out.println("Enabled");
		}
		else
		{
			System.out.println("Not enabled");
		}
	}

}
