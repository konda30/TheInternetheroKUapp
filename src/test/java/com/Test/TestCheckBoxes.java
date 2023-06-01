package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.CheckBoxes;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes {
	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.Checkboxes).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@Test
	public void chkbx1() {

		WebElement checkbox1 = driver.findElement(CheckBoxes.Checkbox1);
		WebElement checkbox2 = driver.findElement(CheckBoxes.Checkbox2);
		m.activeValidation(checkbox1);
		m.activeValidation(checkbox2);
		if (checkbox1.isSelected() == false) {
			checkbox1.click();
		}
		if (checkbox2.isSelected() == false) {
			checkbox2.click();
		}
		
		Assert.assertTrue(checkbox1.isSelected(),"Test failed, unable to select checkbox 1");
		Assert.assertTrue(checkbox2.isSelected(),"Test failed, unable to select checkbox 2");
	}
}
