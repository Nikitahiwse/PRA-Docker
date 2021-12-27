package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pra_package.PRA_Home;

import java.util.List;

public class Regulated_Pest_list extends PRA_Home {
	
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement team;
	@FindBy(linkText = "My Team's Regulated Pest List")WebElement regulated_pest_list_tab;
	@FindBy(xpath="//button[text()=' Add new pest ']")WebElement add_new_pest;
	@FindBy(xpath="//input[@id='SearchPestName']")WebElement search_pest;
	@FindBy(xpath="//li[@class='ui-menu-item']//a[text()='Aculus schlechtendali (']")WebElement pestapple;
	@FindBy(xpath="//button[text()='Save']")WebElement save_button;
	@FindBy(xpath="//button[@class='btn btn-pra-gray valid' and text()='Cancel']")WebElement cancel_button;
	@FindBy(xpath="//div[@id='addeditpopupregulatory']//div[@class='modal-content']")WebElement dialogbox;
	@FindBy(xpath="//div[@id='NotificationDivRegulatoryStatus']//li")WebElement notification;
	@FindBy(xpath="//button[text()='Ok']")WebElement ok;
	public void add_pest() throws InterruptedException
	{
		team.click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		regulated_pest_list_tab.click();
		logger8.log(Status.PASS, "Regulated pest list tab got clicked");
		Thread.sleep(2000);
		add_new_pest.click();
		logger8.log(Status.PASS, "Add new pest button got clicked");
		Thread.sleep(3000);
		List<WebElement>dialog= wd.findElements(By.xpath("//div[@id='addeditpopupregulatory']//div[@class='modal-content']"));
		int dialog_count=dialog.size();
		if(dialog_count==1)
		{
			logger8.log(Status.PASS, "Regulated Pest dialog box is visible");
		}
		Thread.sleep(3000);
		cancel_button.click();
		Thread.sleep(2000);
		logger8.log(Status.PASS, "cancel button got clicked and regulated Pest dialog box is closed");
		
		add_new_pest.click();
		logger8.log(Status.PASS, "Add new pest button got clicked");
		Thread.sleep(2000);
		search_pest.sendKeys("apple");
		logger8.log(Status.PASS, "lookup search for- apple");
		Thread.sleep(2000);
		search_pest.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(10000);
		List<WebElement>pests=wd.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		int count=pests.size();
		
		logger8.log(Status.PASS, "Total pest found in Lookup search for apple "+count);
		int i=1;
		for(WebElement pest : pests)
		{
			String pestname=pest.getText();
			logger8.log(Status.PASS, i+" "+pestname);
			i++;
		}
		
		Thread.sleep(1000);
		pestapple.click();
		
		Thread.sleep(1000);
		Select s1=new Select(wd.findElement(By.xpath("//select[@id='ImportCountryGeonameID']")));
		s1.selectByVisibleText("India");
		
		Thread.sleep(1000);
		Select s2=new Select(wd.findElement(By.xpath("//select[@name='PestQuarantineStatusID']")));
		s2.selectByValue("2");
		logger8.log(Status.PASS, "Second option got selected");
		Thread.sleep(1000);
		save_button.click();
		Thread.sleep(1000);
		String notification_pest=notification.getText();
		logger8.log(Status.PASS, "Save button got clicked and "+notification_pest);
		Thread.sleep(1000);
		ok.click();
		Thread.sleep(5000);
	}
	@FindBy(xpath = "//div[@id='RegulatoryStatusDatagrid']//tr[1]//td[6]//a")WebElement user_action;
	@FindBy(xpath="//span[text()='Edit record']")WebElement edit;
	@FindBy(xpath="//button[text()='Update']")WebElement update;
	@FindBy(xpath="//button[text()='Ok']")WebElement ok_button;
	@FindBy(xpath="//div[@id='NotificationDivRegulatoryStatus']//li")WebElement notification_update;
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//tr[1]//td[3]")WebElement regulatory_status_for_apple_rust;
	@FindBy(xpath="//select[@name='PestQuarantineStatusID']'")WebElement status_option;
	public void edit_record() throws InterruptedException
	{
		
		logger8.log(Status.PASS, "-------------Edit Record---------------");
		user_action.click();
		logger8.log(Status.PASS, "User action got selected");
		Thread.sleep(1000);
		edit.click();
		Thread.sleep(2000);
		logger8.log(Status.PASS, "Edit option got clicked");
		Thread.sleep(4000);
        //status_option.click();
		List<WebElement>status_options=wd.findElements(By.xpath("//select[@name='PestQuarantineStatusID']"));
		int i=1;
		for(WebElement option : status_options)
		{
			if (i==1)
			{
				System.out.println("");
			}
			if(i==2)
			{
				Select edit=new Select(option);
				edit.selectByValue("3");
			}
			i++;
		}
				
		
		Thread.sleep(1000);
		logger8.log(Status.PASS, "Third status option got selected");
		update.click();
		Thread.sleep(1000);
		String update_message=notification_update.getText();
		logger8.log(Status.PASS, "Update button got clicked -"+update_message);
		Thread.sleep(1000);
		ok_button.click();
		Thread.sleep(2000);
		
		String status_no=regulatory_status_for_apple_rust.getText();
		if(status_no.equalsIgnoreCase("3"));
		{
			logger8.log(Status.PASS, "Pest status is updated with key value 3");
		}

		Thread.sleep(3000);
	}
	
