package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ddtforinstagram {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforet()
	{
		driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testt() throws IOException
	{
		String fl = "D:\\Datadriven.xlsx";
		FileInputStream ob = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(ob);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int no = sh.getLastRowNum();
		for(int i = 1;i<=no ; i++)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String uname = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username to be entered = "+uname);
			String pword = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password to be entered = "+pword);
			
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys(uname);
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys(pword,Keys.ENTER);
			driver.navigate().refresh();
		}
	}

}
