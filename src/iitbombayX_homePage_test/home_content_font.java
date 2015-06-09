package iitbombayX_homePage_test;

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


public class home_content_font {
	
	private WebDriver driver;
	WebElement byId,byId1,byId2,byId3,byId4,byId5,byId6,byId7,byId8,byId9,byId10,byId11;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
	//String fontSize,fontSize1,fontSize2,fontSize3,fontSize4;
	
	@Test
	public void check_content()
	{
		// footer navigation content font size check
		
		byId= driver.findElement(By.id("about"));
		byId1= driver.findElement(By.id("news"));
		byId2= driver.findElement(By.id("blog"));
		byId3= driver.findElement(By.id("faq"));
		byId4= driver.findElement(By.id("contact"));
		
		 //header navigation content font check
		
		byId5= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[1]/a")); // how it works
		byId6= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[2]/a")); // courses
		byId7= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[3]/a")); // patener
		byId8= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")); // register now
		byId9= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[5]/a")); // language
		byId10= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li/a")); //login
		
		byId11 = driver.findElement(By.xpath("html/body/div[1]/div[2]/footer/div[1]/div/p"));
		
		
		footer_nav_content();
		header_nav_content();
		//String fontSize11 = byId10.getCssValue("font-size");
		
		//System.out.println("hello"+fontSize11);
		Status="Fail";
	    InsertData();
		
		
	}
	public void footer_nav_content()
	{
		String fontSize= byId.getCssValue("font-size");
		String fontSize1= byId1.getCssValue("font-size");
		String fontSize2= byId2.getCssValue("font-size");
		String fontSize3= byId3.getCssValue("font-size");
		String fontSize4= byId4.getCssValue("font-size");
		String fontSize11 = byId11.getText();
		
		System.out.println("Hellooooooooooo"+fontSize11);
		 
		if(fontSize.equals("16px") )
		{
			System.out.println("About us PASSED");
		}else
		{
		Assert.fail(" About us Font sized not matched");
		}
		if(fontSize1.equals("16px") )
		{
			System.out.println("news PASSED");
		}else
		{
		Assert.fail(" news Font sized not matched");
		}
		if(fontSize2.equals("16px") )
		{
			System.out.println("blog PASSED");
		}else
		{
		Assert.fail("blog Font sized not matched");
		}
		if(fontSize3.equals("16px") )
		{
			System.out.println("faq PASSED");
		}else
		{
		Assert.fail("faq Font sized not matched");
		}
		if(fontSize4.equals("16px") )
		{
			System.out.println("contact us PASSED");
		}else
		{
		Assert.fail("contact us Font sized not matched");
		}
		if(fontSize11.equals("IITBombayX offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. IITBombayX is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI).") )
		{
			System.out.println("footer Paragraph PASSED");
		}else
		{
		Assert.fail("footer Paragraph failed");
		}
		
	System.out.println("PASS FOOTER");
	}
	
	public void header_nav_content()
	{
		String fontSize5= byId5.getCssValue("font-size");
		String fontSize6= byId6.getCssValue("font-size");
		String fontSize7= byId7.getCssValue("font-size");
		String fontSize8= byId8.getCssValue("font-size");
		String fontSize9= byId9.getCssValue("font-size");
		String fontSize10= byId10.getCssValue("font-size");
		
		if(fontSize5.equals("14px") )
		{
			System.out.println("How IT WORKS PASSED");
		}else
		{
		Assert.fail("How IT WORKS Font sized not matched");
		}
		if(fontSize6.equals("14px") )
		{
			System.out.println("courses PASSED");
		}else
		{
		Assert.fail("courses Font sized not matched");
		}
		if(fontSize7.equals("14px") )
		{
			System.out.println("Partners PASSED");
		}else
		{
		Assert.fail("Partners Font sized not matched");
		}
		if(fontSize8.equals("14px") )
		{
			System.out.println("Register Now CLEAR3");
		}else
		{
		Assert.fail("Register Font sized not matched");
		}
		if(fontSize9.equals("14px") )
		{
			System.out.println("Language PASSED");
		}else
		{
		Assert.fail("Language Font sized not matched");
		}
		if(fontSize10.equals("16px") )
		{
			System.out.println("Login PASSED");
		}
		else
		{
		Assert.fail("Login Font sized not matched");
		}
	System.out.println("PASS HEADER");
	}
	
	 private void InsertData() {
			// TODO Auto-generated method stub
			  
			  Connection conn = null;
			   PreparedStatement statement = null;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      
			      
			      
			      Module = "Home Screen";
			      Path= "Home page > Header Links and Home Page > footer Links";
			      Description= "check the font size of How It works , partener ,About Us, Faq etc of IITBombayX";
			      Exp_output= "font size of header and footer links should 14px and 16px ";
			      act_output = "font size of header and footer content is 14px and 16 px ";
			      priority= "None";
			      Executed_by="Nilesh Singh";
			      Status="Pass";
			      
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Inserting records into the table...");
			            
			      //String sql = "INSERT INTO test2 (Date, Module, Test_Case, Description, Expected_output, Actual_output, Executed_By, prority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			      statement = conn.prepareStatement("INSERT INTO test2 (Date, Module, Path, Test_case_Description, Expected_output, Actual_output, Executed_By, priority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			      
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
