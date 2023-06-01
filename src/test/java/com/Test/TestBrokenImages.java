package com.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrokenImages {
	
	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.BrokenImages).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test
	public void imgsrc() {
		List<WebElement> images = driver.findElements(By.tagName("img"));

		for (WebElement image : images) {
			String imageUrl = image.getAttribute("src");
			
			try {
				URL url = new URL(imageUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					System.out.println("Broken image found: " + imageUrl);
				}

				connection.disconnect();
			} catch (IOException e) {
				System.out.println("Exception occurred while checking image: " + imageUrl);
				e.printStackTrace();
			}
		}
	}

}
