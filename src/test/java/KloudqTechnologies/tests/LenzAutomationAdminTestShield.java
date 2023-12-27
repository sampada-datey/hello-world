package KloudqTechnologies.tests;


import java.io.File;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import KloudqTechnologies.TestComponents.BaseTest;

public class LenzAutomationAdminTestShield extends BaseTest {
	ExtentTest logger;
	ExtentReports report;

	LenzAutomationAdminTestShield()
	{
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ShieldTest1.html"));
		this.report=new ExtentReports();
		this.report.attachReporter(extent);

	}


	@Test  (groups= {"Admin-lenzAutomation"},priority = 1)  
	
	 @Parameters({"companyName", "userType"})
	public void LoginLenzAutomation(String companyName, String userType) throws IOException, InterruptedException  
	{  
		System.out.println("Execute Login for Lenz Automation Test User");

		LoginTestExcel LenzAutomationShield=new LoginTestExcel();

		
		LenzAutomationShield.getDataByCompanyName(this.report,companyName,userType);
		System.out.println("CompanyName:-> " + companyName);
		 System.out.println("UserType:->" + userType);
		Thread.sleep(2000);

			System.out.println("Executed Lenz Automation Component");  
	}  

	@Test  (groups= {"Admin-lenzAutomation"},priority = 2)  
	public void LenzAutomationAdministrator() throws IOException, InterruptedException  
	{  

		Thread.sleep(5000);
		//
		//		LenzAutoAdminAlerts LenzAutoAlerts=new LenzAutoAdminAlerts(BaseTest.driver);
		//		LenzAutoAlerts.ClickAdministrator();
		
		
		
		//		////LenzAutoAlerts.AddNewAlert(this.report);//TODO: BUG not able to add Model Name
		//		LenzAutoAlerts.EditAlert(this.report);
		//		LenzAutoAlerts.SearchAlert(this.report);
		//
		//
		//		HolidayMaster HolidayMaster=new HolidayMaster(BaseTest.driver);
		//
		//		//	AddNewHoliday//TODO:BUg Date time picker cannot be selected in Selenium
		//		HolidayMaster.EditHoliday(this.report);
		//		HolidayMaster.DeleteHoliday(this.report);
		//
		//
		//		SubCategoryMaster SubCategoryMaster=new SubCategoryMaster(BaseTest.driver);
		//		SubCategoryMaster.AddSubCategoryMaster(this.report);
		//		SubCategoryMaster.EditSubCategory(this.report);
		//
		//		SubCategoryMaster.SearchSubCategory(this.report);
		//		SubCategoryMaster.DeleteSubCategory(this.report);
		//
		//
		//		ParameterMaster ParameterMaster=new ParameterMaster(BaseTest.driver);
		//		ParameterMaster.AddParameterMaster(this.report);
		//		ParameterMaster.EditParameter(this.report);
		//
		//		ParameterMaster.SearchParameter(this.report);
		//		ParameterMaster.DeleteParameter(this.report);
		//
		//		ParameterTypeMaster ParameterTypeMaster=new ParameterTypeMaster(BaseTest.driver);
		//		ParameterTypeMaster.AddParameterTypeMaster(this.report);
		//		ParameterTypeMaster.EditTypeParameter(this.report);
		//
		//		ParameterTypeMaster.SearchParameterType(this.report);
		//		ParameterTypeMaster.DeleteParameterType(this.report);


		System.out.println("Executed Lenz Automation Administrator");  
	}  
	@Test  (groups= {"Admin"},priority = 7)  
	public void teardown()  
	{  

		report.flush();



	}  
	
}
