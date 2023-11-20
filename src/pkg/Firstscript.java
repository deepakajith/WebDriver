package pkg;

import org.openqa.selenium.chrome.ChromeDriver;


public class Firstscript {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String actualname = driver.getTitle();
		String expectedname = "google";
		if(actualname.equalsIgnoreCase(expectedname)) {
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	}

}
