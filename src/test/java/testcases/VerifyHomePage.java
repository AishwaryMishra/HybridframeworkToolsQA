package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{
		report=new ExtentReports(".\\Reports\\ScreenShots.html",true);
		logger=report.startTest("Starting the Scenario 1 test");
		driver=BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application for VerifyHomePAge call is UP and Running");
	}
	
	@Test
	public void clickOnMyAccount()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.myAccount();
		String Apptitle=home.verifyTitle();
		Assert.assertTrue(Apptitle.contains("ONLINE"));
		logger.log(LogStatus.PASS, "Home Page Title Verified");
		
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		if(driver!=null)
		BrowserFactory.closeBrowser(driver);
		logger.log(LogStatus.INFO, "Browser Closed Successfully");
	}

}
