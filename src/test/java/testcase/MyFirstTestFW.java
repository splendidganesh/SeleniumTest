package testcase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class MyFirstTestFW extends BaseTest {
   @Test(dataProviderClass=ReadXLSData.class,dataProvider="bvtdata")
	public void LoginTest(String username,String password) throws InterruptedException {	   
        System.out.println("Clicked");	   
	    Thread.sleep(4000);
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
	    Thread.sleep(4000);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		 Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		 Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.id(loc.getProperty("signin_button"))).click();
		 Thread.sleep(8000);
	}
      
}
