package com.Equarz.Testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.EditProfile_Functionality;
import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class EditProfileTest extends Testbase {
	EditProfile_Functionality ef;
	Login_Functionality lg;
	
	
	public EditProfileTest ()
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
		ef=new EditProfile_Functionality (driver);		
				
	}
	@Test()
	public void search() throws InterruptedException, AWTException
	{
		ef.editprofie();
		
	}

}
