package HomeToFAQ_page_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class faq_LEARNERS_content_page {

	 private WebDriver driver;
	 static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

		String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "root";
	  
	 
	  @Test
	  public void FAQ_content_page() throws Exception {
		  
		  String bodyText = driver.findElement(By.tagName("body")).getText();
			System.out.println("Text is:"+bodyText);
			WebElement byId = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/div/ul/li[1]/a"));
			
			Assert.assertTrue("Text not found1", bodyText.contains("HOW IT WORKS"));
			Assert.assertTrue("Text not found2", bodyText.contains("COURSES")); 
			Assert.assertTrue("Text not found3", bodyText.contains("PARTNERS")); 
			Assert.assertTrue("Text not found4", bodyText.contains("REGISTER NOW")); 
			Assert.assertTrue("Text not found5", bodyText.contains("LANGUAGE")); 
			
			//find test size if about us
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/div/ul/li[1]/a")).getCssValue("14.4");
			Assert.assertTrue("Text not found6", bodyText.contains("ABOUT"));
			
			System.out.println(byId.getCssValue("font-size"));
			
			
			Assert.assertTrue("Text not found7", bodyText.contains("RESEARCH & PEDAGOGY")); 
			Assert.assertTrue("Text not found8", bodyText.contains("BLOG")); 
			Assert.assertTrue("Text not found9", bodyText.contains("NEWS")); 
			Assert.assertTrue("Text not found11", bodyText.contains("CONTACT US")); 
			
			Assert.assertTrue("Text not found12", bodyText.contains("Our goal is to provide you great self-service tools that ensure your success. Still need help after reading these? Please submit a question through our Contact Us page or, if you are a current learner, post your question(s) in your Course Discussion forum.")); 
			Assert.assertTrue("Text not found13", bodyText.contains("Learners' FAQ")); 
			InsertData();
			
			Status = "fail";
			InsertData();
	  }
	  
	  private void InsertData() {
			// TODO Auto-generated method stub
			  
			  Connection conn = null;
			   PreparedStatement statement = null;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      
			      
			      
			      Module = "FAQ Learners Page";
			      Path= "http://10.129.50.4/faq";
			      Description= "Verify wheather content of Lerner Faq page contents(Links content and paragraph) are present ";
			      Exp_output= "Lerner Faq page contents(Links content and paragraph) should present";
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

	      driver.get("http://10.129.50.4/faq");

	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }
}
