package junitpackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automationexercise {
	ChromeDriver driver;
	@Before
	public void start2()
	{
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/login");
		
	}
	@Test
	public void test2()
	{
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Sai");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("mailofrahul@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sai@123");
		
		WebElement day1 = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		Select enterday1 = new Select(day1);
		enterday1.selectByIndex(8);
		
		WebElement month1 = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		Select entermonth1 = new Select(month1);
		entermonth1.selectByIndex(9);
		
		WebElement year1 = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		Select enteryear1 = new Select(year1);
		enteryear1.selectByIndex(23);
	
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Sai");
		driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Krishna");
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("No Company");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Amriththarayil House");
		driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Manakkapady House");
		
		WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		Select count = new Select(country);
		count.selectByValue("Australia");
		
		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Kerala");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Ernakulam");
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("683520");
		driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("7024107381");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).submit();
		
		
		
		
		
		
	
	}

	

}

