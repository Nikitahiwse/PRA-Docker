package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pra_package.PRA_Home;

import java.util.List;

public class Bypest_Probability_of_entry extends PRA_Home{
	 static JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement team;
	@FindBy(xpath="//input[@Value='Next']")WebElement Next_button;
	@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	@FindBy(xpath="//li[@class='active']//a[text()='Probability of entry']")WebElement subheading;
	@FindBy(xpath="//a[@class='btn btn-pra-red margin-top-30']")WebElement add_pathway_button;
	@FindBy(xpath="//select[@name='PathwayTypeID']")WebElement select_pathway;
    @FindBy(xpath="//div[@class='pathway-desc-box']//textarea")WebElement pathway_description;
    @FindBy(xpath="//body[@data-id='Summary_Questions_0__Notes']//p")WebElement textbox_ques1;
    @FindBy(xpath="//body[@data-id='Summary_Questions_1__Notes']//p")WebElement textbox_ques2;
    @FindBy(xpath="//body[@data-id='Summary_Questions_2__Notes']//p")WebElement textbox_ques3;
    @FindBy(xpath="//body[@data-id='Summary_Questions_3__Notes']//p")WebElement textbox_ques4;
    @FindBy(xpath="//body[@data-id='Summary_SummaryNotes']//p")WebElement summary;
    @FindBy(xpath="//input[@id='Summary_IsPathwayMajorMinor' and @Value='1']")WebElement major_radio_button;
    @FindBy(xpath="//input[@id='Summary_IsManagementMeasure' and @Value='1']")WebElement yes_botton;
    @FindBy(xpath="//input[@id='Summary_IsManagementMeasure' and @Value='0']")WebElement No_button;
    @FindBy(xpath="//div[6]//div[@class='references']//h1//a//span")WebElement reference_icon;
    @FindBy(xpath="//p[@class='question-text']//label[text()='Do you consider this pathway a major or a minor pathway? ']")WebElement radio1;
    @FindBy(xpath="//p[@class='question-text']//label[text()='Does this pathway require management measures? ']")WebElement radio2;
    @FindBy(xpath="//span[@class='glyphicon glyphicon-remove']")WebElement cancel_button;
    @FindBy(xpath="//div[@class='col-sm-12 text-right']//input[@value='Save']")WebElement save_btn;
	
    public void riskassesmenttab(String PRA) throws InterruptedException
    {
    	team.click();
		Thread.sleep(3000);
		
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		WebElement created_pra=wd.findElement(By.linkText(PRA));
		created_pra.click();
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(3000);
		Next_button.click();
		Thread.sleep(2000);
		logger19.log(Status.PASS, "Next button got clicked to switch from intiation to categorization tab");
		
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		Next_button.click();
		logger19.log(Status.PASS, "Next button got clicked to switch from categorization to Risk assessment tab");
    }
    
    
    
