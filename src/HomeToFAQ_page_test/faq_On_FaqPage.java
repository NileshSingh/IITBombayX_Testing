package HomeToFAQ_page_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class faq_On_FaqPage {
	
	private WebDriver wd;
	WebElement byXpath,byXpath1;
	static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

	String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	
	@Test
	public void faqOf_FaqPage() throws Exception
	{
		String content = null;
		//String content= wd.findElement(By.cssSelector(".ac-large>p")).getText();
		//String content= wd.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();
		//.//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p
		wd.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/label")).click();;
		content=wd.findElement(By.xpath("//div[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();		
		System.out.println("Faq Content is:" +content);

		String actual_result="IITBombayX primarily intends to offer courses from IIT Bombay and teacher training workshops, from IIT Bombay and IIT Kharagpur. Courses from other institutions/universities are expected to be offered soon on the national platform, Swayam. A few such courses will be offered on this IITBombayX platform on a pilot basis, as a part of the commitment to the National Mission on Education using ICT (NMEICT). It may be noted that that the content and running of such courses is entirely the responsiblity of the institutional universities which offer these courses. IITBombayX will not be responsible for the conduct of any of such courses.";
	
		Status="Pass";
	    
		InsertData();
		
		/*if(actual_result.equals(content))
		{
			System.out.println("Fail");

		}
*/	
	}
	
	private void InsertData() {
		// TODO Auto-generated method stub
		  
		  Connection conn = null;
		   PreparedStatement statement = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      
		      
		      
		      Module = "Home screen > Learners FAQ";
		      Path= "http://10.129.50.4/faq";
		      Description= "Verify whether Swayam is displaying on FAQ page";
		      Exp_output= "Swayam should not display on FAQ page.";
		      act_output = "On FAQ page word 'Swayam' is displaying.Below question 'How can I help improve 'IITBombayX'?' application displays an email address as 'learnersupport@swayam.ac.in.'.";
		      priority= "None";
		      Executed_by="Nilesh Singh";
		      Status="Fail";
		      
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
	 public void beforeMethod()
	{
		 wd = new FirefoxDriver();
		 
		 wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wd.get("http://10.129.50.4/faq");
		 
		
	}
	 @AfterMethod
	 public void afterMethod()
	 {
		 wd.quit();
	 }
}
