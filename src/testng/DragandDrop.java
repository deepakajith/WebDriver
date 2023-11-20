package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {
	ChromeDriver driver;
	
	@BeforeTest
	public void startip()
	{
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		WebElement fivek1 =driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement debtaccount = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		WebElement Bank = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement amount1 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		WebElement Sales = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement account2 = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		WebElement fivek2 = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement amount2 = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
		Actions act = new Actions(driver);
		act.dragAndDrop(Bank,debtaccount);
		act.dragAndDrop(fivek1, amount1);
		act.dragAndDrop(Sales, account2);
		act.dragAndDrop(fivek2, amount2);
		act.perform();
	}

}
