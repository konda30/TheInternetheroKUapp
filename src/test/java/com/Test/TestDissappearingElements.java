package com.Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.DisappearingElements;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDissappearingElements {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.DisappearingElements).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@Test
	public void all1() {

		WebElement Home = driver.findElement(DisappearingElements.Home);
		WebElement About = driver.findElement(DisappearingElements.About);
		WebElement ContactUs = driver.findElement(DisappearingElements.ContactUs);
		WebElement Portfolio = driver.findElement(DisappearingElements.Portfolio);
		driver.navigate().refresh();
		driver.navigate().refresh();
		WebElement Gallery = driver.findElement(DisappearingElements.Gallery);

		Assert.assertTrue(Gallery.isDisplayed(), "Test Failed, element is not appearing");

		driver.navigate().refresh();

		try {
			Assert.assertTrue(Gallery.isDisplayed(), "Test Failed, element is not appearing");
		} catch (Exception e) {
			System.out.println("Test passed element dissappeared");
		}

	}

}
