package com.PageObjects;

import org.openqa.selenium.By;

public class RedirectLink {
	
	public static By RedirectLink = By.xpath("//a[text()='Redirect Link']");
	public static By ClickHere = By.xpath("//a[@id='redirect']");
	public static By StatusCode200 = By.xpath("//a[@href='status_codes/200']");
	public static By StatusCode301 = By.xpath("//a[@href='status_codes/301']");
	public static By StatusCode404 = By.xpath("//a[@href='status_codes/404']");
	public static By StatusCode500 = By.xpath("//a[@href='status_codes/500']");
}
