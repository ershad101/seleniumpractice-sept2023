package Demo_Sep_TestCases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Loggings.LogerClass;
import POMfile.HomePage;
import ReadProperties.PageProperty;
import retryAnylizer.retryTc;

public class demo_sep23_HomeCurrentUrl {

	public Logger log;
	public HomePage home;

	public PageProperty pro;

	@Test(retryAnalyzer = retryTc.class)
	public void VerifyHoomepageCurrentUrl() throws FileNotFoundException {

		log = LogerClass.getlogger();

		log.info("login with valid crendetial");

		log.info("validate homepage current url ");

		String actualUrl = home.getHomePageCurrentUrl();

		String expectedUrl = pro.gethomepageUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

}
