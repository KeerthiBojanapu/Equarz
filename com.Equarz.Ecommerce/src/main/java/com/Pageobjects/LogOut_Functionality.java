package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class LogOut_Functionality extends Testbase {
	@FindBy(xpath="//small[text()='Hello, sairam']")
	WebElement dashboard;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	@FindBy(xpath="//div[text()='Come back soon, !']")
	WebElement msg;
	
	public LogOut_Functionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void logout() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		logout.click();
		String print=msg.getText();
		System.out.println(print);
		assertEquals("Come back soon, !",print);
		
	}	
	public void refresh() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		logout.click();
		driver.navigate().refresh();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/", url);
	}
	public void back() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		logout.click();
		driver.navigate().back();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/", url);
}
}
