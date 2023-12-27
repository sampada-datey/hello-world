package KloudqTechnologies.tests;
import org.testng.annotations.Optional;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import KloudqTechnologies.JDBCConnection.ConnectJDBC;

import KloudqTechnologies.PageObjects.DashboardShield;

import KloudqTechnologies.PageObjects.IOTErrorLog;
import KloudqTechnologies.PageObjects.SLD;
import KloudqTechnologies.PageObjects.Trends;
import KloudqTechnologies.PageObjects.XMLReport;



import KloudqTechnologies.PageObjects.SystemErrorLog;
import KloudqTechnologies.TestComponents.BaseTest;

public class AdminTestShield {

	
	
	ExtentTest test;
	ExtentTest logger;
	ExtentReports report;
	private String groupNames;
   
	
	AdminTestShield() 
	{
		//ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ShieldTest1.html"));
		 //String reportDirectory = System.getProperty("user.dir") + "/Reports/";
		String reportDirectory = System.getProperty("user.dir") + "/Reports/";

        // Create a date format to include in the filename
        SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
        String timestamp = dateFormat.format(new Date());

        // Define the filename with the included timestamp
        String reportFilename = "ShieldTest_" + timestamp + ".html";
        String reportPath = reportDirectory + reportFilename;

        // Initialize ExtentHtmlReporter with the defined path
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);

        // Create an ExtentReports instance and attach the HTML reporter
      //  ExtentReports extent = new ExtentReports();
       // extent.attachReporter(htmlReporter);
		
		
		
