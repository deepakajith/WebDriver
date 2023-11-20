package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ResumeuploadthroughRobot {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void bf()
	{
		driver = new ChromeDriver();
		driver.get("https://enhancv.com/resources/resume-checker/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/section[1]/div[2]/div[1]/div/div/div[2]/div[3]/button")).click();
		uploadresume("\"C:\\Users\\padee\\Downloads\\Deepak P A - Sheet1.pdf\"");
	}
	
	private void uploadresume(String string) throws AWTException {
			StringSelection strnslct = new StringSelection(string);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strnslct, null);
			
			Robot ro = new Robot();
			
			
			ro.delay(4000);
			
			ro.keyPress(KeyEvent.VK_CONTROL);
			ro.keyPress(KeyEvent.VK_V);
			ro.keyRelease(KeyEvent.VK_V);
			ro.keyRelease(KeyEvent.VK_CONTROL);
			
			ro.delay(3000);
			
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}

