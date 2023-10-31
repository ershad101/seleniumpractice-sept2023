package Demo_Sep_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import Loggings.LogerClass;
import POMfile.HomePage;
import POMfile.loginPage;
import ReadProperties.PageProperty;

public class HOMEPAGE_CURRENTURLVERIFICATION extends BaseClass {

	public Logger log;
	public HomePage home;
	public loginPage login;

	public PageProperty pro;

	@Test(groups="regression")
	
	public void VerifyHoomepageCurrentUrl() throws IOException {

		log = LogerClass.getlogger();

		pro = new PageProperty();

		log = LogerClass.getlogger();

		home = new HomePage(driver);

		login = new loginPage(driver);

		login.login();

		log.info("validate homepage current url ");

		String actualUrl = home.getHomePageCurrentUrl();

		String expectedUrl = pro.gethomepageUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

}
