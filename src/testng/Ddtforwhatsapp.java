package testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ddtforwhatsapp {
	
	WebDriver driver;
	
	@BeforeTest
	public void bftest()
	{
		driver = new ChromeDriver();
		driver.get("https://in.linkedin.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		FileInputStream fl = new FileInputStream("C:\\Users\\padee\\OneDrive\\Desktop\\login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fl);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		for(int i = 1;i<=row;i++)
		{
			String username = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username = "+username);
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password = "+password);
			driver.findElement(By.xpath("//*[@id='session_key']")).clear();
			driver.findElement(By.xpath("//*[@id='session_key']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='session_password']")).clear();
			driver.findElement(By.xpath("//*[@id='session_password']")).sendKeys(password,Keys.ENTER);
			
			driver.navigate().back();
		}
	}

}
