package pra_child_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class User_Action extends PRA_Home {
	
	
	@FindBy(xpath="(//a[@class='k-grid-filter'])[1]")
	WebElement Risk_Assessment_Filter;
	
	@FindBy(xpath="//label[@class='k-label']//input[@value='4']")
	WebElement select_filter;
	
	@FindBy(xpath="//button[@class='k-button k-primary']")
	WebElement Filter_Button;
	

	@FindBy(xpath="//*[@id=\"PestListGridIncluded\"]/div/a[3]/span")
	WebElement next_page;
	
	@FindBy(xpath="//*[@id=\"PestListGridIncluded\"]/div/a[2]")
	WebElement previous_page;
	
	
	
	
	//Export_Import Pest dodder
	
	@FindBy(xpath="//*[@id=\"PestListGridIncluded\"]/table/tbody/tr[7]/td[12]/a")
	WebElement useraction_menu;
	
	
	@FindBy(xpath="//*[@id=\"divpopup\"]/ul/li[7]/a")  
	WebElement export_dodder;
	
	@FindBy(xpath="//a[@class='btn btn-pra-red btn-block docx margin-bottom-10']")
	WebElement download_template_dodder;
	
	@FindBy(xpath="//button[@class='btn-pra-gray']")
	WebElement close_dodder;
	
	@FindBy(xpath="//*[@id=\"PestListGridIncluded\"]/table/tbody/tr[8]/td[12]/a")   //wrong
	WebElement apple_leaf_usermenu;
	
	@FindBy(xpath="//*[@id=\"divpopup\"]/ul/li[8]/a")
	WebElement import_assessment;
	
	@FindBy(name="ImportFile")
	WebElement choose_file;
	
	@FindBy(xpath="//a[@class='btn btn-pra-red k-float-right']")
	WebElement import_on_leaf_upload;

	@FindBy(xpath="//*[@id='modalimportwarning']/div/div/div/div/div[2]/p[2]/input[2]")
	WebElement continue_warning;
	
	@FindBy(xpath="//input[@class='btn btn-default' and @value='OK']")
	WebElement ok;
	
	@FindBy(xpath="//a[@class='k-button k-bare k-button-icon k-window-action']")
	WebElement close;
	
	@FindBy(xpath="//*[@id=\"PestListGridIncluded\"]/table/tbody/tr[7]/td[12]/a")     //correct file
	WebElement dodder_menu;
	
	@FindBy(xpath="//*[@id=\"divpopup\"]/ul/li[8]/a")
	WebElement import_correct_file;
	
	@FindBy(name="ImportFile")
	WebElement choose_correctfile_import;
	
	@FindBy(xpath="//a[@class='btn btn-pra-red k-float-right' and text()='Upload']")
	WebElement correctfile_upload;
	
	@FindBy(xpath = "//*[@id=\"modalimportwarning\"]/div/div/div/div/div[2]/p[2]/input[2]")
	WebElement continue_upload;
	
	//@FindBy(xpath="//*[@id='modalimporterror']/div/div/div[1]/button")
	@FindBy(xpath = "(//button[@class='close pull-right'])[2]")
	WebElement close1;
	
	@FindBy(xpath="//a[@role='button' and @class='k-button k-bare k-button-icon k-window-action']")
	WebElement close2;
	
	@FindBy(xpath = "//*[@id=\"PestListGridIncluded\"]/table/tbody/tr[10]/td[12]/a")    //Drosophila suzukii (spotted wing drosophila)
	WebElement assessment;
	
	@FindBy(xpath = "//a[@class='ga_UserActions_ExcludeFromAssessment']")
	WebElement exclude_assessment;
	
	@FindBy(name = "ExcludeReasonId")
	WebElement select_clicked;
	
	@FindBy(xpath = "//select[@class='ga_ExcludeFromAssessmentReason']")
	WebElement exclude_reson;
	
	@FindBy(name = "Notes")
	WebElement notes;
	
	@FindBy(xpath = "//input[@class='btn btn-pra-green k-float-right ga_Save_ExcludeFromAssessment' and @value='Save']")
	WebElement save;
	
	@FindBy(xpath = "(//a[@class='viewButton ga_PestListGridIncluded_UserActions'])[13]")
	WebElement Frankliniella_useraction;
	
	@FindBy(xpath = "//a[@class='ga_UserActions_AddPestQuarantineStatus']")
	WebElement Add_regulatory_status;
	
	@FindBy(name = "PQStatus")
	WebElement regulatory_status;
	
	@FindBy(xpath = "//*[@id=\"divpopup\"]/form/div[2]/select")
	WebElement select_regulatory_status;
	
	@FindBy(xpath = "//input[@class='btn btn-pra-green k-float-right']")
	WebElement save_regulatory_status;
	
	@FindBy(xpath = "//*[@id=\"PestListGridIncluded\"]/table/tbody/tr[13]/td[12]/a")
	WebElement Frankliniella_useraction_again_click;
	
	@FindBy(xpath = "//a[@class='ga_UserActions_AddNotes']")
	WebElement add_notes;
	
	@FindBy(name = "Notes")
	WebElement write_note;
	
	@FindBy(xpath = "//*[@id=\"divpopup\"]/form/div[3]/input")
	WebElement Save_frankliniella_note;
	
	
	
	
	

	public void perform_action() throws Throwable 
	{
		Thread.sleep(6000);
		Risk_Assessment_Filter.click();
		Logger11.log(Status.PASS, "Risk Assessment Tab Filter Clicked Successfilly");
		
		Thread.sleep(2000);
		select_filter.click();
		Logger11.log(Status.PASS, "Risk Assessment Tab Filter should be Clicked and Option Should be got Selected");
		
		Thread.sleep(3000);
		Filter_Button.click();
		Logger11.log(Status.PASS, "Risk Assessment Tab Filter Button Clicked Successfilly");	
		
		Thread.sleep(5000);
		next_page.click();
		Logger11.log(Status.PASS, "It should moved to next page");
		
		Thread.sleep(3000);
		previous_page.click();
		Logger11.log(Status.PASS, "It should moved to Previous page");
		
	
	}
	
	
	
	public void export_import_pest() throws Throwable
	{
		Thread.sleep(3000);
		useraction_menu.click();
		Logger11.log(Status.PASS, "User Action Menu Should Get Clicked");
		
		Thread.sleep(3000);
		export_dodder.click();
		Logger11.log(Status.PASS, "Export Assessment Option should be clicked");
		
		Thread.sleep(3000);
		download_template_dodder.click();
		Logger11.log(Status.PASS, "Export Assessment Option should be clicked And Template Should be Downloaded");
		
		Thread.sleep(2000);
		close_dodder.click();
		
		Thread.sleep(3000);
	/*	apple_leaf_usermenu.click();
		Logger11.log(Status.PASS, "User Action Menu Should Get Clicked");
		
		Thread.sleep(3000);
		import_assessment.click();
		Logger11.log(Status.PASS, "Import Assessment Option should be clicked");
		
		Thread.sleep(3000);
		choose_file.sendKeys(System.getProperty("user.dir")+"\\Documents\\Wordform template for Cuscuta reflexa (dodder) (4).docx");
		Logger11.log(Status.PASS, "File Path Passed");
		
		Thread.sleep(5000);
		import_on_leaf_upload.click();        // wrong file upload
		Logger11.log(Status.PASS, "Upload Button should be clicked");
		
		Thread.sleep(5000);
		continue_warning.click();
		Logger11.log(Status.PASS, "Before Clicking On Continue Warning Should Be Displayed");
		
		Thread.sleep(5000);
		ok.click();
		Logger11.log(Status.PASS, "Once Uploaded Ok Button Should be clicked");
		
		Thread.sleep(2000);
		close.click();
		*/
		/*Thread.sleep(4000);
		dodder_menu.click();
		Logger11.log(Status.PASS, "User Action Menu Should Get Clicked");
		
		Thread.sleep(3000);
		import_correct_file.click();
		Logger11.log(Status.PASS, "Import Assessment Option should be clicked");
		
		Thread.sleep(3000);
		choose_correctfile_import.sendKeys(System.getProperty("user.dir")+"\\Documents\\Wordform template for Cuscuta reflexa (dodder) (4).docx");
		Logger11.log(Status.PASS, "File path Should Be Passed Which we Want to Upload");
		
		Thread.sleep(5000);
		correctfile_upload.click();
		Logger11.log(Status.PASS, "Upload Button Should Get Clicked");
		
		Thread.sleep(5000);
		continue_upload.click();
		Logger11.log(Status.PASS, "Before Clicking On Continue Warning Should Be Displayed");
		
		Thread.sleep(5000);
		close1.click();
		
		Thread.sleep(5000);
		close2.click();
		*/
		Thread.sleep(5000);
		
		//Drosophila suzukii (spotted wing drosophila)
		
		assessment.click();
		Logger11.log(Status.PASS, "Click on user assessment");
		
		Thread.sleep(3000);
		exclude_assessment.click();
		Logger11.log(Status.PASS, "It should be clicked on exclude assessment button");
		
		Thread.sleep(3000);
		select_clicked.click();
		
		Thread.sleep(3000);
		Select exclude= new Select(exclude_reson);
		exclude.selectByValue("5");
		Logger11.log(Status.PASS, "Reson should be selected before excluding");
		
		Thread.sleep(2000);
		notes.sendKeys("Absent in country");
		Logger11.log(Status.PASS, "Note should be entered");
		
		Thread.sleep(3000);
		save.click();
		Logger11.log(Status.PASS, "Save button should be clicked");
		
		Thread.sleep(4000);
		Frankliniella_useraction.click();
		Logger11.log(Status.PASS, "Click on Franklinieela assessment user action");
		
		Thread.sleep(3000);
		Add_regulatory_status.click();
		Logger11.log(Status.PASS, "User should be able to add regulatory status");
		
		Thread.sleep(3000);
		regulatory_status.click();
		
		Thread.sleep(3000);
		Select status= new Select(select_regulatory_status);
		status.selectByValue("2");
		Logger11.log(Status.PASS, "User should be able to select regulatory satus");
		
		Thread.sleep(3000);
		save_regulatory_status.click();
		Logger11.log(Status.PASS, "Once selected regulatory status it should get saved");
		
		Thread.sleep(4000);
		Frankliniella_useraction_again_click.click();
		Logger11.log(Status.PASS, "it shold click on frankliniella usser action button");
		
		Thread.sleep(3000);
		add_notes.click();
		Logger11.log(Status.PASS, "User should be able to click on add notes button");
		
		Thread.sleep(2000);
		write_note.sendKeys("xyz");
		Logger11.log(Status.PASS, "user should be able to add note");
		
		Thread.sleep(3000);
		Save_frankliniella_note.click();
		Logger11.log(Status.PASS, "After entering note it shold clicked on save button");
		
		Thread.sleep(5000);
	}
		
		
		
	

}
