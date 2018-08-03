package webapp;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.ReadExcel;

public class register_page {

	
	private static final String UnitedStates = null;
		// locator Login page
		By register_link = By.xpath("//*[@id='HMIRegistration']/div/footer/p[1]/a");
		By fn = By.xpath("//*[@id='root_subscriber_firstName']");	
		By ln = By.xpath("//*[@id='root_subscriber_lastName']");
		By emailid = By.xpath("//*[@id='root_subscriber_email']");
		By password= By.xpath("//*[@id='root_registerPassword_password']");
		By compname = By.xpath("//*[@id='root_business_company']");
		By JobTitle = By.xpath("//*[@id='root_business_jobTitle']");
		By Country = By.xpath("//*[@class='HMIRegistration__select']");
		By Select_newletter= By.xpath("//*[@id='HMIRegistration']/div/div/form/div[6]/div/div[1]/div/span[1]/span[1]");
		By relevant_info= By.xpath("//*[@id='HMIRegistration']/div/div/form/div[7]/div/div/span[1]/span[1]");
		By register_button = By.xpath("//*[@class='HMIRegistration__submit']");
		
		By log_in=By.xpath("//*[@id='HMIRegistration']/div/div/p/a");
		By error_msg=By.xpath("//*[@class='HMIRegistration__error']");
		
	public void TC_002(WebDriver driver){
		
	try {
			
		Logger log = Logger.getLogger(login_page.class.getClass());
		
		ReadExcel reader = new ReadExcel(Constant.path);
		log.info("Excel Registersheet opened");
				
		int rowCount = reader.getRowCount("Register");
		
		
		 //Click on register link 
		 WebElement register = driver.findElement(register_link);
		 register.click();
		 log.info("Click on register link");
		
	for(int rowNum = 2; rowNum<=rowCount ; rowNum++) {
			
		
		System.out.println("==============");
		String first_name = reader.getCellData("Register","Firstname" ,rowNum);
		System.out.println(first_name);
		String last_name = reader.getCellData("Register","Lastname" ,rowNum);
		String email_id = reader.getCellData("Register","Email" ,rowNum);
		String pass_word = reader.getCellData("Register","Password" ,rowNum);
		String companyname = reader.getCellData("Register","Company" ,rowNum);
		String job_title = reader.getCellData("Register","Job_Title" ,rowNum);
		String country_name = reader.getCellData("Register","Country" ,rowNum);
		 
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				 
		 //Enter first name
		 WebElement firstname = driver.findElement(fn);
		 firstname.clear();
		 firstname.sendKeys(first_name);
		 log.info("First name is typed");
		 
		 // Enter last name
		 WebElement lastname = driver.findElement(ln);
		 lastname.clear();
		 lastname.sendKeys(last_name);
		 log.info("Last name is typed");
		 
		 // Enter email id
		 WebElement email = driver.findElement(emailid);
		 email.clear();
		 email.sendKeys(email_id);
		 log.info("email id is typed");		
		 
		 // Enter password
		 WebElement pass = driver.findElement(password);
		 pass.clear();
		 pass.sendKeys(pass_word);	
		 log.info("Password is typed");
		 
		 // Enter company name
		 WebElement company_name = driver.findElement(compname);
		 company_name.clear();
		 company_name.sendKeys(companyname);
		 log.info("Company name is typed");
		
		 // Enter Job_title
		 WebElement Job_title = driver.findElement(JobTitle);
		 Job_title.clear();
		 Job_title.sendKeys(job_title);
		 log.info("Job Title is typed");
		 
		// Enter Country_name
		 WebElement Country_name = driver.findElement(Country);
		 
		 Country_name.sendKeys(country_name);
		 log.info("Country name is seleced");
		 System.out.println(country_name);
		 
		 Thread.sleep(2000);
		 //Select Newletter
		 WebElement se_new_letter = driver.findElement(Select_newletter);
		
		 se_new_letter.click();
		 log.info("Newsletter is selected");
		 
		
		String name="United States";
		
		System.out.println(name);
		
		if(!country_name.equals(name)  )
		{	
			 System.out.println("in if");	
			 Thread.sleep(2000);
			 //Select Relevant_info click
			 WebElement Re_info_click = driver.findElement(relevant_info);
			
			 Re_info_click.click();
			 log.info("Relevant_info click is selected");
		}
		
		//Click on Register button
		 WebElement register_btn = driver.findElement(register_button);
		 register_btn.click();
		 log.info("Register button is clicked");
		
		 Thread.sleep(2000);
		 
		 try{	
				String errormessage = driver.findElement(error_msg).getText();
				System.out.println("........."+errormessage);	
				
				if(errormessage==null)
					
				
					System.out.println("Register Unsucessful");			
					reader.setCellData("Register", "Status", rowNum, "Fail");
					log.info("Write in excelsheet fail status");
					
				
				
			}catch(NoSuchElementException e){
				
				//System.out.println("........."+url);
				System.out.println("Register Sucessful");
				reader.setCellData("Register", "Status", rowNum, "Pass");
				log.info("Write in excelsheet Pass status");
				
				//Click on register link 
				 WebElement login = driver.findElement(log_in);
				 login.click();
				 log.info("Click on login link");
			}
			
			
		
		}//for loop
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
