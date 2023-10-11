package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class AddandDeleteAddress_Functionality extends Testbase {
	@FindBy(xpath="//small[text()='Hello, sairam']")
	WebElement dashboard;
	@FindBy(xpath="//a[text()=' My profile']")
	WebElement profile;
	@FindBy(xpath="//a[text()='Address ']")
	WebElement address;
	@FindBy(xpath="//button[@id='add_new_address']")
	WebElement addnew;
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='address-city']")
	WebElement city;
	@FindBy(xpath="//input[@id='zip']")
	WebElement zip;
	@FindBy(xpath="//div[@class='filter-option-inner']")
	WebElement country;
	@FindBy(xpath="//input[@role='textbox']")
	WebElement search;
	@FindBy(xpath="//span[text()='India']")
	WebElement india;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement add;
	@FindBy(xpath="//button[text()='Add Informations  ']")
	WebElement addinfo;
	@FindBy(xpath="(//div[@class='d-flex justify-content-between'])[7]")
	WebElement edit;
	@FindBy(xpath="//input[@id='zip_code']")
	WebElement zipcode;
	@FindBy(xpath="//button[text()='Update  ']")
	WebElement update;
	@FindBy(xpath="//div[text()='Data updated successfully!']")
	WebElement msg;
	@FindBy(xpath="(//a[@id='delete'])[7]")
	WebElement delete;
	
	
	
	
	
	
	public AddandDeleteAddress_Functionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void addaddress(String name1,String phone1,String city1,String zipcode1  ) throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		profile.click();
		address.click();
		addnew.click();
		name.sendKeys(name1);
		phone.sendKeys(phone1);
		city.sendKeys(city1);
		phone.sendKeys(phone1);
		zip.sendKeys(zipcode1);
		country.click();	
		search.sendKeys(props.getProperty("name"));
		india.click();
		add.sendKeys("Hyderabad");
		addinfo.click();
		String str1=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/account-address", str1);
	}
	public void editaddress()
	{
		edit.click();
		
		zipcode.clear();
		zipcode.sendKeys("5000017");
		update.click();
		String print=msg.getText();
		assertEquals("Data updated successfully!",print);
	}
	public void deleteaddress() throws Throwable
	{
		address.click();
		delete.click();
		Alert al=driver.switchTo().alert();
		Thread.sleep(3000);
		al.accept();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/account-address", url);
	}

	}
	
