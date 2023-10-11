package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Homelink_Functionality;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Search_Functionality;
import com.base.Testbase;

public class HomelinkTest extends Testbase {
	Homelink_Functionality hf;
	Login_Functionality lg;
	
	
	public HomelinkTest()
	{
		super();
	}
	@BeforeClass
	public void login()
	{
		Setup();
		lg=new Login_Functionality(driver);
		lg.validateLogin();
		
	}
	@BeforeMethod
	public void initialize() 
	{
		
//		Setup();
//		lg=new Login_Functionality(driver);
//		lg.validateLogin();
		hf=new Homelink_Functionality (driver);		
				
	}
	@Test()
	public void search() 
	{
		hf.validatelinks();
		
	}
	@Test()
	public void latestproduct() 
	{
		hf.latestproduct();
		
	}
	@Test()
	public void sellingproducts() 
	{
		hf.sellingproducts();
		
	}
	@Test()
	public void toprated() 
	{
		hf.toprated();
		
	}
	@Test()
	public void profileinfo() 
	{
		hf.profileinfo();
		
	}
	@Test()
	public void trackorder() 
	{
		hf.trackorder();
		
	}
	@Test()
	public void refundpolicy() 
	{
		hf.refundpolicy();
		
	}
	@Test()
	public void returnpolicy()  
	{
		hf.returnpolicy();
		
	}
	@Test()
	public void cancellation() 
	{
		hf.cancellation();
		
	}
	@Test()
	public void phone() 
	{
		hf.phone();
		
	}
	@Test()
	public void mail() 
	{
		hf.mail();
		
	}
	@Test()
	public void supportticket() 
	{
		hf.supportticket();
		
	}
	@Test()
	public void twitter() 
	{
		hf.twitter();
		
	}
	@Test()
	public void linkedin() 
	{
		hf.linkedin();
		
	}
	@Test()
	public void google() 
	{
		hf.google();
		
	}
	@Test()
	public void pinterest() 
	{
		hf.pinterest();
		
	}
	@Test()
	public void insta() 
	{
		hf.insta();
		
	}
	@Test()
	public void facebook() 
	{
		hf.facebook();
		
	}
	@AfterMethod
	public void teardown()
	{
		//driver.close();
	}

	
	
	
	
	

}
