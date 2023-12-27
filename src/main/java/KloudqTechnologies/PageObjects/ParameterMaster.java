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

public class ParameterMaster extends AbstractComponent{

	public ParameterMaster(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}


	public void ClickAdministrator() throws InterruptedException 
	{
		WebElement clickAdministrator=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[5]/a"));
		clickAdministrator.click();
		ClickParameterMaster();
		URLCheck();

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/admin/masters/parameter";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickParameterMaster() throws InterruptedException 
	{		

		Thread.sleep(1000);		
		WebElement clickAlertMaster=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div[2]/div[1]/a[1]/div/span[2]"));
		clickAlertMaster.click();


	}

	public void AddParameterMaster(ExtentReports report ) throws InterruptedException, IOException
	{			

		Thread.sleep(5000);
		WebElement AddNew=driver.findElement(By.cssSelector("#kt_content_container > app-masters > app-parameter-lookup > div > div > div > div > div:nth-child(1) > div.col-md-2 > div > div > a"));
		AddNew.click();


		// Counter variable
		int counter = 1;
		String textToSend = null;
		String textToSend2 = null;

		// Loop to send increasing counter values
		for (int i = 0; i < 5; i++)
		{ // Sending 5 values, change the limit as needed
			textToSend = "ParameterName" + counter;

			// Increment the counter
			counter++;
		}
		WebElement ParameterName =driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));
		ParameterName.click();
		ParameterName.sendKeys(textToSend);
		ParameterName.sendKeys(Keys.ENTER);


		for (int i = 0; i < 5; i++)
		{ 
			// Sending 5 values, change the limit as needed
			textToSend2 = "UOM Test" + counter;

			// Increment the counter
			counter++;
		}

		WebElement UOM=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));
		UOM.click();
		UOM.sendKeys(textToSend2);
		UOM.sendKeys(Keys.ENTER);


		
		WebElement ParameterDescription=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/textarea"));
		ParameterDescription.click();
		ParameterDescription.sendKeys("Parameter Description Test");
		ParameterDescription.sendKeys(Keys.ENTER);


		WebElement btnSubmit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[3]/div/button[1]"));
		btnSubmit.click();

		WebElement btnOK=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]"));
		btnOK.click();



		// Identify the table element
		//Here we are saving the table and storing all the elements in the Table
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table")); // Replace 'tableId' with the actual ID of the table

		// Define the column index you want to work with (assuming it's the second column, index 1)
		int columnIndex = 1;

		// Use XPath to find all the elements in the specified column
		List<WebElement> columnElements = table.findElements(By.className("table" + (columnIndex + 1) + "]")); 
		// XPath for the column elements, adding 1 to columnIndex because XPath indexes start from 1

		// Now, you have all the elements in the specified column. You can perform verifications or actions on these elements.
		System.out.println("Parameter Name :");
		for (WebElement ParameterNames : columnElements)
		{
			System.out.println(ParameterNames.getText());
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

		logger=report.createTest("Check -> All Textfields are filled in Parameter Master");
		logger.info("Starting Adding new Parameter");
		logger.pass(" Check Parameter");

		// Check if the text was found in any of the elements
		if (textFound) {
			System.out.println("Parameter Name  '" + textToSend2 + "' found in at least one element. Test Passed!");
			logger.log(Status.PASS,"Text is Verified Add function is working in Parameter Master");
		} else {
			System.out.println("Parameter Name '" + textToSend2 + "' not found in any elements. Test Failed!");
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is Verified Add function is not working in Parameter Master");
		}

	}

	public void EditParameter(ExtentReports report2 ) throws InterruptedException, IOException
	{		
		WebElement btnEdit=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[1]"));
		btnEdit.click();


		WebElement EditParameterDesc=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/textarea"));
		EditParameterDesc.click();

		EditParameterDesc.sendKeys("Content of Parameter Description Test Message is Edited");
		EditParameterDesc.sendKeys(Keys.ENTER);


		WebElement btnUpdate=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[3]/div/button[1]"));
		btnUpdate.click();

		WebElement btnOK=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]"));
		btnOK.click();

		WebElement btnEditAgain=driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[1]"));
		btnEditAgain.click();

		// Find the text area element by its ID or any other suitable locator
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-masters/app-parameter-crud/div/div/div/div/div[2]/div/div/form/div[2]/div/textarea")); // Change "textAreaId" to the actual ID

		// Get the text content of the text area
		String textInTextArea = textArea.getAttribute("value"); // For textarea, use 'getAttribute("value")'

		// Text to verify
		String textToVerify = "Content of Parameter Description Test Message is Edited";

		logger=report2.createTest("Check -> All Edit function Parameter Master");
		logger.info("Starting Editing Parameter Master");
		logger.pass("Editing in Parameter Master");

		// Check if the textToVerify is present in the text area
		if (textInTextArea.contains(textToVerify)) 
		{
			System.out.println("Parameter Master Message '" + textToVerify + "' is present in the text area.");
			logger.log(Status.PASS,"Text is Verified Edit function is working");
		} 
		else 
		{
			System.out.println("Parameter Master Message '" + textToVerify + "' is NOT present in the text area.");

			
			String screenshotPath=ErrorScreenshot(driver, textArea);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Edit function is not working in Parameter Master");

			
		}

		WebElement btnViewList=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-crud/div/div/div/div/div[1]/div[2]/button"));
		btnViewList.click();
	}
	public void DeleteParameter(ExtentReports report3 ) throws InterruptedException, IOException
	{


		// Find the delete button element
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/a[2]")); // Change the locator as needed

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
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table")); // Change the locator as needed

		// Get all rows in the table
		int actualRowCount = table.findElements(By.tagName("tr")).size();

		// Define total expected rows
		int expectedRowCount = actualRowCount-1; // Change this to your expected number of rows


		logger=report3.createTest("Check -> All Delete function Parameter");
		logger.info("Starting Delete Parameter");
		logger.pass("Deleting in Parameter");
		// Compare actual row count with expected row count
		if (actualRowCount < expectedRowCount) {
			System.out.println("Parameter Master List has updated with Deletion operation");
			logger.log(Status.PASS,"Text is Verified Delete function is working");
		} else {
			System.out.println("Parameter List has updated with Deletion operation");
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is Verified Delete function is not working in Parameter Master");

		}

	}

	public void SearchParameter(ExtentReports report4 ) throws InterruptedException, IOException
	{


		WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"example-search-input\"]")); // Change "searchInput" to the actual ID

		// Enter search query and perform search
		String query = "UOMTest1"; // Replace with the actual search query
		searchInput.sendKeys(query);
		searchInput.sendKeys(Keys.ENTER); // Assuming ENTER key triggers the search, else locate and click the search button

		// Wait for search results to load (You might need explicit waits here)
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-parameter-lookup/div/div/div/div/div[2]/div/div/table")); // Replace with actual table ID

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

		logger=report4.createTest("Check -> All Search function Parameter Master");
		logger.info("Starting Search new Parameter Master");
		logger.pass("Searching in Parameter Master");
		// Verify if the query is present in the table
		if (isQueryPresent) {
			System.out.println("Search query'" + query + "' is present in the table results.");
			logger.log(Status.PASS,"Text is Verified Search function is working in Parameter Master");
		} 
		else 
		{
			System.out.println("Search query'" + query + "' is NOT present in the table results.");
			
			String screenshotPath=ErrorScreenshot(driver, table);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Search function is not working Parameter Master");

		}

	}

}
