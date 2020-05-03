package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	By txt=By.id("search");
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void tuxedoType(String text)
	{
		driver.findElement(txt).sendKeys(text,Keys.ENTER);
	}
}
