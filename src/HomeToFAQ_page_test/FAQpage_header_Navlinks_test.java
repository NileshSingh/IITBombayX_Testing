package HomeToFAQ_page_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FAQpage_header_Navlinks_test {

	 private WebDriver driver;
	 static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

		String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "root";
	  
	  @Test
	  public void testHomeToFaqHeadernavLink() throws Exception {
		    //driver.get(baseUrl + "/");
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("LEARNERS FAQ")).click();
		    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("HOW IT WORKS")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("COURSES")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("PARTNERS")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("REGISTER NOW")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("LANGUAGE")).click();
		    driver.findElement(By.id("submit-lang")).click();
		    
			
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
			      
			      
			      
			      
			      Module = "Faq header page";
			      Path= "http://10.129.50.4/faq";
			      Description= "verify footer links(How it works, Partner, courses, register Now, language ) page should open or display after clicking on links";
			      Exp_output= "header links(How it works, Partner, courses, register Now, language) page should open or display after clicking on links ";
			      act_output = "fail links(How it works, Partner, courses, register Now, language) page is displaying after clicking on links";
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
