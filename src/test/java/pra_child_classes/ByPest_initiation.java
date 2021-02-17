package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pra_package.PRA_Home;

import java.util.List;

public class ByPest_initiation extends PRA_Home{
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement team;
	@FindBy(linkText = "By Pest")WebElement By_pest_button;
	@FindBy(xpath="//input[@id='SearchPestName']")WebElement searchpestname;
	@FindBy(xpath="//li[@class='ui-menu-item']//a[text()=' loosi (root lesion nematode)']")WebElement pratylenchus;
	@FindBy(xpath="//input[@id='PestName']")WebElement pestname;
	@FindBy(xpath="//button[text()='Add']")WebElement add;
	@FindBy(xpath="//a[@class='btn-remove']")WebElement remove;
	@FindBy(xpath="//div[@class='switch-field ']//label[text()='Yes']")WebElement yes_button;
	@FindBy(xpath="//div[@class='form-group']//textarea[@id='DetailsPreviousPra']")WebElement details_previous_pra;
	@FindBy(xpath="//div[@class='form-group']//textarea[@id='DetailsOtherPreviousPra']")WebElement details_other_previous_pra;
	@FindBy(xpath="//textarea[@id='Title']")WebElement titel_PRA;
	@FindBy(xpath="//textarea[@id='PraArea']")WebElement pra_area;
	@FindBy(xpath="//textarea[@id='Scope']")WebElement scop;
	@FindBy(xpath="//label[@for='NoPreviousPraExists']")WebElement Noprevious;
	@FindBy(xpath="//div[@class='switch-field']//label[text()='Yes']")WebElement yesprevious;
	@FindBy(xpath="//span[@class='glyphicon toggle-icon']")WebElement reference_icon;
	@FindBy(xpath="//body[@id='tinymce']//p")WebElement reference_textbox;
	@FindBy(xpath="//div[@class='datepicker-days']//table[@class='table-condensed']//tr[2]//th[2]")WebElement month;
	@FindBy(xpath="//input[@value='Save']")WebElement save_button;
	@FindBy(xpath="//span[@id='ScientificName-error']")WebElement pra_name_error;
	@FindBy(xpath="//span[@id='Demo-error']")WebElement demo_error;
	@FindBy(xpath="//span[@id='CountryAtRisk-error']")WebElement countryatrisk_error;
	@FindBy(xpath="//span[@id='Title-error']")WebElement title_error;
	
	public void By_pest_initiation_pra(String Pestname, String Country_area_at_risk, String Suggested_title_for_pra, String Pra_start_month, String Pra_due_month, String Pra_due_date, String Pra_area) throws InterruptedException
	{
		//Check mandatory fields are mandatory
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		team.click();
		Thread.sleep(2000);
		By_pest_button.click();
		logger17.log(Status.PASS, "By Pest button got clicked");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,600)", "");
		
		save_button.click();
		Thread.sleep(2000);
		logger17.log(Status.PASS, "PRA is not saved without filling 4 mandatory information");
		String pra_name_error_text=pra_name_error.getText();
		Thread.sleep(1000);
		logger17.log(Status.PASS,"1 "+pra_name_error_text);
		String demo_error_text=demo_error.getText();
		Thread.sleep(1000);
		logger17.log(Status.PASS, "2 "+demo_error_text);
		String countryatrisk_error_text=countryatrisk_error.getText();
		Thread.sleep(1000);
		logger17.log(Status.PASS, "3 "+countryatrisk_error_text);
		String title_error_text=title_error.getText();
		Thread.sleep(1000);
		logger17.log(Status.PASS, "4 "+title_error_text);
		//Fill out fields and make sure data saved
		//Check for manually adding a pest 
		pestname.sendKeys(Pestname);
		Thread.sleep(1000);
				
		logger17.log(Status.PASS, "pestname_abc got entered in pestname textbox");
				
		add.click();
		logger17.log(Status.PASS, "Add button got clicked");
		Thread.sleep(1000);
		remove.click();
		logger17.log(Status.PASS, "Remove button got clicked and pest got removed");
		Thread.sleep(1000);
		
	    //Check adding a pest using the lookup
		searchpestname.sendKeys("pratylenchus");
		logger17.log(Status.PASS, "pratylenchus text entered in pest search box");
		Thread.sleep(15000);
		
		List<WebElement>search_item=wd.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		int count=search_item.size();
		logger17.log(Status.PASS, count+" Pest search result");
		int j=1;
		for(WebElement search :search_item)
		{
			String search_option=search.getText();
			logger17.log(Status.PASS, j+" "+search_option);
			j++;
		}
		
		pratylenchus.click();
		Thread.sleep(1000);
		logger17.log(Status.PASS, "pratylenchus pest is selected ");
		
		yes_button.click();
		Thread.sleep(1000);
		logger17.log(Status.PASS, "Is this a demo or test PRA-yes button got clicked");
		Select s1=new Select(wd.findElement(By.xpath("//select[@id='CountryAtRisk']")));
		
		s1.selectByVisibleText(Country_area_at_risk);
		Thread.sleep(1000);
		logger17.log(Status.PASS, "Country area at risk-India is selected");
		
		titel_PRA.sendKeys(Suggested_title_for_pra);
		logger17.log(Status.PASS, "Suggested title for PRa is- pratylenchus india");
		Thread.sleep(1000);
		
