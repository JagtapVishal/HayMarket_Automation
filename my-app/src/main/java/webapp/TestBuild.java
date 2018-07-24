package webapp;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBuild {
	
	protected WebDriver driver;
	
	
	public void setup(){
		
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		Logger log = Logger.getLogger(login_page.class.getClass());
		
		System.setProperty("webdriver.chrome.driver", "D:\\Haymarket_Project\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		log.info("Browser is Opened");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://35.173.239.167/login-standalone/");
		//System.out.println(".........geturl");
		log.info("Site is Opened");
		
	}

}