package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;
import tech.grasshopper.reporter.ExtentPDFReporter;

public class BaseClass {

	/**
	 * Driver variables
	 */
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	/**
	 * Deliverables
	 */
	public static ExtentReports extent;//allows creation of tests, nodes, events and assignment of tags, devices, authors, environment values 
	public static ExtentTest test;//used to publish logs,or attach screenshots.// create nodes, assign attributes (tags, devices, authors) 
	public static ExtentSparkReporter spark;//Html reporter
	public static ExtentPDFReporter pdf;//pdf reporter
	
	/**
	 * To load Properties files
	 */
	Properties prop = new Properties();
	
	@BeforeClass
	public void pre() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--inprivate");
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		
	    driver=new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("Extent.html");	
		spark.loadXMLConfig(new File("src/main/resources/extentConfig.xml"));
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Urban_SDK");
		 
		test = extent.createTest("Login Test").assignCategory("smoke").assignDevice("EdgeDriver");
		
		/**
	     * Generate PDF name using date and time
	     */

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yy (hh_mm_ss)");
		LocalDateTime now = LocalDateTime.now();
		pdf=new ExtentPDFReporter(new File("UrbanSDK_Report"+dtf.format(now)+".pdf"));
		pdf.config().setReportName("Urban_SDK");
		pdf.loadXMLConfig(new File("src/main/resources/pdf-config.xml"));
		extent.attachReporter(pdf,spark);
		 
	/**
	 * To read file
	 */
	InputStream file = getClass().getClassLoader().getResourceAsStream("config.properties");//YOURCLASSNAME.class.getClassLoader().getResourceAsStream("app.properties");
	
    prop.load(file);
    
    //To get URL from properties file
    String urlP = prop.getProperty("url");
    driver.get(urlP);
  
	}
	
	@AfterClass
	public void close() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("Extent.html").toURI());
		
	}
	
	
	
}
