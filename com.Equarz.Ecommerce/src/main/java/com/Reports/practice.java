package com.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class practice {
	WebDriver driver;
	ExtentReports extent;
	@Test
	public void installapp() {

	ExtentReports extent = ExtentReports.get(ExtentReport.class);
	extent.init("myreport.html", true);
	test =  extent.startTest(" Install App");
	System.setProperty("webdriver.ie.driver","C:\\Anuj\\Downloads\\IEDriverServer_Win32_2.46.0\\IEDriverServer.exe");
	     driver = new InternetExplorerDriver();
	     driver.manage().window().maximize();
	     driver.get("https://www.tripadvisor.com/");
	     String Title = driver.getTitle();
	     Assert.assertTrue(Title.contains("Trip"));
	     test.Log(LogStatus.Pass, "Login Successful");
	     extent.endTest(test);
	     extent.flush();
	     extent.close();
	}
	}

}
