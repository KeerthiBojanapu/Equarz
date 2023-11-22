package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Utils.ListenerEvent;

public class Testbase {

	FileInputStream file;
	public static Properties props;
	public static WebDriver driver;
	//EventFiringWebDriver edriver;
	ListenerEvent event;

	public Testbase() {
		
		props = new Properties();

		try {
			file = new FileInputStream("./src/main/java/com/PropertiesConfig/Propfile");
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
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\keerthi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
//		edriver=new EventFiringWebDriver(driver);
//		event=new ListenerEvent();
//		edriver.register(event);
//		driver=edriver;

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(props.getProperty("url3"));
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().deleteAllCookies();
		
		
	}
}
