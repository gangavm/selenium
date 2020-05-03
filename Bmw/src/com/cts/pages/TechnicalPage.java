package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TechnicalPage
{
	WebDriver driver;
	By tech=By.linkText("Technical Data");
	By hpw=By.xpath("/html/body/div[5]/main/div[1]/div/div[4]/div/div/div[2]/section[1]/div[3]/div/div[1]/div/table/tbody/tr[4]/td[2]/div");
	public TechnicalPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void techClick()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(tech));
		e.click();
	}
	public void horsePower()
	{
		String s=driver.findElement(hpw).getText();
		String st=s.substring(5,8);
		System.out.println("HorsePower is :"+ st);
		int n=Integer.parseInt(st);   
		try
		{
			Assert.assertTrue(n>500);
			System.out.println("Meet my reqt,Pass");	
			driver.close();
		}
		catch(AssertionError e)
		{
			System.out.println("Does not meet my reqt,Fail");
			driver.close();
		}
	}
	
}
