package KloudqTechnologies.PageObjects;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.chrome.ChromeOptions;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class ShieldHistory extends AbstractComponent{

	public ShieldHistory(WebDriver driver)
	{
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

	public void ClickShieldReportTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div"));
		clickReportsTab.click();
		ClickShieldHistory();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/tor-lenz/energy/energy-reports/lenz-parameter-history";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickShieldHistory() 
	{		
		WebElement clickShieldHistory=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[4]/div/div/div[35]/div/a"));
		clickShieldHistory.click();


	}
	public void Datefunction(ExtentReports report1) throws InterruptedException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


		WebElement selectsite=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[1]/ng-select/div"));
		selectsite.click();

		WebElement siteinput=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[1]/ng-select/div/div/div[2]/input"));
		siteinput.sendKeys("KTL");

		WebElement selectKTL=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectKTL.click();

		WebElement equipinput=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/ng-select/div/div/div[2]/input"));
		equipinput.click();
		equipinput.sendKeys("23-1");
	
		
		WebElement selectequip=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectequip.click();

		WebElement selectDaily=driver.findElement(By.xpath("//*[@id=\"Daily\"]"));
		selectDaily.click();

		WebElement datepicker=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/app-custom-date-time-range/div[2]/div[2]/label[1]/span"));
		datepicker.click();

		WebElement Todate=driver.findElement(By.className("owl-dt-container-to"));
		Todate.click();
		Thread.sleep(2000);
		WebElement hoursincreased=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/button[1]"));
		hoursincreased.click();
		Thread.sleep(1000);
		hoursincreased.click();

		WebElement btnSet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/div[2]/button[2]"));
		btnSet.click();


		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();


		logger=report1.createTest("Check Date Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Date Function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			logger.log(Status.FAIL,"Shield History Data Table is not visible in Date Function");
		}


	}
	public void Dailyfunction(ExtentReports report2) throws InterruptedException, IOException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


//		WebElement selectsite=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[1]/ng-select/div"));
//		selectsite.click();
//
//		WebElement siteinput=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[1]/ng-select/div/div/div[2]/input"));
//		siteinput.sendKeys("KTL");
//
//		WebElement selectKTL=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
//		selectKTL.click();
//
//		WebElement equipinput=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/ng-select/div/div/div[2]/input"));
//		equipinput.click();
//		equipinput.sendKeys("23-1");

		Thread.sleep(1000);

//		WebElement selectequip=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
//		selectequip.click();

		WebElement selectDaily=driver.findElement(By.xpath("//*[@id=\"Daily\"]"));
		selectDaily.click();

		WebElement btnClear=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnClear.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();

		
		
		
		
		
		
		logger=report2.createTest("Check Daily Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Daily function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Daily function");

			
		}

	}

	public void Hoursfunction(ExtentReports report3) throws InterruptedException, IOException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


		WebElement selectHours=driver.findElement(By.xpath("//*[@id=\"Hours\"]"));
		selectHours.click();

		WebElement btnclear=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/div[1]/button"));
		btnclear.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();


		logger=report3.createTest("Check Hours Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Hours function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Hours function");

		}
	}


	public void Livefunction(ExtentReports report4) throws InterruptedException, IOException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


		WebElement selectLive=driver.findElement(By.xpath("//*[@id=\"Live\"]"));
		selectLive.click();

		WebElement btnclear=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/div[1]/button"));
		btnclear.click();


		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();

		logger=report4.createTest("Check Live Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Live function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Live function");

		}
	}
	public void Todayfunction(ExtentReports report5) throws InterruptedException, IOException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


		WebElement selectToday=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[1]"));
		selectToday.click();

		WebElement btnclear=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/div[1]/button"));
		btnclear.click();


		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();



		logger=report5.createTest("Check Today Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Today function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Today function");

			
		}

	}
	public void Weekfunction(ExtentReports report6) throws InterruptedException, IOException {

		//Here the date is current date and checking the two hours data 
		//Here the date picker is not allowing the from and to date to be validated from code scenario current date - two days

		//not working elements are not working


		WebElement selectWeek=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[2]"));
		selectWeek.click();

		WebElement btnclear=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/div[1]/button"));
		btnclear.click();


		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();

		logger=report6.createTest("Check Week Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Week function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Week function");

		}


	}
	public void Monthfunction(ExtentReports report7) throws InterruptedException, IOException {



		WebElement selectMonth=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[3]"));
		selectMonth.click();

		WebElement btnclear=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/div[1]/button"));
		btnclear.click();


		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[4]"));
		btnFilter.click();

		logger=report7.createTest("Check Month Function-> Shield History Data Table ");
		logger.info("Shield History Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.className("dataTables_scroll"));

		if(historytable.isDisplayed()) {
			System.out.println("Shield History Data Table is visible");
			logger.log(Status.PASS,"Shield History Data Table is visible in Month function");
		}else {


			System.out.println("Shield History Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Shield History Data Table is not visible in Month function");

		}


	}

	private boolean isFileDownloaded(String fileName) {
		// Check if a file with the specified name exists in the download directory


		String downloadPath = System.getProperty("user.dir")+"/exportdownload/" ;
		File downloadDir = new File(downloadPath);
		File[] downloadedFiles = downloadDir.listFiles();

		if (downloadedFiles != null) 
		{
			for (File file : downloadedFiles) 
			{
				if (file.getName().equals(fileName)) 
				{
					return true;


				}
			}
		}

		return false;
	}
	public void Exportfunction(ExtentReports report8) throws InterruptedException 
	{
		// Configure Chrome options to specify download directory
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("--download.default_directory=path/to/downloaded/files");



		// Locate and click the element that initiates the file export
		WebElement exportButton = driver.findElement(By.xpath("//*[@id=\"kt_password_submit\"]"));
		exportButton.click();



		logger=report8.createTest("Check Export Function-> Shield History Data Export ");
		logger.info("Shield History Export function Test");
		logger.pass("Visibility Test Success");

		// Verify that the file has been downloaded (replace "your-file-name" with the actual file name)
		String downloadedFileName = "Lenz Parameter History.xlsx";
		boolean isFileDownloaded = isFileDownloaded(downloadedFileName);


		if (isFileDownloaded) {
			System.out.println("File downloaded successfully.");
			logger.log(Status.PASS,"Shield History Export function file is downloaded successfully");
			// You can add further processing here if needed
		} else {
			System.out.println("File download failed.");
			logger.log(Status.FAIL,"Error! Shield History Export function file is not downloaded successfully");
		}
		
	//	driver.get(dir);
		
	}

	
	public void teardown() {
	//	report.flush();
	}
}
