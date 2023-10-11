package com.Equarz.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.Signup_Functionality;
import com.Utils.SignUtils;
import com.Utils.Utils;
import com.base.Testbase;
import com.base.Testbase2;

public class SignupTest extends Testbase {
	int testid;
	Signup_Functionality sf;
	private final String sheetname="signupdata";
	public SignupTest()
	{
		super();
	}
	@DataProvider
	public String[][] signupData() throws Throwable{
		return Utils.readdata(sheetname);
	}
	@BeforeMethod
	public void initialize()
	{
		Setup();
		sf=new Signup_Functionality(driver);
		
		
	}
	@Test(dataProvider = "signupData",dataProviderClass = SignupTest.class)
	public void verifyurl(String firstname,String lastname,String Email,String phone,String password,String cpassword) throws InterruptedException
	{
		testid=1;
		sf.validateSignup(firstname,lastname,Email,phone,password,cpassword);
		String url=driver.getCurrentUrl();
		Assert.assertEquals("http://e-quarz.com/customer/auth/login", url);
	}
	@AfterMethod
	public void capturess() throws IOException {
//		if (ITestResult.FAILURE == result.getStatus()) {
//			Utils.capture(driver, testid);

		// Extentreportss.flushExtentReport();
	}


}
