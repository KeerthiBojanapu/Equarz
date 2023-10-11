package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Search_Functionality extends Testbase {
	@FindBy(xpath="//input[@class='form-control appended-form-control search-bar-input']")
	WebElement searchbar;
	
	@FindBy(xpath="//li[@class='list-group-item']")
	List<WebElement> ele;
	
	
	
	public Search_Functionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void validatesearch() 
	{
		
		searchbar.sendKeys(props.getProperty("product"));
		searchbar.sendKeys(Keys.ENTER);
		

}
	public void dropdownsearch() throws InterruptedException 
	{
		
		searchbar.sendKeys(props.getProperty("product"));
		Thread.sleep(3000);
		for(WebElement dyn:ele) {

		if (dyn.getText().equals("HP Laptop 14s, 12th Gen Intel Core i3-1215U, 14-inch (35.6 cm), FHD, 8GB DDR4, 5")) {
			dyn.click();
			String str1=driver.getCurrentUrl();
			assertEquals("http://e-quarz.com/product/hp-14s-12th-gen-intel-core-i5-16gb-ram512gb-ssd-14-inch356-cm-micro-edge-fhd-laptopintel-iris-xe-graphicsalexadual-speak", str1);
					}
		}
			
		
		

}
	
}