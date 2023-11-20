package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fbloginpage {
	WebDriver driver;
	
	By fbemail = By.id("email");
	By fbpasswd = By.id("pass");
	By fblogin = By.name("login");
	
	
	public Fbloginpage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	
	public void setValues(String email, String passwd)
	{
		driver.findElement(fbemail).sendKeys(email);
		driver.findElement(fbpasswd).sendKeys(passwd);
	
	}
	public void login()
	{
		driver.findElement(fblogin).click();
		
	}

}
