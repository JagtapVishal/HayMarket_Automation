package api_test;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;


public class api_services {

	@Test(priority=0)
	public void login_postMethoad() throws Exception
	{
		// Post method
		
		RequestSpecification request= RestAssured.given();
		
		JSONObject user= new JSONObject();
		user.put("email", "test_user@vishal.com");
		user.put("password", "Test1234");
		user.put("publicationId", 4);
		user.put("url", "");
		user.put("ipAddress", "");
		String jsonData=user.toString();
		System.out.println("data"+jsonData);
		

		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
				
		// Post method
		Response resp=request.post("http://qa3.subapi.haymarketmedia.com/login");
		
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result = resp.asString();
	    System.out.print("returned response: " + result +"\n"); 
	  	     
	}
	
	@Test(priority=1)
	public void subscriber_getMethoad() throws Exception
	{
		
		// Get method
		RequestSpecification request = RestAssured.given();
		
		JSONObject user=new JSONObject();
        user.put("subscriberId", "Qp2SSGSzfXM=");
      
        String jsonData=user.toString();
		System.out.println("data"+jsonData);
		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
			
		Response resp=request.get("http://qa3.subapi.haymarketmedia.com/subscriber");
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result1 = resp.asString();
	    System.out.print("returned response: " + result1 +"\n");
	    
	     
	}
	
	@Test(priority=2)
	public void reset_email_postMethoad() throws Exception
	{
		
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject user=new JSONObject();
        user.put("email", "test_user@vishal.com");
        user.put("publicationId", 4);
        
        String jsonData=user.toString();
		System.out.println("data"+jsonData);
		
		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
		
		// Post method
		Response resp=request.post("http://qa3.subapi.haymarketmedia.com/reset-email");
		
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result = resp.asString();
	    System.out.print("returned response: " + result +"\n"); 
	   
	     
	}
	

	
	@Test(priority=3)
	public void reset_password_postMethod()throws Exception
	{
		
		RequestSpecification request= RestAssured.given();
		
		JSONObject user= new JSONObject();
		user.put("password", "Admin1234");
		user.put("newPassword", "Test123");
		String sub_id= new String("Qp2SSGSzfXM=");
		
		String jsonData=user.toString();
		System.out.println("data"+jsonData);
		
		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
		
		String url= ("http://qa3.subapi.haymarketmedia.com/reset-password?subId="+sub_id+"");
		
		//System.out.println(url);
		Response resp=request.post(url);
		
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result = resp.asString();
	    System.out.print("returned result: " + result +"\n"); 
		
	}
	
	@Test(priority=4)
	public void change_password_postMethod()throws Exception
	{
		
		RequestSpecification request= RestAssured.given();
		
		JSONObject user= new JSONObject();
		user.put("subscriberId", "Qp2SSGSzfXM=");
		user.put("publicationId", 4);
		user.put("url", "");
		user.put("password", "Test1234");
		user.put("newPassword", "Test123");
		
		String jsonData=user.toString();
		System.out.println("data"+jsonData);
		
		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
		
		String url= ("http://qa3.subapi.haymarketmedia.com/change-password");
		
		//System.out.println(url);
		Response resp=request.post(url);
		
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result = resp.asString();
	    System.out.print("returned result: " + result +"\n"); 
		
	}
	
	@Test(priority=5)
	public void newsletter_getMethoad() throws Exception
	{
		
		// Get method
		RequestSpecification request = RestAssured.given();
		
		JSONObject user=new JSONObject();
		String publicationid= new String("4");
      
        //String jsonData=user.toString();
		//System.out.println("data"+jsonData);
		request.header("Content-Type","application/json");
		request.body(user.toJSONString());
		String url=("http://qa3.subapi.haymarketmedia.com/newsletter/"+publicationid+"");
		//System.out.println(url);
		Response resp=request.get(url);
		
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String result1 = resp.asString();
	    System.out.print("returned response: " + result1 +"\n");
	    
	     
	}
}
