package Demo_Sep_TestCases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import Loggings.LogerClass;
import POMfile.DashBorad;
import POMfile.HomePage;
import POMfile.loginPage;
import ReadProperties.PageProperty;

public class LOGOUT_VALIDATECREDENTIAL extends BaseClass {
	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public loginPage kogin;

	public DashBorad dashBoard;

	@Test(groups = "smoke")
	public void validateLogoutFunctiionality() throws FileNotFoundException {

		log = LogerClass.getlogger();

		login = new loginPage(driver);

		login.login();

		log.info("clickon logout button");

		home = new HomePage(driver);

		home.clickOnLogoutButton();

		log.info("verify the expected result after logout");

		dashBoard = new DashBorad(driver);

		String ExpectedTitle = "Adactin.com - Logout";
		String ActualTitle = dashBoard.getTitle();

		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}
}
