package com.qa.Orange.OrangeTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.FindBy;
import junit.framework.TestCase;

public class EmployeeTab {

	WebDriver driver;
	
	String url;
	public ExtentReports report;
	public ExtentTest test;
	
	@Before
	public void setup() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\OrangeReport.html", true);
		test = report.startTest("init Orange Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Web Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		
		OrangePage page = PageFactory.initElements(driver, OrangePage.class);
		
		page.method();
		
	}
	
	
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws Throwable {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
	}    
	@When("^I fill out the Employee Details correctly$") 
	public void I_fill_out_the_Employee_Details_correctly() {
	
		driver.findElement(By.id("firstName")).sendKeys("Abdilasis");
		driver.findElement(By.id("lastName")).sendKeys("Warya");
	}
	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() throws Throwable {
		
		driver.findElement(By.id("chkLogin")).click();	
		
	}
	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {
		driver.findElement(By.id("user_name")).sendKeys("Mo Salah");
		driver.findElement(By.id("user_password")).sendKeys("excellentfinish");
		driver.findElement(By.id("re_password")).sendKeys("excellentfinish");
	}
	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
	    
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("^I can see information about the user$") 
	public void I_can_see_information_about_the_user() {
		
		String expected = "Abdilasis Warya";
		
		String result = driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1")).getText();
		assertEquals(expected ,result); 
		
		test.log(LogStatus.PASS, "Success");
		
		report.endTest(test);
		report.close();
				
	}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
