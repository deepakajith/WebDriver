package testng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Udemythroughddt {
	
	WebDriver driver;
	
	@BeforeTest
	public void tdtdt()
	{
		driver = new ChromeDriver();
		driver.get("https://www.udemy.com/join/signup-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		FileInputStream ob = new FileInputStream("C:\\Users\\padee\\OneDrive\\Desktop\\udemy.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ob);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		for(int i =1;i<=row;i++)
		{
			String fullname = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(fullname);
			String email = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(email);
			String pword = sh.getRow(i).getCell(2).getStringCellValue();
			System.out.println(pword);
			driver.findElement(By.xpath("//*[@id=\"form-group--1\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"form-group--1\"]")).sendKeys(fullname);
			driver.findElement(By.xpath("//*[@id=\"form-group--3\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"form-group--3\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"form-group--5\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"form-group--5\"]")).sendKeys(pword,Keys.ENTER);
			Thread.sleep(3000);
		}
		
		
		
	}

}
