package com.cts.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerPage
{
	WebDriver driver;
	By name=By.xpath("//input[@placeholder='Name']");
	By phone=By.xpath("//input[@placeholder='Phone']");
	By message=By.xpath("//textarea[@placeholder='Message']");
	By contact=By.xpath("//input[@type='submit' and @value='Contact']");
	By thanks=By.xpath("//*[contains(text(),'Thanks For Contacting')]");
	public SummerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void inputData(String nam,String phn,String msg)
	{
		driver.findElement(name).sendKeys(nam);
		driver.findElement(phone).sendKeys(phn);
		driver.findElement(message).sendKeys(msg);
	}
	public void buttonClick()
	{
		driver.findElement(contact).click();
	}
	public void scrnshot() throws IOException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.presenceOfElementLocated(thanks));
		e.click();
		TakesScreenshot sht=((TakesScreenshot)driver);
		File src=sht.getScreenshotAs(OutputType.FILE);
		File dst=new File("E:\\Eclipse\\eclipse\\PhpOffers\\output\\scnt.png");
		FileHandler.copy(src,dst);
		driver.close();
	}
}
