package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;
import com.base.Testbase2;

public class Signup_Functionality extends Testbase {
	@FindBy(xpath="//input[@name='f_name']")
	WebElement fname;
	
	@FindBy(name="l_name")
	WebElement lname;
	
	@FindBy(name="email")
	WebElement email ;
	
	@FindBy(name="phone")
	WebElement phone ;
	
	@FindBy(id="si-password")
	WebElement pass ;
	
	@FindBy(name="con_password")
	WebElement cpass;
	
	@FindBy(xpath="//input[@id='inputCheckd']")
	WebElement cbox;
	
	@FindBy(xpath="//button[@id='sign-up']")
	WebElement signupbtn;
	public Signup_Functionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public Homepage validateSignup(String firstname1,String lastname1,String Email1,String phone1,String password1,String cpassword1) throws InterruptedException
	{
		fname.sendKeys(firstname1);
		lname.sendKeys(lastname1);
		email.sendKeys(Email1);
		phone.sendKeys(phone1);
		pass.sendKeys(password1);
		cpass.sendKeys(cpassword1);
		cbox.click();
		Thread.sleep(10000);
		signupbtn.click();
		
		return new Homepage();
		
	}

}
