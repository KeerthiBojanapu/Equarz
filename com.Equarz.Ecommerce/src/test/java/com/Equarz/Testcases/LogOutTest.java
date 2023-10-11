package com.Equarz.Testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Pageobjects.LogOut_Functionality;
import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class LogOutTest extends Testbase {
	LogOut_Functionality lf;
	Login_Functionality lg;
	
	
	public LogOutTest ()
	{
		super();
	}
	
	@BeforeMethod
	public void initialize() 
	{
		
		Setup();
		lg=new Login_Functionality(driver);
		lg.validateLogin();
		lf=new LogOut_Functionality (driver);		
				
	}
	@Test()
	public void logout() throws InterruptedException, AWTException
	{
		lf.logout();
		
	}
	@Test()
	public void refresh() throws InterruptedException, AWTException
	{
		lf.refresh();
		
	}
	@Test()
	public void back() throws InterruptedException, AWTException
	{
		lf.back();
		
	}



}
