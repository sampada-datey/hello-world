package KloudqTechnologies.TestComponents;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;





import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import KloudqTechnologies.PageObjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest  {

	public static WebDriver driver;
	public  ExtentTest logger;
	public static  ExtentReports report;
	

	public  WebDriver initializeDriver() throws IOException {


		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//KloudqTechnologies//resources//GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Execute function in global.properties");
		}

		else if (browserName.equalsIgnoreCase("firefox")) 
		{}
		else if (browserName.equalsIgnoreCase("Edge")) 
		{}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		return driver;

	}
	
	

	public  Login launchApplication(String url) throws IOException
	{
		driver=initializeDriver();
		Login landingPage=new Login(driver);

		landingPage.goTo(url);
		return landingPage;

	}
 

	
	
	
 
 
}
