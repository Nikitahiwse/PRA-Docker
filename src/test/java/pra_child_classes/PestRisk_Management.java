package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.Set;

public class PestRisk_Management extends PRA_Home {      //Apate monachus (black borer)

	
	@FindBy(xpath="//a[@class='ga_PestList_Tab_RiskManagement']")
	WebElement pest_management_tab;
	
	@FindBy(xpath="//*[@id=\"PestListGridManagement\"]/table/tbody/tr/td[12]/a")
	WebElement user_actions;
	
	@FindBy(xpath="//a[@class='ga_UserActions_GoToAndCompleteRiskManagement']")
	WebElement complete_risk_management;
	
		
	@FindBy(xpath="//input[@value='Save and return to pest list' and @class='btn-pra-red']")
	WebElement save_return_to_pestlist;
	
	@FindBy(xpath="//*[@id='PestListGridManagement']/table/tbody/tr/td[12]/a")
	WebElement user_actions_tab;
	
	@FindBy(xpath="//*[@id=\"divpopup\"]/ul/li[3]/a")
	WebElement add_notes;
	
	@FindBy(name="Notes")
	WebElement write_note;
	
	@FindBy(xpath="//*[@id=\"divpopup\"]/form/div[3]/input")
	WebElement save;
	
	@FindBy(xpath="//*[@id=\"PestListGridManagement\"]/table/tbody/tr/td[12]/a")
	WebElement useractions;
	
	@FindBy(xpath="//a[@class='ga_UserActions_ViewDatasheet']")
	WebElement view_datasheet;
	
	/*
	 * @FindBy(xpath = "//iframe[@class='sigma-iframe']") WebElement iframe;
	 * 
	 * @FindBy(xpath = "//div[@class='access-inner']//a[@tabindex='100']")
	 * WebElement Log_in_via_email_username;
	 * 
	 * @FindBy(id="username") WebElement username;
	 * 
	 * @FindBy(id="password") WebElement password;
	 * 
	 * @FindBy(xpath="//button//span[text()='Log in']") WebElement login;
	 */
	
	@FindBy(xpath="//a[@class='k-button k-bare k-button-icon k-window-action']")
	WebElement close;
	
	
	//Risk Management Tab
	
	@FindBy(xpath="//*[@id='PestListGridManagement']/table/tbody/tr/td[12]/a")
	WebElement user_action;
	
	@FindBy(xpath = "//a[@class='ga_UserActions_GoToAndCompleteRiskManagement']")
	WebElement go_to_risk_management;
	
	//@FindBy(xpath="//*[@id=\"tab5\"]/div[1]/label/span")
	@FindBy(xpath = "//input[@class='check-box' and @name='RiskManagementSections[0].RiskManagementQuestions[0].Selected']")
	WebElement checkbox_selected;
	
	@FindBy(xpath = "//iframe[@id='RiskManagementSections_0__RiskManagementQuestions_0__Notes_ifr']")
	WebElement frame;
	
	@FindBy(xpath = "//body[@id='tinymce' and @data-id='RiskManagementSections_0__RiskManagementQuestions_0__Notes']")
	WebElement text;
	
	@FindBy(xpath = "//iframe[@id='SummaryNotes_ifr']")
	WebElement iframe_summarynote;
	
	@FindBy(xpath = "//body[@id='tinymce' and @data-id='SummaryNotes']")
	WebElement summary_note;
	
