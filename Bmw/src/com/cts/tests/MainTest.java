package com.cts.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cts.pages.HomePage;
import com.cts.pages.TechnicalPage;

public class MainTest
{
	WebDriver driver;
	@BeforeTest
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.bmw.in/en/");
		driver.manage().window().maximize();
	}
   @Test
   public void bmwTest() throws InterruptedException 
   {	
	  HomePage hp=new HomePage(driver);
	  hp.modelClick();
	  hp.carClick();
	  TechnicalPage tp=new TechnicalPage(driver);
	  tp.techClick();
	  Thread.sleep(2000);
	  tp.horsePower();
   }
}
