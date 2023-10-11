package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Search_Functionality;
import com.base.Testbase;

public class SearchTest extends Testbase {
	Search_Functionality bf;
	Login_Functionality lg;

	
	
	public SearchTest()
	{
		super();
	}
	@BeforeMethod
	public void initialize() throws InterruptedException
	{
		
		Setup();
		lg=new Login_Functionality(driver);
		lg.validateLogin();
		bf=new Search_Functionality (driver);		
				
	}
	@Test()
	public void search () throws InterruptedException 
	{
		bf.validatesearch();
		
	}
	@Test()
	public void searchdrop () throws InterruptedException 
	{
		bf.dropdownsearch();
		
	}
	@AfterMethod
	public void teardown()
	{
		//driver.close();
	}


}
