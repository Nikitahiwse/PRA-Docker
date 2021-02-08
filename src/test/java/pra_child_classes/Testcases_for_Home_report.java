package pra_child_classes;

import pra_package.PRA_Home;

public class Testcases_for_Home_report extends PRA_Home{
public void testcase_creation()
{
	extent.attachReporter(htmlReporter); 
	//for Homepage Test
	logger1=extent.createTest("Login Test");
	logger2=extent.createTest("Title Verification Test");
	logger3=extent.createTest("Banner Test");
	logger4=extent.createTest("Footer Test");
	logger5=extent.createTest("Team creation Test");

	logger6=extent.createTest("PRA_Home_Test");
	logger7=extent.createTest("My teams Previous PRA's");
	logger8=extent.createTest("My teams reulated pest List");
	//By pathway
	Logger9=extent.createTest("By Pathway Test");           
	Logger10=extent.createTest("Pathway Risk Assessments");  
	Logger11=extent.createTest("User Action");               
	Logger12=extent.createTest("Pest Risk Management"); 
	Logger13=extent.createTest("Summary Analysis"); 
	Logger14=extent.createTest("Report Generation"); 
	Logger15=extent.createTest("Delete PRA ByPathway Test"); 
	
	//for By Pest Test
	logger17=extent.createTest("By Pest initiation");
	logger18=extent.createTest("By Pest Categorization Tab Test");
	logger19=extent.createTest("By Pest Probability of entry and Add pathway Test");
	logger20=extent.createTest("By Pest Risk Assessment Tab Test");
	logger21=extent.createTest("By Pest Risk Management Tab Test");
	logger22=extent.createTest("By Pest PRA Summary Screen Test");
	logger23=extent.createTest("By Pest PRA Report");
	logger24=extent.createTest("Delete By Pest PRA Test");
	logger25=extent.createTest("Screenshot for failed testcase");
}
}
