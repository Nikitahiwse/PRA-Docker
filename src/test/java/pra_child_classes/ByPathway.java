package pra_child_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class ByPathway extends PRA_Home {
	
	
	
	@FindBy(linkText = "ABC")
	WebElement team;
		
	@FindBy(linkText = "By Pathway")
	WebElement pathway;
	
	@FindBy(id="Title")
	WebElement title;
	
	@FindBy(xpath="//*[@id=\"initiation-form\"]/div[2]/div[2]/label[1]")
	WebElement select_option;
	
	@FindBy(id="PRAArea")
	WebElement area;
	
	@FindBy(id="Scope")
	WebElement transport;
	
	@FindBy(id="VolumeOrQuantity")
	WebElement quantity;
	
	@FindBy(id="ExportingCountry")
	WebElement exportcountry;
	
	@FindBy(name="ImportingCountry")
	WebElement importcountry;
	
	@FindBy(id="CropBeingImported")
	WebElement search_crop;
	
	@FindBy(xpath="//a[@class='ui-corner-all ui-menu-item-wrapper' and text()='Prunus persica (']")
	WebElement click_crop;
	
	@FindBy(xpath="//input[@class='ga_CommodityType_Leaves']")
	WebElement leaves;
	
	//@FindBy(xpath = "//input[@name='PreviousPraExists'][1]")
	//@FindBy(xpath = "//input[@name='PreviousPraExists' and @value='True']")
	@FindBy(xpath = "//div[@class='switch-field']//label[text()='Yes']")
	WebElement Previous_PRA;
	
	@FindBy(name = "PreviousPRAsForPathwayNotes")
	WebElement details;
	
	@FindBy(name="Notes")
	WebElement note;
	
	@FindBy(xpath="//input[@value='Generate Pest List']")
	WebElement button;

	
	//Group of pest
	
		
	@FindBy(xpath="//button[@class='btn btn-pra-red btn-generate-options btn-submit-form' and text()='Select groups of pests']")
	WebElement group_button;
	
	@FindBy(xpath="//*[@id='tblAllCategory']/tbody/tr[1]/td/div/label/span")
	WebElement plant;
	
	@FindBy(xpath="//*[@id=\"tblAllCategory\"]/tbody/tr[3]/td/div/label/span")
	WebElement virus;
	
	@FindBy(xpath="//*[@id=\"tblAllCategory\"]/tbody/tr[4]/td/div/label/span")
	WebElement Fungi;
	
	@FindBy(xpath="//*[@id=\"tblAllCategory\"]/tbody/tr[5]/td/div/label/span")
	WebElement invertebrates;
	
	@FindBy(xpath="//button[@class='btn step1 btn-pra-red']")
	WebElement confirm_selection;
	
	@FindBy(xpath="//button[@class='btn step2 btn-pra-red btn-submit-form']")
	WebElement Generate_List;
	
	@FindBy(linkText = "Home")
	WebElement home;
	
	
	
	//Generate full list
	
	@FindBy(xpath="//button[@class='btn btn-pra-red btn-generate-options btn-submit-form' and text()='Generate full list']")
	WebElement full_list;
	
	
	
	public void Initiation(String Title) throws Throwable {
		
		team.click();
		Logger9.log(Status.PASS, "Clicked on team");
		
		Thread.sleep(3000);
		pathway.click();
		Logger9.log(Status.PASS, "By Pathway clicked successfully");
		
		title.sendKeys(Title);
		Logger9.log(Status.PASS, "Title of PRA");
		
		select_option.click();
		area.sendKeys("India");
		Logger9.log(Status.PASS, "Area where PRA is being conducted");
		
		transport.sendKeys("Airlines");
		Logger9.log(Status.PASS, "Modes of transport should be entered");
		
		quantity.sendKeys("50 tns");	
		Logger9.log(Status.PASS, "Quantity entered successfully");
		
		Thread.sleep(2000);
		exportcountry.click();
		
		Select country = new Select(exportcountry);
		country.selectByValue("1269750");
		Logger9.log(Status.PASS, "Export country selected successfully");
		
		Thread.sleep(2000);
		importcountry.click();
		
		Select country1 = new Select(importcountry);
		country1.selectByValue("2077456");
		Logger9.log(Status.PASS, "Import country selected successfully");
		
		search_crop.sendKeys("peach");
		Logger9.log(Status.PASS, "Crop searched successfully");
		
		Thread.sleep(6000);
		click_crop.click();
		Logger9.log(Status.PASS, "Search Crop selected successfully");
		
		
		Thread.sleep(3000);
		leaves.click();
		Logger9.log(Status.PASS, "leaves checkbox selected successfully");
		
		Thread.sleep(3000);
		Previous_PRA.click();
		
		Thread.sleep(2000);
		details.sendKeys("Abc");
		
		Thread.sleep(3000);
		note.sendKeys("commodity selected");
		Logger9.log(Status.PASS, "Notes should be written if any");
		
		Thread.sleep(5000);
		button.click();
		Logger9.log(Status.PASS, "Pest List Generated successfully");
		
		Thread.sleep(5000);
		
		
		
	
		
		

}
	
	public void group_of_pest() throws Throwable
	{
		group_button.click();
		Logger9.log(Status.PASS, "Group of pest button clicked successfully");
		
		Thread.sleep(3000);
		plant.click();
		Logger9.log(Status.PASS, "plant checkbox should get unchecked");
		
		Thread.sleep(3000);
		virus.click();
		Logger9.log(Status.PASS, "virus checkbox should get unchecked");
		
		Thread.sleep(3000);
		Fungi.click();
		Logger9.log(Status.PASS, "Fungi checkbox should get unchecked");
		Thread.sleep(3000);
		invertebrates.click();
		Logger9.log(Status.PASS, "Invertebrates checkbox should get unchecked");
		
		Thread.sleep(3000);
		confirm_selection.click();
		Logger9.log(Status.PASS, "Confirm Button got clicked successfully");
		
		Thread.sleep(5000);
		Generate_List.click();
		Logger9.log(Status.PASS, "Generate List Button got clicked successfully");
		
		Thread.sleep(3000);
		home.click();
		Logger9.log(Status.PASS, "Return to Home Page ");
		
		Thread.sleep(5000);
	}
	
	public void generate_full_list() throws Throwable
	{
		full_list.click();
		Logger9.log(Status.PASS, "Full List Button got clicked successfully");
		Thread.sleep(5000);
	}
	
}


