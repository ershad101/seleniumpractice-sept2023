package Demo_Sep_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import Loggings.LogerClass;
import POMfile.HomePage;
import ReadProperties.PageProperty;
import retryAnylizer.retryTc;

public class demo_Sep23_Homepage extends BaseClass {

	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	@Test(retryAnalyzer = retryTc.class)
	public void validateHomepageTitle() throws IOException {
		log=LogerClass.getlogger();
		

		log.info("login with valid credential ");

		home = new HomePage(driver);

		pro = new PageProperty();

		String expectedTitle = pro.gethomepageTitle();

		String actualTitle = home.getHomePageTitle();

		log.info("valdiate homepage title");
		Assert.assertEquals(actualTitle, expectedTitle);

	}


}
