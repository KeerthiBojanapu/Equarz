package com.Equarz.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Pageobjects.CustomerorderFunctionality;
import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class CustomerorderTest extends Testbase{
	CustomerorderFunctionality cf;
	Login_Functionality lg;
	
	
	public CustomerorderTest()
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
	public void initialize() throws InterruptedException
	{
		
//		Setup();
//		lg=new Login_Functionality(driver);
//		lg.validateLogin();
		cf=new CustomerorderFunctionality (driver);		
				
	}
	@Test()
	public void addbuy () throws InterruptedException 
	{
		cf.addbuy();
		
	}

}
