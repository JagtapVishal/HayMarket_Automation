
package webapp_test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webapp.TestBuild;
import webapp.login_page;
import webapp.register_page;

public class Test_Run extends TestBuild {
	

	@BeforeMethod
	public void Test() throws IOException
	{
		 		
		setup();
		
	}	
	
	
	@BeforeMethod
	public void BrowserOpen() throws IOException
	{
		 		
		setup();
		
	}	
	
	@Test(priority=2)
	public void Login_Testcase()
	{
		login_page lp =new login_page();
	
		lp.TC_001(driver);
	}	
	
	@Test(priority=1)	
	public void Register_Testcase() throws IOException
	{
		register_page rp =new register_page();
	
		rp.TC_002(driver);
	}
	
	@AfterMethod
	public void CloseBrowser(){
		
		driver.close();
	}
	
}
