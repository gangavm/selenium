package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DetailsPage
{
	WebDriver driver;
	By euro=By.xpath("//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/div/p[1]/strong");
	
	public DetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void  euroAssert()
	{
		String s=driver.findElement(euro).getText();
		System.out.println(s);
		String st=s.substring(4,6);
		int n=Integer.parseInt(st);
		try
		{
			Assert.assertTrue((n>100)&&(n<250));
			System.out.println("Euro is more than 100 and less than 250,Assertion true");
		}
		catch(AssertionError ae)
		{
			System.out.println("Euro is neither more than 100 nor less than 250,Assertion fail ");
		}
	}
		
}