	@FindBy(xpath="//button[text()='Cancel' and @class='btn btn-pra-gray valid']")WebElement cancel_del;
	@FindBy(xpath="//span [text()=' Delete record ']")WebElement Delete;
	@FindBy(xpath="//button[text()='Delete']")WebElement delete_button;

	@FindBy(xpath="//div[@id='NotificationDivRegulatoryStatus']//li")WebElement notification_delete;
	@FindBy(xpath="//button[text()='Ok']")WebElement ok_del;
	
	public void cleanup_pest() throws InterruptedException
	{

		logger8.log(Status.PASS, "-------------Delete Pest---------------");
		user_action.click();
		Thread.sleep(2000);
		logger8.log(Status.PASS, "User action got clicked");
	
		Delete.click();
		Thread.sleep(4000);
		logger8.log(Status.PASS, "Delete option got selected");
		
		delete_button.click();
		Thread.sleep(1000);
		logger8.log(Status.PASS, "Delete button got clicked");
		Thread.sleep(1000);
		
		String delete_notification=notification_delete.getText();
	    logger8.log(Status.PASS, "Notification message after click on delete button-"+delete_notification);
	    
	    Thread.sleep(1000);
	    ok_del.click();
	    Thread.sleep(1000);
	    List<WebElement>apple=wd.findElements(By.xpath("//div[@id='RegulatoryStatusDatagrid']//td[text()='Aculus schlechtendali (apple rust mite)']"));
	    int count_del=apple.size();
	    if(count_del== 0)
	    {
	    	logger8.log(Status.PASS, "Pest is deleted successfully");
	    }
	    
	    
	    
	}
	@FindBy(xpath="//a[@aria-label='Go to the next page' and @data-page='2']")WebElement go_to_next_page;
	@FindBy(xpath="//a[@aria-label='Go to the previous page' and @class='k-link k-pager-nav']")WebElement go_to_previous_page;
	public void pagination() throws InterruptedException
	{
		
		logger8.log(Status.PASS, "------------Pagination-------------");
		List<WebElement>pests=wd.findElements(By.xpath("//div[@id='RegulatoryStatusDatagrid']//tbody//tr"));
		int pest_count=pests.size();
		if(pest_count== 10)
		{
			logger8.log(Status.PASS, "Total no of pest present in page 1 = "+pest_count);
		}
		
		Thread.sleep(2000);
		
		/*go_to_next_page.click();
		Thread.sleep(5000);
		logger8.log(Status.PASS, "Next page is opened");
	
		Thread.sleep(1000);
		List<WebElement>pest_secondpage=wd.findElements(By.xpath("//div[@id='RegulatoryStatusDatagrid']//tbody//tr"));
		int pest_count_secondpage=pest_secondpage.size();
		if(pest_count_secondpage== 2)
		{
			logger8.log(Status.PASS, "Total no of pest present in page 2 = "+pest_count_secondpage);
		}
		Thread.sleep(1000);
		
		go_to_previous_page.click();
		Thread.sleep(2000);
		logger8.log(Status.PASS, "Previous page is opened");*/
		
	}
	
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//a[text()='Pest name ']//a[@class='k-grid-filter']")WebElement pestname_filter;
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//a[text()='Type ']//a[@class='k-grid-filter']")WebElement type;
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//a[text()='Regulating country/area ']//a[@class='k-grid-filter']")WebElement Regulating_country_filter;
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//a[text()='Regulatory status ']//a[@class='k-grid-filter']")WebElement Regulatory_status_filter;
	@FindBy(xpath="//div[@id='RegulatoryStatusDatagrid']//a[text()='Date last modified ']//a[@class='k-grid-filter']")WebElement Date_last_modified_filter;
	public void regulated_filter() throws InterruptedException
	{
		
		logger8.log(Status.PASS,"---------------------Regulated Filter------------------------");
		Thread.sleep(3000);
		logger8.log(Status.PASS, "Pestname passed for Pest Name Filter- Pratylenchus rwandae");
		Filter.regulated_pest_filter(pestname_filter,"Pratylenchus rwandae","Pest name");
		
		Thread.sleep(1000); 
		
		logger8.log(Status.PASS, "Pest Type passed for Type Filter- Nematoda");
		Filter.regulated_pest_filter(type,"Nematoda","Type");
		Thread.sleep(1000);
		
		//logger8.log(Status.PASS,"Country passed for Country/area Filter- United Kingdom");
	    //Filter.regulated_pest_filter(Regulating_country_filter,"United Kingdom","Regulating country/area");
	   // Thread.sleep(1000);
		//logger8.log(Status.PASS, " Status number  passed for Status Filter- 2 ");
		//Filter.regulated_pest_filter(Regulatory_status_filter, "2","Regulatory status");
		//Thread.sleep(1000);
		//logger8.log(Status.PASS," Date passed for Date last modified Filter- 30/11/2020");
	    //Filter.regulated_pest_filter(Date_last_modified_filter,"2020/10/30","Date last modified");
	    //Thread.sleep(1000);
		System.out.println("HomePage Test is passed");
	}
}
