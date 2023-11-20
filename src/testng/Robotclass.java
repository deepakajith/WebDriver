package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Robotclass {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tst() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
		
		fileupload("C:\\Users\\padee\\Downloads\\Test Scenarios.docx");
	}

	private void fileupload(String p) throws AWTException {
		StringSelection strngselection = new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strngselection, null);
		
		Robot robo = new Robot();
		
		robo.delay(5000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		//robo.delay(5000);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
