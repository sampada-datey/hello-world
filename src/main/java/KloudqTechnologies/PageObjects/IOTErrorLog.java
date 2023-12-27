package KloudqTechnologies.PageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class IOTErrorLog extends AbstractComponent{

	public IOTErrorLog(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	public void ClickReportsTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div"));
		clickReportsTab.click();
		ClickIOTErrorLog();
		URLCheck();

	}
	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/reports/iot-errorlog";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickIOTErrorLog() 
	{		
		WebElement clickIOTErrorLog=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[6]/div/div/div[18]/div/a/a"));
		clickIOTErrorLog.click();


	}
	
	
	public void Week(ExtentReports report1) throws InterruptedException, IOException
	{
		WebElement clickSite=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
		clickSite.click();
		clickSite.sendKeys("KTL");
		WebElement clickKTL=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		clickKTL.click();

		WebElement clickEquip=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[2]/ng-select/div/div/div[2]/input"));
		clickEquip.click();
		clickEquip.sendKeys("23-1");
		Thread.sleep(2000);
		WebElement click23=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		click23.click();

		Thread.sleep(2000);
		

		WebElement btnWeek=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-iot-errorlog/div/div[1]/div/div/div/div[1]/form/div/app-custom-date-time-range/div[2]/div[1]/div[2]/a"));
		btnWeek.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		logger=report1.createTest("Check Today Function-> IOT Error Log Report Data Table ");
		logger.info("IOT Error Log Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("IOT Error Log Report Data Table is visible");
			logger.log(Status.PASS,"IOT Error Log Report Data Table is visible in Week function");
		}else {


			System.out.println("IOT Error Log Report Table is not visible in Week function");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    IOT Error Log Report Data Table is not visible in Week function");

		}
		
		
	}
	public void Today(ExtentReports report) throws InterruptedException, IOException
	{
		WebElement btnToday=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-iot-errorlog/div/div[1]/div/div/div/div[1]/form/div/app-custom-date-time-range/div[2]/div[1]/div[1]/a"));
		btnToday.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		logger=report.createTest("Check Today Function-> IOT Error Log Report Data Table ");
		logger.info("IOT Error Log Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("IOT Error Log Report Data Table is visible");
			logger.log(Status.PASS,"IOT Error Log Report Data Table is visible in Today function");
		}else {


			System.out.println("IOT Error Log Report Table is not visible");
			logger.log(Status.FAIL,"IOT Error Log Report Table is not visible in Today function");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    IOT Error Log Report Table is not visible in Today function");

		}
		
	}
	public void Month(ExtentReports report2) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		

		WebElement btnMonth=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-iot-errorlog/div/div[1]/div/div/div/div[1]/form/div/app-custom-date-time-range/div[2]/div[1]/div[3]/a"));
		btnMonth.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		logger=report2.createTest("Check Month Function-> IOT Error Log Report Data Table ");
		logger.info("IOT Error Log Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("IOT Error Log Report Table is visible");
			logger.log(Status.PASS,"IOT Error Log Report Data Table is visible in Month function");
		}else {


			System.out.println("IOT Error Log Report Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    IOT Error Log Report Data is not visible in Month function");

		}
		
		
	}
	
	
	
	private boolean isFileDownloaded(String fileName) 
	{
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



		logger=report8.createTest("Check Export Function-> IOT Error Log Data Export ");
		logger.info("IOT Error Log Export function Test");
		logger.pass("Visibility Test Success");

		// Verify that the file has been downloaded (replace "your-file-name" with the actual file name)
		String downloadedFileName = "IOT-Error Report.xlsx";
		boolean isFileDownloaded = isFileDownloaded(downloadedFileName);


		if (isFileDownloaded) {
			System.out.println("File downloaded successfully.");
			logger.log(Status.PASS,"IOT Error Log Export function file is downloaded successfully");
			// You can add further processing here if needed
		} else {
			System.out.println("File download failed.");
			logger.log(Status.FAIL,"Error! IOT Error Log Export function file is not downloaded successfully");
		}
		
		
		//driver.get(dir);
		
	}
	
	public void teardown() {
		//report.flush();
	}
	
	

}
