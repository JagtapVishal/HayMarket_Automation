/*
  @author vishal.jagtap
  ProjectName- Hyamarket
  Login Page	
*/

package webapp;

//import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Constant;
import utility.ReadExcel;

public class login_page {

	
    //locator Login page
	//By login_Tab = By.xpath("//*[@id='hrefDynamicLogin']");
	By email_id = By.xpath("//*[@id='root_email']");	
	By password = By.xpath("//*[@id='root_password']");
	By Keep_in_sign = By.xpath("//*[@class='HMIRegistration__sprite-border']");
	By login_button = By.xpath("//*[@class='HMIRegistration__submit']");
	//By logout_button= By.xpath("//*[@id='hrefLogout']");
	By error_msg=By.xpath("//*[@class='HMIRegistration__error']");
	
	
	public void TC_001(WebDriver driver)
	{ 
		try {
								
				Logger log = Logger.getLogger(login_page.class.getClass());
													
				ReadExcel reader = new ReadExcel(Constant.path);
				log.info("Excel Loginsheet opened");
						
				int rowCount = reader.getRowCount("Login");
				
				for(int rowNum = 2; rowNum<=rowCount ; rowNum++) {
					
				System.out.println("============");
				String UserName = reader.getCellData("Login","userName" ,rowNum);
				System.out.println(UserName);
				String Password = reader.getCellData("Login","Password", rowNum);
				System.out.println(Password);						
															
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
												
				WebElement email= driver.findElement(email_id);
				email.clear();
				email.sendKeys(UserName);
				log.info("Email address typed");
				
				//System.out.println("enter password");
				WebElement pass= driver.findElement(password);
				pass.clear();
				pass.sendKeys(Password);
				log.info("Password typed");
				
				//System.out.println("click on Keep_in_sign");
				WebElement sign= driver.findElement(Keep_in_sign);
				sign.click();
				log.info("Clicking on keep_in_sign");
				
				
				//System.out.println("click on login button");
				WebElement login= driver.findElement(login_button);
				login.click();
				log.info("Clicking on login button");
				//Thread.sleep(1000);	
			    
			try{	
				String errormessage = driver.findElement(error_msg).getText();
				System.out.println("........."+errormessage);	
				
				if(errormessage==null)
					
				
					System.out.println("Login Unsucessful");			
					reader.setCellData("Login", "Status", rowNum, "Fail");
					log.info("Write in excelsheet fail status");
					
				
				
			}catch(NoSuchElementException e){
				
				
				String url = driver.getCurrentUrl();
				String id =url.substring(url.lastIndexOf("=")-11);
				System.out.println("subscriber_id="+id);
				System.out.println("Login Sucessful");
				reader.setCellData("Login", "Status", rowNum, "Pass");
				reader.setCellData("Login", "Subscriber_id", rowNum, id);
				log.info("Write in excelsheet Pass status");
				
			}
			
			
			}//for looop
			
			}// close try block
		
		 catch (Exception exception) {
            
        	 exception.printStackTrace();
         }
	
	
	}
	
}
