package KloudqTechnologies.PageObjects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class SECReportMaster  extends AbstractComponent{
	public  SECReportMaster(WebDriver driver)
	{
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	
	
	
	public void ClickReportsTab() 
	{
		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[2]/a/div/div/img"));
		clickReportsTab.click();

	}

	public void URLCheck() 
		{		
			String url = "https://shield.tor-iot.com/admin/masters/sec-report-master";
			driver.get(url);		      
			// get the current URL
			String strUrl = driver.getCurrentUrl();
			//Print the URL
			System.out.println("Current URL : "+strUrl);
	 
	 
		}
		public void ClickSECReportMaster() 
		{		
			//WebElement clickSECReportMaster=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[4]/div/div/div[38]/div/a/a"));
			//clickSECReportMaster.click();
			
			WebElement	clickSECReportMaster = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div[2]/div[4]/a[3]/div/span[1]"));

	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", clickSECReportMaster);
			
			clickSECReportMaster.click();
			
			
			
			
			
	 
		}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentReports report;
	private ExtentTest logger;




	
	public void SECReportandProductMaster(ExtentReports report1) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		// Check SEC product master in  Administrator 

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[5]")).click();


		WebElement	Element = driver.findElement(By.xpath("(//span[@class=\"fw-bold fs-6-dash title-color\"])[19]"));


		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", Element);

		Element.click();



		String SECProductMaster= driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bolder d-block fs-6\"])[1]")).getText();

		System.out.println("SECProductMaster :"+SECProductMaster);


		driver.findElement(By.xpath("(//span[@class=\"menu-title span-top headerfont\"])[6]")).click();

		driver.findElement(By.xpath("(//span[@class=\"menu-title rmenu-width title_color_submenu\"])")).click();

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[1]/div/div[1]/div/div[2]/input")).sendKeys("11/15/2023");

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[1]/div/div[2]/div/div[2]/input")).sendKeys("11/30/2023");

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[2]/button[1]")).click();


		String SECReportMaster= driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]/a")).getText();

		System.out.println("SECReportMaster :"+SECReportMaster);


		logger=report1.createTest("Check -> SECReportMaster and SECProductMaster code ");
		logger.info("Starting SECReportMaster and SECProductMaster code");
		logger.pass("SECReportMaster and SECProductMaster code Success");

		if (SECProductMaster==SECReportMaster) {

			System.out.println("The SECReportMaster and SECProductMaster  is matching ");
			logger.log(Status.PASS,"The SECReportMaster and SECProductMaster code is matching");
		}
		else {

			System.out.println("Error! in matching The SECReportMaster and SECProductMaster ");
			highLighterMethod(driver,Element);
			String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the SECReportMaster and SECProductMaster code is not matching ");

		}

	}
	
	
	public void AddSECProductMaster(ExtentReports report ) throws InterruptedException
	{	
	
	Thread.sleep(5000);
	WebElement AddNew=driver.findElement(By.cssSelector("#kt_content_container > app-masters > app-sec-product-lookup > div > div > div > div > div:nth-child(1) > div.col-12.col-sm-12.col-md-2.col-lg-2.col-xl-2 > div > div > a"));
	AddNew.click();
	
	
    // Counter variable
    int counter = 1;
    String textToSend = null;
    String textToSend2 = null;
    
    // Loop to send increasing counter values
    for (int i = 0; i < 5; i++)
    { // Sending 5 values, change the limit as needed
        textToSend = "SECProductMaster" + counter;
        
        // Increment the counter
        counter++;
    }
    WebElement SECProductMasterCode=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));
    SECProductMasterCode.click();
    SECProductMasterCode.sendKeys(textToSend);
    SECProductMasterCode.sendKeys(Keys.ENTER);
    
    
    for (int i = 0; i < 5; i++)
    { // Sending 5 values, change the limit as needed
        textToSend2 = "SECProductMaster Test" + counter;
        
        // Increment the counter
        counter++;
    }
    
    WebElement SECProductMasterName=driver.findElement(By.xpath("<input _ngcontent-nyk-c243=\"\" type=\"text\" formcontrolname=\"productName\" placeholder=\"Product Name\" maxlength=\"50\" class=\"form-control form-control-solid ng-pristine ng-invalid ng-touched\">"));
    SECProductMasterName.click();
    SECProductMasterName.sendKeys(textToSend2);
    SECProductMasterName.sendKeys(Keys.ENTER);
    
    
  

 // Division code module is not working 
    
    WebElement SECProductMasterDivisioncode=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[2]/div/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
    SECProductMasterDivisioncode.click();
    SECProductMasterDivisioncode.sendKeys("200");
    SECProductMasterDivisioncode.sendKeys(Keys.ENTER);
