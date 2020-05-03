package com.cts.tets;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cts.pages.DetailsPage;
import com.cts.pages.HomePage;
import com.cts.pages.TuxedoPage;
import com.cts.utils.ExcelRead;

public class MainTest 
{
	WebDriver driver;
	@BeforeTest
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse\\eclipse\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.kohls.com/");
		driver.manage().window().maximize();
	}
  @Test(dataProvider= "TestData")
  public void kohlTest(String text) throws InterruptedException 
  {
	  HomePage hp=new HomePage(driver);
	  hp.tuxedoType(text);
	  Thread.sleep(7000L);
	  TuxedoPage tp=new TuxedoPage(driver);
	  tp.priceClick();
	  Thread.sleep(2000L);
	  tp.tuxedoClick();
	  Thread.sleep(5000L);
	  DetailsPage dp=new DetailsPage(driver);
	  dp.details();
	  Thread.sleep(5000L);
	  dp.plusClick();
	  Thread.sleep(5000L);
	  dp.assertCheck();
  }
  
  @DataProvider(name= "TestData")
  public Object[][] getData() throws IOException
  {
	  ExcelRead rd=new ExcelRead("E:\\Eclipse\\eclipse\\Kohl\\excel\\kohl.xlsx");
	  int row=rd.rowcnt("Sheet1");
	  Object[][] data=new Object[row][1];
	  for(int i=0;i<row;i++)
	  {
		  for(int j=0;j<1;j++)
		  {
			  data[i][j]=rd.getCellData("Sheet1",i,j);
		  }
	  }
	  return data;
  }
}