    public void add_pathway(String pathwayname) throws InterruptedException
	{
    	logger19.log(Status.PASS, "-------------Add Pathway Test for --------- "+pathwayname);
		
		// for getting text of header
		Thread.sleep(2000);
		String tab_header_text=tab_header.getText();
		logger19.log(Status.PASS, tab_header_text +" is opened");
		Thread.sleep(1000);
		
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		String sub_heading_text=subheading.getText();
		logger19.log(Status.PASS, sub_heading_text+" is opened");
		Thread.sleep(3000);
		add_pathway_button.click();
		Thread.sleep(7000);
		logger19.log(Status.PASS, "Add Pathway button got clicked");
		if(pathwayname.equalsIgnoreCase("Seeds for planting"))
		{
		List<WebElement> cancel_buttons=wd.findElements(By.xpath("//span[@class='glyphicon glyphicon-remove']"));
		int k=1;
		for(WebElement cancel: cancel_buttons)
		{
			if(k==2)
			{
			cancel.click();
			}
			k++;
		}
		}
		else {
		cancel_button.click();
		}
		Thread.sleep(2000);
		logger19.log(Status.PASS, "Cancel icon got clicked and Add pathway page got closed ");
		
		
		add_pathway_button.click();
		
		Thread.sleep(8000);
		logger19.log(Status.PASS, "Add Pathway button got clicked");
		Select s=new Select(select_pathway);
		s.selectByVisibleText(pathwayname);
		Thread.sleep(1000);
		logger19.log(Status.PASS, "Plants for planting got selected");
		pathway_description.sendKeys("abc");
		logger19.log(Status.PASS, "Pathway description is added- abc");
		Thread.sleep(1000);
		
		
		wd.switchTo().frame(2);
		Thread.sleep(2000);
	
		dropdown_and_text(textbox_ques1,0);
		wd.switchTo().frame(3);
		Thread.sleep(2000);
		dropdown_and_text(textbox_ques2,1);
		wd.switchTo().frame(4);
		Thread.sleep(2000);
		dropdown_and_text(textbox_ques3,2);
		
		wd.switchTo().frame(5);
		Thread.sleep(2000);
		dropdown_and_text(textbox_ques4,3);
		
		//for summary
		
		Select s1=new Select(wd.findElement(By.xpath("//select[@id='Summary_SummaryRatingId']")));
		s1.selectByValue("3");
		Thread.sleep(1000);
		logger19.log(Status.PASS, "Medium got selected in summary rating");
		Select s2=new Select(wd.findElement(By.xpath("//select[@id='Summary_SummaryConfidenceLevelID']")));
		s2.selectByValue("3");
		logger19.log(Status.PASS, "High got selected in summary confidence level");
		Thread.sleep(2000);
		
		wd.switchTo().frame(6);
		Thread.sleep(1000);
		summary.sendKeys("xyz");
		logger19.log(Status.PASS, "Text got entered in summary textbox- xyz");
		wd.switchTo().defaultContent();
		Thread.sleep(1000);
		
		String radio1q=radio1.getText();
	
		major_radio_button.click();
		Thread.sleep(1000);
		
		logger19.log(Status.PASS, radio1q+" - Major got selected");
		//for Plants for planting pathway -Does this pathway require management measures? for yes
		if(pathwayname.equalsIgnoreCase("Plants for planting"))
		{
		String radio2q=radio2.getText();
		yes_botton.click();
		Thread.sleep(1000);
		
		logger19.log(Status.PASS, radio2q+" - yes got selected");
		Thread.sleep(3000);
		}
		//for Plants for seed pathway -Does this pathway require management measures? for No
		else if(pathwayname.equalsIgnoreCase("Seeds for planting"))
		{
			String radio2q=radio2.getText();
			No_button.click();
			Thread.sleep(1000);
			
			logger19.log(Status.PASS, radio2q+" - No got selected");
			Thread.sleep(3000);	
		}
		/*reference_icon.click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,300)", "");
		wd.switchTo().frame(7);
		
		List<WebElement> ref=wd.findElements(By.xpath("//body[@id='tinymce']//p[text()='Text entered -First reference']"));
		int i=1;
		for(WebElement r : ref)
		{
			Thread.sleep(1000);
			String r_text=r.getText();
			
			if(i==1)
			{
			
				if(r_text.equalsIgnoreCase("Text entered -First reference"))
				{
					logger19.log(Status.PASS, "Reference is present - "+ r_text);
				}
				
			}
			i++;
			
		}
		
		wd.switchTo().defaultContent();
		;*/
		Thread.sleep(3000);
		save_btn.click();
		Thread.sleep(8000);
		logger19.log(Status.PASS, "Save button got clicked and pathway added successfully");
		
	}
	