	@FindBy(xpath = "//input[@class='btn-pra-red' and @value='Save and return to pest list']")
	WebElement return_to_pestlist;
	
	
	
	
	
	
	
	
	
	
	
	
	public void pest_management(String cpc_username, String cpc_password) throws Throwable {
		
		Thread.sleep(3000);
		pest_management_tab.click();
		Logger12.log(Status.PASS, "Pest Management Tab Should be Clicked");
		
		Thread.sleep(3000);
		user_actions.click();
		Logger12.log(Status.PASS, " User Action Button Should beClicked");
		
		Thread.sleep(3000);
		complete_risk_management.click();
		Logger12.log(Status.PASS, "Click on Complete Risk Management");
				
		Thread.sleep(8000);
		save_return_to_pestlist.click();
		Logger12.log(Status.PASS, "Clicked on Save & Return to Pest List");
		
		Thread.sleep(5000);
		user_actions_tab.click();
		Logger12.log(Status.PASS, "Click on user action tab");
		
		Thread.sleep(3000);
		add_notes.click();
		Logger12.log(Status.PASS, "Add Note option should be clicked");
		
		Thread.sleep(3000);
		write_note.sendKeys("xyz");
		Logger12.log(Status.PASS, "User should be able to write note");
		
		Thread.sleep(3000);
		save.click();
		Logger12.log(Status.PASS, "Once note written user should be able to click on Save botton and note should be saved");
		
		Thread.sleep(4000);
		useractions.click();
		Logger12.log(Status.PASS, "Click on user action tab");
		
		Thread.sleep(5000);
		view_datasheet.click();
		Logger12.log(Status.PASS, "Click on View datasheet tab");
		
		//Window Handling
		
		 String parent=wd.getWindowHandle();
		  System.out.println("parent window id is:"+parent);
		  System.out.println(wd.getTitle());
		
		 Set<String> allwindows = wd.getWindowHandles();
		 
		 int count = allwindows.size(); 
		 System.out.println("Total no of windows"+count);
		  
		  for(String child : allwindows)
		  {
			  if(!parent.equalsIgnoreCase(child))
			  {
				  wd.switchTo().window(child);
				  System.out.println("child window title is"+wd.getTitle());
				 
				  
				/*  Thread.sleep(3000); 
				  wd.switchTo().frame(iframe);
				  
				  Thread.sleep(3000);  
				   Log_in_via_email_username.click();  
				   Logger12.log(Status.PASS, "Log_in email_username tab should get clicked");
					  
					Thread.sleep(3000);
					username.sendKeys(cpc_username);
					Logger12.log(Status.PASS, "Enter Username");
					  
					Thread.sleep(2000);
					password.sendKeys(cpc_password);
					Logger12.log(Status.PASS, "Enter Password");
					  
					Thread.sleep(4000); 
					login.click();
					Logger12.log(Status.PASS, "Login button clicked Successfully"); */
					 
					Thread.sleep(8000);
					wd.close();
										
					  wd.switchTo().window(parent);
					  System.out.println("parent window title is:"+wd.getTitle());
					 
					
					Thread.sleep(3000);
					close.click();
					
					Thread.sleep(5000);
					
				 
			  }
		  }
		
		 
		  }
	
	 
	
				public void risk_management() throws Throwable
				{
					user_action.click();
					Logger12.log(Status.PASS, "User Action button should be clicked");
					
					Thread.sleep(3000);
					go_to_risk_management.click();
					Logger12.log(Status.PASS, "go to risk management tab should be clicked");
					
					Thread.sleep(4000);
					checkbox_selected.click();
					Logger12.log(Status.PASS, "Checkbox should be got selected");
					
					Thread.sleep(3000);
					wd.switchTo().frame(frame);
					
					Thread.sleep(3000);
					text.sendKeys("xyz");
					Logger12.log(Status.PASS, "User should be allowed to enter text");
					
					Thread.sleep(3000);
					wd.switchTo().defaultContent();	
					System.out.println(wd.getTitle());
					
					wd.switchTo().frame(iframe_summarynote);
					summary_note.sendKeys("inspection and testing selected");
					Logger12.log(Status.PASS, "User should be able to write summary note");
					wd.switchTo().defaultContent();
					System.out.println(wd.getTitle());
					
					Thread.sleep(4000);
					return_to_pestlist.click();
					Logger12.log(Status.PASS, "Return to pest list button got clicked successfully");
					
					Thread.sleep(4000);
					
				}
	
	
	       
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
   	    
	   
		

