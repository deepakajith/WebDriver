package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Rediffthroughselect{
	
	ChromeDriver driver;
	String baselink ="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@Before
	public void start()
	{
		driver = new ChromeDriver();
		driver.get(baselink);
	}
	@Test
	public void starttt()
	{
		WebElement day = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select enterday = new Select(day);
		enterday.selectByValue("08");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select entermonth = new Select(month);
		entermonth.selectByVisibleText("SEP");
		
		WebElement year = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select enteryear = new Select(year);
		enteryear.selectByIndex(25);
		
		
	}
}