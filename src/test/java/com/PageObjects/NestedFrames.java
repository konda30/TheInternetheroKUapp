package com.PageObjects;

import org.openqa.selenium.By;

public class NestedFrames {
	
	public static By NestedFrames = By.xpath("//a[text()='Nested Frames']");
	public static By Left = By.xpath("//frame[@name='frame-left']");
	public static By Middle = By.xpath("//frame[@name='frame-middle']");
	public static By Right = By.xpath("//frame[@name='frame-right']");
	public static By  Bottom = By.xpath("//frame[@name='frame-bottom']");

}
