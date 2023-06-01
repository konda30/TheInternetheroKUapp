package com.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.EntryAd;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEntryAd {
	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.EntryAd).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}

	@Test(description = "Verify that ad is displayed after entering into page", priority = 1)
	public void enteryadd()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement ad = driver.findElement(EntryAd.ad);
		WebElement close = driver.findElement(EntryAd.close);
		Assert.assertTrue(ad.isDisplayed(), "Test failed, add is not displayed");

	}

	@Test(description = "Verify that ad is closing after clicking on close button", priority = 2)
	public void clsoe() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ad = driver.findElement(EntryAd.ad);
		WebElement close = driver.findElement(EntryAd.close);
		close.click();
		
		Assert.assertFalse(ad.isDisplayed(), "Test failed, add is not displayed");

	}

}
