package com.Equarz.Testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Pageobjects.FailedTestcaseScreenshot;
import com.base.Testbase;

public class FailedScreenshotTest extends Testbase {
	
	FailedTestcaseScreenshot fs;
		
		public FailedScreenshotTest ()
		{
			super();
		}
		@BeforeMethod
		public void initialize()
		{			
			Setup();
			fs=new FailedTestcaseScreenshot (driver);
		}
		@Test(priority=1)
		public void validlogin() throws InterruptedException
		{
			fs.loginpass();
			//String url=driver.getCurrentUrl();
			//Assert.assertEquals("http://e-quarz.com/product/panasonic-20l-solo-microwave-oven-nn-st26jmfdg-silver-51-auto-menus-C81NSM", url);
		}
		@Test(priority=2)
		public void invalidlogin() throws InterruptedException
		{
			fs.loginfail();
		}
		@AfterMethod
	    public void takescreenshotonfailure(ITestResult testresult) throws IOException {
	    	if(testresult.getStatus()==ITestResult.FAILURE) {
	    		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(scrFile, new File("screenshots1\\" +testresult.getName() + "-" + ".png"));
	    	}
	    	
	    }
		@AfterClass
		public void teardown()
		{
			//driver.close();
		}
}

