package com.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.DragandDrop;
import com.PageObjects.Dropdown;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDown {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(HomePage.Dropdown).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@Test
	public void drpdw() throws Exception {
		WebElement select = driver.findElement(Dropdown.Select);
		Select s = new Select(select);
		s.selectByIndex(1);
		String Selected1 = select.getAttribute("value");
		Assert.assertEquals(Selected1, "1", "Test Failed, desired option not selected");
		s.selectByIndex(2);
		String Selected2 = select.getAttribute("value");
		Assert.assertEquals(Selected2, "2", "Test Failed, desired option not selected");

	}

}
