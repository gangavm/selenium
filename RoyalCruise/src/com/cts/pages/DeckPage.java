package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DeckPage 
{
	WebDriver driver;
	By info=By.className("deck__info-panel");
	By dck=By.id("deckDropdown");
	//By deck=By.className("deck-dropdown");
	By text=By.xpath("//h4[contains(text(),'Royal Suite')]");
	public DeckPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void deckNumber()
	{
		driver.findElement(info);
		Select plan=new Select(driver.findElement(dck));
		plan.selectByVisibleText("Deck Eight");	
	}
	public boolean royalPresent()
	{
		boolean q=driver.findElement(text).isDisplayed();
		return q;
	}
}
