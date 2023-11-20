package junitpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitDemo {
	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	@Test
	public void test1() {
		String actualname = driver.getTitle();
		String expectedname = "facebook";
		if(actualname.equalsIgnoreCase(expectedname)) {
			System.out.println("Title verified");
		}
		else
		{
			System.out.println("Title not verified");
		}
	}
	@Test
	public void test2(){
		String word = driver.getPageSource();
		if(word.contains("Google Search")) {
			System.out.println("Verified");
		}
		else
		{
			System.out.println("not verified");
		}
		
	}



}
