package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Rediffthroughactionclass {
	ChromeDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
	}
	@Parameters({"fullname","rediffid"})
	@Test
	public void test(String fullname,String rediffid)
	{
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys(fullname);
		WebElement Rediff1 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		Rediff1.sendKeys(rediffid);
		WebElement password = driver.findElement(By.xpath("//*[@id=\"newpasswd\"]"));
		WebElement password2 = driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]"));
		WebElement altemail = driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input"));
		password.sendKeys("Deepak@123");
		Actions act = new Actions(driver);
		
		act.keyDown(password,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(password,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(password,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.dragAndDrop(Rediff1, altemail);
		act.perform();
		
	}

}
