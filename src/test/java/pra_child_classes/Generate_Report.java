package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.Set;

public class Generate_Report extends PRA_Home {
	
	@FindBy(linkText = "3. Pest risk analysis summary")
	WebElement analysis_summary_tab;
	
	@FindBy(xpath = "//a[@class='nav-link introPRAReport']")
	WebElement PRA_Report;
	
	@FindBy(xpath = "//*[@id=\"navbar-adv\"]/ul/li[1]/ul/li[1]/a")
	WebElement view_report;
	
	@FindBy(xpath = "(//a[@class='action'])[2]")
	WebElement download_word;
	
	
	@FindBy(xpath = "//a[@class='nav-link introPRAReport']") 
	WebElement PRA_Full_Report;
	  
	@FindBy(xpath = "//*[@id=\"navbar-adv\"]/ul/li[1]/ul/li[3]/a") 
	WebElement view_full_report;
	  
	@FindBy(xpath = "(//a[@class='action'])[2]") 
	WebElement download_wordfile;
	
	
	//Delete PRA
	
	
	static JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "ABC")
	WebElement team;
	
	@FindBy(xpath = "//*[@id=\"RecentPRADatagrid\"]/table/tbody/tr[2]/td[3]/a")
	WebElement createdPRA;
	
	@FindBy(xpath="(//a[@class='k-button k-button-icontext k-grid-delete'])[2]")
	WebElement delete_button;
	
	@FindBy(xpath = "(//a[@class='k-button k-button-icontext k-grid-delete'])[1]")
	WebElement delete_button_1;
	
	@FindBy(xpath = "//*[@id=\"RecentPRADatagrid\"]/table/tbody/tr[1]/td[3]/a")
	WebElement createdPRAList;
	
	
	
	
	
	
	
	
	
	

	public void generate_pra_report() throws Throwable {
		
		//analysis_summary_tab.click();
		//Logger14.log(Status.PASS, "Pest Risk Analysis summary tab clicked successfully");
		
		Thread.sleep(5000);
		PRA_Report.click();
		Logger14.log(Status.PASS, "PRA Report tab got clicked successfully");
		
		Thread.sleep(4000);
		view_report.click();
		Logger14.log(Status.PASS, "View report button got clicked successfully");
		Thread.sleep(4000);
		
		//Window Handling
		
		int count =0;
		 String parent=wd.getWindowHandle();
		 System.out.println("parent window id is:"+parent);
		 System.out.println(wd.getTitle());
		
		 Set<String> allwindows = wd.getWindowHandles();
		 
		
		  for(String child : allwindows)
		  {
			 
				  wd.switchTo().window(child);
				  System.out.println("child window title is:"+wd.getTitle());
				  
				  count++;
				  
				  if(count==2) {
					  
					
					  Thread.sleep(5000);
					  download_word.click();
					  Logger14.log(Status.PASS, "Word file downloaded successfully");
						
						  Thread.sleep(5000);
						  wd.close();
						 
					  
					  Thread.sleep(8000);
						wd.switchTo().window(parent);     //Switch back to parent window
						System.out.println("parent window title is:"+wd.getTitle());
						
				  }
				  }
						
						  PRA_Full_Report.click(); 
						  Logger14.log(Status.PASS, "PRA Report tab got clicked successfully");
						  Thread.sleep(3000); 
						  view_full_report.click();
						  Logger14.log(Status.PASS, "View Full Report button got clicked successfully");
						  Thread.sleep(5000); 
				
						//Window Handling Full report
							
							int counter =0;
							
							String win = wd.getWindowHandle();
							 System.out.println("parent window id is:"+win);
							 System.out.println(wd.getTitle());

							Set<String> alwindows = wd.getWindowHandles();

							for(String eachwindow : alwindows)
							{

							wd.switchTo().window(eachwindow);

							counter++;

							if(counter==2)
							{		  
										  	Thread.sleep(5000);
										  	download_wordfile.click();
											Logger14.log(Status.PASS, " Full report word file downloaded successfully");
										  	
										  	Thread.sleep(5000);
										  	wd.close();
										  	
										  	wd.switchTo().window(parent);     //Switch back to parent window
											System.out.println("parent window title is:"+wd.getTitle());
										  	Thread.sleep(5000);
						 
					  
					  
				  }
				 
		  }
							
	}
				 
							
				

	public void Delete_PRA(String PRA) throws Throwable {
		
		team.click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		
		 String CreatedPra_name=createdPRA.getText();
		 Thread.sleep(2000);
		 if(CreatedPra_name.equalsIgnoreCase(PRA))
	    {
		
		delete_button.click();
		Logger15.log(Status.PASS, "Delete button got clicked");
		Thread.sleep(1000);
		
		Alert a1=wd.switchTo().alert();
		a1.accept();
	
		System.out.println("PRA is deleted successfully");
		Thread.sleep(2000);
	    }	
		 
		 else if (CreatedPra_name.equalsIgnoreCase(PRA)) {
			 
			 delete_button_1.click();
				Logger15.log(Status.PASS, "Delete button got clicked");
				Thread.sleep(1000);
				
				Alert a2=wd.switchTo().alert();
				a2.accept();
			
				System.out.println("PRA is deleted successfully");
				Thread.sleep(2000);
			
		}
		
		
		 else
		 {
			 System.out.println(PRA+" is not present in ABC team");
		 }
		 Thread.sleep(8000);
	}
}
		 
		
		 
		 
		 
		 
		 
		
		
	


