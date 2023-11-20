package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fileup {
	WebDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver= new ChromeDriver();
		driver.get("https://www.persofoto.com/upload/passport-photo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	@Test
	public void testtt() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id=\"startWebcam\"]")).click();
		uploadpic("C:\\Users\\padee\\Downloads\\bmw-3-series-cs-m-automobiles-modelfinder.png");
	}
	private void uploadpic(String string) throws  InterruptedException, Exception {
		StringSelection ss = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot ro = new Robot();
		
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		
		
		
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(5000);
		
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
