package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazonscrolldown {
	
	WebDriver driver;
	
	@BeforeTest
	public void bgt()
	{
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void amatesting()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,3700)");
		//js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement mm = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();",mm);
		mm.click();
		
	}

}
