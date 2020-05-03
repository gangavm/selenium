package com.cts.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cts.pages.GridPage;
import com.cts.pages.HomePage;

public class MainTest
{ 
  WebDriver driver;
  @BeforeTest
  public void browserLaunch()
  {
	  System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.selenium.dev/");
	  driver.manage().window().maximize();
  }
  @Test
  public void seleniumTest() throws IOException 
  {
	  HomePage hp=new HomePage(driver);
	  hp.download();
	  hp.documentation();
	  GridPage gp=new GridPage(driver);
	  gp.whenToUse();
  }
  @AfterTest
  public void screenshot() throws IOException
	{
		TakesScreenshot sht=((TakesScreenshot)driver);
		File src=sht.getScreenshotAs(OutputType.FILE);
		File dst=new File("E:\\Eclipse\\eclipse\\SeleniumHQ\\output\\scrnsht.png");
		FileHandler.copy(src,dst);
		driver.close();
		
	}

}
