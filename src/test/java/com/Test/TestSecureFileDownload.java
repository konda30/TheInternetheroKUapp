package com.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSecureFileDownload {

	static WebDriver driver;
	static String path = "F:\\eclipse workshop\\InternetHerokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.SecureFileDownload).click();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test
	 public void filedownload()
	    {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);	
        driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure");
        System.out.println("Before clicking");
        driver.findElement(By.linkText("some-file.txt")).click();
	    }
		
}
