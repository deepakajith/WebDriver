package junitpackage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertboxprgrm {
	ChromeDriver driver;
	
	@Before
	public void begining()
	{
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/padee/OneDrive/Desktop/alertone.html");
		
	}
	@Test
	public void testing()
	{
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert a = driver.switchTo().alert();
		String alerttext = a.getText();
		System.out.println(alerttext);
		a.accept();
		driver.findElement(By.name("firstname")).sendKeys("Deepak");
		driver.findElement(By.name("lastname")).sendKeys("Ajith");
		driver.findElement(By.xpath("/html/body/input[4]")).click();
	}

}
