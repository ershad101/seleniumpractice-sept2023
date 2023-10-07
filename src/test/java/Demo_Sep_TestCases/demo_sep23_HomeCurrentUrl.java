package Demo_Sep_TestCases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import Loggings.LogerClass;
import POMfile.HomePage;
import ReadProperties.PageProperty;

public class demo_sep23_HomeCurrentUrl extends BaseClass {

	public Logger log;
	public HomePage home;

	public PageProperty pro;

	@Test()
	public void VerifyHoomepageCurrentUrl() throws IOException {

		log = LogerClass.getlogger();
		
		pro= new PageProperty()
				;
		
		log=LogerClass.getlogger();
		
		
		home= new HomePage(driver);
		

		log.info("login with valid crendetial");

		log.info("validate homepage current url ");

		String actualUrl = home.getHomePageCurrentUrl();

		String expectedUrl = pro.gethomepageUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

}
