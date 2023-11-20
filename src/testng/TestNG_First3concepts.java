package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_First3concepts {
	
	
	@BeforeTest
	public void bftest()
	{
		System.out.println("Opening Browser");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Checked that the url are the same");
	}
	@Test(priority = 1,enabled=true,groups={"smoke","sanity","regression"})
	public void test1()
	{
		System.out.println("Test 1 is being executed");
	}
	@Test(dependsOnMethods="test1",groups="smoke")
	public void test2()
	{
		System.out.println("Test 2 is being executed");
	}
	@Parameters("d")
	@Test(priority =3,groups="sanity")
	public void test3(String d)
	{
		System.out.println("Test 3 is being executed");
		System.out.println(d);
	}
	@Test(priority =4,groups="regression")
	public void test4()
	{
		System.out.println("Test 4 is being executed");
	}
	@Test(priority =5,groups="smoke")
	public void test5()
	{
		System.out.println("Test 5 is being executed");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("Verified that URL are the same ");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("Browser closes");
	}

}
