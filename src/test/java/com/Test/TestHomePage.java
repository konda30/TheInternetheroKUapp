package com.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String HomePropPath = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\testdata\\HomePage.properties";

	@BeforeClass
	public void Launch() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		
	}

	@Test(description = "Verify that the application is launching successfully or not", priority = 1)
	public void header1() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String header = driver.findElement(HomePage.Header).getText();
		String expectedHeader = Method.ReadPropertyFile(HomePropPath, "header");
		m.navigation(header, expectedHeader);

	}

	@Test(description = "Verify that all the links are active and enabled to be clicked or not", priority = 2)
	public void link2() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			m.activeValidation(link);
		}
	}

}
