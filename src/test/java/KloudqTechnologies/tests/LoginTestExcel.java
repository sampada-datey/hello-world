package KloudqTechnologies.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;


import KloudqTechnologies.PageObjects.Login;
import KloudqTechnologies.TestComponents.BaseTest;

public class LoginTestExcel  extends BaseTest {

	@DataProvider(name="loginData")
	

	public static String[][] getData(ExtentReports report) throws IOException, InterruptedException 
	{

		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
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

			String[] names = arrOfStr.split(" ", 6); // "1" means stop splitting after one space
			String usertype = names[0].replace("[", "").replace("]", "").replace(",","");
			String email = names[1].replace("[", "").replace("]", "").replace(",","");
			String password = names[2].replace("[", "").replace("]", "").replace(",","");
			String url=names[3].replace("[", "").replace("]", "").replace(",","");

			System.out.println("This last fetched usertype: "+usertype);
			System.out.println("This last fetched email id: "+email);
			System.out.println("This last fetched password: "+password);

			System.out.println("This last fetched url: "+url);

			ArrayList<String> teamArr = new ArrayList<String>();
			teamArr.add(usertype);		
			teamArr.add(email);	
			teamArr.add(password);	
			teamArr.add(url);	
			System.out.println("User Information are as follows," + " ");
			for (int i = 0; i < teamArr.size(); i++) 
			{
				System.out.println("This is the Arraylist: "+teamArr.get(i) + " ");

			}
			
			//Login login=launchApplication(url);
			
			BaseTest baseTestInstance = new BaseTest();
			
			Login login=baseTestInstance.launchApplication(url);
	        
			login.loginApplication(email,password,report);

		}
		return data;

	}

	//	public static  String getAdminUserDataEVPOC() throws IOException, InterruptedException  
	//	{
	//
	//		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
	//		System.out.println(excelFile.exists());
	//		FileInputStream fis=new FileInputStream(excelFile);
	//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//		XSSFSheet sheet=workbook.getSheet("Sheet1");
	//
	//
	//
	//
	//		Row row = sheet.getRow(2); // Row 0 is the first row
	//
	//		Cell cell = row.getCell(0); // Column 0 is the first column
	//		Cell cell2 = row.getCell(1);
	//		Cell cell3 = row.getCell(2);
	//		Cell cell4 = row.getCell(3);
	//
	//		String usertype = cell.getStringCellValue();
	//		String email = cell2.getStringCellValue();
	//		String password = cell3.getStringCellValue();
	//		String url = cell4.getStringCellValue();
	//
	//		System.out.println(usertype);
	//		System.out.println(email);
	//		System.out.println(password);
	//		System.out.println(url);
	//
	//		Login login=launchApplication(url);
	//
	//		login.loginApplication(email,password,report);
	//
	//
	//		return null;
	//
	//
	//
	//
	//	}

	//	public static  String getCustomerUserDataEVPOC() throws IOException, InterruptedException  
	//	{
	//
	//		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
	//		System.out.println(excelFile.exists());
	//		FileInputStream fis=new FileInputStream(excelFile);
	//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//		XSSFSheet sheet=workbook.getSheet("Sheet1");
	//
	//
	//
	//
	//		Row row = sheet.getRow(4); // Row 0 is the first row
	//
	//		Cell cell = row.getCell(0); // Column 0 is the first column
	//		Cell cell2 = row.getCell(1);
	//		Cell cell3 = row.getCell(2);
	//		Cell cell4 = row.getCell(3);
	//
	//		String usertype = cell.getStringCellValue();
	//		String email = cell2.getStringCellValue();
	//		String password = cell3.getStringCellValue();
	//		String url = cell4.getStringCellValue();
	//
	//		System.out.println(usertype);
	//		System.out.println(email);
	//		System.out.println(password);
	//		System.out.println(url);
	//
	//		Login login=launchApplication(url);
	//
	//		login.loginApplication(email,password,report,logger);
	//
	//
	//		return null;
	//
	//
	//
	//
	//	}
	public  String getAdminUserDataShield(ExtentReports report) throws IOException, InterruptedException  
	{

		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		Row row = sheet.getRow(7); // Row 0 is the first row

		Cell cell = row.getCell(0); // Column 0 is the first column
		Cell cell2 = row.getCell(1);
		Cell cell3 = row.getCell(2);
		Cell cell4 = row.getCell(3);

		String usertype = cell.getStringCellValue();
		String email = cell2.getStringCellValue();
		String password = cell3.getStringCellValue();
		String url = cell4.getStringCellValue();

		System.out.println(usertype);
		System.out.println(email);
		System.out.println(password);
		System.out.println(url);

		Login login=launchApplication(url);

		login.loginApplication(email,password,report);
		logger=report.createTest("Check -> Login now to Shield with Lenz User");
		logger.info("Starting Application");
		logger.pass("Login Success");
		

		return url;

	}
	
	
	public  String getLenzAutomationTestUserDataShield(ExtentReports report) throws IOException, InterruptedException  
	{

		File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		Row row = sheet.getRow(8); // Row 0 is the first row

		Cell cell = row.getCell(0); // Column 0 is the first column
		Cell cell2 = row.getCell(1);
		Cell cell3 = row.getCell(2);
		Cell cell4 = row.getCell(3);

		String usertype = cell.getStringCellValue();
		String email = cell2.getStringCellValue();
		String password = cell3.getStringCellValue();
		String url = cell4.getStringCellValue();

		System.out.println(usertype);
		System.out.println(email);
		System.out.println(password);
		System.out.println(url);

		Login login=launchApplication(url);

		login.loginApplication(email,password,report);
		logger=report.createTest("Check -> Login now to Shield with Lenz Automation User");
		logger.info("Starting Application");
		logger.pass("Login Success of Lenz Automation");
		

		return url;

	}

	
	public  String getDataByCompanyName(ExtentReports report,String companyName,String userType) throws IOException, InterruptedException  
	{
		

        try {
        	
        	

        	File excelFile=new File("./src/main/java/KloudqTechnologies/tests/resources/Test.xlsx");
    		System.out.println(excelFile.exists());
    		FileInputStream fis=new FileInputStream(excelFile);
    		XSSFWorkbook workbook=new XSSFWorkbook(fis);
    		XSSFSheet sheet=workbook.getSheet("Sheet2");
    		
            int companyIdIndex = -1;
            int userTypeIndex = -1;
            int userIdIndex = -1;
            int passwordIndex = -1;
            int urlIndex=-1;

            // Find column indexes for "Company", "UserType", "UserID", and "Password"
            Row headerRow = sheet.getRow(0);
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                Cell cell = headerRow.getCell(i);
                String header = cell.getStringCellValue().trim();
                if (header.equalsIgnoreCase("company")) {
                    companyIdIndex = i;
                } else if (header.equalsIgnoreCase("usertype")) {
                    userTypeIndex = i;
                } else if (header.equalsIgnoreCase("Username")) {
                    userIdIndex = i;
                } else if (header.equalsIgnoreCase("Password")) {
                    passwordIndex = i;
                }
                else if (header.equalsIgnoreCase("url")) {
                	urlIndex = i;
                }
            }

            if (companyIdIndex != -1 && userTypeIndex != -1 && userIdIndex != -1 && passwordIndex != -1) {
                // Iterate through rows and fetch UserID and Password based on Company Name and UserType
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);

                    Cell companyCell = row.getCell(companyIdIndex);
                    Cell userTypeCell = row.getCell(userTypeIndex);

                    if (companyCell != null && userTypeCell != null) {
                        String company = companyCell.getStringCellValue().trim();
                        String type = userTypeCell.getStringCellValue().trim();

                        if (company.equalsIgnoreCase(companyName) && type.equalsIgnoreCase(userType)) {
                            Cell userIdCell = row.getCell(userIdIndex);
                            Cell passwordCell = row.getCell(passwordIndex);
                            Cell urlCell=row.getCell(urlIndex);
                            String userId = userIdCell.getStringCellValue();
                            String password = passwordCell.getStringCellValue();
                            String url=urlCell.getStringCellValue();
                            
                            Login login=launchApplication(url);

                    		login.loginApplication(userId,password,report);
                    		logger=report.createTest("Check -> Login to Shield");
                    		logger.info("Starting Automation Application");
                    		logger.pass("Login Success to Shield");
                            System.out.println("UserID: " + userId + ", Password: " + password + ", URL: "+url);
                            // You can use the retrieved UserID and Password as needed
                            
                            
                            
                        }
                    }
                }
            } else {
                System.out.println("Required headers not found.");
            }


           
        } catch (IOException e) {
            e.printStackTrace();
        }
		return companyName;
		
	}
	
	


}








