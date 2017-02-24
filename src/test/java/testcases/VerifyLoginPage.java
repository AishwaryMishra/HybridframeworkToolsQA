package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
		
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{
		report=new ExtentReports(".\\Reports\\ScreenShots.html",false);
		logger=report.startTest("Starting the test");
		driver=BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Applicatiomn is up and starting scenario no 2");
	}
	
	@Test
	public void doLogin()
	{
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.myAccountlogin();
		//String Apptitle=login.verifyTitlelogin();
		//Assert.assertTrue(Apptitle.contains("ONLINE"));
		//login.loginToapplication("aishwary.hcst@birlasoft.com", "Birlasoft@123");
		logger.log(LogStatus.INFO, "Fetching UN and Password from excel sheet");
		login.loginToapplication(DataProviderFactory.getExcel().getData(0, 1, 0), DataProviderFactory.getExcel().getData(0, 1, 1));
		logger.log(LogStatus.INFO, "Fateched UN and Password from excel sheet");
	}
	
	
	@AfterMethod
	
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		logger.log(LogStatus.INFO, "Browser closed");
	}

}
