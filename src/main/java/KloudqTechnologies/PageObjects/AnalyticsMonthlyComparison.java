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

public class AnalyticsMonthlyComparison extends AbstractComponent{

	public AnalyticsMonthlyComparison(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	
	public void ClickReportsTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div"));
		clickReportsTab.click();
		ClickAMCReport();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/tor-lenz/energy/energy-reports/monthly-comparision";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickAMCReport() 
	{		
		WebElement clickAMCReport=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[4]/div/div/div[37]/div/a/a"));
		clickAMCReport.click();


	}
	public void Equipment(ExtentReports report1) throws InterruptedException, IOException
	{		
		WebElement clickSite=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
		clickSite.click();
		clickSite.sendKeys("KTL");
		WebElement clickKTL=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		clickKTL.click();
		
		WebElement clickEquip=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[2]/ng-select/div/div/div[2]/input"));
		clickEquip.click();
		clickEquip.sendKeys("23-1");
		
		WebElement click23=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-monthly-comparision/div/div[2]/div/div/div/div/form/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		click23.click();
		
		WebElement clickyear1=driver.findElement(By.xpath("//*[@id=\"year\"]"));
		clickyear1.click();
		
		
		WebElement click2023=driver.findElement(By.xpath("//*[@id=\"year\"]/option[2]"));
		click2023.click();
		
		
		WebElement clickyear2=driver.findElement(By.xpath("//*[@id=\"compYear\"]"));
		clickyear2.click();
		
		
		WebElement click2022=driver.findElement(By.xpath("//*[@id=\"compYear\"]/option[3]"));
		click2022.click();
		
		
		WebElement clickmonth=driver.findElement(By.xpath("//*[@id=\"month\"]"));
		clickmonth.click();
		
		
		WebElement clickFeb=driver.findElement(By.xpath("//*[@id=\"month\"]/option[3]"));
		clickFeb.click();
		
		
		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		

		logger=report1.createTest("Check Equipment Function-> Analytics Monthly Comparison Data Table ");
		logger.info("Analytics Monthly Comparison Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("Monthly Comparison Report Data Table is visible");
			logger.log(Status.PASS,"Analytics Monthly Comparison Report Data Table is visible in Daily function");
		}else {


			System.out.println("Monthly Comparison Report Data Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Analytics Monthly Comparison Report Data Table is not visible in Daily function");

		}
	}
		public void Division(ExtentReports report2) throws InterruptedException, IOException
		{		
			WebElement selectDivision=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[1]/a[2]"));
			selectDivision.click();
			
			
			WebElement clickdivision=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/ng-select"));
			clickdivision.click();
			clickdivision.sendKeys("ACRREF");
			
			WebElement clickACRREF=driver.findElement(By.xpath("//*[@id=\"a83df1003fdf-1\"]"));
			clickACRREF.click();
			
			
			
			WebElement clickyear1=driver.findElement(By.xpath("//*[@id=\"year\"]"));
			clickyear1.click();
			
			
			WebElement click2023=driver.findElement(By.xpath("//*[@id=\"year\"]/option[2]"));
			click2023.click();
			
			
			WebElement clickyear2=driver.findElement(By.xpath("//*[@id=\"compYear\"]"));
			clickyear2.click();
			
			
			WebElement click2022=driver.findElement(By.xpath("//*[@id=\"compYear\"]/option[3]"));
			click2022.click();
			
			
			WebElement clickmonth=driver.findElement(By.xpath("//*[@id=\"month\"]"));
			clickmonth.click();
			
			
			WebElement clickFeb=driver.findElement(By.xpath("//*[@id=\"month\"]/option[3]"));
			clickFeb.click();
			
			
			WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
			btnFilter.click();
			
			

			logger=report2.createTest("Check Division Function-> Analytics Monthly Comparison Data Table ");
			logger.info("Monthly Comparison Report Test");
			logger.pass("Visibility Test Success");



			WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

			if(historytable.isDisplayed()) 
			{
				System.out.println("Monthly Comparison Report Data Table is visible");
				logger.log(Status.PASS,"Analytics Monthly Comparison Report Data Table is visible in Daily function");
			}else 
			{


				System.out.println("Monthly Comparison Report Data Table is not visible");
				logger.log(Status.FAIL,"Analytics Monthly Comparison Report Data Table is not visible in Daily function");
				
				
				String screenshotPath=ErrorScreenshot(driver, historytable);
				logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Analytics Monthly Comparison Report Data Table is not visible in Daily function");

			}
			
		
	}
		
		
		public void Export(ExtentReports report3) throws InterruptedException
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



			logger=report3.createTest("Check Export Function-> Shield History Data Export ");
			logger.info("Analytics Monthly Comparison Export function Test");
			logger.pass("Visibility Test Success");

			// Verify that the file has been downloaded (replace "your-file-name" with the actual file name)
			String downloadedFileName = "Monthly Comparision Report.xlsx";
			boolean isFileDownloaded = isFileDownloaded(downloadedFileName);


			if (isFileDownloaded) {
				System.out.println("File downloaded successfully.");
				logger.log(Status.PASS,"Analytics Monthly Comparison Export function file is downloaded successfully");
				// You can add further processing here if needed
			} else {
				System.out.println("File download failed.");
				logger.log(Status.FAIL,"Error! Analytics Monthly Comparison Export function file is not downloaded successfully");
			}
			
			
			driver.get(dir);
			
			
		}

		private boolean isFileDownloaded(String fileName) {

			String downloadPath = System.getProperty("user.dir") + "/exportdownload/" ;
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
	
		public void teardown() {
		//	report.flush();
		}
}
