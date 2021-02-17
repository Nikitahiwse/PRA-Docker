package pra_package;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.PRA_Base;
import library.Utility;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pra_child_classes.Mycabi_tab;
import pra_child_classes.Testcases_for_Mycabi_report;
import pra_child_classes.mycabi_account_creation;

import java.io.IOException;

public class My_cabi_account extends PRA_Base {
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./PRA_Report/mycabi.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1,logger2,logger3,logger4,logger5;
	

	@BeforeSuite
	void initialization_browser_opening() throws InterruptedException, IOException
	{
		initialzation(getobject("url"));
		Testcases_for_Mycabi_report testcase=new Testcases_for_Mycabi_report();
		testcase.testcases_creation();
	}
	@Test(priority = 1)
	void account_creation() throws InterruptedException, IOException
	{
		 mycabi_account_creation ac1=PageFactory.initElements(wd, mycabi_account_creation.class);
	     ac1.login_to_cpc(getobject("cpc_username"),getobject("cpc_password"));
	     ac1.account_creation_mycabi(getobject("firstname"),getobject("lastname"),getobject("email"),getobject("password"));
	}
	@Test (priority = 2)
	void login_with_created_account() throws IOException, InterruptedException
	{
		mycabi_account_creation ac2=PageFactory.initElements(wd, mycabi_account_creation.class);
		ac2.login_to_mycabi(getobject("email"),getobject("password"));
	}
	@Test(priority = 3)
	void mycabi_tab() throws InterruptedException
	{
		Mycabi_tab mycabi=PageFactory.initElements(wd, Mycabi_tab.class);
		mycabi.mycabi_account_edit();
		mycabi.mycabi_delete();
	}
	
	
	@AfterMethod
	void fail_testcase(ITestResult result)
	{
		try {
			if(ITestResult.FAILURE==result.getStatus())
			{
			String temp=Utility.attachscreenshotreport(wd, result.getName());
		
			logger5.fail("Testcase name"+ result.getName());
			logger5.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		    }}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		
	}
	@AfterSuite
	void teardown_browerclosing()
	{
		teardown();
		extent.flush();
	}

}