//    
  
 //   Equipment Hierarchy
    
    
//  WebElement SECProductMasterDivisionCcode=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[2]/div/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
//  SECProductMasterName.click();
//  SECProductMasterName.sendKeys("");
//  SECProductMasterName.sendKeys(Keys.ENTER);
//  

    
//   UOM
    
    
 WebElement SECProductMasterUOM=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[2]/div/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
 SECProductMasterUOM.click();
 SECProductMasterUOM.sendKeys("UOM200");
 SECProductMasterUOM.sendKeys(Keys.ENTER);
//  

//   Counter
    
    
//  WebElement SECProductMasterDivisionCcode=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[2]/div/div/form/div[2]/div[1]/ng-select/div/div/div[2]/input"));
//  SECProductMasterName.click();
//  SECProductMasterName.sendKeys("");
//  SECProductMasterName.sendKeys(Keys.ENTER);
//  
    
    
    
    WebElement btnSubmit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[3]/div/button[1]"));
	btnSubmit.click();
	
	// view list
	
	WebElement viewlist=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-product-crud/div/div/div/div/div[1]/div[2]/button"));
	viewlist.click();
	

	
	// Identify the table element
	//Here we are saving the table and storing all the elements in the Table
			WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table")); // Replace 'tableId' with the actual ID of the table

			// Define the column index you want to work with (assuming it's the second column, index 1)
			int columnIndex = 1;

			// Use XPath to find all the elements in the specified column
			List<WebElement> columnElements = table.findElements(By.className("table" + (columnIndex + 1) + "]"));
			// XPath for the column elements, adding 1 to columnIndex because XPath indexes start from 1

			// Now, you have all the elements in the specified column. You can perform verifications or actions on these elements.
			  System.out.println("SECProductMasterCode :");
		        for (WebElement WebElementSECProductMasterCode : columnElements)
		        {
		            System.out.println(SECProductMasterCode.getText());
		        }
		        
		   //Finding the List is showing whether added sub category is being displayed in the table     
		        // Replace with your specific text

		        boolean textFound = false;

		        // Iterate through the elements and check for the specific text
		        for (WebElement element : columnElements)
		        {
		            String elementText = element.getText();
		            if (elementText.contains(textToSend2))
		            {
		                textFound = true;
		                break;
		            }
		        }
		        
		        logger=report.createTest("Check -> All Textfields are filled in SECProductMasterCode");
				logger.info("Starting Adding new SECProductMasterCode");
				logger.pass(" Check SECProductMasterCode");
				
		        // Check if the text was found in any of the elements
		        if (textFound) {
		            System.out.println("SECProductMasterCode  '" + textToSend2 + "' found in at least one element. Test Passed!");
		        } else {
		            System.out.println("SECProductMasterCode '" + textToSend2 + "' not found in any elements. Test Failed!");
		        }
    
}


	public void SECReportexport(ExtentReports report2) throws SQLException, FileNotFoundException, IOException, InterruptedException	{	

		WebElement exportButton = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[2]/button[3]"));
		exportButton.click();


		logger=report2.createTest("Check Export Function->SECReort Data Export ");
		logger.info("SECReort Data Export function Test");
		logger.pass("Visibility Test Success");

		// Verify that the file has been downloaded (replace "your-file-name" with the actual file name)
		String downloadedFileName = "SECReort Data Report.xlsx";
		boolean isFileDownloaded = isFileDownloaded(downloadedFileName);


		if (isFileDownloaded) {
			System.out.println("File downloaded successfully.");
			logger.log(Status.PASS,"SECReort Data Export function file is downloaded successfully");
			// You can add further processing here if needed
		} else {
			System.out.println("File download failed.");
			logger.log(Status.FAIL,"Error! SECReort Data Export function file is not downloaded successfully");
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
//	public void teardown() {
//		report.flush();
//	}


}
