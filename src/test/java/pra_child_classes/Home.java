package pra_child_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import pra_package.PRA_Home;

public class Home extends PRA_Home{
	

	@FindBy(xpath="//a[@class='showTeamModal']")
	WebElement create;
	
	@FindBy(id="TeamName")
	WebElement teamname;
	
	@FindBy(id="txtInviteUsers")
	WebElement invite_user_1;
	
	@FindBy(xpath="//button[@class='btn btn-pra-red']")
	WebElement add_user_1;
	
	@FindBy(id="txtInviteUsers")
	WebElement invite_user_2;
	
	@FindBy(xpath="//button[@class='btn btn-pra-red']")
	WebElement add_user_2;
	
	
	@FindBy(id="txtInviteUsers")
	WebElement invite_user_3;
	
	@FindBy(xpath="//button[@class='btn btn-pra-red']")
	WebElement add_user_3;
	
	
	@FindBy(xpath="//button[@type='submit' ][@class='btn btn-pra-red']")
	WebElement create_team;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	
	

	
	
	public void Teamcreation_for_PRA() throws Throwable 
	{
			
		
		create.click();
		logger5.log(Status.PASS, "Create Team button got clicked successfully");
		
		Thread.sleep(2000);
		teamname.sendKeys("team_for_automation");
		logger5.log(Status.PASS, "Team Name Entered Successfully");
		
		
		invite_user_1.sendKeys("nikita.hiwse@neosoftmail.com");
		logger5.log(Status.PASS, "Nikita invited");
		add_user_1.click();
		logger5.log(Status.PASS, "Nikita Added successfully");
		
		
		invite_user_2.sendKeys("shubhambhandarineosoft@gmail.com");
		logger5.log(Status.PASS, " Shubham invited");
		add_user_2.click();
		logger5.log(Status.PASS, "Shubham Added successfully");
		
		invite_user_3.sendKeys("ombhandari9090@gmail.com");
		logger5.log(Status.PASS, "Om invited");
		add_user_3.click();
		logger5.log(Status.PASS, "Om Added successfully");
		
		
		
		Thread.sleep(3000);
		create_team.click();
		logger5.log(Status.PASS, "Team Created successfully");
		Thread.sleep(2000);
		close.click();
	
	}
	
	
	
	
		
			  
			 
				}
			