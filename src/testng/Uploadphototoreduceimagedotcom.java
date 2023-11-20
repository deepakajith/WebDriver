package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Uploadphototoreduceimagedotcom {
	
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.reduceimages.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void strtingtest() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"dropzone-container-offline\"]/div[2]/button")).click();
		
		uploadpic("C:\\Users\\padee\\Downloads\\bmw-3-series-cs-m-automobiles-modelfinder.png");
	}

	private void uploadpic(String string) throws AWTException {
		StringSelection ob = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ob, null);
		
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
