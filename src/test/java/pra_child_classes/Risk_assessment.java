package pra_child_classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;


import pra_package.PRA_Home;

public class Risk_assessment extends PRA_Home{

	static JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(xpath="//div[@class='col-sm-12']//li[@class='active']//p//a")WebElement sub_header;
	@FindBy(xpath="//body[@data-id='Questions_0__Notes']//p")WebElement text1;
	@FindBy(xpath="//body[@data-id='Questions_1__Notes']//p")WebElement text2;
	@FindBy(xpath="//body[@data-id='Questions_2__Notes']//p")WebElement text3;
	@FindBy(xpath="//body[@data-id='Questions_3__Notes']//p")WebElement text4;
	@FindBy(xpath="//body[@data-id='Questions_4__Notes']//p")WebElement text5;
	@FindBy(xpath="//body[@data-id='Questions_5__Notes']//p")WebElement text6;
	@FindBy(xpath="//body[@data-id='Questions_6__Notes']//p")WebElement text7;
	@FindBy(xpath="//body[@data-id='Questions_7__Notes']//p")WebElement text8;
	@FindBy(xpath="//body[@data-id='Questions_8__Notes']//p")WebElement text9;
	
	@FindBy(xpath="//body[@data-id='SummaryNotes']//p")WebElement summarytext;
	
	@FindBy(xpath="//input[@class='btn btn-pra-green' and @value='Save']")WebElement save;
	@FindBy(xpath="//input[@class='btn btn-pra-red' and @value='Next']")WebElement next_btn;
	public void by_pest_risk_assessment(String tab_under_risk_assessment) throws InterruptedException
	{
		
		logger20.log(Status.PASS, "------------------"+tab_under_risk_assessment+" tab Test--------------------------");
		String sub_header_text=sub_header.getText();
		logger20.log(Status.PASS, sub_header_text+" tab is opened");
		Thread.sleep(2000);
		wd.switchTo().frame(0);
		text_enter(text1,0);
		Thread.sleep(2000);
		wd.switchTo().frame(1);
		text_enter(text2,1);
		Thread.sleep(2000);
		wd.switchTo().frame(2);
		text_enter(text3,2);
		Thread.sleep(2000);
		wd.switchTo().frame(3);
		text_enter(text4,3);
		Thread.sleep(2000);
		wd.switchTo().frame(4);
		text_enter(text5,4);
		Thread.sleep(2000);
		wd.switchTo().frame(5);
		text_enter(text6,5);
		if(tab_under_risk_assessment.equalsIgnoreCase("Probability of establishment"))
		{
		Thread.sleep(2000);
		wd.switchTo().frame(6);
		text_enter(text7,6);
		}
		else if(tab_under_risk_assessment.equalsIgnoreCase("Potential consequences"))
		{
			Thread.sleep(2000);
			wd.switchTo().frame(6);
			text_enter(text7,6);
			Thread.sleep(2000);
			wd.switchTo().frame(7);
			text_enter(text8,7);
			Thread.sleep(2000);
			wd.switchTo().frame(8);
			text_enter(text9,8);
		}
		//for summary
		
		Select s1=new Select(wd.findElement(By.xpath("//select[@id='SummaryRatingId']")));
		s1.selectByValue("3");
		Thread.sleep(1000);
		logger20.log(Status.PASS, "Medium got selected in summary rating");
		Select s2=new Select(wd.findElement(By.xpath("//select[@id='SummaryConfidenceLevelID']")));
		s2.selectByValue("3");
		logger20.log(Status.PASS, "High got selected in summary confidence level");
		Thread.sleep(2000);
		if(tab_under_risk_assessment.equalsIgnoreCase("Probability of establishment"))
		{
		wd.switchTo().frame(7);
		Thread.sleep(1000);
		}
		else if(tab_under_risk_assessment.equalsIgnoreCase("Probability of spread"))
		{
			wd.switchTo().frame(6);
			Thread.sleep(1000);
		}
		else if(tab_under_risk_assessment.equalsIgnoreCase("Potential consequences"))
		{
			wd.switchTo().frame(9);
			Thread.sleep(1000);
		}
		summarytext.sendKeys("xyz");
		logger20.log(Status.PASS, "Text got entered in summary textbox- xyz");
		wd.switchTo().defaultContent();
		Thread.sleep(1000);
		
		// for import from cpc button
		if(tab_under_risk_assessment.equalsIgnoreCase("Potential consequences"))
		{
			import_from_cpc();
		}
		save.click();
		Thread.sleep(3000);
		logger20.log(Status.PASS, tab_under_risk_assessment+" tab is saved");
		next_btn.click();
		Thread.sleep(2000);
		logger20.log(Status.PASS, "Next button got clicked to switch from "+ tab_under_risk_assessment+" to next tab");
		
	}
	public static void text_enter(WebElement textbox,int i) throws InterruptedException
	{
	
		int c=i+1;
		textbox.sendKeys("xyz");
		Thread.sleep(1000);
		logger20.log(Status.PASS, "xyz text got entered for question "+ c);
		wd.switchTo().defaultContent();
		Thread.sleep(2000);
		Select s=new Select(wd.findElement(By.xpath("//select[@name='Questions["+i+"].RatingId']")));
		s.selectByValue("3");
		Thread.sleep(2000);
		logger20.log(Status.PASS, "Medium got selected in Add Rating dropdown for question "+c);
		Select s1=new Select(wd.findElement(By.xpath("//select[@name='Questions["+i+"].ConfidenceLevelID']")));
		s1.selectByValue("2");
		Thread.sleep(2000);
		logger20.log(Status.PASS, "Medium got selected in Add confidence level dropdown for question "+c);
		
		jse.executeScript("window.scrollBy(0,200)", "");
	}
	
