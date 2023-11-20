package testng;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriven {
	WebDriver driver;
	@BeforeTest
	public void tet()
	
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() throws Exception
	{
		
		FileInputStream ob = new FileInputStream("D:\\Datadriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ob);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		for(int i = 1;i<=row;i++)
		{
			String Username = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username = "+Username);
			String Password = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password = "+Password);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Username);
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
		
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Password,Keys.ENTER);
			//driver.findElement(By.xpath("//*[@id=\"u_0_5_VY\"]")).click();
			
		}
		
	}

}
