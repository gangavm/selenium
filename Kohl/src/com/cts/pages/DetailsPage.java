package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DetailsPage
{
	WebDriver driver;
	By size=By.id("size-dropdown");
	By plus=By.xpath("//li[@tabindex='0' and @role='button' and @data-qttyoptn='increase']");
	By add=By.id("addtobagID");
	By cnt=By.xpath("//*[@id='tr_phase2_ShoppingBg']/span[2]");
	
	public DetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void details()
	{
		Select s=new Select(driver.findElement(size));
		s.selectByVisibleText("42L 35");
	}
	public void plusClick()
	{
		driver.findElement(plus).click();
		driver.findElement(add).click();
	}
	public void assertCheck()
	{
		String st=driver.findElement(cnt).getText();
		try
		{
			Assert.assertEquals(st, "2");
			System.out.println("Cart displayed 2,Pass");
			driver.close();
		}
		catch(AssertionError e)
		{
			System.out.println("2 is not diplayed,Fail");
			driver.close();
		}
	}
}
