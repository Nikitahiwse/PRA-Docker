package pra_child_classes;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class ByPest_categorization extends PRA_Home {
	static JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(linkText = "0_automation_PRA")WebElement o_automation;
	@FindBy(xpath="//input[@Value='Next']")WebElement Next_button;
	@FindBy(xpath="//h1[@class='tab-header']")WebElement tab_header;
	@FindBy(xpath="//body[@id='tinymce' and @data-id='CategorisationIdentity']//p")WebElement categorization_identity;
	@FindBy(xpath="//div[@id='mceu_4']//i[@class='mce-ico mce-i-link']")WebElement insert_link;
	@FindBy(xpath="//input[@class='mce-textbox']")WebElement link_text;
	
	@FindBy(xpath="//span[text()='Ok']")WebElement ok;
	@FindBy(xpath="//div[@id='mceu_2']//i[@class='mce-ico mce-i-bold']")WebElement bold;
	@FindBy(xpath="//div[@id='mceu_0']//i[@class='mce-ico mce-i-undo']")WebElement undo;
	@FindBy(xpath="//div[@id='mceu_3']//i[@class='mce-ico mce-i-italic']")WebElement Italic;
	@FindBy(xpath="//div[@id='mceu_5']//i[@class='mce-ico mce-i-unlink']")WebElement remove_link;
	
	@FindBy(xpath="//body[@id='tinymce'and @data-id='PresenceorAbsence']//p")WebElement presenceorabsence;
	@FindBy(xpath="//select[@id='PestQuarantineStatusID']")WebElement regulatory;
	@FindBy(xpath="//body[@data-id='RegulatoryStatusElseWhere']//p")
	static WebElement status_more;
	@FindBy(xpath="//body[@data-id='DistributionSummary']//p")WebElement distributed_summary;
	@FindBy(xpath="//body[@data-id='HostPlantAssociation']//p")WebElement Hostplanassociation;
	@FindBy(xpath="//body[@data-id='PotentialForEstablishment']//p")WebElement Potentialforestablishment;
	@FindBy(xpath="//body[@data-id='PotentialForEconomicImpact']//p")WebElement PotentialForEconomicImpact;
	
	@FindBy(xpath="//input[@id='PotentiallyAPest' and @value='0']")WebElement no;
	@FindBy(xpath="//input[@id='PotentiallyAPest' and @value='1']")WebElement yes;
	@FindBy(xpath="//span[@class='glyphicon toggle-icon']")WebElement reference_icon;
	@FindBy(xpath="//body[@class='mce-content-body editor-body']//p[text()='Text entered -First reference']")WebElement reference;
	@FindBy(xpath="//input[@Value='Save']")WebElement save;
	@FindBy(linkText = "Home")WebElement home;
	
	public void categorization(String PRA) throws InterruptedException
	{
		o_automation.click();
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
		logger18.log(Status.PASS, "Next button got clicked");
		
		String tab_header_text=tab_header.getText();
		logger18.log(Status.PASS, tab_header_text+" is opened");
		Thread.sleep(1000);
		//for identity textbox
		
		
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		wd.switchTo().frame(0);
		Thread.sleep(1000);
		categorization_identity.sendKeys("identity");
		logger18.log(Status.PASS, "Identity text got entered in identity textbox");
		categorization_identity.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		wd.switchTo().defaultContent();
		insert_link.click();
		Thread.sleep(1000);
		logger18.log(Status.PASS, "Inser link button got clicked");
		Thread.sleep(1000);
		link_text.sendKeys("https://en.wikipedia.org/wiki/Taxonomic_rank");
		logger18.log(Status.PASS, "URL got entered");
		Thread.sleep(1000);
		
		List<WebElement>linktextbox=wd.findElements(By.xpath("//input[@class='mce-textbox mce-abs-layout-item mce-last']"));
		int i=1;
		for(WebElement linktext:linktextbox)
		{
			if(i==1)
			{
			linktext.clear();
			Thread.sleep(1000);
			linktext.sendKeys("Taxonomic");
			Thread.sleep(1000);
			logger18.log(Status.PASS, "URL text got entered-Taxonomic");
			Thread.sleep(1000);
			}
			else if (i==2)
			{
				linktext.clear();
				linktext.sendKeys("title1");
				logger18.log(Status.PASS, "Title got entered title1");
				Thread.sleep(2000);
			}
			i++;
		}
		
		
		ok.click();
		Thread.sleep(3000);
		wd.switchTo().frame(0);
		wd.findElement(By.linkText("Taxonomic")).click();
		
		wd.switchTo().defaultContent();
		
		bold.click();
		Thread.sleep(1000);
		logger18.log(Status.PASS, "URL got bold");
		
		undo.click();
		Thread.sleep(1000);
		logger18.log(Status.PASS, "undo is performed");
		Italic.click();
		Thread.sleep(1000);
		logger18.log(Status.PASS, "Italic is performed");
		remove_link.click();
		Thread.sleep(1000);
		logger18.log(Status.PASS, "link got removed");
		
		

		//Presence or absence in the PRA area
		
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
		wd.switchTo().frame(1);
		enter_text("xyz",presenceorabsence,"4");
		

		//Regulatory status of the pest in the country/area at risk
		
		Select s=new Select(regulatory);
		s.selectByValue("3");
		Thread.sleep(1000);
		logger18.log(Status.PASS, "Regulatory status is set- key=3");
		
		//Regulatory status of the pest elsewhere
		wd.switchTo().frame(2);
		enter_text("xyz", status_more,"6");
		//Distribution summary
		wd.switchTo().frame(3);
		enter_text("xyz", distributed_summary,"7");
		
		//Association with host plants or, in the case of potential weeds, habitats
		wd.switchTo().frame(4);
		enter_text("xyz", Hostplanassociation,"8");
		
		//Potential for establishment in the PRA area
		wd.switchTo().frame(5);
		enter_text("xyz", Potentialforestablishment,"9");
		//Potential for economic, environmental and social consequences in the PRA area
		wd.switchTo().frame(6);
		enter_text("xyz", PotentialForEconomicImpact,"10");
		no.click();
		Thread.sleep(1000);
		yes.click();;
		Thread.sleep(1000);
		reference_icon.click();
		Thread.sleep(1000);
		wd.switchTo().frame(7);
		Thread.sleep(1000);
		String reference_text=reference.getText();
		if(reference_text.equalsIgnoreCase("Text entered -First reference"))
		{
			logger18.log(Status.PASS, "reference text is -"+reference_text);
		}
		
		wd.switchTo().defaultContent();
		Thread.sleep(1000);
		
		import_from_cpc_categorization();
		Thread.sleep(1000);
		save.click();
		Thread.sleep(3000);
		
		logger18.log(Status.PASS, "Save button got clicked");
		
		home.click();
		Thread.sleep(3000);
		
	}
	
	public static void enter_text(String text,WebElement textbox,String subtitle) throws InterruptedException
	{
	
	    
		Thread.sleep(2000);
		textbox.sendKeys(text);
		Thread.sleep(2000);
		wd.switchTo().defaultContent();
		String title_text=wd.findElement(By.xpath("//div["+subtitle+"]/h2")).getText();
		logger18.log(Status.PASS, "Text got entered in- "+title_text +"is -->"+ text);
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,200)", "");
	}
  public void import_from_cpc_categorization() throws InterruptedException
   {
	List<WebElement>import_buttons=wd.findElements(By.xpath("//div[@class='col-sm-12']//a[text()='Import from CPC']"));
	int p=1;
	for(WebElement import_b : import_buttons)
	{
		import_b.click();
		Thread.sleep(12000);
		if(p==1)
		{
			logger18.log(Status.PASS, "---------Import from cpc button got clicked of Identity------------");
			logger18.log(Status.PASS, "Identity text is imported");
			wd.switchTo().frame(0);
			for(int i=3;i<=8;i++) {
			String identity_text=wd.findElement(By.xpath("//body[@data-id='CategorisationIdentity']//p["+i+"]")).getText();
			Thread.sleep(500);
			logger18.log(Status.PASS, "identity text for row "+i+"-->"+identity_text);
			}
			wd.switchTo().defaultContent();
		}
		else if(p==2)
		{
			Thread.sleep(2000);
			logger18.log(Status.PASS, "-----------Import from cpc button got clicked of distribution summary------------");
			logger18.log(Status.PASS, "Distribution summary text is imported");
			jse.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(1000);

			wd.switchTo().frame(3);
			for(int j=2;j<=7;j++) {
			String distributed_text=wd.findElement(By.xpath("//body[@data-id='DistributionSummary']//p["+j+"]")).getText();
			Thread.sleep(500);
			logger18.log(Status.PASS, "Distribution text for row "+j+"-->"+distributed_text);
			}
			wd.switchTo().defaultContent();
		}
		p++;
		
	}
   }
}
