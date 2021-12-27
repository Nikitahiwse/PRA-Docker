package pra_child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pra_package.PRA_Home;

import java.util.Set;

public class Bypest_download_pra_report extends PRA_Home {
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "4. PRA summary")WebElement PRA_summary_tab;
	@FindBy(xpath="//*[@id=\"navbar-adv\"]/ul/li[1]/a/span/span[2]")WebElement PRA_Report;
	@FindBy(xpath="//*[@id=\"navbar-adv\"]/ul/li[1]/ul/li/a")WebElement view_html_report;
	@FindBy(xpath="//span[@class='cabi-icon-icon_download']")WebElement download_btn;
	@FindBy(linkText = "Home")WebElement home_tab;
	public void HTML_report() throws InterruptedException
	{
		Thread.sleep(2000);
	
		PRA_Report.click();
		Thread.sleep(2000);
		logger23.log(Status.PASS, "PRA Report dropdownd got clicked");
		view_html_report.click();
		Thread.sleep(2000);
		logger23.log(Status.PASS, "View HTML report tab got clicked");
		//to check html report
		String parent=wd.getWindowHandle();
		Set<String>Allwindow=wd.getWindowHandles();
		for(String child: Allwindow)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				wd.switchTo().window(child);
				Thread.sleep(6000);
				logger23.log(Status.PASS, "HTML report is opened in new tab");
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,900)", "");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,900)", "");
				Thread.sleep(2000);
				
				jse.executeScript("window.scrollBy(0,-650)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-650)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-650)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-650)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-850)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-850)");
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-950)");
				Thread.sleep(1000);
				
				
				download_btn.click();
				Thread.sleep(5000);
				logger23.log(Status.PASS, "Report downloded successfully");
				
				wd.close();
				
			}
		}
		 wd.switchTo().window(parent);
		 Thread.sleep(6000);
		 home_tab.click();
		 Thread.sleep(3000);
		
	}

	

}
