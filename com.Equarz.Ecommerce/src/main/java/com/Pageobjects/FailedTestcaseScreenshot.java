package com.Pageobjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.base.Testbase;

public class FailedTestcaseScreenshot extends Testbase {		
	
	@FindBy(xpath="//input[@name='username']")
	WebElement user;
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	@FindBy(xpath="//button[text()='Login']")
	WebElement login;
	public FailedTestcaseScreenshot(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void loginpass() throws InterruptedException 
	{
		user.sendKeys("John Doe");
		pass.sendKeys("ThisIsNotAPassword");
		login.click();
	}
	public void loginfail()
	{
		user.sendKeys("John");
		pass.sendKeys("ThisIsNotAPass");
		login.click();
		String urlhomepage=driver.getCurrentUrl();
    	org.testng.Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", urlhomepage);
	}
	

}