		  List<WebElement>calender=wd.findElements(By.xpath("//span[@class=\"glyphicon glyphicon-calendar\"]"));
		  int i=1;
		  for(WebElement cal : calender) 
		  { 
			  if(i==1) 
			  { 
			  cal.click(); 
			  Thread.sleep(2000);
		      WebElement date1=wd.findElement(By.xpath("//td[@class='today day']"));
		      String Pra_start_d=date1.getText();
			  calender_bypest_prev(Pra_start_month,date1);
		
			  Thread.sleep(1000);
			  logger17.log(Status.PASS, "start date selected-"+Pra_start_d+" "+Pra_start_month);
		      } 
			  else if(i==2) 
			  { 
				  Thread.sleep(4000); 
				  cal.click(); 
				//  WebElement date2=wd.findElement(By.xpath("//td[@class='day' and text()='"+Pra_due_date+"']"));
				  calender_bypest_next(Pra_due_month,Pra_due_date);
				  Thread.sleep(2000);
				  logger17.log(Status.PASS, "PRA due date selected-"+ Pra_due_date+" "+Pra_due_month);
		  
		      } 
			  i++;
	     }
		 
		
		pra_area.sendKeys(Pra_area);
		Thread.sleep(2000);
		logger17.log(Status.PASS, "PRA area-UK is entered");
		scop.sendKeys("Airlines");
		Thread.sleep(2000);
		logger17.log(Status.PASS, "Define scope of PRA-Airlines is entered ");
		Select s2=new Select(wd.findElement(By.xpath("//select[@id='ReasonForPra']")));
		Thread.sleep(2000);
		s2.selectByVisibleText("Demo or test PRA");
		Thread.sleep(2000);
		logger17.log(Status.PASS, "Reason of PRA-Demo or test PRA is selected");
		yesprevious.click();
		logger17.log(Status.PASS, "Do previous PRAs exist for this pest- Yes button got clicked");
		Thread.sleep(1000);
		details_previous_pra.sendKeys("abc");
		Thread.sleep(500);
		details_other_previous_pra.sendKeys("abc");
		Thread.sleep(1000);
		
		Noprevious.click();
		Thread.sleep(2000);
		logger17.log(Status.PASS,"Do previous PRAs exist for this pest- No button got clicked");
		reference_icon.click();
		Thread.sleep(3000);
		logger17.log(Status.PASS, "Reference icon got clicked");
		
	
		wd.switchTo().frame(0);
		Thread.sleep(1000);
		reference_textbox.sendKeys("Text entered -First reference");
		logger17.log(Status.PASS,"Reference got entered");
		Thread.sleep(1000);
		wd.switchTo().defaultContent();
		Thread.sleep(1000);
		save_button.click();
		
		logger17.log(Status.PASS,"Save button got clicked and pest saved succussfully");
		Thread.sleep(3000);
		
	}
	
	
	@FindBy(linkText = "0_automation_PRA")WebElement automation_team;
	@FindBy(xpath="//div[@class='noneditable-overlay non-editable']")WebElement non_editable;
	@FindBy(xpath="//p[@class='non-editable-message']")WebElement non_editable_popup;
	@FindBy(xpath="//button[text()='Ok']")WebElement ok_button;
	@FindBy(linkText = "Home")WebElement home;
	public void re_edit_initiation_form(String createdpra) throws InterruptedException
	{
		logger17.log(Status.PASS, "-----------------Re-edit By pest initiation form----------------");
		automation_team.click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		logger17.log(Status.PASS, "0_automation team link got clicked");
		WebElement created_PRA=wd.findElement(By.linkText(createdpra));
		String pra_name=created_PRA.getText();
		created_PRA.click();
		Thread.sleep(3000);
		logger17.log(Status.PASS, pra_name+" is created successfully in 0_automation team");
		non_editable.click();
		Thread.sleep(2000);
		logger17.log(Status.PASS, "Non editable Gray out area got clicked");
		String non_editable_popup_text=non_editable_popup.getText();
		logger17.log(Status.PASS," Popup message is- "+non_editable_popup_text);
		ok_button.click();
		Thread.sleep(3000);
		home.click();
		Thread.sleep(3000);
		System.out.println("By Pest PRA created successfully");
	}
	
		
	
	public static void calender_bypest_prev(String month,WebElement date_to_click) throws InterruptedException
		 {
			 Thread.sleep(2000);
			 while(true)
			 {
				String month_cal=wd.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tr[2]//th[2]")).getText();
				 if(month_cal.equalsIgnoreCase(month))
				 {
					break; 
				 }
				 else
				 {
					 
					 WebElement previous_icon=wd.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//thead//tr[2]//th[1]"));
					 previous_icon.click(); 
					 Thread.sleep(1000);
				 }
				 
					 
				 
			 } 
					
				Thread.sleep(2000); 
			    date_to_click.click();
			 
			 
	}
		 
		 public static void calender_bypest_next(String month,String Pra_due_date_new) throws InterruptedException
		 {
			 Thread.sleep(2000);
			 while(true)
			 {
				String month_cal=wd.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tr[2]//th[2]")).getText();
				 if(month_cal.equalsIgnoreCase(month))
				 {
					break; 
				 }
				 else
				 {
					 
					 WebElement next_icon=wd.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//thead//tr[2]//th[3]"));
					 next_icon.click(); 
					 Thread.sleep(1000);
				 }
				 
					 
				 
			 } 
				WebElement date_to_click_new=wd.findElement(By.xpath("//td[@class='day' and text()='"+Pra_due_date_new+"']"));
				Thread.sleep(2000); 
			    date_to_click_new.click();
			 
			 
	}

}
