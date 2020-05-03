package com.cts.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightPage 
{
	WebDriver driver;
	By from=By.id("s2id_location_from");
	By fromto=By.xpath("//*[@id='select2-drop']/div/input");
	By lax=By.xpath("//*[@id='select2-drop']/ul/li[1]/div/span");
	By dfw=By.xpath("//*[@id='select2-drop']/ul/li/div/span");
	By to=By.id("s2id_location_to");
	By dept=By.id("FlightsDateStart");
	By next=By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[3]/svg");
	By submit=By.xpath("//*[@id='flights']/div/div/form/div/div[3]/div[4]/button");
	public FlightPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void flightDetails(String frm,String dest) throws InterruptedException
	{
		driver.findElement(from).click();
		//Thread.sleep(7000L);
		driver.findElement(fromto).sendKeys(frm);
		Thread.sleep(7000L);
		driver.findElement(lax).click();
		
		driver.findElement(to).click();
		driver.findElement(fromto).sendKeys(dest);
		Thread.sleep(7000L);
		driver.findElement(dfw).click();
	}
	public void dateClick() throws InterruptedException
	{
		 driver.findElement(By.xpath("//*[@id='cookyGotItBtnBox']/div/button")).click();
		 driver.findElement(dept).click();
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
		 int n=Integer.parseInt(date1);
		 if(n>25)
		 {
			 int d=30-n;
			 int b=5-d;
			 driver.findElement(next).click();
			 Thread.sleep(3000l);
			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/div/div/div[2]/div[@data-date='"+ b +"']")).click();
		 }
		 else
		 {
			 n=n+5;
			 System.out.println(n);
			 String st=Integer.toString(n);
			 System.out.println(st);
			 Thread.sleep(2000L);
			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/div/div/div[2]/div[@data-date='"+ st +"']")).click();
			 Thread.sleep(3000L);
		 }
		 driver.findElement(submit).click();
	}
}
