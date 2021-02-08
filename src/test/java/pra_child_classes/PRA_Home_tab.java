package pra_child_classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class PRA_Home_tab extends PRA_Home {
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement Team;

	
	public void PRA_Home() throws InterruptedException
	{
		// To check attributes present in PRA
		Team.click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		List<WebElement>tablerow=wd.findElements(By.xpath("//div[@id='RecentPRADatagrid']//tbody//tr"));
		int totalrow=tablerow.size();
		System.out.println("Total PRA present "+ totalrow);
		logger6.log(Status.PASS, "Total PRA present "+totalrow);
		for(int i=1;i<=totalrow;i++) {
		List<WebElement>row=wd.findElements(By.xpath("//div[@id='RecentPRADatagrid']//tbody//tr["+i+"]//td"));
		Thread.sleep(2000);
		logger6.log(Status.PASS, "Row"+i);
		for(WebElement attribute : row)
		{
			String attributename=attribute.getText();
			System.out.println("Attributes present in PRA row-->"+attributename);
			Thread.sleep(1000);
			
			logger6.log(Status.PASS, "Attributes present in PRA row-->"+ attributename);
				
		}
		
		}
		
		
		
	}
	
	@FindBy(xpath="//div[@id='RecentPRADatagrid']//a[text()='demo2 india']")WebElement demo2india;
	@FindBy(xpath="//input[@value='Next']")WebElement Next;
	@FindBy(xpath="//input[@value='Home']")WebElement Home_button;
	@FindBy(xpath="//h1[@class='text-center']")WebElement initiation;
	@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	
	
	public void View_PRA() throws InterruptedException
	{
		       // to view By pest PRA 
		        logger6.log(Status.PASS, "---------------To view PRA----------------");
				demo2india.click();
				Thread.sleep(2000);
				logger6.log(Status.PASS, "demo2india pest PRA is opened");
				String initiation_title=initiation.getText();
                logger6.log(Status.PASS, initiation_title+" is opened");
                jse.executeScript("window.scrollBy(0,900)", "");
				Thread.sleep(3000);
                Next.click();
                Thread.sleep(2000);
                
				for(int i=1;i<=8;i++)
				{
				String header=tab_header.getText();
				logger6.log(Status.PASS, header+" is opened");
				if(i>=2 && i<=6)
				{
					Thread.sleep(2000);
					jse.executeScript("window.scrollBy(0,100)", "");
					WebElement sub_header=wd.findElement(By.xpath("//ul[@class='work-flow']//li[@class='active']//a"));
					String header_sub=sub_header.getText();
					logger6.log(Status.PASS, header_sub+" is opened");
					
				}
				jse.executeScript("window.scrollBy(0,900)", "");
				Thread.sleep(3000);
				if(i==8)
				{
					Home_button.click();
					Thread.sleep(2000);
					logger6.log(Status.PASS, "Home button got clicked");
				}
				else
				{
					Next.click();
					Thread.sleep(4000);
					logger6.log(Status.PASS, "Next button got clicked");
				}
				
				
				}
				
			}
	
	WebElement PRA_report;
	//to veiw PRA Report
	public void View_Report() throws InterruptedException
	{
		logger6.log(Status.PASS, "------------To view Report-----------");
		jse.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		List<WebElement>tablerow=wd.findElements(By.xpath("//div[@id='RecentPRADatagrid']//tbody//tr"));
		int totalrow=tablerow.size();
		int j=1;
		for(int i=1;i<=totalrow;i++)
		{
		List<WebElement>Reports=wd.findElements(By.xpath("//div[@id='RecentPRADatagrid']//tr["+i+"]//a[text()='Report']"));
		for(WebElement report:Reports)
		{
			
			WebElement PRA_type=wd.findElement(By.xpath("//div[@id='RecentPRADatagrid']//tr["+j+"]//td[2]"));
			String PRAtype=PRA_type.getText();
			report.click();
			Thread.sleep(3000);
			logger6.log(Status.PASS," Report got clicked");
			if(PRAtype.equalsIgnoreCase("Pathway"))
			{
			PRA_report=wd.findElement(By.xpath("//div[@class='report-title']//strong"));
			
			}
			else 
			{
			PRA_report=wd.findElement(By.xpath("//div[@class='report-by-pest-title']//span"));
		
			}
			String Session_titile=PRA_report.getText();
			jse.executeScript("window.scrollBy(0,300)", "");
			jse.executeScript("window.scrollBy(0,300)", "");
			logger6.log(Status.PASS, Session_titile+" report is opened");
			wd.navigate().back();
			Thread.sleep(3000);
			j++;
		}
		}
		
		
	}
	

	}
	
