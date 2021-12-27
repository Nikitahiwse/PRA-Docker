package pra_package;

import GmailAPiLib.GMail;
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
import pra_child_classes.*;

import java.io.IOException;
import java.util.HashMap;

public class PRA_Home extends PRA_Base{


	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./PRA_Report/home.html");
	public static ExtentReports extent = new ExtentReports();

	public static ExtentTest logger1,logger2,logger3,logger4,logger5,logger6,logger7,logger8,Logger9,Logger10,Logger11,Logger12,Logger13,Logger14,Logger15,logger17,logger18,logger19,logger20,logger21,logger22,logger23,logger24,logger25;


	@BeforeSuite
	void initialization_browser_opening() throws InterruptedException, IOException
	{
		System.out.println(getobject("url"));
		initialzation(getobject("url"));
		Testcases_for_Home_report testcase=new Testcases_for_Home_report();
		testcase.testcase_creation();
	}
	@Test(priority=1)
	void title_verification() throws InterruptedException
	{

		Title_verification.website_title_verification("Pest Risk Analysis Tool");
	}


	@Test(priority=2)
	void login_Test() throws InterruptedException, IOException
	{
		Login log=PageFactory.initElements(wd, Login.class);
		log.login_to_cpc(getobject("cpc_username"),getobject("cpc_password"));
		log.login_to_mycabi(getobject("mycabi_username"),getobject("mycabi_password"));
	}



	//@Test(priority=3)
	void Team_creation() throws Throwable
	{
		Home ho=PageFactory.initElements(wd, Home.class);
		ho.Teamcreation_for_PRA();


	}
	//@Test(priority = 4)
	void gmail_verification()
	{
		HashMap<String, String> hm = GMail.getGmailData("subject:You have been invited to join: Testing 9 in the CABI Pest Risk Analysis Tool.");
		System.out.println(hm.get("subject"));
		System.out.println("=================");
		System.out.println(hm.get("body"));
		System.out.println("=================");
		System.out.println(hm.get("link"));

		System.out.println("=================");
		System.out.println("Total count of emails is :"+GMail.getTotalCountOfMails());

		System.out.println("=================");
		boolean exist = GMail.isMailExist("You have been invited to join: Testing 9 in the CABI Pest Risk Analysis Tool.");
		System.out.println("title exist or not: " + exist);
	}

	//@Test(priority = 5)
	void Banner_footer() throws InterruptedException
	{
		Banner_footer_PRA bf=PageFactory.initElements(wd, Banner_footer_PRA.class);
		bf.banner();
		bf.footer();

	}
	@Test(priority = 6)
	void PRA_Home_Test() throws InterruptedException
	{
		PRA_Home_tab hometab=PageFactory.initElements(wd, PRA_Home_tab.class);
		hometab.PRA_Home();
		hometab.View_PRA();
		hometab.View_Report();
	}

	@Test(priority = 7)
	void Previous_PRA_Test() throws InterruptedException
	{
		Previous_PRA previous=PageFactory.initElements(wd, Previous_PRA.class);
		previous.previousPRA();
		//previous.View_Bypathway_PRA();
		previous.View_Report_from_previous_PRA();
		previous.filter();

	}

	@Test(priority = 8)
	void Regulated_Pest_Test() throws InterruptedException
	{
		Regulated_Pest_list regulated=PageFactory.initElements(wd, Regulated_Pest_list.class);
		regulated.add_pest();
		regulated.edit_record();
		regulated.cleanup_pest();
		regulated.pagination();
		regulated.regulated_filter();
	}

	//@Test(priority = 9)
	void pathway_creation() throws Throwable
	{
		ByPathway pathway = PageFactory.initElements(wd, ByPathway.class);
		pathway.Initiation(getobject("ByPathway_Title_Group"));
		pathway.group_of_pest();
		pathway.Initiation(getobject("ByPathway_Title_List"));
		pathway.generate_full_list();
	}

	//@Test(priority = 10)
	void By_pathway_risk_assessments() throws Throwable
	{
		Pathway_RiskAssessments path = PageFactory.initElements(wd, Pathway_RiskAssessments.class);
		path.rapid_assessments();
		path.full_risk_assessment();
	}

	//@Test(priority = 11)
	void By_pathway_risk_assessments_actions() throws Throwable
	{
		User_Action action= PageFactory.initElements(wd, User_Action.class);
		action.perform_action();
		action.export_import_pest();
	}

