package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void loginTitleTest() {
		System.out.println(driver.getTitle());
	}

	@Test
	public void failTest() {
		// System.out.println(driver.getTitle());
		try
		{
		Assert.assertFalse(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("Hello World");
		}
	}

	@Test(dependsOnMethods  = "failTest")
	public void skippedTest() {
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
