package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;
import com.PageObjects.ShiftingContent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestShiftingContent {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.ShiftingContent).click();
	}

	@AfterClass
	public void close() {
		driver.quit();;
	}

	@AfterMethod
	public void back() throws Exception {
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.ShiftingContent).click();

	}

	@Test(description = "Shifting elements randomly", priority = 1)
	public void menuf() {
		driver.findElement(ShiftingContent.menu).click();
		driver.findElement(ShiftingContent.random).click();
		WebElement home = driver.findElement(ShiftingContent.home);
		WebElement about = driver.findElement(ShiftingContent.about);
		WebElement contactUs = driver.findElement(ShiftingContent.contactUs);
		WebElement portfolio = driver.findElement(ShiftingContent.portfolio);
		WebElement gallery = driver.findElement(ShiftingContent.gallery);

		home.click();
		driver.navigate().back();
		about.click();
		driver.navigate().back();
		contactUs.click();
		driver.navigate().back();
		portfolio.click();
		driver.navigate().back();
		gallery.click();
		driver.navigate().back();

		System.out.println("Test passed,after shifting elements");
	}

	@Test(description = "Shifting pixels randomly", priority = 2)
	public void menus() {

		driver.findElement(ShiftingContent.menu).click();
		driver.findElement(ShiftingContent.shiftingPixels).click();
		WebElement home = driver.findElement(ShiftingContent.home);
		WebElement about = driver.findElement(ShiftingContent.about);
		WebElement contactUs = driver.findElement(ShiftingContent.contactUs);
		WebElement portfolio = driver.findElement(ShiftingContent.portfolio);
		WebElement gallery = driver.findElement(ShiftingContent.gallery);

		home.click();
		driver.navigate().back();
		about.click();
		driver.navigate().back();
		contactUs.click();
		driver.navigate().back();
		portfolio.click();
		driver.navigate().back();
		gallery.click();
		driver.navigate().back();

		System.out.println("Test passed, accessed all elements after shifting pixels");

	}
	
	@Test(description = "Shifting pixels and elements randomly", priority = 3)
	public void menur() {

		driver.findElement(ShiftingContent.menu).click();
		driver.findElement(ShiftingContent.shiftingRandomeAndPixels).click();
		WebElement home = driver.findElement(ShiftingContent.home);
		WebElement about = driver.findElement(ShiftingContent.about);
		WebElement contactUs = driver.findElement(ShiftingContent.contactUs);
		WebElement portfolio = driver.findElement(ShiftingContent.portfolio);
		WebElement gallery = driver.findElement(ShiftingContent.gallery);

		home.click();
		driver.navigate().back();
		about.click();
		driver.navigate().back();
		contactUs.click();
		driver.navigate().back();
		portfolio.click();
		driver.navigate().back();
		gallery.click();
		driver.navigate().back();

		System.out.println("Test passed, accessed all element");

	}

}
