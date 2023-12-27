package KloudqTechnologies.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class HolidayMaster extends AbstractComponent{

	public HolidayMaster(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	public void ClickAdministrator() throws InterruptedException 
	{
		WebElement clickAdministrator=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[5]/a"));
		clickAdministrator.click();
		ClickHolidayMaster();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/admin/masters/holiday-master";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickHolidayMaster() throws InterruptedException 
	{		

		Thread.sleep(1000);		
		WebElement clickAlertMaster=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div[2]/div[2]/a[5]/div/span[2]"));
		clickAlertMaster.click();


	}


	public void AddNewHoliday(ExtentReports report1 ) throws InterruptedException
	{			

		Thread.sleep(5000);
		WebElement AddNew=driver.findElement(By.cssSelector("#kt_content_container > app-masters > app-holiday-master > div > div > div > div > div:nth-child(1) > div.col-12.col-sm-12.col-md-2.col-lg-2.col-xl-2 > div > div > a"));
		AddNew.click();



		WebElement HolidayType=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[2]/div[1]/input"));
		HolidayType.click();
		HolidayType.sendKeys("HolidayCalendar");
		HolidayType.sendKeys(Keys.ENTER);	



		WebElement OptionalDate=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master-crud/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));
		OptionalDate.click();



	}

	public void EditHoliday(ExtentReports report2 ) throws InterruptedException, IOException
	{		
		WebElement btnEdit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master/div/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div/a[1]/span/svg"));
		btnEdit.click();


		WebElement EditHolidayname=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/input"));
		EditHolidayname.click();

		EditHolidayname.sendKeys("Content of Holiday Name is Edited");
		EditHolidayname.sendKeys(Keys.ENTER);


		WebElement btnSubmit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/input"));
		btnSubmit.click();



		WebElement btnEditAgain=driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-masters/app-holiday-master/div/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div/a[1]/span/svg"));
		btnEditAgain.click();

		// Find the text area element by its ID or any other suitable locator
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/input")); // Change "textAreaId" to the actual ID

		// Get the text content of the text area
		String textInTextArea = textArea.getAttribute("value"); // For textarea, use 'getAttribute("value")'

		// Text to verify
		String textToVerify = "Content of Holiday Name is Edited";

		logger=report2.createTest("Check -> All Edit function Holiday");
		logger.info("Starting Editing Holiday");
		logger.pass("Editing in Holiday");

		// Check if the textToVerify is present in the text area
		if (textInTextArea.contains(textToVerify)) {
			System.out.println("Holiday Message '" + textToVerify + "' is present in the text area.");
			logger.log(Status.PASS,"Text is Verified Edit function is working");
		} 
		else 
		{
			System.out.println("Alert Message '" + textToVerify + "' is NOT present in the text area.");

			
			String screenshotPath=ErrorScreenshot(driver, textArea);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Edit function is not working in Holiday master");

		}

		WebElement btnViewList=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master-crud/div/div/div/div/div[1]/div[2]/button"));
		btnViewList.click();
	}


	public void DeleteHoliday(ExtentReports report3 ) throws InterruptedException, IOException
	{


		// Find the delete button element
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[2]")); // Change the locator as needed

		// Click the delete button
		deleteButton.click();

		// Find the delete button element
		WebElement YesdeleteButton = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")); // Change the locator as needed

		// Click the delete button
		YesdeleteButton.click();


		// Find the ok button element
		WebElement OKdeleteButton = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")); // Change the locator as needed

		// Click the delete button
		OKdeleteButton.click();



		// Wait for deletion process (if needed)

		// Verify deletion
		// Find the table element
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-holiday-master/div/div/div/div/div[2]/div/div/table")); // Change the locator as needed

		// Get all rows in the table
		int actualRowCount = table.findElements(By.tagName("tr")).size();

		// Define total expected rows
		int expectedRowCount = actualRowCount-1; // Change this to your expected number of rows


		logger=report3.createTest("Check -> All Delete function Holiday");
		logger.info("Starting Delete Holiday");
		logger.pass("Deleting in Holiday");
		// Compare actual row count with expected row count
		if (actualRowCount < expectedRowCount) {
			System.out.println("Holiday List has updated with Deletion operation");
			logger.log(Status.PASS,"Delete function is not working in Holiday Master");
		} else {
			System.out.println("Holiday List has updated with Deletion operation");
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Delete function is not working in Holiday Maste");

		}

	}
}
