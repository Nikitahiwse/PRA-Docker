package pra_child_classes;

import pra_package.My_cabi_account;

public class Testcases_for_Mycabi_report extends My_cabi_account {

	public void testcases_creation()
	{
		extent.attachReporter(htmlReporter); 
		logger1=extent.createTest("CPC Login Test ");
		logger2=extent.createTest("My Cabi Account Creation Test");
		logger3=extent.createTest("Login Test with created account");
		logger4=extent.createTest("Mycabi tab");
		logger5=extent.createTest("Screenshot for failed Test");
	}
}
