package pra_child_classes;

import java.util.List;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Filter extends PRA_Home{
	
	public static void filte_previoustab(WebElement Sessionfilter,String input_text1,String input_text2,String k) throws InterruptedException
	{
		  Sessionfilter.click();
		  Thread.sleep(1000);
		  int i=1;
		  List<WebElement>dropdown=wd.findElements(By.xpath("//span[@class='k-icon k-i-arrow-60-down']"));
		  for(WebElement dr :dropdown)
			{
				//if(i==1||i==3)
				//{
				 dr.click();
				 Thread.sleep(1000);
				 List<WebElement>drdw=wd.findElements(By.xpath("//div[@class='k-list-scroller']//ul//li["+k+"]"));
				
				 int j=1;
				 for(WebElement dr1:drdw)
			     {
					 if(i==1 & j==1)
					 {
					 dr1.click(); 
					 }
					 else if(i==3 & j==3)
					 {
						 
						 dr1.click();
					
					 }
					 else if(i==2 &j==2)
					 {
						 if(k=="1" || k=="2")
						 {
							 dr1.click();
						 }
					
					 }
					
					 else if(i<=3 & j<=2)
					 {
						 System.out.println("");
					 }
					 
					j++;
					
			     }	
				 
				//}
				if(i==1)
				{
				WebElement input1=wd.findElement(By.xpath("//input[@title='Value']"));
				input1.sendKeys(input_text1);
				}
				else if(i==2)
				{
					
					System.out.println("And is selected");
				}
				else if (i==3)
				{
					WebElement input2=wd.findElement(By.xpath("//input[@title='Additional value']"));
					input2.sendKeys(input_text2);
				}
				
			 
				i++;
			
			}
			Thread.sleep(1000);
			WebElement filter_submit_button=wd.findElement(By.xpath("//button[text()='Filter']"));
			filter_submit_button.click();
			Thread.sleep(3000);
			
			Filter.filter_result();
			
			wd.navigate().refresh();
		    Thread.sleep(3000);
		    JavascriptExecutor jse=(JavascriptExecutor)wd;
		    jse.executeScript("window.scrollBy(0,600)", "");
		    Thread.sleep(2000);
		    WebElement previous_PRA=wd.findElement(By.linkText("My Team's Previous PRAs"));
		    previous_PRA.click();
		    Thread.sleep(1000);
	      
		}
	public static String attribute_name,coloumn_value;
	public static void filter_result()
	{
		
		logger7.log(Status.PASS, "Attributes present after applying filter");
		List<WebElement> results=wd.findElements(By.xpath("//div[@id='PRADatagrid']//td"));
		int count=results.size();
	     	if(count==0)
		     {
			logger7.log(Status.PASS, "No Previous Teams PRA");
		      }
		     for(WebElement result1 :results)
			
				{
			       attribute_name=result1.getText();
			        logger7.log(Status.PASS,attribute_name);
				}
	
		 
		
		
		
		 
	}
	 public static String  compare_single_result(String c,String value1,String value2,String value3)
	 {
		
		 int i=1;
		 List<WebElement>result_coloumn_values=wd.findElements(By.xpath("//div[@id='PRADatagrid']//td["+c+"]"));
		 
		 for(WebElement coloumn_val : result_coloumn_values)
		 {
			 if(i==1)
			 {
			if (!value1.equalsIgnoreCase(""))
			{
			 coloumn_value=coloumn_val.getText();
			 
			 if(coloumn_value.equalsIgnoreCase(value1))
				{
					System.out.println("Filter Result is correct"+ coloumn_value);
					
					
				}
			}
			 }
			if(i==2)
			{
			if(!value2.equalsIgnoreCase(""))
			{
				 coloumn_value=coloumn_val.getText();
				 
				 if(coloumn_value.equalsIgnoreCase(value2))
					{
					    System.out.println("Filter Result is correct"+ coloumn_value);
						
						
						
					}
			}
			}
			if(i==3)
			{
			if(!value3.equalsIgnoreCase(""))
			{
				 coloumn_value=coloumn_val.getText();
				 
				 if(coloumn_value.equalsIgnoreCase(value2))
					{
					    System.out.println("Filter Result is correct"+ coloumn_value);
						
						
					}
			}
			}
			
			i++;
		 }
		return coloumn_value;	
			
	 }
		
	
	
	 public static void regulated_pest_filter(WebElement filter,String input_text,String active_filter_name ) throws InterruptedException
	 {
		 Thread.sleep(2000);
		 filter.click();
		 Thread.sleep(1000);
		 WebElement filter_arrow=wd.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-down']"));
		 filter_arrow.click();
		 Thread.sleep(2000);
		 List<WebElement> option_drop_regulated=wd.findElements(By.xpath("//div[@class='k-list-scroller']//li"));
		 int i=1;
		
		 for(WebElement option : option_drop_regulated)
		 {
			
			 if(i>=2)
			 {
				 WebElement active_filter=wd.findElement(By.xpath("//div[@id='RegulatoryStatusDatagrid']//a[text()='"+active_filter_name+" ']//a[@class='k-grid-filter k-state-active']"));
				 active_filter.click();
				 
				 Thread.sleep(1000);
				 filter_arrow.click();
				 Thread.sleep(1000);
			 }
			 option.click();
			
			 
			 if(active_filter_name.equalsIgnoreCase("Date last modified"))
			 {
				WebElement calender_icon=wd.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
				 calender(calender_icon,"November 2020");
				
				 
				 
			 }
		     if (active_filter_name.equalsIgnoreCase("Regulatory status"))
			 {
				 if(i==1)
				 {
				 
				 WebElement input_status=wd.findElement(By.xpath("//input[@title='Value' and @class='k-formatted-value k-input']"));
				 input_status.clear();
				 Thread.sleep(1000);
				 input_status.sendKeys(input_text);
				 Thread.sleep(4000);
				 }
			 }
			 else if(!active_filter_name.equalsIgnoreCase("Date last modified"))
			 {
			 WebElement input=wd.findElement(By.xpath("//input[@title='Value']"));
			 input.clear();
			 Thread.sleep(1000);
			 input.sendKeys(input_text);
			 Thread.sleep(1000);
			 }
			 WebElement filter_button=wd.findElement(By.xpath("//button[text()='Filter']"));
			 filter_button.click();
			 
			 Thread.sleep(3000);
			 
			 result_after_filter_relulated(i);
			 i++;
		 }
		 Thread.sleep(1000);
		 wd.navigate().refresh();
		 Thread.sleep(4000);
		 WebElement regulate_pest_tab=wd.findElement((By.linkText("My Team's Regulated Pest List")));
		 regulate_pest_tab.click();
		 
	 }
	 
	 public static void result_after_filter_relulated(int i) throws InterruptedException
	 {
		 
		 logger8.log(Status.PASS, "Filter Result for dropdown option "+i);
		 
		 List<WebElement>attributes_of_regulated_pest=wd.findElements(By.xpath("//div[@id='RegulatoryStatusDatagrid']//td"));
		 int count_regu=attributes_of_regulated_pest.size();
		 if(count_regu==0)
		 {
			 String text_no=wd.findElement(By.xpath("//div[@class='k-grid-norecords-template']")).getText();
			 if(text_no.equalsIgnoreCase("No Regulatory Status"))
			 {
				 logger8.log(Status.PASS, text_no);
			 }
			
		 }
		 Thread.sleep(1000);
		 for(WebElement attribute:attributes_of_regulated_pest)
		 {
			 
			 String attribute_text=attribute.getText();
			 logger8.log(Status.PASS, attribute_text);
		 }
	 }
	 
	 public static void calender(WebElement calender_icon,String month) throws InterruptedException
	 {
		 
		 calender_icon.click();
		 
		 Thread.sleep(2000);
		 while(true)
		 {
			String month_cal=wd.findElement(By.xpath("//div[@data-role='calendar']//a[@class='k-link k-nav-fast']")).getText();
			 if(month_cal.equalsIgnoreCase(month))
			 {
				 System.out.println("outer loop"+ month_cal);
				break; 
			 }
			 else
			 {
				 
				 WebElement previous_icon=wd.findElement(By.xpath("//div[@data-role='calendar']//a[@class='k-link k-nav-prev']"));
				 for(int i=1;i<=11;i++)
				 {
				previous_icon.click();
				Thread.sleep(1000);
				String month_call=wd.findElement(By.xpath("//div[@data-role='calendar']//a[@class='k-link k-nav-fast']")).getText();
				 if(month_call.equalsIgnoreCase(month))
				 {
				
					break;
				 }
				 
				   
				 }
			 }
			 
	 
		 } 
		 
				
			Thread.sleep(2000); 
		 
		 
		 WebElement date=wd.findElement(By.xpath("//a[@data-value='2020/10/30']"));
		 Thread.sleep(1000);
		 date.click();
		 
		 
	 

		 
			
	 }

}
