package testng;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alhnd {
    WebDriver driver;

    @BeforeTest
    public void startingUp() {
        driver = new ChromeDriver();
        driver.get("https://www.alhind.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // You might want to wait for some element to be present, visible, or clickable here
    }

    @Test
    public void testHeaderLinks() {
    	List<WebElement>li = driver.findElements(By.tagName("a"));
    	for(WebElement links : li)
    	{
    		String ln = links.getAttribute("href");
    		System.out.println(ln);
    	}
    	System.out.println("Total number of links = "+li.size());
    	
       
    }
}
