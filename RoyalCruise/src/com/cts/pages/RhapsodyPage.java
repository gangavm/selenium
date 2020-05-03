package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RhapsodyPage 
{
	WebDriver driver;
	By deck=By.xpath("//a[@href='/cruise-ships/rhapsody-of-the-seas/deck-plans']");
	public RhapsodyPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void deckClick()
	{
		driver.findElement(deck).click();
	}
}
