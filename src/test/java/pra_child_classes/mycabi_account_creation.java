package pra_child_classes;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.My_cabi_account;

public class mycabi_account_creation extends My_cabi_account{
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
		String name=window_name.getText();
	    System.out.println(name);
	    
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
	
	
	
	@FindBy(xpath="//input[@id='FirstName']")WebElement Firstname;
	@FindBy(xpath="//input[@id='LastName']")WebElement Lastname;
	@FindBy(xpath="//input[@id='EmailAddress']")WebElement Email;
	@FindBy(xpath="//input[@id='ConfirmPassword']")WebElement confirm_password;
	@FindBy(xpath="//input[@id='Feedback']")WebElement feedback_radio;
	@FindBy(xpath="//input[@id='CABIProduct']")WebElement product_radio;
	@FindBy(xpath="//input[@id='PrivacyPolicy']")WebElement privacy_radio;
	@FindBy(xpath="//button[text()='Create account']")WebElement create_account;
	
	public void account_creation_mycabi(String firstname,String lastname,String email,String password) throws InterruptedException
	{
		
		Thread.sleep(2000);
		Firstname.sendKeys(firstname);
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Firstname got entered successfully");
		Lastname.sendKeys(lastname);
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Lastname got entered successfully");
		Email.sendKeys(email);
		Thread.sleep(1000);
		logger2.log(Status.PASS, "email got entered successfully");
		
		List<WebElement> Password= wd.findElements(By.xpath("//input[@id='Password']"));
		int i=0;
		for(WebElement pass : Password)
		{
			
			if(i==0) {
				i++;
				}
			else {
			pass.clear();
			pass.sendKeys(password);
			logger2.log(Status.PASS, "Password got entered successfully");	
			}
		}
		
		Thread.sleep(1000);
		confirm_password.sendKeys(password);
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Confirm password got entered successfully");
		feedback_radio.click();
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Feedback radio button  got clicked");
		product_radio.click();
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Product and services radio button  got clicked");
		privacy_radio.click();
		Thread.sleep(1000);
		logger2.log(Status.PASS, "privacy radio button  got clicked");
		Thread.sleep(1000);
		create_account.click();
		Thread.sleep(3000);
		Alert a1=wd.switchTo().alert();
		a1.accept();
		logger2.log(Status.PASS, "Mycabi account is created successfully");
		Thread.sleep(5000);
		
	}
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(xpath="//input[@id='UsernameEmail']")WebElement user_name;
	@FindBy(xpath="//button[text()='Submit']")WebElement submit;
	@FindBy(xpath="//li[@class='nav-item left-border right-border']//span[@class='icon-text']")WebElement signed_icon;
	@FindBy(xpath="//input[@id='AcceptedTermsAndConditions']")WebElement checkbox1;
	@FindBy(xpath="//input[@id='ShareAgreed']")WebElement checkbox2;
	@FindBy(xpath="//input[@Value='Save']")WebElement save_button;
	public void login_to_mycabi(String username,String Password) throws InterruptedException
	{
		user_name.clear();
		user_name.sendKeys(username);
		Thread.sleep(1000);
		logger3.log(Status.PASS, "Mycabi username got entered successfully");
		List<WebElement> password= wd.findElements(By.xpath("//input[@id='Password']"));
		for(WebElement pass : password)
		{
			int i=0;
			pass.clear();
			pass.sendKeys(Password);
			i++;
			if(i==1) {
			break;
			}
		}
		Thread.sleep(1000);
		logger3.log(Status.PASS, "Mycabi password got entered successfully");
		submit.click();
		Thread.sleep(3000);
		logger3.log(Status.PASS, "Submit button got clicked successfully");
		Thread.sleep(4000);
		String icon_text=signed_icon.getText();
		System.out.println("Successfully "+icon_text);
		logger3.log(Status.PASS, "Successfully "+icon_text);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(2000);
		checkbox1.click();
		Thread.sleep(1000);
		checkbox2.click();
		Thread.sleep(1000);
		save_button.click();
		Thread.sleep(3000);
		
		
		
	}
}
