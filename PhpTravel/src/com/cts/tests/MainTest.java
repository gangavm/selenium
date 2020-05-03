package com.cts.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cts.pages.DetailsPage;
import com.cts.pages.FlightPage;
import com.cts.pages.HomePage;
import com.cts.utils.ExcelRead;

public class MainTest 
{
	WebDriver driver;
	@BeforeTest
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.phptravels.net/home");
		driver.manage().window().maximize();
		
	}
  @Test(dataProvider= "TestData")
  public void mainTest(String frm,String dest) throws InterruptedException 
  {
	  HomePage pg= new HomePage(driver);
	  pg.currencyClick();
	  Thread.sleep(3000L);
	  pg.flightClick();
	  FlightPage fp=new FlightPage(driver);
	  fp.flightDetails(frm,dest);
	  fp.dateClick();
	  DetailsPage dp=new DetailsPage(driver);
	  dp.euroAssert();
	  driver.close();
  }
  @DataProvider(name= "TestData")
  public Object[][] getCellData() throws IOException
  {
	  ExcelRead rd=new ExcelRead("E:\\Eclipse\\eclipse\\PhpTravel\\excel\\travel.xlsx");
	  int row=rd.rowcnt("Sheet1");
	  Object[][] data=new Object[row][2];
	  for(int i=0;i<row;i++)
	  {
		  for(int j=0;j<2;j++)
		  {
			  data[i][j]=rd.getData("Sheet1",i,j);
		  }
	  }
	  return data;
  }
}
