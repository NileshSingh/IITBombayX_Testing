package iitbombayX_homePage_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePage_text {

	private WebDriver driver;
	static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

	 //  Database credentials
	 static final String USER = "root";
	 static final String PASS = "root";
	 String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
	
	@Test
	public void text_onPage()
	{
		String bodyText = driver.findElement(By.tagName("body")).getText();
		//dString strResult="Fail";
		
			
		
		System.out.println("Text is:"+bodyText);
		Assert.assertTrue("Text not found1!", bodyText.contains("IITBombayX online courses starting soon"));
	//Assert.assertTrue("Text not found!", bodyText.contains("Take great online courses from one of India's best Institutes"));
		//Assert.assertTrue("Text not found!", bodyText.contains("Your Platform Name Here offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. Your Platform Name Here is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI)."));
		Assert.assertTrue("Text not found2!", bodyText.contains("HOW IT WORKS"));
		Assert.assertTrue("Text not found3!", bodyText.contains("COURSES")); 
		Assert.assertTrue("Text not found4!", bodyText.contains("PARTNERS")); 
		Assert.assertTrue("Text not found5!", bodyText.contains("REGISTER NOW")); 
		Assert.assertTrue("Text not found6!", bodyText.contains("LANGUAGE")); 
		Assert.assertTrue("Text not found!", bodyText.contains("Take great online courses from")); 
		Assert.assertTrue("Text not found!", bodyText.contains("one of India's best Institutes")); 
		
		Assert.assertTrue("Text not found7!", bodyText.contains("About")); 
		Assert.assertTrue("Text not found8!", bodyText.contains("News")); 
		Assert.assertTrue("Text not found9!", bodyText.contains("Blog")); 
		Assert.assertTrue("Text not found10!", bodyText.contains("FAQ")); 
		Assert.assertTrue("Text not found11!", bodyText.contains("Contact Us")); 
		Assert.assertTrue("Text not found13!", bodyText.contains("IITBombayX offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. IITBombayX is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI).")); 
		
		
	 
		Status="Fail";
	    InsertData();
	  }

	  private void InsertData() {
		// TODO Auto-generated method stub
		  
		  Connection conn = null;
		   PreparedStatement statement = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      
		      
		      
		      Module = "Home Screen";
		     Path= "Test Home Page Content or text ";
		      Description= "Check Home Page Content or text mentioned properly";
		      Exp_output= "Home Page Content or text should available and it should be as per the requirement";
		      act_output = "As Expected";
		      priority= "None";
		      Executed_by="Nilesh Singh";
		      Status="Pass";
		      
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		            
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
