package com.Equarz.Testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.AddandDeleteAddress_Functionality;
import com.Pageobjects.Homelink_Functionality;
import com.Pageobjects.Login_Functionality;
import com.Utils.AddressUtils;
import com.Utils.SignUtils;
import com.Utils.Utils;
import com.base.Testbase;

public class AddressTest extends Testbase {
	int testid;
	AddandDeleteAddress_Functionality af;
	Login_Functionality lg;
	private final String sheetname="addressdata";
	
	
	public AddressTest()
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
	@DataProvider
	public String[][] addressData() throws IOException
	{
		return Utils.readdata(sheetname);
	}
	
	@BeforeMethod
	public void initialize() 
	{
		
//		Setup();
//		lg=new Login_Functionality(driver);
//		lg.validateLogin();
		af=new AddandDeleteAddress_Functionality (driver);		
				
	}
	@Test(priority=1,dataProvider = "addressData",dataProviderClass =AddressTest.class )
	public void addaddress(String name,String phone,String city,String zipcode) throws InterruptedException 
	{
		testid=1;
		af.addaddress(name,phone,city,zipcode);
		
	}
	@Test(priority=2)
	public void editaddress()
	{
		af.editaddress();
	}
	@Test(priority=3)
	public void deleteaddress() throws Throwable
	{
		af.deleteaddress();
	}
	

}
