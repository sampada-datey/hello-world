package KloudqTechnologies.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class XMLReport extends AbstractComponent{

	public XMLReport(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	public void ClickReportsTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div"));
		clickReportsTab.click();
		ClickXMLReport();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/reports/xml-viewer";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickXMLReport() 
	{		
		WebElement clickXMLReport=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[6]/div/div/div[18]/div/a/a"));
		clickXMLReport.click();


	}

	public void Date(ExtentReports report1) throws InterruptedException, IOException
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
		WebElement clickdtp=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		clickdtp.click();

		WebElement clickFrom=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[1]/div[1]/span/span[1]"));
		clickFrom.click();


		WebElement hourdownarrow=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/button[2]"));
		hourdownarrow.click();
		hourdownarrow.click();
		WebElement clickTo=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[1]/div[2]/span/span[1]"));
		clickTo.click();

		Thread.sleep(2000);
		WebElement houruparrow=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/button[1]"));
		houruparrow.click();
		houruparrow.click();

		WebElement btnset=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[2]/button[2]"));
		btnset.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();


		logger=report1.createTest("Check Date Function-> XML Report Data Table ");
		logger.info("XML Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("XML Report Data Table is visible");
			logger.log(Status.PASS,"XML Report Data Table is visible in Daily function");
		}else {


			System.out.println("XML Report Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    XML Report Data Table is not visible in Daily function");

		}


	}

	public void Today(ExtentReports report2) throws InterruptedException, IOException
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
		
		
		
		
		
		WebElement clickToday=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[1]/a"));
		clickToday.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();


		logger=report2.createTest("Check Today Function-> XML Report Data Table ");
		logger.info("XML Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("XML Report Data Table is visible");
			logger.log(Status.PASS,"XML Report Data Table is visible in Today function");
		}else {


			System.out.println("XML Report Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    XML Report Data Table is not visible in Today function");

		}
	}
	public void Week(ExtentReports report3) throws InterruptedException, IOException
	{
		WebElement clickWeek=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[2]/a"));
		clickWeek.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();


		logger=report3.createTest("Check Week Function-> XML Report Data Table ");
		logger.info("XML Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) {
			System.out.println("XML Report Data Table is visible");
			logger.log(Status.PASS,"XML Report Data Table is visible in Week function");
		}else {


			System.out.println("XML Report Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    XML Report Data Table is not visible in Week function");

		}



	}
	public void Month(ExtentReports report4) throws InterruptedException, IOException
	{
		WebElement clickMonth=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[3]/a"));
		clickMonth.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();


		logger=report4.createTest("Check Month Function-> XML Report Data Table ");
		logger.info("XML Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) 
		{
			
			System.out.println("XML Report Data Table is visible");
			logger.log(Status.PASS,"XML Report Data Table is visible in Month function");
		}
		else 
		{

			System.out.println("XML Report Table is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    XML Report Data Table is not visible in Month function");

		}

	//	driver.get(dir);

	}
	
	public void teardown() {
		//report.flush();
	}
}
