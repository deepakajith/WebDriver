package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fileupload {
	
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.jobscan.co/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//*[@id=\"tryLinkedInCTA\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"dropZone\"]/button")).click();
		fileupload("\"C:\\Users\\padee\\Downloads\\Defect Report of SSS - Sheet1.pdf\"");
		
		
	}
	private void fileupload(String string) throws AWTException {
		StringSelection select = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		Robot robo = new Robot();
		
		robo.delay(5000);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		robo.delay(4000);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
