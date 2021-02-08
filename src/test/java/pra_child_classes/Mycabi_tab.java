package pra_child_classes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.My_cabi_account;

public class Mycabi_tab extends My_cabi_account {

	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	@FindBy(linkText = "My CABI")WebElement mycabi;
	@FindBy(xpath="//input[@id='FirstName']")WebElement firstname;
	@FindBy(xpath="//input[@id='LastName']")WebElement lastname;
	@FindBy(xpath="//input[@id='Role']")WebElement role;
	@FindBy(xpath="//input[@id='University']")WebElement organization;
	@FindBy(xpath="//input[@value='Update profile']")WebElement update_profile;
	public void mycabi_account_edit() throws InterruptedException
	{
		
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		mycabi.click();
		Thread.sleep(2000);
		logger4.log(Status.PASS, "Mycabi tab got clicked");
		
		firstname.clear();
		firstname.sendKeys("abc");
		Thread.sleep(1000);
		logger4.log(Status.PASS, "Firsname is updated with - abc");
		
		lastname.clear();
		lastname.sendKeys("xyz");
		Thread.sleep(1000);
		logger4.log(Status.PASS, "Lastname is updated with - xyz");
		
		role.clear();
		role.sendKeys("Autmation Tester");
		Thread.sleep(1000);
		logger4.log(Status.PASS, "role is updated with- Automation Tester");
		
		organization.clear();
		organization.sendKeys("Neosoft");
		Thread.sleep(1000);
		logger4.log(Status.PASS, "Organization is updated with - Neosoft");
		
		update_profile.click();
		Thread.sleep(3000);
		
		Alert a1=wd.switchTo().alert();
		a1.accept();
		
		logger4.log(Status.PASS, "Mycabi account is updated successfully");
		
		System.out.println("Mycabi account is updated successfully");
	}
	
	@FindBy(xpath="//button[text()='Delete My CABI Account']")WebElement delete_account;
	public void mycabi_delete() throws InterruptedException
	{
		logger4.log(Status.PASS, "-------------------Delete Mycabi Account-------------");
		Thread.sleep(3000);
		delete_account.click();
		logger4.log(Status.PASS, "Delete My CABI Account button got clicked");
		Thread.sleep(3000);
		Alert a1=wd.switchTo().alert();
		a1.accept();
		logger4.log(Status.PASS, "Mycabi account is deleted successfully");
		System.out.println("Mycabi account is deleted successfully");
	}
}
