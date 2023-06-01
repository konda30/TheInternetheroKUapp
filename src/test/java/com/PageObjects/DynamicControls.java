package com.PageObjects;

import org.openqa.selenium.By;

public class DynamicControls {
	
	public static By checkbox = By.id("checkbox");
	public static By remove = By.xpath("//button[text()='Remove']");
	public static By message = By.id("message");
	public static By add = By.xpath("//button[text()='Add']");
	public static By input = By.xpath("//input[@type='text']");
	public static By enable = By.xpath("//button[text()='Enable']");
	public static By disable = By.xpath("//button[text()='Disable']");
	

}
