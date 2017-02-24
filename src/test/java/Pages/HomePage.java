package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
@FindBy(xpath="//div[@id='account']/a[1]") WebElement MyAccountlink;
//@FindBy(xpath="//input[@id='log']") WebElement UserName;
//@FindBy(xpath="//input[@id='pwd']")WebElement Password;
//@FindBy(xpath="login")WebElement LoginButton;

public void myAccount()
{
	MyAccountlink.click();
}

public String verifyTitle()
{
	return driver.getTitle();
	
}
	

}
