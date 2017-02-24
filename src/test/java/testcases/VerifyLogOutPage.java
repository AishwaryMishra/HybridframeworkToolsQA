package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LogOutPage;
import Pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.Helper;


public class VerifyLogOutPage 
{
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
		logger.log(LogStatus.INFO, "Application is UP and runnoing");
	}

	
	@Test
	public void doLogin()
	{
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.myAccountlogin();
		String Apptitle=login.verifyTitlelogin();
		
		Assert.assertTrue(Apptitle.contains("ONLINE"));
		logger.log(LogStatus.PASS, "Application titel verified");
		login.loginToapplication(DataProviderFactory.getExcel().getData(0, 1, 0), DataProviderFactory.getExcel().getData(0, 1, 1));
		logger.log(LogStatus.INFO,"Login to application sucessfully!");
		
		String AccountTitle=login.verifyTitleofAccount();
		Assert.assertTrue(AccountTitle.contains("Your Account"));
		logger.log(LogStatus.PASS, "My Account Title Verifird");
		//logger.log(LogStatus.FAIL, "My Account Title not Verifird");
		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshot(driver, "loginValidation")));
		
		LogOutPage logout=PageFactory.initElements(driver, LogOutPage.class);
		
		logout.Logout();
		logger.log(LogStatus.PASS,"Logout to application sucessfully!");
		//logger.log(LogStatus.FAIL,"Unexpected link title");
	}
	
	
@AfterMethod
	
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
	 	}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush(); 
	}

}
