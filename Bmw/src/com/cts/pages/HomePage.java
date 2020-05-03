package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	By model=By.xpath("//*[contains(text(),'Models')]");
	By seven=By.xpath("//*[@id='pad2']/nav/div/ul/li[4]");
	By car=By.xpath("//a[@href='/en/all-models/7-series/sedan/2019/bmw-7-series-sedan-inspire.html' and @data-component-path='ds2-model-card']");
	//By car=By.xpath("//h4[contains(text(),'BMW 7 Series Sedan')]");
	//By car=By.xpath("//*[@id='ds2-model-cars']/div[5]/div/div[2]/h4");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void modelClick()
	{
		driver.findElement(model).click();
		driver.findElement(seven).click();
	}
	public void carClick()
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(car));
		e.click();
		
	}
}