		this.report=new ExtentReports();
		this.report.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Shield Lenz Admin Report  ");
		htmlReporter.config().setReportName("Test Results of Shield Lenz Admin ");
		
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	//	extent.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

       
	}
	
	
	
	@BeforeTest
	@Parameters("groupNames")
	public void ToSetUPTest(@Optional String groupNames)
	{
		
		        // Retrieve parameter value from TestNG XML
		//groupNames = context.getCurrentXmlTest().getParameter("groupNames");
		 //       System.out.println("Parameter value: " + groupNames);
		  
		        if (groupNames != null && !groupNames.isEmpty()) {
		            String[] groupsArray = groupNames.split(",");
		            for (String group : groupsArray) {
		                System.out.println("Running test in group: " + group.trim());
		                // Perform actions or setup specific to each group
		            }
		        } else {
		            System.out.println("No specific groups provided. Running default test.");
		            // Run default test or perform default actions
		        }
		        
	
	
	
	
	}
	
	
	
	@Test(groups= {"All,Dashboard"},priority = 1) 
	 @Parameters({"company","userType"})
	public void Login( @Optional String company, String userType) throws IOException, InterruptedException
	{  

		System.out.println("Started Executing Login Component");
		LoginTestExcel AdminTestShield=new LoginTestExcel();
		AdminTestShield.getDataByCompanyName(this.report, company,userType);
		 System.out.println("CompanyName:-> " + company);
		 System.out.println("UserType:->" + userType);
		
		
		
		//lte.getDataByCompanyName(this.report);
		Thread.sleep(4000);
		
	}  

	@Test(groups= {"All,Dashboard"},priority = 2)  
	public void Dashboard() throws SQLException, FileNotFoundException, IOException, InterruptedException
	{  
		
		ConnectJDBC sqlconnect=new ConnectJDBC();

		sqlconnect.getConnectionString(this.report);

		DashboardShield DS=new DashboardShield(BaseTest.driver);

		DS.HeaderCheck(this.report); 
		DS.CheckActualConsumptionToday(this.report);
		//		//DS.CheckCostOFActualPredToday(this.report);//TODO-->this needs to be put id
		DS.CheckPowerFactor(this.report); 
		DS.CheckAvgKwhToday(this.report);
		//		//DS.CheckEnergyTreeToday(this.report);//TODO-->this needs to be put id

		DS.CheckEcActualPrYesterday(this.report);
		DS.CheckCostActualPrYesterday(this.report);
		DS.CheckAvgKwhYesterday(this.report);
		//		//DS.CheckEnergyTreeYesterday(this.report);//TODO-->this needs to be put id
		//
		DS.CheckEcActualMonthly(this.report); 
		DS.CheckCoAcMonthly(this.report);
		DS.CheckAvgKwhMonthly(this.report);
		//		//DS.CheckEnergyTreeMonthly(this.report);//TODO-->this needs to be put id

		//		//DS.CheckEnegryConsumptionTrendGraph(this.report);//TODO-->this needs to be
		//
		DS.CheckEnergyUsageDaywise(this.report);
		DS.CheckEnergyUsageMonthwise(this.report);
		DS.CheckEnergyUsageDivisionWise(this.report);
		DS.CheckEnergyUsageSiteWise(this.report);
		DS.clickCostTab();
		//DS.EnergyUsageCostDaywiseGraph(this.report);//TODO-->this needs to be put id

		DS.EnergyUsageCostMonthWiseGraph(this.report);
		DS.EnergyUsageCostDivisionWiseGraph(this.report);
		DS.EnergyUsageCostSiteWiseGraph(this.report);
		DS.MaximumDemandMain(this.report);
		DS.MaximumDemandIND(this.report);


		Thread.sleep(3000);

		System.out.println("Executed Dashboard Component of Shield");

	}  

	@Test  (groups= {"All"},priority = 3)  
	public void SLD() throws FileNotFoundException, SQLException, IOException, InterruptedException  
	{  

		SLD SLD = new SLD(BaseTest.driver);
		SLD.ClickSLDTab();
		SLD.SLDParentNodesCount(this.report);
		Thread.sleep(2000);
		SLD.SLDChildNodesCount(this.report);
		//		Thread.sleep(2000);
		//		//SLD.SLDOnineStatus(this.report);//TODO: Here the color code is in rgb format 
		//		//SLD.SLDOfflineStatus(this.report);

			SLD.MachineSpecificationfrequency(this.report);//TODO:the DB value needs to be compared with only first two digits of frequecny
			//	SLD.MachineSpecificationPowerFactor(this.report);//TODO :HighChart power factor value is not being fetched
			//	SLD.MachineSpecificationPower(this.report);//TODO:DB Value is not considering decimal value of power to be matched
				SLD.MachineSpecificationStatus(this.report);
			//	SLD.MachineSpecificationVoltage(this.report);//TODO:Decimal point not matching with the DB Value
			//	SLD.MachineSpecificationCurrent(this.report);//TODO:Decimal point not matching with the DB Value
				//SLD.MachineSpecificationVTHD(this.report);//TODO:Decimal point not matching with the DB value
				SLD.MachineSpecificationCTHD(this.report);



		System.out.println("Executed SLD Component");  

	}  

	@Test  (groups= {"All"},priority = 4)  
	public void Trends() throws InterruptedException, IOException  
	{  

		Trends TR=new Trends(BaseTest.driver); 
		TR.ClickTrendsTab();
		TR.Search(this.report);
		//		////TR.DateFunction(this.report);//TODO-> Time Setting is giving issue over here also Graph hover value has to be fetched //DONE->It isgiving the data of 3mins of 18 date TR.OpenShieldHistory();
		//////TR.CompareDate(this.report); //TODO->Bug- not able to set the Compare date
		TR.CheckParameters(this.report); 
		//TR.CheckToday(this.report);//TODO->Not able to get the Value of ToolTip of Graph TR.CheckWeek(this.report);//TODO->Notable to get the Value of ToolTip of Graph
		TR.CheckWeek(this.report);
		TR.CheckMonth(this.report);
		////	TR.CheckMonth(this.report);//TODO->Not able to get the Value of ToolTip of Graph
		System.out.println("Executed Trends Component");

	}  
	@Test  (groups= {"All"},priority = 5)  
	public void Investigate() throws InterruptedException, FileNotFoundException, IOException  
	{  

		//Investigate IT=new Investigate(BaseTest.driver);
		//	IT.ClickInvestigateTab();
		//		IT.DeviceIDVerification(this.report);//TODO->To check the voltage and Current with exact match
		//		//IT.Date(this.report); 
		//		IT.AlertsDisplay(this.report);
		//		IT.TodayFunction(this.report); 
		//		IT.WeekFunction(this.report);
		//		IT.MonthFunction(this.report); 
		//		IT.AlertsDisplay(this.report); 
		//// IT.CompareDate();//TODO:Not able to perform



		System.out.println("Executed Investigate Component"); 
		Thread.sleep(5000);

	}  
	@Test  (groups= {"All"},priority = 6)  
	public void Reports() throws InterruptedException  
	{  
		//Shield History Report


		//		ShieldHistory ShieldHistoryreport=new ShieldHistory(BaseTest.driver);
		//
		//		ShieldHistoryreport.ClickShieldReportTab();
		//		ShieldHistoryreport.Datefunction(this.report);
		//		ShieldHistoryreport.Dailyfunction(this.report);
		//		ShieldHistoryreport.Hoursfunction(this.report);
		//		ShieldHistoryreport.Livefunction(this.report);
		//		ShieldHistoryreport.Todayfunction(this.report);
		//		ShieldHistoryreport.Monthfunction(this.report);
		//		ShieldHistoryreport.Exportfunction(this.report);

		//Analytics Monthly Comparison Report

		// AnalyticsMonthlyComparison AMCReport=new AnalyticsMonthlyComparison(BaseTest.driver); 
		//  AMCReport.ClickReportsTab();//Bug Element REport Tab not opening
		Thread.sleep(2000);
		// AMCReport.Equipment(this.report); 
		//AMCReport.Division(this.report);
		// AMCReport.Export(this.report);

		//Analytics Quarterly Comparison Report

		//AnalyticsQuarterlyComparision AQCReport=new AnalyticsQuarterlyComparision(BaseTest.driver); AQCReport.ClickReportsTab();
		//  AQCReport.Equipment(this.report); 
		//AQCReport.Division(this.report);
		//  AQCReport.Export(this.report);


		XMLReport XMLReport=new XMLReport(BaseTest.driver);
		//XMLReport.ClickReportsTab(); 
		//XMLReport.Date(this.report);
		//XMLReport.Today(this.report);
		//XMLReport.Week(this.report);
		//XMLReport.Month(this.report);

		IOTErrorLog IOTReport=new IOTErrorLog(BaseTest.driver);
		//	IOTReport.ClickIOTErrorLog();
		//	IOTReport.Week(this.report);
		//	IOTReport.Today(this.report);
		//	IOTReport.Month(this.report);
		//	IOTReport.Exportfunction(this.report);

		SystemErrorLog SEL=new SystemErrorLog(BaseTest.driver);
		//SEL.ClickSystemErrorLog();
		//SEL.Today(this.report);
		//SEL.Week(this.report);
		//	SEL.Month(this.report);
		SEL.Logout();		
		System.out.println("Executed Reports Component");  

	} 

	
    @AfterTest(groups= {"All,Dashboard"})  
	public void teardown()  
	{  

		report.flush();



	}  
	
}

