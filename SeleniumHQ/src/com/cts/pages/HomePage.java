package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
	WebDriver driver;
	By dwnld=By.linkText("Downloads");
	By docmt=By.linkText("documentation");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void download()
	{
		driver.findElement(dwnld).click();
	}
	public void documentation()
	{
		driver.findElement(docmt).click();
	}
}
