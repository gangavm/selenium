package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GridPage 
{
	WebDriver driver;
	By when=By.xpath("//a[@href='https://selenium.dev/documentation/en/grid/when_to_use_grid/']");
	public GridPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void whenToUse()
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(when));
		action.click().perform();
	}
	
}
