package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Instapage{
	
	WebDriver driver;
	@FindBy(id = "login1")
	WebElement uname;
	
	@FindBy(id = "password")
	WebElement pword;
	
	@FindBy(name = "proceed")
	WebElement btton;
	
	public Instapage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	public void setvalues(String username,String password)
	{
		uname.sendKeys(username);
		pword.sendKeys(password);
	}
	
	public void login()
	{
		btton.click();
	}
	}