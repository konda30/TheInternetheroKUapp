package com.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBasicAuth {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.BasicAuth).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test
	public void userpass() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.sendKeys(Method.ReadPropertyFile(path, "UID"));
		a.sendKeys("\t");
		a.sendKeys(Method.ReadPropertyFile(path, "pass"));
		a.accept();
	}
	
}
