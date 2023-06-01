package com.PageObjects;

import org.openqa.selenium.By;

public class DynamicLoading {
	
	public static By hiddenElementsPage = By.xpath("//a[@href='/dynamic_loading/1']");
	public static By renderedElementsPage = By.xpath("//a[@href='/dynamic_loading/2']");
	public static By start = By.xpath("//button[text()='Start']");
	public static By element = By.xpath("//div[@id='finish']");
	
	

}
