package KloudqTechnologies.JDBCConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;

import KloudqTechnologies.PageObjects.Login;

 
public class ConnectJDBC {

	public static void ConnecttoDB()throws SQLException, IOException, InterruptedException {


        ConnectJDBC sqlconnect=new ConnectJDBC();

      //  sqlconnect.getConnectionString(report);

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
    
    public  String getConnectionString(ExtentReports report) throws IOException, InterruptedException  
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
		

		String url = cell.getStringCellValue();
		String user = cell2.getStringCellValue();
		String password = cell3.getStringCellValue();
		

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
    
    
    

    

}