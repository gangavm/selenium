package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage
{
	WebDriver driver;
	By whale=By.linkText("whale watching tour");
	By menu=By.id("rciHeaderOpenSidenav");
	By plan=By.xpath("//span[contains(text(),'Plan A Cruise')]");
	By close=By.id("rciHeaderCloseSidenav");
	By ship=By.xpath("//a[@href='/cruise-ships']");
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean linkPresent()
	{
		boolean b=driver.findElement(whale).isDisplayed();
		return b;
	}
	public void menuClick()
	{
		driver.findElement(menu).click();
	}
	public void planACruise()
	{
		driver.findElement(plan).click();
		driver.findElement(close).click();
	}
	public void shipClick()
	{
		driver.findElement(ship).click();
	}
}
