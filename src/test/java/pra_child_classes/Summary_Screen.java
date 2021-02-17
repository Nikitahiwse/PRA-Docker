package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

public class Summary_Screen extends PRA_Home{

	@FindBy(xpath="/html/body/div[2]/div[3]/div[4]/div/ul/li[3]/a")
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
	
	/*@FindBy(xpath = "//a[@class='btn btn-pra-green ga_SaveAndReturnToPestList']")
	WebElement return_to_pestlist;
	*/
	@FindBy(css = ".ga_SaveAndReturnToPestList")WebElement return_to_pestlist;
	
	
	
	
	
	
	public void summary_content() throws Throwable {

		//analysis_summary_tab.click();
		WebElement element = analysis_summary_tab;
		Actions actions = new Actions(wd);
		actions.moveToElement(element).click().perform();
		Thread.sleep(5000);
		Logger13.log(Status.PASS, "Analysis Summary Tab Should Get Clicked");


		//code edited by nikita
	/*	List<WebElement> Edit_buttons=wd.findElements(By.xpath("//a[@class='btn-pra-red pull-right margin-top-10']"));
		int i=1;
		for(WebElement edit : Edit_buttons)
		{
			if(i==1) {
				edit.click();
				Logger13.log(Status.PASS,"Edit button clicked for summary");
				wd.switchTo().frame(iframe);
				System.out.println(wd.getTitle());
				Thread.sleep(3000);

				edit_summarynote.sendKeys("xyz");
				Logger13.log(Status.PASS, "User should be able to edit summary note");

				Thread.sleep(3000);
			}
			i++;
			wd.switchTo().defaultContent();
			Thread.sleep(4000);
			save.click();
			Logger13.log(Status.PASS, "Save button got clicked successfully");
			Thread.sleep(3000);
		}*/

		//Thread.sleep(3000);
		//summarynote_edit.click();
		//Logger13.log(Status.PASS, "Edit button should be clickable");
		
		//Thread.sleep(3000);
		/*wd.switchTo().frame(iframe);
		System.out.println(wd.getTitle());
		Thread.sleep(3000);
		
		edit_summarynote.sendKeys("xyz");
		Logger13.log(Status.PASS, "User should be able to edit summary note");
		
		Thread.sleep(3000);*/
		/*wd.switchTo().defaultContent();
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
		Thread.sleep(3000);*/
		//Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(wd, 10);
		//WebElement return_to_pest= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-pra-green ga_SaveAndReturnToPestList']")));
		//return_to_pest.click();
		Thread.sleep(5000);
		wd.navigate().refresh();
		Thread.sleep(3000);
		WebElement return_to_pest = wd.findElement(By.xpath("//a[@class='btn btn-pra-green ga_SaveAndReturnToPestList']"));
		//JavascriptExecutor executor = (JavascriptExecutor)wd;
		//executor.executeScript("arguments[0].click();", return_to_pest);
		return_to_pest.click();
		Logger13.log(Status.PASS, "Return to pestlist button got clicked successfully");
		}

}
