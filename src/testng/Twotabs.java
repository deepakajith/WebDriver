package testng;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Twotabs {

	ChromeDriver driver;

	@BeforeTest
	public void bef() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void tst() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();

		
		 Set<String> allwindowhandles = driver.getWindowHandles();
		 
		 for(String handle : allwindowhandles) {
		 if(!handle.equalsIgnoreCase(parentwindow)) {
		 driver.switchTo().window(handle);
		 
		 } 
		 else
		 {
		 driver.switchTo().window(parentwindow);
	}
		 

	}
}
}
