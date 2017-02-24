package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//div[@id='account']/a[1]") WebElement MyAccountlink;
	@FindBy(xpath="//input[@id='log']") WebElement logintextbox;
	@FindBy(xpath="//input[@id='pwd']") WebElement pwdtextbox;
	@FindBy(xpath="//input[@id='login']") WebElement loginbutton;
	
	
	public void myAccountlogin()
	{
		MyAccountlink.click();
	}
	
	public String verifyTitlelogin()
	{
		return driver.getTitle();
		
	}
		
	public String verifyTitleofAccount()
	{
		return driver.getTitle();
		
	}
		
	public void loginToapplication(String username,String Password)
	{
	logintextbox.sendKeys(username);
	pwdtextbox.sendKeys(Password);
	loginbutton.click();
	}
	
}