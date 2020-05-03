package com.cts.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
	WebDriver driver;
	By currency=By.id("dropdownCurrency");
	By usd=By.linkText("USD");
	By cookie=By.xpath("//*[@id=\"cookyGotItBtnBox\"]/div/button");
	By summer=By.xpath("//*[@href='https://www.phptravels.net/offers/Summer-Vacation']");
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void currencyClick()
	{
		driver.findElement(currency).click();
		driver.findElement(usd).click();
	}
	public void cookieClick()
	{
		driver.findElement(cookie).click();
	}
	public void readMore()
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		driver.findElement(summer).click();
	}
}
