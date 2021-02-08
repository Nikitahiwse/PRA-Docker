package pra_child_classes;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Login extends PRA_Home{
	@FindBy(xpath="//li//a[text()='Sign in']")WebElement signin;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(xpath="//button//span[text()='Log in']")WebElement login;
	@FindBy(xpath="//div[@class='access-inner']//a[@tabindex='100']")WebElement login_via_username_password;
	@FindBy(xpath="//div[@class='content-site-login-header']//div[@class='ng-binding']")WebElement window_name;
	@FindBy(xpath="//iframe[@class='sigma-iframe']")WebElement sigmaframe;
	
	public void login_to_cpc(String cpc_username, String cpc_password) throws InterruptedException
	{
		
		signin.click();
		Thread.sleep(5000);
		logger1.log(Status.PASS, "Signin button got clicked successfully");
	
		wd.switchTo().frame(0);
		Thread.sleep(2000);
		//String name=window_name.getText();
	    //System.out.println(name);
	    
		/*
		 * if(name.equals("Manage Access")) { login_via_username_password.click(); }
		 */
	    Thread.sleep(2000);
		username.sendKeys(cpc_username);
		Thread.sleep(1000);
		logger1.log(Status.PASS, "CPC username got entered successfully");
		password.sendKeys(cpc_password);
		Thread.sleep(1000);
		logger1.log(Status.PASS, "CPC password got entered successsfully");
		login.click();
		Thread.sleep(3000);
		logger1.log(Status.PASS, "Login button got clicked successfully");
		Thread.sleep(5000);
		
	}
	
	@FindBy(xpath="//input[@id='UsernameEmail']")WebElement user_name;
	@FindBy(xpath="//button[text()='Submit']")WebElement submit;
	
	public void login_to_mycabi(String mycabi_username,String mycabi_password) throws InterruptedException
	{
		
		
		user_name.clear();
		user_name.sendKeys(mycabi_username);
		Thread.sleep(1000);
		logger1.log(Status.PASS, "Mycabi username got entered successfully");
		List<WebElement> password= wd.findElements(By.xpath("//input[@id='Password']"));
		for(WebElement pass : password)
		{
			int i=0;
			pass.clear();
			pass.sendKeys(mycabi_password);
			i++;
			if(i==1) {
			break;
			}
		}
		Thread.sleep(1000);
		logger1.log(Status.PASS, "Mycabi password got entered successfully");
		submit.click();
		Thread.sleep(3000);
		logger1.log(Status.PASS, "Submit button got clicked successfully");
		Thread.sleep(4000);
		System.out.println("login Test is passed");
	}

}
