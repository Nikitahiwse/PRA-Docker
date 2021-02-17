package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.List;

public class Previous_PRA extends PRA_Home
{
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement Team;
	@FindBy(linkText = "My Team's Previous PRAs")WebElement previous_PRA;

	
	public void previousPRA() throws InterruptedException
	{
		// To check attributes present in PRA
		Team.click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		previous_PRA.click();
		List<WebElement>tablerow=wd.findElements(By.xpath("//div[@id='PRADatagrid']//tbody//tr"));
		int totalrow=tablerow.size();
		System.out.println("Total PRA present "+ totalrow);
		logger7.log(Status.PASS, "Total PRA present "+totalrow);
		for(int i=1;i<=totalrow;i++) {
		List<WebElement>row=wd.findElements(By.xpath("//div[@id='PRADatagrid']//tbody//tr["+i+"]//td"));
		Thread.sleep(2000);
		logger7.log(Status.PASS, "Row"+i);
		for(WebElement attribute : row)
		{
			String attributename=attribute.getText();
			System.out.println("Attributes present in PRA row-->"+attributename);
			Thread.sleep(1000);
			
			logger7.log(Status.PASS, "Attributes present in PRA row-->"+ attributename);
				
		}
		
		}
		
	}
	@FindBy(xpath="//div[@id='PRADatagrid']//a[text()='PRA_demo1']")WebElement PRA_demo1;
	@FindBy(xpath="//input[@value='Save and go to pest list']")WebElement save_and_goto_pest_list;
	@FindBy(xpath="//h1[@class='text-center']")WebElement initiation;
	
	
	@FindBy(linkText = "1. Pest lists and risk assessments")WebElement risk_assessment;
	@FindBy(linkText = "2. Pest risk management")WebElement risk_management;
	@FindBy(linkText = "3. Pest risk analysis summary")WebElement analysis_summary;
	@FindBy(xpath="//*[@id='initiation-form']/div[@class='col-sm-12']/div/input")WebElement PRA_status_complete;
	@FindBy(xpath="//div[@id='divsuccess']//li")WebElement success_message;
	@FindBy(xpath="//a[text()='Home']")WebElement home;
	
	
	public void View_Bypathway_PRA() throws InterruptedException
	{
		//To view Bypathway PRA
		JavascriptExecutor jse=(JavascriptExecutor)wd;
        logger7.log(Status.PASS, "---------------To view  Bypathway PRA----------------");
		PRA_demo1.click();
		Thread.sleep(2000);
		logger7.log(Status.PASS, "PRA_demo1 pathway PRA is opened");
		String initiation_title=initiation.getText();
        logger7.log(Status.PASS, initiation_title+" is opened");
        jse.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(3000);
        save_and_goto_pest_list.click();
        Thread.sleep(2000);
        logger7.log(Status.PASS, "Save and goto pestlist- button got clicked");
        String risk_assesment_text=risk_assessment.getText();
        logger7.log(Status.PASS, risk_assesment_text+" is opened");
        jse.executeScript("window.scrollBy(0,900)", "");
        jse.executeScript("window.scrollBy(0,-900)", "");
        risk_management.click();
        Thread.sleep(1000);
        String risk_management_text=risk_management.getText();
        Thread.sleep(2000);
        logger7.log(Status.PASS, risk_management_text+" tab is opened");
        jse.executeScript("window.scrollBy(0,300)", "");
        jse.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(5000);
        //analysis_summary.click();
		WebElement element = analysis_summary;
		Actions actions = new Actions(wd);
		actions.moveToElement(element).click().perform();
        Thread.sleep(5000);
        String analysis_summary_text=analysis_summary.getText();
        logger7.log(Status.PASS, analysis_summary_text+" tab is opened");
        //jse.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(4000);
        //PRA_status_complete.click();
       //logger7.log(Status.PASS, "Change PRA status to complete-button got clicked");
       //String save_message=success_message.getText();
       //logger7.log(Status.PASS, save_message);
       //Thread.sleep(3000);

     Team.click();
     Thread.sleep(2000);
    
		
	}
	WebElement PRA_report;
	@FindBy(xpath="//div[@id='PRADatagrid']//tr[1]//td[2]")WebElement PRA_type;
	public void View_Report_from_previous_PRA() throws InterruptedException
	{
		//To view Report 
		logger7.log(Status.PASS, "------------To view Report-----------");
		previous_PRA.click();
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		List<WebElement>tablerow=wd.findElements(By.xpath("//div[@id='PRADatagrid']//tbody//tr"));
		int totalrow=tablerow.size();
		int j=1;
		for(int i=1;i<=totalrow;i++)
		{
			
		List<WebElement>Reports=wd.findElements(By.xpath("//div[@id='PRADatagrid']//tr["+i+"]//a[text()='Report']"));
		for(WebElement report:Reports)
		{
			
			
			WebElement PRA_type=wd.findElement(By.xpath("//div[@id='PRADatagrid']//tr["+j+"]//td[2]"));
			String PRAtype=PRA_type.getText();
			report.click();
			Thread.sleep(3000);
			logger7.log(Status.PASS," Report got clicked");
			if(PRAtype.equalsIgnoreCase("Pathway"))
			{
			PRA_report=wd.findElement(By.xpath("//div[@class='report-title']//strong"));
			
			}
			else 
			{
			PRA_report=wd.findElement(By.xpath("//div[@class='report-by-pest-title']//span"));
		
			}
			String Session_titile=PRA_report.getText();
			jse.executeScript("window.scrollBy(0,300)", "");
			jse.executeScript("window.scrollBy(0,300)", "");
			logger7.log(Status.PASS, Session_titile+" report is opened");
			wd.navigate().back();
			
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,600)", "");
			previous_PRA.click();
			Thread.sleep(2000);
			j++;
		}
		
	}
	}

	@FindBy(xpath="//button[text()='Filter']")WebElement filter_submit_button;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='Session number ']//span[@class='k-icon k-i-filter']")WebElement Session_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='PRA type ']//span[@class='k-icon k-i-filter']")WebElement PRA_Type_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='PRA title ']//span[@class='k-icon k-i-filter']")WebElement PRA_Title;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='PRA start date ']//span[@class='k-icon k-i-filter']")WebElement PRA_start_date_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='PRA due date ']//span[@class='k-icon k-i-filter']")WebElement PRA_due_date_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='Status ']//span[@class='k-icon k-i-filter']")WebElement Status_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='Last Modified ']//span[@class='k-icon k-i-filter']")WebElement Last_modified_filter;
	@FindBy(xpath="//div[@id='PRADatagrid']//a[@class='k-link'and text()='Completed ']//span[@class='k-icon k-i-filter']")WebElement completed_date_filter;
	
   public void filter() throws InterruptedException
	{
		
		
		  logger7.log(Status.PASS,"-------------Filter Test for Previous PRA-----------------------");
		
		 
		
		  logger7.log(Status.PASS, "Values passed for session filter -equal To = P03848  and equal To = P03848");
		  Filter.filte_previoustab(Session_filter,"P03848","P03848","1");
		 
		  logger7.log(Status.PASS, "Values passed for session filter -Not equal To = P03848  or Not equal To = blank ");
		  Filter.filte_previoustab(Session_filter,"P03847","","2");
		 
		 
		  logger7.log(Status.PASS, "Values passed for PRA Type filter -Starts With = Pathway  And  Is equal To = Pest ");
		  Filter.filte_previoustab(PRA_Type_filter,"Pathway","Pest","3");
		
		  logger7.log(Status.PASS, "Values passed for PRA Type filter -Contains = Pathway  And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_Type_filter,"Pathway","","4");
	
		 
		  logger7.log(Status.PASS, "Values passed for PRA Title filter -Does not contain = PRA  And  Is equal To = blank  ");
		  Filter.filte_previoustab(PRA_Title,"PRA","","5");
		  
		  logger7.log(Status.PASS, "Values passed for PRA Title filter -Ends With = india  And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_Title,"india","","6");
		 
		
		  logger7.log(Status.PASS, "Values passed for PRA start date filter -Is null= blank  And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_start_date_filter,"","","7");
		 
		  logger7.log(Status.PASS, "Values passed for PRA start date filter -Is not Null = 24/11/2020  And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_start_date_filter,"24/11/2020","","8");
		  
	
		  logger7.log(Status.PASS, "Values passed for PRA due date filter - Is empty = blank  And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_due_date_filter,"","","9");
		 
		  logger7.log(Status.PASS, "Values passed for PRA due date filter -Is not Empty = 31/12/2020 And  Is equal To = blank ");
		  Filter.filte_previoustab(PRA_due_date_filter,"31/12/2020","","10");
		 
		 
		  logger7.log(Status.PASS, "Values passed for Status filter -Has Value = blank  And  Is equal To = blank ");
		  Filter.filte_previoustab(Status_filter,"","","11");
		  
		  logger7.log(Status.PASS, "Values passed for Last modified filter -Has Value = 24/11/2020  And  Is equal To = blank ");
		  Filter.filte_previoustab(Last_modified_filter,"24/11/2020","","11");
		  
		 
		  logger7.log(Status.PASS, "Values passed for Completed date filter -Has not value = 25/11/2020  And  Is equal To = blank ");
		  Filter.filte_previoustab(completed_date_filter,"25/11/2020","","12");
        
	    
	
	}
}
