package pra_child_classes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Delete_bypest_pra extends PRA_Home{
	static JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement team;
	@FindBy(xpath="//div[@id='RecentPRADatagrid']//tr[1]//td[10]//a[text()='Delete']")WebElement delete_button;
	@FindBy(xpath="//div[@id='RecentPRADatagrid']//tr[1]//td[3]//a")WebElement createdPRA;
	public void delete_PRA(String PRA) throws InterruptedException
	{
		
		team.click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		
		 String CreatedPra_name=createdPRA.getText();
		 Thread.sleep(2000);
		 if(CreatedPra_name.equalsIgnoreCase(PRA))
	    {
		Thread.sleep(1000);
		delete_button.click();
		Thread.sleep(1000);
		logger24.log(Status.PASS, "Delete button got clicked");
		Alert a1=wd.switchTo().alert();
		a1.accept();
		logger24.log(Status.PASS, "PRA is deleted successfully");
		System.out.println("PRA is deleted successfully");
		Thread.sleep(2000);
		 }
		 
		 else
		 {
			 System.out.println(PRA+" is not present in 0_automation_PRA team");
		 }
		 
	}

}
