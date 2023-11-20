package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//button[text()='Ok, let me check']")
	WebElement order;
	@FindBy(xpath="//i[@class='tio-shopping-cart-outlined nav-icon']")
	WebElement orders;
	@FindBy(xpath="//a[@title='Pending']")
	WebElement pending;
	@FindBy(xpath="//input[@id='datatableSearch_']")
	WebElement searchbar;
	@FindBy(xpath="//button[text()='Search']")
	WebElement search;
	@FindBy(xpath="//a[@class='btn btn-outline--primary square-btn btn-sm mr-1']")
	WebElement view;
	@FindBy(xpath="//select[@class='status form-control']")
	WebElement dropdown;
	@FindBy(xpath="//button[text()='Yes  Change it!']")
	WebElement alert;
//	@FindBy(xpath="//div[text()='Status Change successfully!']")
//	WebElement success;
	@FindBy(xpath="//small[text()='Hello, Jakkam']")
	WebElement dashboard;
	@FindBy(xpath="//a[text()=' My order ']")
	WebElement myorder;
	@FindBy(xpath="//a[text()='Track your order']")
	WebElement track;
	@FindBy(xpath="//input[@name='order_id']")
	WebElement orderid;
	@FindBy(xpath="//input[@name='phone_number']")
	WebElement phno;
	@FindBy(xpath="//button[text()='Track Order']")
	WebElement trackorder;
	@FindBy(xpath="//span[@class='text-uppercase ']")
	WebElement orderstatus;
	
	
	
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
		order.click();
		orders.click();
		pending.click();
		searchbar.sendKeys("100230");
		search.click();
		view.click();
		Select sel=new Select(dropdown);
		sel.selectByVisibleText(" Confirmed");
		alert.click();
		 String window1 = driver.getWindowHandle();
		 ul.windowhandles(window1);
		 //driver.navigate().refresh();
		 ac.moveToElement(dashboard).build().perform();
		 myorder.click();
		 track.click();
		 orderid.sendKeys("100230");
		 phno.sendKeys("8106637137");
		 trackorder.click();
		 String print1=orderstatus.getText();
			System.out.println(print1);
			assertEquals("CONFIRMED",print1);
		 
		 
		
		
		
		
		
		

}
}
