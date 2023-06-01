package com.PageObjects;

import org.openqa.selenium.By;

public class ShiftingContent {

	public static By menu = By.xpath("//a[@href='/shifting_content/menu']");
	public static By random = By.xpath("//a[@href='/shifting_content/menu?mode=random']");
	public static By shiftingPixels = By.xpath("//a[@href='/shifting_content/menu?pixel_shift=100']");
	public static By shiftingRandomeAndPixels = By.xpath("//a[@href='/shifting_content/menu?mode=random&pixel_shift=100']");
	public static By home = By.xpath("//a[text()='Home']");
	public static By about = By.xpath("//a[text()='About']");
	public static By contactUs = By.xpath("//a[text()='Contact Us']");
	public static By portfolio = By.xpath("//a[text()='Portfolio']");
	public static By gallery = By.xpath("//a[text()='Gallery']");
	
	
}
