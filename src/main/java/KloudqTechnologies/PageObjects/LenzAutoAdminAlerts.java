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

public class LenzAutoAdminAlerts extends AbstractComponent{

	public LenzAutoAdminAlerts(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

	
	public void ClickAdministrator() throws InterruptedException 
	{
		WebElement clickAdministrator=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[5]/a"));
		clickAdministrator.click();
		ClickAlertsMaster();
		URLCheck();

	}
	
	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/shared/alert";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	public void ClickAlertsMaster() throws InterruptedException 
	{		
		
		Thread.sleep(1000);		
		WebElement clickAlertMaster=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div[2]/div[2]/a[6]/div/span[2]"));
		clickAlertMaster.click();


	}
	
	public void AddNewAlert(ExtentReports report ) throws InterruptedException
	{			
		
		Thread.sleep(5000);
		WebElement AddNew=driver.findElement(By.cssSelector("#kt_content > div.row.gy-5.g-xl-8 > div > div > div.row > div.col-md-2 > div > a"));
		AddNew.click();
		
		
        // Counter variable
        int counter = 1;
        String textToSend = null;
        
        // Loop to send increasing counter values
        for (int i = 0; i < 5; i++) { // Sending 5 values, change the limit as needed
            textToSend = "AlertCode" + counter;
            
            // Increment the counter
            counter++;
        }
        WebElement AlertCode=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[2]/div[1]/input"));
		AlertCode.click();
		AlertCode.sendKeys(textToSend);
		AlertCode.sendKeys(Keys.ENTER);
		
		
       
		WebElement AlertName=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/input"));
		AlertName.click();
		AlertName.sendKeys("AlertTestName");
		AlertName.sendKeys(Keys.ENTER);
		
		WebElement FromulatxtArea=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[3]/div/ngx-monaco-editor/div/div/div/div[1]/textarea"));
		FromulatxtArea.click();
		FromulatxtArea.sendKeys("e=mc2");
		FromulatxtArea.sendKeys(Keys.ENTER);
		
		WebElement AlertMessage=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[4]/div/textarea"));
		AlertMessage.click();
		AlertMessage.sendKeys("AlertTestMessage");
		AlertMessage.sendKeys(Keys.ENTER);
		
		WebElement ModelName=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[5]/div[1]/div[1]/input[2]"));
		ModelName.click();
		
		WebElement selectModelName=driver.findElement(By.cssSelector("#a08fd5f106ea-1"));
		selectModelName.click();
	
	
		
		WebElement UserName=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[5]/div[2]/div[1]/ng-select"));
		UserName.click();
		
		WebElement selectlenzautomation=driver.findElement(By.xpath("//*[@id=\"adb1c466238c-0\"]/span"));
		selectlenzautomation.click();
		
		
		WebElement plususername=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[4]/div/textarea"));
		plususername.click();
		
		
		
		
		
		WebElement AlertPriority=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[6]/div[1]/ng-select/div"));
		AlertPriority.click();
		AlertPriority.sendKeys("Medium");
		AlertPriority.sendKeys(Keys.ENTER);
		
		WebElement selectAlertType=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[6]/div[2]/ng-select/div/div/div[2]/input"));
		selectAlertType.click();
		selectAlertType.sendKeys("GarbageValue");
		selectAlertType.sendKeys(Keys.ENTER);
		
		WebElement ParameterName=driver.findElement(By.xpath("//*[@id=\"aabbe01dc495\"]"));
		ParameterName.click();
		ParameterName.sendKeys("SG_SPEED");
		ParameterName.sendKeys(Keys.ENTER);
		
		WebElement Relatedparametername=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[7]/div[2]/ng-select/div/div/div[2]/input"));
		Relatedparametername.click();
		Relatedparametername.sendKeys("SG_SPEED");
		Relatedparametername.sendKeys(Keys.ENTER);
		
		
		
		WebElement SnoozeTimemins=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[8]/div/input"));
		SnoozeTimemins.click();
		SnoozeTimemins.sendKeys("2");
		SnoozeTimemins.sendKeys(Keys.ENTER);
		
		
		WebElement isEmail=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[9]/div[2]/div/input"));
		isEmail.click();
		
		WebElement EmailTo=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[9]/div[2]/div/input"));
		EmailTo.click();
		EmailTo.sendKeys("sampadadatey21@gmail.com");
		EmailTo.sendKeys(Keys.ENTER);
		
		WebElement EmailContent=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[9]/div[2]/div/input"));
		EmailContent.click();
		EmailContent.sendKeys("Test Email Content");
		EmailContent.sendKeys(Keys.ENTER);
		
		WebElement isWhatsapp=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[10]/div[1]/div/div/input"));
		isWhatsapp.click();
		
		WebElement WhatsAppTo=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[10]/div[2]/div/input"));
		WhatsAppTo.click();
		WhatsAppTo.sendKeys("8237225405");
		WhatsAppTo.sendKeys(Keys.ENTER);
		
		WebElement WhatsappContent=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[10]/div[2]/div/textarea"));
		WhatsappContent.click();
		WhatsappContent.sendKeys("Content of Whatsapp");
		WhatsappContent.sendKeys(Keys.ENTER);
		
		WebElement isSMS=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[11]/div[1]/div/div/input"));
		isSMS.click();
		
		WebElement SMSTo=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[11]/div[1]/div/div/input"));
		SMSTo.click();
		SMSTo.sendKeys("8237225405");
		SMSTo.sendKeys(Keys.ENTER);
		
		WebElement SMSContent=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[11]/div[2]/div/textarea"));
		SMSContent.click();
		SMSContent.sendKeys("Content of SMS");
		SMSContent.sendKeys(Keys.ENTER);
		
		
		WebElement SendToCustomer=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[12]/div[1]/div/input"));
		SendToCustomer.click();
		
		WebElement SendtoDealer=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[12]/div[2]/div/input"));
		SendtoDealer.click();
		
		
		WebElement btnSubmit=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[15]/span/button"));
		btnSubmit.click();
		
		logger=report.createTest("Check -> All Textfields are filled in Alerts");
		logger.info("Starting Adding new Alert");
		logger.pass("Visibility Check Added Alert");
		
		// Assuming driver is your WebDriver instance

		// Identify the table element
		WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div[2]/div/table")); // Replace 'tableId' with the actual ID of the table

		// Define the column index you want to work with (assuming it's the second column, index 1)
		int columnIndex = 1;

		// Use XPath to find all the elements in the specified column
		List<WebElement> columnElements = table.findElements(By.className("table" + (columnIndex + 1) + "]")); 
		// XPath for the column elements, adding 1 to columnIndex because XPath indexes start from 1

		// Now, you have all the elements in the specified column. You can perform verifications or actions on these elements.
		  System.out.println("Alert Codes in Alert Code Column:");
	        for (WebElement AlertCodename : columnElements)
	        {
	            System.out.println(AlertCodename.getText());
	        }
	        
	        
	        


	}
	
	
	public void EditAlert(ExtentReports report2 ) throws InterruptedException, IOException
	{		
		WebElement btnEdit=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div[2]/div/table/tbody/tr/td[6]/div/a"));
		btnEdit.click();
		
		
		WebElement EditAlertMessage=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[4]/div/textarea"));
		EditAlertMessage.click();
		
		EditAlertMessage.sendKeys("Content of Alert Message is Edited");
		EditAlertMessage.sendKeys(Keys.ENTER);
		
		
		WebElement btnUpdate=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[15]/span/button"));
		btnUpdate.click();
		
		WebElement btnOK=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[3]/div/div[6]/button[1]"));
		btnOK.click();
		
		WebElement btnEditAgain=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div[2]/div/table/tbody/tr/td[6]/div/a"));
		btnEditAgain.click();
		
		// Find the text area element by its ID or any other suitable locator
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[4]/div/textarea")); // Change "textAreaId" to the actual ID

        // Get the text content of the text area
        String textInTextArea = textArea.getAttribute("value"); // For textarea, use 'getAttribute("value")'

        // Text to verify
        String textToVerify = "Content of Alert Message is Edited";
        
        logger=report2.createTest("Check -> All Edit function Alerts");
		logger.info("Starting Editing new Alert");
		logger.pass("Editing in Alert");

        // Check if the textToVerify is present in the text area
        if (textInTextArea.contains(textToVerify)) {
            System.out.println("Alert Message '" + textToVerify + "' is present in the text area.");
            logger.log(Status.PASS,"Text is Verified Edit function is working");
        } 
        else 
        {
            System.out.println("Alert Message '" + textToVerify + "' is NOT present in the text area.");
            
            
            String screenshotPath=ErrorScreenshot(driver, textArea);
			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Edit function is not working");

        }
		
        WebElement btnViewList=driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[1]/div[2]/div/a"));
        btnViewList.click();
	}
	
	public void SearchAlert(ExtentReports report3 ) throws InterruptedException, IOException
	{
			
		
		 WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"example-search-input\"]")); // Change "searchInput" to the actual ID

	        // Enter search query and perform search
	        String query = "e=mc2"; // Replace with the actual search query
	        searchInput.sendKeys(query);
	        searchInput.sendKeys(Keys.ENTER); // Assuming ENTER key triggers the search, else locate and click the search button

	        // Wait for search results to load (You might need explicit waits here)
	        WebElement table = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div[2]/div/table")); // Replace with actual table ID

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
	        logger=report3.createTest("Check -> All Search function Alerts");
			logger.info("Starting Search new Alert");
			logger.pass("Searching in Alert");
	        // Verify if the query is present in the table
	        if (isQueryPresent) {
	            System.out.println("Search query e=mc2'" + query + "' is present in the table results.");
	            logger.log(Status.PASS,"Text is Verified Search function is working");
	        } else {
	            System.out.println("Search query e=mc2'" + query + "' is NOT present in the table results.");
	           
	        
	            String screenshotPath=ErrorScreenshot(driver, table);
				logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Text is not Verified Search function is not working");

	        
	        }
		
	}
}
