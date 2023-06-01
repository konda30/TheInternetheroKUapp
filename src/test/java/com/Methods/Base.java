package com.Methods;

import org.openqa.selenium.WebElement;

public class Base {

	public void navigation(String header, String expectedHeader) {

		org.testng.Assert.assertEquals(header, expectedHeader,"Test failed, site is not being redirected to the expected page");

	}
	
	public void validation(WebElement element) {
		
		org.testng.Assert.assertTrue(element.isDisplayed(),"Test failed, the expected content is not visible");
	}
	
	public void activeValidation(WebElement element) {
		org.testng.Assert.assertTrue(element.isEnabled(),"Test failed, the "+ element+" is not enabled");
	}
	
	

}
