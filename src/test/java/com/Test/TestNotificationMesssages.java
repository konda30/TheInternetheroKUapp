package com.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;
import com.PageObjects.NotificationMessages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNotificationMesssages {
	
	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.NotificationMessages).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test
	public void msg() {
		driver.findElement(NotificationMessages.LoadMessage).click();
		m.validation(driver.findElement(NotificationMessages.Message));
	}
	

}
