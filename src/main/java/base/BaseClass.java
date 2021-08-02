package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Builder.Default;

public class BaseClass {
	protected static WebDriver driver;
	protected Properties prop, pageTitleProperties;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public BaseClass() {
		// TODO Auto-generated constructor stub
		// BasicConfigurator.configure();
		log.info("##### Inside Constructor of " + BaseClass.class.getName() + " Class #####");
		try {
			/// Users/mohitrajupardeshi/eclipse-workspace/LeetCode
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/Config.properties");
			FileInputStream fis1 = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/pageTitle.properties");
			prop = new Properties();
			pageTitleProperties = new Properties();
			prop.load(fis);
			pageTitleProperties.load(fis1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() {
		// log.info("##### Inside Method
		// "+this.getClass().getEnclosingMethod().getName()+" Method #####");

		// As per the string given the browser will be invoked

		String browserName = "";

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Safari":
			//WebDriverManager.sa
			break;
		default:

		}

		driver.get(prop.getProperty("URL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
