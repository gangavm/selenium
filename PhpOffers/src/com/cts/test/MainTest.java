package com.cts.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cts.pages.HomePage;
import com.cts.pages.SummerPage;
import com.cts.utils.ExcelRead;

public class MainTest 
{
	WebDriver driver;
	@BeforeTest
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.phptravels.net/offers/");
		driver.manage().window().maximize();
	}
	@Parameters({ "nam" , "phn" , "msg" })
	@Test(dataProvider= "TestData")
    public void offers(String nam,String phn,String msg) throws IOException 
   {
		HomePage hp=new HomePage(driver);
		hp.currencyClick();
		hp.cookieClick();
		hp.readMore();
		SummerPage sp=new  SummerPage(driver);
		sp.inputData(nam,phn,msg);
		sp.buttonClick();
		sp.scrnshot();
   }
	
	@DataProvider(name= "TestData")
	public Object[][] getData() throws IOException
	{
		ExcelRead er=new ExcelRead("E:\\Eclipse\\eclipse\\PhpOffers\\excel\\offer.xlsx");
		int row=er.rowcnt("Sheet1");
		Object[][] data=new Object[row][3];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<3;j++)
			{
				data[i][j]=er.getDataCell("Sheet1",i,j);
			}
		}
		return data;			
	}
}
