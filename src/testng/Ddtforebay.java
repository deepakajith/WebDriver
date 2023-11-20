package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ddtforebay {
	WebDriver driver;
	
	@BeforeTest
	public void bft()
	{
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void tstt() throws IOException
	{
		driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
		FileInputStream fs = new FileInputStream("D:\\Luminar\\ebaylogin.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		int row = sh.getLastRowNum();
		for(int i =1 ; i<=row ; i++)
		{
			String email = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(email);
			driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"signin-continue-btn\"]")).click();
			driver.navigate().refresh();
		}
	}

}
