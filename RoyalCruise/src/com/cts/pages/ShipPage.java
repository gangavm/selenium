package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipPage 
{
	WebDriver driver;
	By gallery=By.xpath("//*[starts-with(@id,'staticGalleryComponent-1257575066')]");
	By rhapsody=By.xpath("//a[@href='/cruise-ships/rhapsody-of-the-seas']");
	public ShipPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void rhapsodyClick()
	{
		driver.findElement(gallery);
		driver.findElement(rhapsody).click();
	}
}
