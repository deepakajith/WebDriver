package junitpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redditthroughparentandchild {
	ChromeDriver driver;
	
	@Before
	public void Settingup()
	{
		driver =new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	@Test
	public void Testone()
	{
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys("Deepak");
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input")).sendKeys("deepak2389@gmail.com");
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[9]/td[3]/input")).sendKeys("Deepak@123");
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[9]/td[3]/em")).click();
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[11]/td[3]/input")).sendKeys("Deepaj@234");
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[11]/td[3]/em")).click();
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[14]/td[1]/div/table/tbody/tr/td[3]/input")).sendKeys("mailofdeepajajith@gmail.com");
		
	
	}
	
	

}
