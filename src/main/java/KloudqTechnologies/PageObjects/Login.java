package KloudqTechnologies.PageObjects;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import KloudqTechnologies.AbstractComponents.AbstractComponent;



public class Login extends AbstractComponent{
	WebDriver driver;
	public Login(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		  
	 }
	@FindBy(name="email")
	WebElement userEmail;
	@FindBy(name="password")
	WebElement passwordEle;
	@FindBy(id="kt_sign_in_submit")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"kt_login_signin_form\"]/div[2]")
	WebElement errorMessage;
	Properties prop;
	//Actions methods
	public String url;

	public LiveMap loginApplication(String email,String password,ExtentReports report)throws IOException, InterruptedException{
		userEmail.isDisplayed();
		userEmail.isEnabled();
		userEmail.sendKeys(email);
		
		passwordEle.isDisplayed();
		passwordEle.isEnabled();
		passwordEle.sendKeys(password);
		
		submit.isDisplayed();
		submit.isEnabled();
		submit.click();
		
		LiveMap lm=new LiveMap(driver);
		System.out.println("Login Application");
		logger=report.createTest("Check->Login to Shield Application is Verified with correct ID and Password");
		logger.info("Starting Application");
		
	
		logger.pass("Login Success");
		return lm;
		
		
		}
	public LiveMap loginuserApplication(String email,String password)throws IOException, InterruptedException{
		userEmail.isDisplayed();
		userEmail.isEnabled();
		userEmail.sendKeys(email);
		
		passwordEle.isDisplayed();
		passwordEle.isEnabled();
		passwordEle.sendKeys(password);
		
		submit.isDisplayed();
		submit.isEnabled();
		submit.click();
		System.out.println("login User Application");
		LiveMap lm=new LiveMap(driver);
		return lm;
		
		}
	
	public void  goTo(String url) {
		// TODO Auto-generated method stub
		System.out.println(url);
		driver.get(url);
		
	}


	

	
}
