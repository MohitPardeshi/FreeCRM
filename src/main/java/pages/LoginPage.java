package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement home;
	
	@FindBy(xpath="")
	private WebElement signUp;
	
	@FindBy(xpath="")
	private WebElement pricing;
	
	@FindBy(xpath="")
	private WebElement features;
	
	@FindBy(xpath="")
	private WebElement customers;
	
	@FindBy(xpath="")
	private WebElement contact;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='password']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public WebElement getHome() {
		return home;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
