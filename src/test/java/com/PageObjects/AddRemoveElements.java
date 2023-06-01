package com.PageObjects;

import org.openqa.selenium.By;

public class AddRemoveElements {
	
	//Link
	public static By AddRemoveElements = By.xpath("//a[text()='Add/Remove Elements']");

	public static By Header = By.xpath("//h3[text()='Add/Remove Elements']");
	public static By AddElementButton = By.xpath("//button[text()='Add Element']");
	public static By Delete = By.xpath("//button[text()='Delete']");
	public static By Elements = By.xpath("//button[@class='added-manually']");
}
