package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class CustomerorderFunctionality extends Testbase {
	@FindBy(xpath="//span[text()='TVs & Appliances']")
	WebElement cat;
	@FindBy(xpath="//span[text()='Microwave oven']")
	WebElement subcat;
	@FindBy(xpath="//a[text()='Normal']")
	WebElement subsub;
	@FindBy(xpath="//a[@href='http://e-quarz.com/product/lifelong-llot10-10-litres-oven-toaster-griller-with-auto-shut-off-and-30-minute-timer-otg-oven-for-baking-cake-pizza-gri']")
    WebElement product;
	@FindBy(xpath="//span[text()='Buy now']")
	WebElement buy;
	@FindBy(xpath="//select[@class='form-control']")
	WebElement shipping;
	Utils ul;
	@FindBy(xpath="//a[@class='btn btn--primary pull-right']")
	WebElement checkout;
	@FindBy(xpath="//input[@id='same_as_shipping_address']")
	WebElement checkbox;
	@FindBy(xpath="//span[text()='Proceed payment']")
	WebElement payment;
	@FindBy(xpath="//img[@class='__mt-n-10']")
	WebElement cod;
	@FindBy(xpath="//div[@class='col-md-6']")
	WebElement msg;
	@FindBy(xpath="//input[@id='signinSrEmail']")
	WebElement user;
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signin;
	
	@FindBy(xpath="//i[@class='tio-shopping-cart-outlined nav-icon']")
	WebElement orders;
	@FindBy(xpath="//a[@title='Pending']")
	WebElement pending;
	
	
	
	public CustomerorderFunctionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void addbuy() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(cat).build().perform();
		Thread.sleep(3000);
		ac.moveToElement(subcat).build().perform();
		subsub.click();		
		product.click();
		buy.click();
		ul=new Utils();
		Utils.dropdown(shipping, "6");
		checkout.click();
		checkbox.click();
		payment.click();
		cod.click();
		String print=msg.getText();
		assertEquals("Your order has been placed successfully! !",print);
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get("http://e-quarz.com/admin/auth/login");
		user.sendKeys("arun@marolix.com");
		pass.sendKeys("Reset@123");
		Thread.sleep(10000);
		signin.click();
		orders.click();
		pending.click();
		
		
		

}
}
