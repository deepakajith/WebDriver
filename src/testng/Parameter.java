package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	@Parameters("d")
	@Test
	public void testing(String d)
	{
		System.out.println(d);
	}

}
