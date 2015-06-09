package iitbombayX.registrationPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_registration_page {
  private WebDriver driver;
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/testJDBC";
  	//String Status="Fail";
  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";
  String Module, Path, Description,Exp_output,act_output,Status,priority,Executed_by;

  @Test
  public void testRegPage() throws Exception {
    //driver.get(baseUrl + "/");
	  
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("raj88_007@yahoo.co.in");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("vivek123");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("vivek008");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("design1234");
    new Select(driver.findElement(By.id("state"))).selectByVisibleText("Arunachal Pradesh");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("mumbai");
    driver.findElement(By.id("pincode")).clear();
    driver.findElement(By.id("pincode")).sendKeys("453453");
    driver.findElement(By.id("aadhar")).clear();
    driver.findElement(By.id("aadhar")).sendKeys("354634646346");
    new Select(driver.findElement(By.id("education-level"))).selectByVisibleText("Associate's degree");
    new Select(driver.findElement(By.id("education-level"))).selectByVisibleText("Master's or professional degree");
    new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Male");
    new Select(driver.findElement(By.id("yob"))).selectByVisibleText("1984");
    driver.findElement(By.id("address-mailing")).clear();
    driver.findElement(By.id("address-mailing")).sendKeys("rasghdrshgfmgh,mgj,mhj,h,h,,,\nfnjdfygjdfmnjdfmjgfmdmg\nmnghfmndfmndmgm");
    driver.findElement(By.id("goals")).clear();
    driver.findElement(By.id("goals")).sendKeys("mghmghfmghmghmgmgfmg\ndgfjmndfmnjghfmghmghm\nghmghmghfmghmgj,hk,.,.hfj,,jfjukjsfhdtshdrtsbdbd");
    driver.findElement(By.id("tos-yes")).click();
    driver.findElement(By.id("honorcode-yes")).click();
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
    driver.findElement(By.linkText("Log Out")).click();
    
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
		      
		      
		      
		      
		      Module = "Registration Page";
		      Path= "http://10.129.50.4/register";
		      Description= "verify all fields of the Registration form accepting data with it's proper validation";
		      Exp_output= "Registration form fields should accept data properly with it's validation";
		      act_output = "Registration form fields are accepting data properly with it's validation";
		      priority= "None";
		      Executed_by="Deepak Shinde";
		     Status="Pass";
		      
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table2...");
		            
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