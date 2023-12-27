package KloudqTechnologies.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class SubCategoryMaster extends AbstractComponent{

	public SubCategoryMaster(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

	public void ClickAdministrator() throws InterruptedException 
	{
		WebElement clickAdministrator=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[5]/a"));
		clickAdministrator.click();
		ClickSubCategoryMaster();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/admin/masters/subcategory";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickSubCategoryMaster() throws InterruptedException 
	{		

		Thread.sleep(1000);		
		WebElement clickAlertMaster=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div[2]/div[2]/a[4]/div/span[2]"));
		clickAlertMaster.click();


	}


	public void AddSubCategoryMaster(ExtentReports report ) throws InterruptedException, IOException
	{			

		Thread.sleep(5000);
		WebElement AddNew=driver.findElement(By.cssSelector("#kt_content_container > app-masters > app-category-list > div > div > div > div > div:nth-child(1) > div.col-12.col-sm-12.col-md-2.col-lg-2.col-xl-2 > div > div > a"));
		AddNew.click();


		// Counter variable
		int counter = 1;
		String textToSend = null;
		String textToSend2 = null;

		// Loop to send increasing counter values
		for (int i = 0; i < 5; i++)
		{ // Sending 5 values, change the limit as needed
			textToSend = "SubCategory" + counter;

			// Increment the counter
			counter++;
		}
		WebElement SubCategoryCode=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));
		SubCategoryCode.click();
		SubCategoryCode.sendKeys(textToSend);
		SubCategoryCode.sendKeys(Keys.ENTER);


		for (int i = 0; i < 5; i++)
		{ // Sending 5 values, change the limit as needed
			textToSend2 = "Sub Category Test" + counter;

			// Increment the counter
			counter++;
		}

		WebElement SubCategoryName=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));
		SubCategoryName.click();
		SubCategoryName.sendKeys(textToSend2);
		SubCategoryName.sendKeys(Keys.ENTER);


		WebElement SubCategoryImage=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));


		// Check if the image is displayed
		if (SubCategoryImage.isDisplayed()) {
			System.out.println("Image is displayed. Test Passed!");
		} else {
			System.out.println("Image is not displayed. Test Failed!");
		}


		WebElement ProductCategoryName=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[2]/div[2]/ng-select/div/div/div[3]/input"));
		ProductCategoryName.click();
		ProductCategoryName.sendKeys("ProductCategoryTestName");
		ProductCategoryName.sendKeys(Keys.ENTER);


		WebElement btnSubmit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[3]/div/button[1]"));
		btnSubmit.click();

		WebElement btnOK=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]"));
		btnOK.click();



		// Identify the table element
		//Here we are saving the table and storing all the elements in the Table
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table")); // Replace 'tableId' with the actual ID of the table

		// Define the column index you want to work with (assuming it's the second column, index 1)
		int columnIndex = 1;

		// Use XPath to find all the elements in the specified column
		List<WebElement> columnElements = table.findElements(By.className("table" + (columnIndex + 1) + "]")); 
		// XPath for the column elements, adding 1 to columnIndex because XPath indexes start from 1

		// Now, you have all the elements in the specified column. You can perform verifications or actions on these elements.
		System.out.println("Sub Category Codes :");
		for (WebElement SubCategoryCodename : columnElements)
		{
			System.out.println(SubCategoryCodename.getText());
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

		logger=report.createTest("Check -> All Textfields are filled in Sub Category Master");
		logger.info("Starting Adding new Sub Category");
		logger.pass(" Check Sub Category");

		// Check if the text was found in any of the elements
		if (textFound) {
			System.out.println("Sub Category Code  '" + textToSend2 + "' found in at least one element. Test Passed!");
			logger.log(Status.PASS,"Sub Category Add function is working");
		
		} else {
			System.out.println("Sub Category Code '" + textToSend2 + "' not found in any elements. Test Failed!");
			
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Sub Category Add function is working");

		}

	}

	public void EditSubCategory(ExtentReports report2 ) throws InterruptedException, IOException
	{		
		WebElement btnEdit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[1]"));
		btnEdit.click();


		WebElement EditSubCategory=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));
		EditSubCategory.click();

		EditSubCategory.sendKeys("Content of Sub Category Message is Edited");
		EditSubCategory.sendKeys(Keys.ENTER);


		WebElement btnUpdate=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[3]/div/button[1]"));
		btnUpdate.click();

		WebElement btnOK=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]"));
		btnOK.click();

		WebElement btnEditAgain=driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[1]"));
		btnEditAgain.click();

		// Find the text area element by its ID or any other suitable locator
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input")); // Change "textAreaId" to the actual ID

		// Get the text content of the text area
		String textInTextArea = textArea.getAttribute("value"); // For textarea, use 'getAttribute("value")'

		// Text to verify
		String textToVerify = "Content of Sub Category Message is Edited";

		logger=report2.createTest("Check -> All Edit function Sub Category Master");
		logger.info("Starting Editing new Sub Category");
		logger.pass("Editing in Sub Category");

		// Check if the textToVerify is present in the text area
		if (textInTextArea.contains(textToVerify)) 
		{
			System.out.println("Sub Category Message '" + textToVerify + "' is present in the text area.");
			logger.log(Status.PASS,"Text is Verified Edit function is working");
		} 
		else 
		{
			System.out.println("Sub Category Message '" + textToVerify + "' is NOT present in the text area.");

			
			String screenshotPath=ErrorScreenshot(driver, textArea);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Edit function is not working in Sub Category Master");

		}

		WebElement btnViewList=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-add/div/div/div/div/div[1]/div[2]/button"));
		btnViewList.click();
	}
	public void DeleteSubCategory(ExtentReports report3 ) throws InterruptedException, IOException
	{


		// Find the delete button element
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[2]")); // Change the locator as needed

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


		// Verify deletion
		// Find the table element
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table")); // Change the locator as needed

		// Get all rows in the table
		int actualRowCount = table.findElements(By.tagName("tr")).size();

		// Define total expected rows
		int expectedRowCount = actualRowCount-1; // Change this to your expected number of rows


		logger=report3.createTest("Check -> All Delete function Sub Category");
		logger.info("Starting Delete Sub Category");
		logger.pass("Deleting in Sub Category");
		// Compare actual row count with expected row count
		if (actualRowCount < expectedRowCount) {
			System.out.println("Sub Category List has updated with Deletion operation");
			logger.log(Status.PASS,"Text is Verified Delete function is working in Sub Category Master");
		} else {
			System.out.println("Sub Category List has updated with Deletion operation");
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is Verified Delete function is working in Sub Category Master");

		}

	}

	public void SearchSubCategory(ExtentReports report4 ) throws InterruptedException, IOException
	{


		WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"example-search-input\"]")); // Change "searchInput" to the actual ID

		// Enter search query and perform search
		String query = "SearchByName"; // Replace with the actual search query
		searchInput.sendKeys(query);
		searchInput.sendKeys(Keys.ENTER); // Assuming ENTER key triggers the search, else locate and click the search button

		// Wait for search results to load (You might need explicit waits here)
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-category-list/div/div/div/div/div[2]/div/div/table")); // Replace with actual table ID

		// Get all rows from the table
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		boolean isQueryPresent = false;

		// Iterate through each row to check if the query is present in the table

		for (WebElement row : rows) 
		{
			// Assuming the text to be searched is in the first column of the table
			WebElement cell = row.findElement(By.tagName("td"));
			String cellText = cell.getText();

			if (cellText.contains(query)) {
				isQueryPresent = true;
				break;
			}
		}
		
		logger=report4.createTest("Check -> All Search function Sub Category Master");
		logger.info("Starting Search new Sub Category Master");
		logger.pass("Searching in Sub Category Master");
		// Verify if the query is present in the table
		if (isQueryPresent) {
			System.out.println("Search query'" + query + "' is present in the table results.");
			logger.log(Status.PASS,"Text is Verified Search function is working in Sub Category Master");
		} else {
			System.out.println("Search query'" + query + "' is NOT present in the table results.");
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Search function is not working in Sub Category Master");

			
			
		}

	}

}
