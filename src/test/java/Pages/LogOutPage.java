package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LogOutPage {
WebDriver driver;
	
By Logoutlink=By.xpath("//div[@id='account_logout']");

public LogOutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}



public void Logout()
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(Logoutlink));
	String signoutText=ele.getText();
	Assert.assertEquals(signoutText, "(Logout)");
	ele.click();
}

}
