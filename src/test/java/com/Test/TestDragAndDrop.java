package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.DragandDrop;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.DragAndDrop).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@Test
	public void acti1() {
		Actions a = new Actions(driver);
		WebElement ColumnA = driver.findElement(DragandDrop.ColumnA);
		WebElement ColumnB = driver.findElement(DragandDrop.ColumnB);
		a.dragAndDrop(ColumnA, ColumnB).build().perform();

	}
}
