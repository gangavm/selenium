package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TuxedoPage
{
	WebDriver driver;
	By price=By.xpath("//a[contains(text(),'Featured')]");
	By high=By.xpath("//a[@href='#Price High-Low']");
	By txedo=By.xpath("//p[contains(text(),'Nick Graham Black Shawl Houndstooth 32')]");
	public TuxedoPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void priceClick() throws InterruptedException
	{
		Thread.sleep(1000L);
		driver.findElement(price).click();
		driver.findElement(high).click();
	}
	public void tuxedoClick()
	{
		driver.findElement(txedo).click();
	}
}
