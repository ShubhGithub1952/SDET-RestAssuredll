package com.CRM.SDET37.GenericUtility;
/**
 * 
 * @author Shubham
 *
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAPIClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();

	/**
	 * connecting to database
	 */
	@BeforeSuite
	public void dbConfig()
	{
	
		dLib.connectToDB("projects");
	}
	/**
	 * launching the browser
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	
	@AfterSuite
	public void closeDBconfig()
	{
		dLib.closeDB();
	}
}