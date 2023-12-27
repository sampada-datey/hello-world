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

public class SystemErrorLog extends AbstractComponent {

	public SystemErrorLog(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

	public void ClickShieldReportTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div"));
		clickReportsTab.click();
		ClickSystemErrorLog();
		URLCheck();

	}
	

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/reports/system-errorlog";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickSystemErrorLog() 
	{		
		WebElement clickSystemErrorLog=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[6]/div/div/div[20]/div/a/a"));
		clickSystemErrorLog.click();


	}
	public void Today(ExtentReports report) throws IOException 
	{		
		
		WebElement clickToday=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[1]/a"));
		clickToday.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		logger=report.createTest("Check Today Function-> XML Report Data Table ");
		logger.info("System Error Log Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) 
		{
			
			System.out.println("System Error Log Data Table is visible in Today Function");
			logger.log(Status.PASS,"System Error Log Data Table is visible in Today Function");
		}
		else 
		{

			System.out.println("System Error Log Table is not visible in Today Function");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    System Error Log Data Table is not visible in Month function");

		}
		
		
		

	}
	
	public void Week(ExtentReports report2) throws IOException 
	{		
		
		WebElement clickWeek=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[2]/a"));
		clickWeek.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		logger=report2.createTest("Check Week Function-> System Error Log Data Table ");
		logger.info("System Error Log Data Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) 
		{
			
			System.out.println("System Error Log Data Table is visible");
			logger.log(Status.PASS,"System Error Log Data Table is visible in Week function");
		}
		else 
		{

			System.out.println("System Error Log Data is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    System Error Log Data Table is not visible in Week function");

		}
		
		
	}
	public void Month(ExtentReports report3) throws IOException 
	{		
		
		WebElement clickMonth=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[1]/div[3]/a"));
		clickMonth.click();

		WebElement btnFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilter.click();
		
		logger=report3.createTest("Check Month Function-> System Error Log Data Table ");
		logger.info("System Error Log Data Report Visibility Test");
		logger.pass("Visibility Test Success");



		WebElement historytable=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/table"));

		if(historytable.isDisplayed()) 
		{
			
			System.out.println("System Error Log Data Table is visible");
			logger.log(Status.PASS,"System Error Log Data Table is visible in Month function");
		}
		else 
		{

			System.out.println("System Error Log Data is not visible");
			
			String screenshotPath=ErrorScreenshot(driver, historytable);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    System Error Log Data Table is not visible in Month function");

		}
		
		driver.get(dir);
	}
	
	
	public void teardown() {
		report.flush();
	}
	
	public void Logout() {
		
		WebElement ProfileImage=driver.findElement(By.xpath("//*[@id=\"kt_header_user_menu_toggle\"]/div/img"));
		ProfileImage.click();
		
		WebElement Signout=driver.findElement(By.xpath("//*[@id=\"kt_header_user_menu_toggle\"]/div/div/div[4]/a"));
		Signout.click();
	}
	
}
