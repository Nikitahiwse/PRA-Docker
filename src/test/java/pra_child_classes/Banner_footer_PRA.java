package pra_child_classes;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Banner_footer_PRA extends PRA_Home {

	
	@FindBy(linkText = "PRA Home")WebElement PRA_home;
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Other CABI sites ']")WebElement Othercabisites;
	@FindBy(linkText = "About")WebElement about;
	@FindBy(linkText = "Help")WebElement help;
	@FindBy(linkText = "Compendium Home")WebElement compendium;
	public void banner() throws InterruptedException
	{
		//for PRA home page
		PRA_home.click();
		Thread.sleep(4000);
		Title_verification.website_title_verification("Pest Risk Analysis Tool");
		System.out.println("Home page title is verified");
		logger3.log(Status.PASS, "PRA Home button got clicked");
		//for other cabi sites page
		Othercabisites.click();
		logger3.log(Status.PASS, "Other cabi sites dropdown got clicked");
		Thread.sleep(3000);
		
		List<WebElement> othercabi_sites=wd.findElements(By.xpath("//li[@class='nav-item left-border open']/ul[@class='dropdown-menu']//li//a"));
		int count_sites=othercabi_sites.size();
		logger3.log(Status.PASS,"Total other sites under other cabi sites dropdown are-"+count_sites);
		int i=1;
		for(WebElement site : othercabi_sites)
		{
			String parent=wd.getWindowHandle();
		    String other_site_name=site.getText();
			System.out.println("other sites name "+other_site_name);
			logger3.log(Status.PASS, i+": Other site name is "+other_site_name);
			site.click();
			Thread.sleep(3000);
			logger3.log(Status.PASS, other_site_name+" got clicked and site is opened in onother tab");
			Set<String>Allwindow=wd.getWindowHandles();
			int count=Allwindow.size();
			System.out.println("Total no of window"+count);
	
		for(String child: Allwindow)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				wd.switchTo().window(child);
				Thread.sleep(6000);
				String other_site_title=wd.getTitle();
			    Title_verification.website_title_verification(other_site_title);
			    logger3.log(Status.PASS, "Title is verified for "+other_site_title);
				wd.close();
				
			}
		}
		
		    wd.switchTo().window(parent);
		    Thread.sleep(6000);
		    Othercabisites.click();
			Thread.sleep(3000);
			i++;
			
		}
		
	   //for about page
		about.click();
		Thread.sleep(3000);
		logger3.log(Status.PASS, "About button got clicked and page opened in same tab");
		wd.navigate().back();
		Thread.sleep(3000);
		//for Help page
		help.click();
		Thread.sleep(3000);
		logger3.log(Status.PASS, "Help button got clicked and page opened in same tab ");
		wd.navigate().back();
		Thread.sleep(2000);
	
		//for Compendium Home
		String home=wd.getWindowHandle();
		compendium.click();
		Thread.sleep(3000);
		logger3.log(Status.PASS, "Compendium home button got clicked and page opened in another tab");
		Set<String>windows=wd.getWindowHandles();
		
		for(String child: windows)
		{
			if(!home.equalsIgnoreCase(child))
			{
				wd.switchTo().window(child);
				Thread.sleep(6000);
				String compendium=wd.getTitle();
			    Title_verification.website_title_verification(compendium);
			    logger3.log(Status.PASS, "Title is verified for "+compendium);
				wd.close();
				
			}
			wd.switchTo().window(home);
			Thread.sleep(3000);
		}
				
	}
	
	@FindBy(linkText = "Contact Us")WebElement contactUS;
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	public void footer() throws InterruptedException
	{
		 jse.executeScript("window.scrollBy(0,600)", "");
		 Thread.sleep(4000);
		 contactUS.click();
		 Thread.sleep(3000);
		 Title_verification.website_title_verification("Pest Risk Analysis Tool");
		 wd.navigate().back();
		 Thread.sleep(3000);
		 
		 int j=1;
		 List<WebElement>footer=wd.findElements(By.xpath("//section[@class='container footer']//ul//li"));
		 int footer_tab_count=footer.size();
		 System.out.println("Total footer tabs are"+ footer_tab_count);
		 logger4.log(Status.PASS, "Total footer tabs are -"+footer_tab_count);
		 for(WebElement footer_tab : footer)
		 {
			 String footer_button=footer_tab.getText();
			 logger4.log(Status.PASS, j+": "+footer_button);
			 
			 if(footer_button.equalsIgnoreCase("Contact Us"))
			 {
				System.out.println("ContactUs page got clicked");
				logger4.log(Status.PASS, "Contact Us button got clicked and page opened in same tab");
					 
			 }
			 else
			 {
				   jse.executeScript("window.scrollBy(0,600)", "");
					String homepage=wd.getWindowHandle();
			        footer_tab.click();
					Thread.sleep(4000);
					logger4.log(Status.PASS, footer_button+" button got clicked and page opened in another tab");
					Set<String>windows=wd.getWindowHandles();
					
					for(String child: windows)
					{
						if(!homepage.equalsIgnoreCase(child))
						{
							wd.switchTo().window(child);
							Thread.sleep(6000);
							String footer_page_title=wd.getTitle();
						    Title_verification.website_title_verification(footer_page_title);
						    logger4.log(Status.PASS, "Title is verified for "+footer_page_title);
							wd.close();
							
						}
						wd.switchTo().window(homepage);
						Thread.sleep(3000);
					} 
			 }
			 j++;
		 }
		 
	}
}
