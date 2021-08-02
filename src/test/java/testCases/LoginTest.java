package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void testSetUp() {
		init();

	}

	@BeforeMethod
	public void methodSetUp() {

		loginPage = new LoginPage(driver);
	}

	@Test
	public void loginTitleTest() {
		Assert.assertEquals(driver.getTitle(), pageTitleProperties.getProperty("LoginPage"));
	}

	@Test
	public void clickMenu() {
		// Home Menu
		SoftAssert softAssert = new SoftAssert();
		loginPage.getHome().click();
		softAssert.assertEquals(driver.getTitle(), pageTitleProperties.getProperty("LoginPage"));

		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void failTest() {
		// System.out.println(driver.getTitle());
		try {
			Assert.assertFalse(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Hello World");
		}
	}

	@Test(dependsOnMethods = "failTest", enabled = false)
	public void skippedTest() {
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void methodTearDown() {
		// driver.quit();
	}

	@AfterTest
	public void testTearDown() {
		driver.quit();
	}
}
