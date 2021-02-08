package pra_child_classes;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.List;

public class Bypest_pra_summary extends PRA_Home{
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "4. PRA summary")WebElement PRA_summary_tab;
	@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	@FindBy(xpath="//body[@data-id='RiskAssessmentNotes']//p")WebElement riskassessmentnote;
	@FindBy(xpath="//div[@id='tab0']//td[1]")WebElement pathway_of_entry;
	@FindBy(xpath="//div[@id='tab0']//td[2]")WebElement notes_for_plants_for_planting;
	@FindBy(xpath="//div[@id='tab1']//td[1]")WebElement after_entry;
	@FindBy(xpath="//div[@id='tab1']//td[2]")WebElement notes_for_inspection;
	@FindBy(xpath="//body[@data-id='RiskManagementNotes']//p")WebElement riskmanagement;
	@FindBy(xpath="//input[@class='btn btn-pra-green' and @value='Save']")WebElement save_btn;
	@FindBy(xpath="//h1[@class='sub-header']")WebElement sub_header;
	@FindBy(xpath="//input[@value=1]")WebElement yes;
	@FindBy(xpath="//body[@data-id='Notes_oyyfvshud3u']//p")WebElement note1;
	@FindBy(xpath="//button[@class='btn-pra-gray' and text()='Cancel']")WebElement cancel_btn;
	@FindBy(xpath="//button[@class='btn-pra-red btn-references' and text()='Save']")WebElement save;
	
	public void pra_summary() throws InterruptedException
	{
		Thread.sleep(4000);
		PRA_summary_tab.click();
		Thread.sleep(2000);
		logger22.log(Status.PASS, tab_header.getText()+" is opened");
		
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		check_summary_tab(2);
		Thread.sleep(1000);
		check_summary_tab(3);
		Thread.sleep(1000);
		check_summary_tab(4);
		Thread.sleep(1000);
		check_summary_tab(5);
		Thread.sleep(1000);
		check_summary_tab(6);
		Thread.sleep(1000);
		
	wd.switchTo().frame(0);
	logger22.log(Status.PASS, riskassessmentnote.getText() +" is visible in risk assessment summary notes");
	wd.switchTo().defaultContent();
	Thread.sleep(2000);
	logger22.log(Status.PASS, "Pathway of Entry --->"+pathway_of_entry.getText());
	logger22.log(Status.PASS, "Notes for Plants for pathway-->"+ notes_for_plants_for_planting.getText());
	logger22.log(Status.PASS, "After Entry--->"+ after_entry.getText());
	logger22.log(Status.PASS, "Notes for Inspection or testing in post-entry quarantine-->"+ notes_for_inspection.getText());
	
	Thread.sleep(2000);
		
	wd.switchTo().frame(1);
	logger22.log(Status.PASS, riskmanagement.getText() +" is visible in risk management summary notes");
	wd.switchTo().defaultContent();
	Thread.sleep(2000);
	
	jse.executeScript("window.scrollBy(0,300)", "");
	Thread.sleep(2000);
	
	List<WebElement>PRA_note=wd.findElements(By.xpath("//a[@class='btn-pra-red pull-right margin-top-10']"));
	int n=1;
	for(WebElement note :PRA_note)
	{
		
		if(n==1)
		{
			logger22.log(Status.PASS, "------Edit Summary Note------");
		}
		else if(n==2)
		{
			logger22.log(Status.PASS, "------Edit Next Steps------");
		}
		else if(n==3)
		{
			logger22.log(Status.PASS, "------Contact Details ------");
		}
		note.click();
		Thread.sleep(2000);
		logger22.log(Status.PASS,"Edit button got clicked textbox is opened");
		cancel_btn.click();
		Thread.sleep(2000);
		logger22.log(Status.PASS,"cancel button got clicked");
		note.click();
		Thread.sleep(2000);
		logger22.log(Status.PASS, "Edit button got clicked again");
		
	
	   wd.switchTo().frame(6);
		List<WebElement>textbox=wd.findElements(By.xpath("//body[@class='mce-content-body editor-body']//p"));
		int t=1;
		for(WebElement tbox:textbox)
		{
			if(t==1)
			{
				
				tbox.sendKeys("abc");
				Thread.sleep(2000);
				logger22.log(Status.PASS, "abc text got inserted in textbox");
				wd.switchTo().defaultContent();
			}
			t++;
		}
		Thread.sleep(2000);
		
		save.click();
		Thread.sleep(2000);
		logger22.log(Status.PASS, "Save button got clicked");
		n++;
	}
	
	Thread.sleep(2000);
	yes.click();
	Thread.sleep(2000);
	logger22.log(Status.PASS, sub_header.getText()+"-->yes got clicked");
	save_btn.click();
	Thread.sleep(3000);
	logger22.log(Status.PASS, "Save button got clicked and PRA summary saved successfully");
	
	
	jse.executeScript("window.scrollBy(0,-900)");
	Thread.sleep(1000);
	}
	
	public static void check_summary_tab(int i)
	{
		String header1=null;
		String header2=null;
		String header3=null;
		String header4=null;
		String header5=null;
		List<WebElement>table_headers=wd.findElements(By.xpath("//div[@class='row table-header']//div"));
		int k=1;
		for(WebElement header:table_headers)
		{
			if(k==1)
			{
			 header1=header.getText();
			}
			if(k==2)
			{
				header2=header.getText();
			}
			if(k==3)
			{
				header3=header.getText();
			}
			if(k==4)
			{
				header4=header.getText();
			}
			if(k==5)
			{
				header5=header.getText();
			}
			k++;
		}
		
		
		
		
		List<WebElement> rows=wd.findElements(By.xpath("//div[@class='row regular-font']//div[@class='col-sm-12']//div["+i+"]//div"));
	    int j=1;
	    for(WebElement row: rows)
	    {
	    	if(j==1)
	        {
	    		logger22.log(Status.PASS, "For "+ row.getText());
	    	}
	    	else if(j==2)
	    	{
	    		logger22.log(Status.PASS, header2+"-->"+row.getText());
	    	}
	    	else if(j==3)
	    	{
	    		logger22.log(Status.PASS, header3+"-->"+row.getText());
	    	}
	    	else if(j==4)
	    	{
	    		logger22.log(Status.PASS, header4+"-->"+row.getText());
	    	}
	    	else if(j==5)
	    	{
	    		logger22.log(Status.PASS, header5+"-->"+row.getText());
	    	}
	    	j++;
	    }
	
	}

}