	//@Test(priority = 12)
	void By_pathway_pestrisk() throws Throwable
	{
		PestRisk_Management pest= PageFactory.initElements(wd, PestRisk_Management.class);
		pest.pest_management(getobject("cpc_username"),getobject("cpc_password"));
		pest.risk_management();
	}

	//@Test(priority = 13)
	//skiped permanently
	void By_pathway_summaryscreen() throws Throwable
	{
		Summary_Screen screen= PageFactory.initElements(wd, Summary_Screen.class);
		screen.summary_content();
	}

	//@Test(priority = 14)
	void By_pathway_report_generation() throws Throwable
	{
		Generate_Report report=PageFactory.initElements(wd, Generate_Report.class);
		report.generate_pra_report();
		report.open_team();
		//report.Delete_PRA("AutomationList");
		//report.Delete_PRA("AutomationGroup");

	}

	//@Test(priority = 15)
	void By_pest_initiation() throws InterruptedException, IOException
	{
		ByPest_initiation bypest=PageFactory.initElements(wd, ByPest_initiation.class);
		bypest.By_pest_initiation_pra(getobject("pestname"),getobject("country_area_at_risk"),getobject("suggested_title_for_pra"),getobject("pra_start_month"),getobject("pra_due_month"),getobject("pra_due_date"),getobject("pra_area"));
		bypest.re_edit_initiation_form(getobject("suggested_title_for_pra"));
	}

	//@Test(priority = 16)
	void By_pest_cattegorization_tab() throws InterruptedException, IOException
	{
		ByPest_categorization bypestcat=PageFactory.initElements(wd, ByPest_categorization.class);
		bypestcat.categorization(getobject("suggested_title_for_pra"));
	}

	//@Test(priority = 17)
	void By_pest_Probabity_of_entry() throws InterruptedException, IOException
	{
		Bypest_Probability_of_entry probability=PageFactory.initElements(wd, Bypest_Probability_of_entry.class);
		probability.riskassesmenttab(getobject("suggested_title_for_pra"));
		probability.add_pathway("Plants for planting");
		probability.check_tab_risk_management("Plants for planting");
		probability.add_pathway("Seeds for planting");
		probability.check_tab_risk_management("Seeds for planting");
		probability.export_import();

	/*File listOfFiles[]=folder.listFiles();
    Assert.assertTrue(listOfFiles.length>0);

    for(File file:listOfFiles)
    {
    	Assert.assertTrue(file.length()>0);
    	logger19.log(Status.PASS, "Downloaded File is not empty");
    }*/
		probability.save();


	}

	//@Test(priority = 18)
	void Bypest_riskassessment() throws InterruptedException
	{
		Risk_assessment risk=PageFactory.initElements(wd,Risk_assessment.class);
		risk.by_pest_risk_assessment("Probability of establishment");
		risk.by_pest_risk_assessment("Probability of spread");
		risk.by_pest_risk_assessment("Potential consequences");
		risk.Risk_assessment_summary();
	}

	//@Test(priority = 19)
	void Bypest_risk_management() throws InterruptedException
	{
		Risk_management risk=PageFactory.initElements(wd, Risk_management.class);
		risk.risk_management_form();
	}

	//@Test(priority = 20)
	void Bypest_PRA_summary_screen() throws InterruptedException
	{
		Bypest_pra_summary  summary=PageFactory.initElements(wd, Bypest_pra_summary.class);
		summary.pra_summary();
	}

	//@Test(priority = 21)
	void Bypest_download_PRA_report() throws InterruptedException
	{
		Bypest_download_pra_report report=PageFactory.initElements(wd, Bypest_download_pra_report.class);
		report.HTML_report();
		/*File listOfFiles[]=folder.listFiles();
	    Assert.assertTrue(listOfFiles.length>0);

	    for(File file:listOfFiles)
	    {
	    	Assert.assertTrue(file.length()>0);
	    	logger23.log(Status.PASS, "Downloaded File is not empty");
	    }*/
	}
    //Skipped permanently because now delete functionality is not available
	//@Test(priority = 22)
	void By_pest_delete_PRA() throws InterruptedException, IOException
	{
		Delete_bypest_pra deletePRA=PageFactory.initElements(wd, Delete_bypest_pra.class);
		deletePRA.delete_PRA(getobject("suggested_title_for_pra"));
	}


	@AfterMethod
	void fail_testcase(ITestResult result)
	{
		try {

			if(ITestResult.FAILURE==result.getStatus())
			{
				String temp=Utility.attachscreenshotreport(wd, result.getName());


				logger25.fail("Testcase name"+ result.getName());
				logger25.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

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
