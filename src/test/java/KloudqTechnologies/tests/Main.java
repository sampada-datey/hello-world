package KloudqTechnologies.tests;

import KloudqTechnologies.TestComponents.BaseTest;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class Main extends BaseTest{
	public static void main(String[] args) throws IOException, InterruptedException, SQLException{
	
		System.out.println("In main class");

    for (String arg : args) 
    {
        System.out.println("Argument: " + arg);
    }
	TestNG testNGfile = new TestNG();

    // Create a list of XmlSuite
    List<XmlSuite> suites = new ArrayList<>();

    // Add the path to your testng.xml file to the list
    XmlSuite suite = new XmlSuite();
    suite.setSuiteFiles(Collections.singletonList("testSuits/testng.xml"));
    suites.add(suite);

    // Set the list of suites to the TestNG instance
    testNGfile.setXmlSuites(suites);

    // Run the TestNG suite
    testNGfile.run();
	
	
	}}

	


