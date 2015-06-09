package iitbombayX.registrationPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class content_test {
	
	private WebDriver driver;
	WebElement byXpath,byXpath1;
	static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
	
	@Test
	public void RegistrationPageContent () throws Exception
	{
		//driver.findElement(By.linkText("REGISTER NOW")).click();
		driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		byXpath = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/header/h1/span[1]"));
		byXpath1 = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/header/h1/span[2]"));
		
		Status="Fail";
	    
		bannerText();
		
	}
	public void bannerText()
	{
		String bannerText = byXpath.getText();
		String bannerText1 = byXpath1.getText();
		System.out.println("Banner Text PASSED1" +bannerText);
		
		
		
		if(bannerText.equals("WELCOME TO IITBOMBAYX!"))
		{
			if(bannerText1.equals("register below to create your iitbombayx account"))
			{
				System.out.println("Banner Text PASSED1");
			}else {
				Assert.fail("Banner Text Failed1");
			}
			
		}else {
			Assert.fail("Banner Text Failed");
		}
		
		InsertData();
	}
	
	private void InsertData() {
		// TODO Auto-generated method stub
		  
		  Connection conn = null;
		   PreparedStatement statement = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      
		      
		      
		      Module = "Registration Page";
		      Path= "http://10.129.50.4/register";
		      Description= "Verify and check  Registration Page banner contents are present";
		      Exp_output= "Registration Page banner contents should present as per the requirement";
		      act_output = "As Expected";
		      priority= "None";
		      Executed_by="Nilesh Singh";
		      Status="Pass";
		      
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table1...");
		            
		      //String sql = "INSERT INTO test2 (Date, Module, Test_Case, Description, Expected_output, Actual_output, Executed_By, prority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		      statement = conn.prepareStatement("INSERT INTO test2 (Date, Module, Path, Test_Case_Description, Expected_output, Actual_output, Executed_By, priority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
		      
		      statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
		      statement.setString(2, Module);
		      statement.setString(3, Path);
		      statement.setString(4, Description);
		      statement.setString(5, Exp_output);
		      statement.setString(6, act_output);
		      statement.setString(7, Executed_by);
		      statement.setString(8, priority);
		      statement.setString(9, Status);
		      
		      statement.executeUpdate();
		      
		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(statement!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
		
	
	
	@BeforeMethod
	public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();

	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get("http://10.129.50.4/");

	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }

}
