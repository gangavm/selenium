package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	By currency=By.id("dropdownCurrency");
	By euro=By.linkText("EUR");
	By flight=By.xpath("//*[@href='#flights' and @data-name='flights']");
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void currencyClick()
	{
		driver.findElement(currency).click();
		driver.findElement(euro).click();
	}
	public void flightClick()
	{
		driver.findElement(flight).click();
	}
}
