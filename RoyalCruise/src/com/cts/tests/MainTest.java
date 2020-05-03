package com.cts.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cts.pages.DeckPage;
import com.cts.pages.HomePage;
import com.cts.pages.RhapsodyPage;
import com.cts.pages.ShipPage;

public class MainTest 
{
	WebDriver driver;
	@BeforeTest
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.royalcaribbean.com/alaska-cruises");
		driver.manage().window().maximize();
	}
	@Test
    public void cruiseTest() throws InterruptedException
   {
		HomePage hp=new HomePage(driver);
		boolean a=hp.linkPresent();
		hp.menuClick();
		hp.planACruise();
		hp.shipClick();
		Thread.sleep(3000L);
		ShipPage sp=new ShipPage(driver);
		sp.rhapsodyClick();
		Thread.sleep(3000L);
		RhapsodyPage rp=new RhapsodyPage(driver);
		rp.deckClick();
		Thread.sleep(7000L);
		DeckPage dp=new DeckPage(driver);
		dp.deckNumber();
		Thread.sleep(2000L);
		boolean b=dp.royalPresent();
		try
		{
			Assert.assertEquals(a,b);
			System.out.println("Link and Royal suite is present,Pass");
			driver.close();
		}
		catch(AssertionError e)
		{
			System.out.println("Elements not present,Fail");
			driver.close();
		}	
   }
}
