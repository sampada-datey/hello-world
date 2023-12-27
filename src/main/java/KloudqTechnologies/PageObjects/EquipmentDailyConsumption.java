package KloudqTechnologies.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class EquipmentDailyConsumption  extends AbstractComponent{
	public  EquipmentDailyConsumption(WebDriver driver)
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

	

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentReports report;
	private ExtentTest logger;




}
