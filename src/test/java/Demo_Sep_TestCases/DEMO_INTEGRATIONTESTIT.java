package Demo_Sep_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ExcellUtilities.readExcel;
import Loggings.LogerClass;
import POMfile.HomePage;
import POMfile.loginPage;
import POMfile.selectHotel;
import POMfile.serachHotelPage;
import ReadProperties.PageProperty;

public class DEMO_INTEGRATIONTESTIT extends BaseClass {

	public selectHotel hotelselect;

	public serachHotelPage searchHotel;

	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public loginPage login;

	public selectHotel selectHotel;

	@Test(dataProvider = "hotelDetails")
	public void verify_date_time(String location, String hotel, String roomType, String numberOfRoom,
			String checkinDate, String checkoutdate, String adultoption, String childrenO, String type)
			throws InterruptedException, IOException {

		//login = new loginPage(driver);
		//login.login();
		log = LogerClass.getlogger();

		log.info("validate the arrivaldate and depart date ");

		hotelselect = new selectHotel(driver);

		log.info("fill the neccessory data to search hotel ");

		searchHotel = new serachHotelPage(driver);

		searchHotel.hotelDetailsSubmission(location, hotel, roomType, numberOfRoom, checkinDate, checkoutdate,
				adultoption, childrenO);

		log.info("get the arrivadate as expectation ");

		String expectationArrival_Date = hotelselect.getarrivaldate();

		String expectedDepart_date = hotelselect.getdepartureDAte();

		if (type.equals("valid")) {

			Assert.assertEquals(expectationArrival_Date, checkinDate, "not match check in date");
		} else if (type.equals("valid")) {
			Assert.assertEquals(expectedDepart_date, checkoutdate, "not match check out date");

		}

		else {

			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "hotelDetails")
	public String[][] hotelDetailsProvider() throws EncryptedDocumentException, IOException {

		String path = ".\\testData\\SearchHotel\\searchHotelDetails.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = readExcel.dataContainer(path, "Sheet1");
		return data;
	}
}
