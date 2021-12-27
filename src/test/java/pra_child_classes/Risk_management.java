package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.List;

public class Risk_management extends PRA_Home{
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	@FindBy(linkText = "3. Risk management")WebElement risk_manag_tab;
	@FindBy(xpath="//body[@data-id='Management_QuestionTypes_1__Questions_0__RiskManagementNotes']//p")WebElement text1;
	@FindBy(xpath="//body[@data-id='Management_SummaryNotes']//p")WebElement summary;
	@FindBy(xpath="//input[@id='Management_ManagementCompleted' and @value='1']")WebElement yes_btn;
	@FindBy(xpath="//h2[@class='sub-header']")WebElement sub_header;
	@FindBy(xpath="//input[@class='btn btn-pra-green' and @value='Save']")WebElement save_btn;
	@FindBy(xpath="//input[@class='btn btn-pra-red' and @value='Next']")WebElement next_btn;
	@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	@FindBy(xpath="//td[@class='bold' and text()='Inspection or testing in post-entry quarantine']")WebElement verify_summary_tab;
	@FindBy(linkText = "3. Risk management")WebElement risk_management;

	public void risk_management_form() throws InterruptedException
	{
		
		//risk_manag_tab.click();
		//Thread.sleep(3000);
		
		logger21.log(Status.PASS,tab_header.getText()+" is opened ");
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		
		List<WebElement>checkbox=wd.findElements(By.xpath("//label[@class='checkbox']//span"));
		int i=1;
		for(WebElement check:checkbox)
		{
			if(i==2)
			{
				check.click();
				Thread.sleep(1000);
				logger21.log(Status.PASS, "Inspection or testing in post-entry quarantine checkbox got selected");
			}
			i++;
		}
		
		Thread.sleep(1000);
		wd.switchTo().frame(1);
		Thread.sleep(1000);
		text1.sendKeys("xyz");
		Thread.sleep(1000);
		logger21.log(Status.PASS, "xyz text got entered in Inspection or testing in post-entry quarantine textbox");
		wd.switchTo().defaultContent();
		Thread.sleep(1000);
		wd.switchTo().frame(10);
		Thread.sleep(1000);
		summary.sendKeys("summary");
		Thread.sleep(1000);
        logger21.log(Status.PASS, "summary text got entered in summary textbox");
		wd.switchTo().defaultContent();
        Thread.sleep(2000);
        yes_btn.click();
        
        logger21.log(Status.PASS, sub_header.getText()+"--> yes got selected");
        
        Thread.sleep(1000);
        save_btn.click();
        Thread.sleep(3000);
        logger21.log(Status.PASS, "save button got clicked");
        next_btn.click();
        Thread.sleep(3000);
        logger21.log(Status.PASS, "next button got clicked to switch from risk management tab to PRA summary tab");
        jse.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);
        String text_s=wd.findElement(By.xpath("//p[text()='xyz']")).getText();
        logger21.log(Status.PASS, "In PRA summary tab-> In management option -"+ verify_summary_tab.getText()+" with text "+ text_s+" is visible");
        wd.switchTo().frame(1);
        Thread.sleep(2000);
        String summary_txt=wd.findElement(By.xpath("//body[@data-id='RiskManagementNotes']//p")).getText();
        logger21.log(Status.PASS, "In PRA summary tab->"+summary_txt+" text is visible in risk management summary notes");
        wd.switchTo().defaultContent();
        Thread.sleep(2000);
        //risk_management.click();
        //Thread.sleep(3000);
        //logger21.log(Status.PASS,"risk management tab got clicked");
        
	}
}
