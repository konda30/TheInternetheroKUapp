package com.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.ABTesting;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestABTesting {
	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String ABTestpath = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\testdata\\ABTest.properties";

	@BeforeClass
	public void Launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
	}

	@BeforeMethod
	public void ToABTesting() {
		driver.findElement(HomePage.ABTesting).click();
	}

	@AfterMethod
	public void ToHomepage() throws Exception {
		driver.navigate().back();
	}

	@AfterClass
	public void terminate() {
		driver.quit();
	}

	@Test(description = "Verify that site is redirected to AB Testing page", priority = 1)
	public void hometest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String header = driver.findElement(ABTesting.Header).getText();
		String ExpectedHeader = Method.ReadPropertyFile(ABTestpath, "header");
		m.navigation(header, ExpectedHeader);

	}

	@Test(description = "Verify that the AB Testing content is available or not", priority = 2)
	public void contentm() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement content = driver.findElement(ABTesting.Content);
		m.validation(content);
	}

}
