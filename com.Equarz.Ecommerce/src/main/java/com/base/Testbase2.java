package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase2 {
	FileInputStream file;
	public static Properties props;
	protected WebDriver driver;

	public Testbase2() {
		
		props = new Properties();

		try {
			file = new FileInputStream("C:\\Users\\Dell\\git\\Eccomerce_Project\\com.Equarz.Ecommerce\\src\\main\\java\\com\\PropertiesConfig\\Propfile");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Setup() {

		String browsername = props.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(props.getProperty("url2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().deleteAllCookies();
		
		
	}

}
