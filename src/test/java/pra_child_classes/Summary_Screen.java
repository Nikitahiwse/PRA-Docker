package pra_child_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Summary_Screen extends PRA_Home{

	@FindBy(linkText = "3. Pest risk analysis summary")
	WebElement analysis_summary_tab;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[4]/div/div/div/div/div/form/div[1]/div/div/div[1]/div/a")
	WebElement summarynote_edit;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[9]/div[1]/div/form/div/div[2]/div[1]/div/div[2]/iframe")
	WebElement iframe;
	
	@FindBy(xpath = "(//body[@id='tinymce' and @class='mce-content-body editor-body'])[1]")
	WebElement edit_summarynote;
	
	@FindBy(xpath = "//button[@class='btn-pra-red btn-references' and text()='Save']")
	WebElement save;
	
	
	//Next Steps Edit
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[4]/div/div/div/div/div/form/div[1]/div/div/div[2]/div/a")
	WebElement nextsteps_edit;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[9]/div[1]/div/form/div/div[2]/div[1]/div/div[2]/iframe")
	WebElement nextsteps_frame;
	
	@FindBy(xpath = "(//body[@id='tinymce' and @class='mce-content-body editor-body'])[1]")
	WebElement edit_next_summarynote;
	
	@FindBy(xpath = "//*[@id=\"initiation-form\"]/div/div[3]/button[2]")
	WebElement nextsteps_save;
	
	
	
	
	//Contact Details
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[4]/div/div/div/div/div/form/div[1]/div/div/div[3]/div/a")
	WebElement contact_edit;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[9]/div[1]/div/form/div/div[2]/div[1]/div/div[2]/iframe")
	WebElement contact_frame;
	
	@FindBy(xpath = "(//body[@id='tinymce' and @class='mce-content-body editor-body'])[1]")
	WebElement edit_contact_summarynote;
	
	@FindBy(xpath = "//button[@class='btn-pra-red btn-references']")
	WebElement contact_save;
	
	@FindBy(xpath = "//a[@class='btn btn-pra-green ga_SaveAndReturnToPestList']")
	WebElement return_to_pestlist;
	
	
	
	
	
	
	
	public void summary_content() throws Throwable {

		analysis_summary_tab.click();
		Logger13.log(Status.PASS, "Analysis Summary Tab Should Get Clicked");
		
		Thread.sleep(3000);
		summarynote_edit.click();
		Logger13.log(Status.PASS, "Edit button should be clickable");
		
		Thread.sleep(3000);
		wd.switchTo().frame(iframe);
		System.out.println(wd.getTitle());
		Thread.sleep(3000);
		
		edit_summarynote.sendKeys("xyz");
		Logger13.log(Status.PASS, "User should be able to edit summary note");
		
		Thread.sleep(3000);
		wd.switchTo().defaultContent();
		Thread.sleep(4000);
		save.click();
		Logger13.log(Status.PASS, "Save button got clicked successfully");
		Thread.sleep(3000);
		
		
		
		nextsteps_edit.click();
		Logger13.log(Status.PASS, "Edit button should be clickable");
		
		Thread.sleep(3000);
		wd.switchTo().frame(nextsteps_frame);
		
		Thread.sleep(3000);
		
		edit_next_summarynote.sendKeys("abc");
		Logger13.log(Status.PASS, "User should be able to edit summary note");
		
		Thread.sleep(4000);
		wd.switchTo().defaultContent();
		Thread.sleep(3000);
		
		nextsteps_save.click();
		Logger13.log(Status.PASS, "Save button got clicked successfully");
		Thread.sleep(5000);
		
		
		
		
		//contact
		
		Thread.sleep(4000);
		contact_edit.click();
		Logger13.log(Status.PASS, "Edit button should be clickable");
		
		Thread.sleep(4000);
		wd.switchTo().frame(contact_frame);
		System.out.println(wd.getTitle());
		
		Thread.sleep(3000);
		edit_contact_summarynote.sendKeys("xyz");
		Logger13.log(Status.PASS, "User should be able to edit summary note");
		
		Thread.sleep(4000);
		wd.switchTo().defaultContent();
		
		contact_save.click();
		Logger13.log(Status.PASS, "Save button got clicked successfully");
		Thread.sleep(3000);
		
		return_to_pestlist.click();
		Thread.sleep(5000);
		
		}

}
