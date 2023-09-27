package BaseUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Loggings.LogerClass;
import ReadProperties.Readpro;

public class BaseClass {

	public Readpro pro;
	public LogerClass obj;
	public WebDriver driver;

	public Logger log;

	
	@BeforeTest
	public void lounching() throws IOException {

		pro = new Readpro();

		String chromeBrowser = "Chrome";

		if (chromeBrowser.equalsIgnoreCase(pro.getBrowser())) {

			log = obj.logobject();

			log.info("*******  we are ready to lounch the Chrome browser  ******");

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

			driver.manage().deleteAllCookies();

		}

		else {
			System.err.println("-------------Pleaser provide the Browser name --------------");

		}

	}

	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		
		
		Thread.sleep(500);
		
		log.info("********* we are ready to closed the Browser ***********");
		
		
		driver.close();
		
		

	}
	
	
	public static String captureScreenShot(WebDriver driver,String filename) throws IOException {
		
		String screenshotName=new SimpleDateFormat("ddmmyyyhhmmss").format(new Date());
		
		TakesScreenshot t=(TakesScreenshot)driver;
		
		
		File src=t.getScreenshotAs(OutputType.FILE);
		
		String destiPath="C:\\Users\\webca\\eclipse-workspace\\seleniumpractice-sept2023\\SceenShot\\"+screenshotName+filename+".png";
		
		
		File destination=new File(destiPath);
		
		
		
		FileUtils.copyFile(src, destination);
		
		
		return destiPath;
		
	}
	
	
}
