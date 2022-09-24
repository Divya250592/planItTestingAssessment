package BrowserRelatedFunction;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static WebDriver driver;
	
	@BeforeMethod
	public void lanch() throws InterruptedException{
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://jupiter.cloud.planittesting.com/#");
	    Thread.sleep(1000);
	     
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