	//to import from cpc for question 1 3 and 7
	public static void import_from_cpc() throws InterruptedException
	{
		List<WebElement>import_cpc_button=wd.findElements(By.xpath("//div[@class='col-sm-2 import-from-cpc']//a"));
		int p=1;
		for(WebElement cpc_button : import_cpc_button)
		{
			cpc_button.click();
			Thread.sleep(4000);
			if(p==1)
			{
			wd.switchTo().frame(0);
			logger20.log(Status.PASS, "----------Import from CPC button got clicked of question 1--------");
			String para2_text=wd.findElement(By.xpath("//body[@data-id='Questions_0__Notes']//p[2]")).getText();
			logger20.log(Status.PASS, "Text imported in second paragraph is -"+ para2_text);
			String para3_text=wd.findElement(By.xpath("//body[@data-id='Questions_0__Notes']//p[3]")).getText();
			logger20.log(Status.PASS, "Text imported in Third paragraph is -"+ para3_text);
			wd.switchTo().defaultContent();
			}
			else if(p==2)
			{
				logger20.log(Status.PASS, "-----------Import from CPC button got clicked of question 3---------");
				String model_alert_text=wd.findElement(By.xpath("//div[@id='modalAlertDialog']//div[@class='modal-body']//p")).getText();
				logger20.log(Status.PASS,"Alert for question 2 -"+model_alert_text );
				wd.findElement(By.xpath("//button[text()='Close']")).click();
			}
			else if(p==3)
			{
				logger20.log(Status.PASS, "-----------Import from CPC button got clicked of question 7---------");
				String model_alert_text=wd.findElement(By.xpath("//div[@id='modalAlertDialog']//div[@class='modal-body']//p")).getText();
				logger20.log(Status.PASS,"Alert for question 2 -"+model_alert_text );
				wd.findElement(By.xpath("//button[text()='Close']")).click();
			}
			
			p++;
		}
	}
	@FindBy(xpath="//span[text()='Plants for planting']")WebElement plants_for_planting;
	@FindBy(xpath="//span[text()='Seeds for planting']")WebElement seeds_for_planting;
	@FindBy(xpath="//div[@class='col-sm-4']//h3[text()='Probability of establishment']")WebElement Probability_of_establishment;
	@FindBy(xpath="//div[@class='col-sm-4']//h3[text()='Probability of spread']")WebElement Probability_of_spread;
	@FindBy(xpath="//div[@class='col-sm-4']//h3[text()='Potential economic, environmental and social consequences']")WebElement consequences;
	@FindBy(xpath="//body[@data-id='Notes']//p")WebElement notes;
	@FindBy(linkText = "Home")WebElement home_btn;
	public void Risk_assessment_summary() throws InterruptedException
	{
		Thread.sleep(3000);
		
		jse.executeScript("window.scrollBy(0,400)", "");
		
		Thread.sleep(3000);
		String sub_header_text=sub_header.getText();
		logger20.log(Status.PASS, sub_header_text+" tab is opened");
		Thread.sleep(2000);
		
		
		
		ratting(plants_for_planting.getText(),5);
		ratting(seeds_for_planting.getText(),6);
		ratting(Probability_of_establishment.getText(),7);
		ratting(Probability_of_spread.getText(),8);
		ratting(consequences.getText(),9);
		
		Thread.sleep(2000);
		wd.switchTo().frame(0);
		Thread.sleep(2000);
		notes.sendKeys("summary notes");
		Thread.sleep(1000);
		wd.switchTo().defaultContent();
		save.click();
		Thread.sleep(2000);
		next_btn.click();
		Thread.sleep(2000);
		
		
	}
	public static void ratting(String row,int i) throws InterruptedException
	{
		String header_first_text=null;
		String header_second_text=null;
		String header_third_text=null;
		String header_fourth_text=null;
		logger20.log(Status.PASS, "For "+row);
		List<WebElement>row_table_header_left=wd.findElements(By.xpath("//div[@class='row table-header']//div[@class='col-sm-3']"));
		int j=1;
		for(WebElement header_left:row_table_header_left)
		{
			if(j==1)
			{
		     header_first_text=header_left.getText();
			}
			else if(j==2)
			{
			header_second_text=header_left.getText();
			}
			j++;
		}
		
		List<WebElement>row_table_header_right=wd.findElements(By.xpath("//div[@class='row table-header']//div[@class='col-sm-2']"));
		int k=1;
		for(WebElement header_right:row_table_header_right)
		{
			if(k==1)
			{
			header_third_text=header_right.getText();
			}
			else if(k==2)
			{
		      header_fourth_text=header_right.getText();
			}
		k++;
			
		}
		
		
		
		
		List<WebElement> ratinngs=wd.findElements(By.xpath("//div[@class='row push-top-24 green-background regular-font']//div//div["+i+"]//div[@class='col-sm-8']//div"));
		int l=1;
		for(WebElement rating:ratinngs)
		{
			if(l==1)
			{
			
				logger20.log(Status.PASS, header_first_text+"  -->"+rating.getText());
				Thread.sleep(1000);
			}
			else if(l==2)
			{
				logger20.log(Status.PASS, header_second_text+"  -->"+rating.getText());
				Thread.sleep(1000);
			}
			else if(l==3)
			{
				logger20.log(Status.PASS, header_third_text+"  -->"+rating.getText());
                Thread.sleep(1000);
			}
			else if(l==4)
			{
				logger20.log(Status.PASS, header_fourth_text+"  -->"+rating.getText());
				Thread.sleep(1000);
			}
			l++;
		
		}
	}
}
