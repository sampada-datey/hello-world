package KloudqTechnologies.AbstractComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import KloudqTechnologies.JDBCConnection.ConnectJDBC;
import KloudqTechnologies.PageObjects.DashboardShield;

public class AbstractComponent {

	public WebDriver driver;
	public static ExtentReports report;
	public ExtentTest logger;
	public  String url;

	public  String user;

	public  String password;

	

	public void setExtentReport() {
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ShieldTest1.html"));
		report=new ExtentReports();
		report.attachReporter(extent);

	}
	//Here the super class is communicating with parent class ie Abstract class from child class 

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//Re usability of code
	public void waitForElementToAppear(By findBy) {
		//Waiting for the WebElement to appear
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement findBy) {
		//Waiting for the WebElement to appear

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToShow(WebElement ele) throws InterruptedException {
		//Waiting for the WebElement to appear
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(ele));

	}


	public static void ConnecttoDB()throws SQLException, IOException, InterruptedException {

		ConnectJDBC sqlconnect=new ConnectJDBC();

		sqlconnect.getConnectionString(report);

	}



	public static String[][] getData(ExtentReports report) throws IOException, InterruptedException 
	{

		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/ConnectionString.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noofRows=sheet.getPhysicalNumberOfRows();
		int noofColumns=sheet.getRow(0).getLastCellNum();

		String[][] data=new String [noofRows-1][noofColumns];
		for(int i=0;i<noofRows-1;i++) {
			for (int j=0;j<noofColumns;j++) {
				//String value=sheet.getRow(i).getCell(j).getStringCellValue();
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));

			}

		}

		fis.close();
		for (String[] dataArr : data) {

			System.out.println(Arrays.toString(dataArr));
			String arrOfStr=Arrays.toString(dataArr);

			String[] Con = arrOfStr.split(" ", 6); // "1" means stop splitting after one space
			String url = Con[0].replace("[", "").replace("]", "").replace(",","");
			String user = Con[3].replace("[", "").replace("]", "").replace(",","");
			String password = Con[2].replace("[", "").replace("]", "").replace(",","");

			System.out.println("This Connection String fetched url: "+url);
			System.out.println("This fetched user of Connection String: "+user);
			System.out.println("This last fetched password of Connection String: "+password);

			System.out.println("This last fetched url: "+url);

			ArrayList<String> teamArr = new ArrayList<String>();
			teamArr.add(url);		
			teamArr.add(user);	
			teamArr.add(password);	
			teamArr.add(url);	
			System.out.println("User Information are as follows," + " ");
			for (int i = 0; i < teamArr.size(); i++) 
			{
				System.out.println("This is the Arraylist for Connection String: "+teamArr.get(i) + " ");

			}

		}
		return data;

	}

	public  String getConnectionString() throws IOException, InterruptedException  
	{

		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/ConnectionString.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		Row row = sheet.getRow(1); // Row 0 is the first row

		Cell cell = row.getCell(0); // Column 0 is the first column
		Cell cell2 = row.getCell(1);
		Cell cell3 = row.getCell(2);


		url = cell.getStringCellValue();
		user = cell2.getStringCellValue();
		password = cell3.getStringCellValue();


		System.out.println(url);
		System.out.println(user);
		System.out.println(password);

		try (Connection connection =DriverManager.getConnection(url,user,password);)

		{

			if (connection!=null) {

				System.out.println("Connection Sucessful");

			}

			else {
				System.out.println("Connection not Sucessful");

			}

		}

		catch(SQLException e){



			e.printStackTrace();

		}


		return url;

	}


	//Common Code for executing the Fail Screenshot to reset the css 
	public String ErrorScreenshot(WebDriver driver, WebElement element) throws IOException
	{
		//Storing the original css key values in the hashmap 

		Dictionary<String, String> abc=highLighterMethod(driver,element);
		String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);
		blurhighlightMethod(driver,element,abc);
		return screenshotPath;
	}

	//To take the screenshot and storing the same in the screenshot folder
	public static String takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		String dateName =new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);

		return destination;
	}


	public Dictionary<String,String> highLighterMethod(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String cssBackground = element.getCssValue("background").toString();
		String cssBorder = element.getCssValue("border").toString();

		//To get the Key Value of css of WebElement
		Dictionary<String, String> cssAttribute= new Hashtable<>();
		cssAttribute.put("background", cssBackground);
		cssAttribute.put("border", cssBorder);


		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		return cssAttribute;
	}

	public void blurhighlightMethod(WebDriver driver, WebElement element,Dictionary<String,String> cssAttribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: "+cssAttribute.get("background")+"; border: "+cssAttribute.get("border")+";');", element);

	}




}


