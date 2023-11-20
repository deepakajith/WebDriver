package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class  Instagram{
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		String expectedname = driver.getTitle();
		String actualname="gmail";
		if(expectedname.equalsIgnoreCase(actualname)) {
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title not matched");
		}
		String word = driver.getPageSource();
		if(word.contains("Next")) {
			System.out.println("Next is present");
		}
		else {
			System.out.println("Next is not present");
		}
		
		
		
	}
}