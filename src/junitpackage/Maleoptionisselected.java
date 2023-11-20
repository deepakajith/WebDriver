package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maleoptionisselected {
	
	ChromeDriver driver;
	@Before
	public void srtr()
	{
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	@Test
	public void testst()
	{
		boolean a = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).isSelected();
		if(a)
		{
			System.out.println("Selected");
		}
		else
		{
			System.out.println("Not selected");
		}
	}

}
