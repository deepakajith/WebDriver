package testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99 {
	ChromeDriver driver;
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
	}
	@Test(groups = "Smoke")
	public void test1()
	{
		WebElement rightclick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		Actions act = new Actions(driver);
		act.contextClick(rightclick);
		act.perform();
		driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[4]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		WebElement dc =driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		act.doubleClick(dc);
		act.perform();
		
		
		Alert a1 = driver.switchTo().alert();
		String m = a1.getText();
		System.out.println("The message displayed on the alert box = "+m);
		a.accept();
		
		
	}
	@Test(groups="Sanity")
	public void test2()
	{
		System.out.println("its test2");
	}
	@Test(groups ={"Smoke","Sanity"})
	public void test3()
	{
		System.out.println("its test3");
	}

}
