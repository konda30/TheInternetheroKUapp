package com.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNestedFrames {

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
		driver.findElement(HomePage.NestedFrames).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@Test
	public void frames() {

		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println("Total frames: " + frameCount);

		for (int i = 0; i < frameCount; i++) {

			driver.switchTo().frame(i);
			System.out.println("Switched to frame: " + i);
			int iframeCount = driver.findElements(By.tagName("frame")).size();
			for (int j = 0; j < iframeCount; j++) {
				System.out.println("Switched to iframe: " + j);
				driver.switchTo().defaultContent();
				System.out.println("Switched back to main content");
			}
		}
	}

}
