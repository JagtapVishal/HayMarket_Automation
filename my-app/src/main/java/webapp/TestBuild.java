package webapp;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constant;


public class TestBuild extends Constant {
	
	protected WebDriver driver;
	
	
	public void setup(){
		
		
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		Logger log = Logger.getLogger(login_page.class.getClass());
		
		System.setProperty("webdriver.chrome.driver", driver_path);
		driver=new ChromeDriver();
		log.info("Browser is Opened");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(haymarket_QA_url);
		//System.out.println(".........geturl");
		log.info("Site is Opened");
		
	}

}