	public static void dropdown_and_text(WebElement textbox_q1,int i) throws InterruptedException
	{
		int c= i+1;
		
		Thread.sleep(2000);
		textbox_q1.sendKeys("xyz");
		Thread.sleep(1000);
		logger19.log(Status.PASS, "Text got entered xyz in answer for question "+ c);
		wd.switchTo().defaultContent();
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Select s1=new Select(wd.findElement(By.xpath("//select[@name='Summary.Questions["+i+"].RatingId']")));
		s1.selectByValue("3");
		logger19.log(Status.PASS, "Medium got selected in rating for question "+ c);
		Thread.sleep(2000);
		Select s2=new Select(wd.findElement(By.xpath("//select[@name='Summary.Questions["+i+"].ConfidenceLevelID']")));
		s2.selectByValue("3");
		Thread.sleep(2000);
		logger19.log(Status.PASS, "High got selected in confidence level for question "+ c);
		
		
		
	}
	@FindBy(linkText = "3. Risk management")WebElement risk_management_tab;
	//@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	@FindBy(xpath="//div[@class='col']//button[text()='View pathway description']")WebElement view_pathway_desc_button;
	@FindBy(xpath="//div[@class='col']//h3")WebElement name_of_pathway;
	@FindBy(xpath="//div[@class='popover-content']")WebElement desc_pathway;
	@FindBy(xpath="//a[@class='close']")WebElement close;
	@FindBy(linkText="2. Risk assessment")WebElement risk_assessment_tab;
	@FindBy(linkText = "Home")WebElement home;
	public void check_tab_risk_management(String pathwayname) throws InterruptedException
	{
		if(pathwayname.equalsIgnoreCase("Plants for planting"))
		{
		logger19.log(Status.PASS, "---------------------Risk management Test: Record added should be visible for "+pathwayname);
		Thread.sleep(1000);
		}
		else
		{
		logger19.log(Status.PASS, "---------------------Risk management Test: Record added should not be visible for "+pathwayname);
			Thread.sleep(1000);
		}
		risk_management_tab.click();
		Thread.sleep(2000);
		logger19.log(Status.PASS, "Risk management tab got clicked");
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		String tab_header_text=tab_header.getText();
		logger19.log(Status.PASS, tab_header_text+" is opened");
		
		List<WebElement>pathway=wd.findElements(By.xpath("//div[@class='col']"));
		int count=pathway.size();
		int j=1;
		if(pathwayname.equalsIgnoreCase("Seeds for planting"))
		{
			if(count==2)
			{
				logger19.log(Status.PASS, pathwayname +"is not visisble");
			}
		}
		else if(pathwayname.equalsIgnoreCase("Plants for planting"))
		{
		
		for(WebElement p : pathway)
		{
			if(j==1)
			{
			String pathway_name=p.getText();
			if(pathway_name.equalsIgnoreCase("Plants for planting"))
			{
				logger19.log(Status.PASS, pathway_name+" is visible in risk management tab");
				
			}
			}
			
			j++;
			
		}
		
		
		Thread.sleep(2000);
		view_pathway_desc_button.click();
		Thread.sleep(2000);
		logger19.log(Status.PASS, "View pathway description button got clicked");
		
		String name_of_pathway_text=name_of_pathway.getText();
		logger19.log(Status.PASS, "Name of pathway is "+ name_of_pathway_text);
		
		String desc_pathway_text=desc_pathway.getText();
		logger19.log(Status.PASS, "Description of pathway is "+ desc_pathway_text);
		
		Thread.sleep(2000);
		
		close.click();
		logger19.log(Status.PASS, "Cancel button got clicked");
		}
		Thread.sleep(2000);
		
		risk_assessment_tab.click();
		Thread.sleep(3000);
		logger19.log(Status.PASS, "Risk assessment tab got clicked");
		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-pra-red' and text()=' Export to Word']")WebElement Export;
	@FindBy(xpath="//a[@class='btn btn-pra-red' and text()=' Import from Word']")WebElement import_file;
	@FindBy(xpath="//input[@id='ImportFile']")WebElement choose_file;
	@FindBy(linkText="Upload")WebElement upload;
	@FindBy(xpath="//span[@id='ImportFile-error']")WebElement import_file_error;
	@FindBy(xpath="//input[@value='Cancel']")WebElement cancel_btn;
	@FindBy(xpath="//div[@class='col-sm-12']//p[@class='margin-bottom-30 about message1']")WebElement warning_message;
	@FindBy(xpath="//input[@class='btn btn-pra-red' and @value='Continue']")WebElement continue_button;
	@FindBy(xpath="//input[@class='btn btn-default' and @value='OK']")WebElement ok;
	public void export_import() throws InterruptedException
	{
		
		
		logger19.log(Status.PASS, "----------------Import Export Test-------------");
		Thread.sleep(3000);
		Export.click();
		Thread.sleep(5000);
		logger19.log(Status.PASS, "File is exported successfully");
		
		import_file.click();
		Thread.sleep(2000);
		
		upload.click();
		Thread.sleep(1000);
		
		String error_text=import_file_error.getText();
		if(error_text.equalsIgnoreCase("Select file to upload"))
		{
			logger19.log(Status.PASS, " Error should present withoud selecting any file- "+error_text);
		}
		Thread.sleep(1000);
		
		choose_file.sendKeys(System.getProperty("user.dir")+"/Import_files/fileabc.docx");
			
		Thread.sleep(3000);
		upload.click();
		Thread.sleep(5000);
		String warning_msg=warning_message.getText();
		logger19.log(Status.PASS, "Warning message should display "+ warning_msg );
		Thread.sleep(3000);
		cancel_btn.click();
		Thread.sleep(3000);
		upload.click();
		Thread.sleep(2000);
		logger19.log(Status.PASS, "File is uploded successfully");
		continue_button.click();
		Thread.sleep(2000);
		String text_war=wd.findElement(By.xpath("//div[@class='col-sm-12']//p[@class='margin-bottom-20 about message']")).getText();
		logger19.log(Status.PASS, "Error message is -"+ text_war);
		
		
		logger19.log(Status.PASS, "File is not imported");
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[@id='modalimportassessment']//div[@class='modal-header']//button[@class='close pull-right']")).click();

		
		
	}
	@FindBy(xpath="//input[@class='btn btn-pra-red' and @value='Next']")WebElement next;
	@FindBy(xpath="//input[@class='btn btn-pra-green' and @value='Save']")WebElement save;
	public void save() throws InterruptedException
	{
		Thread.sleep(3000);
		save.click();
		Thread.sleep(2000);
		next.click();
		Thread.sleep(2000);
	}
	
	
	

}
