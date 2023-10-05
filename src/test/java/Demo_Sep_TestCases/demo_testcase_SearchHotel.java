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
import POMfile.serachHotelPage;
import ReadProperties.PageProperty;

public class demo_testcase_SearchHotel extends BaseClass {

	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public serachHotelPage searchHotel;

	public loginPage login;

	@Test(dataProvider = "test")
	public void validateErrorMessage(String location, String hotel, String roomType, String numberOfRoom, String checkinDate,
			String checkoutdate, String adultoption, String childrenO) throws InterruptedException, IOException {

		login = new loginPage(driver);

		login.login();

		log = LogerClass.getlogger();

		log.info("select the location ");

		searchHotel = new serachHotelPage(driver);

		searchHotel.locationSelecation(location);

		log.info("select the hotel ");

		searchHotel.hotelSelection(hotel);

		log.info("select the room type ");

		searchHotel.roomTypeSelection(roomType);

		log.info("enter the check in date");

		searchHotel.datePickInSendKeys(checkinDate);

		log.info("enter the checkout date  ");

		searchHotel.datepick_outsendkeys(checkoutdate);

		log.info("select the adult per room ");

		searchHotel.adult_roomSelection(adultoption);

		log.info("select the children per room");

		searchHotel.child_roomSelection(childrenO);

		log.info("click on search button ");

		searchHotel.clickonSubmitButton();

		pro = new PageProperty();
		String expectedMessage = pro.getCheckInError();

		String ActualCheckinErro = searchHotel.getCheckInErrorMessage();

		log.info("verify the error message");
		Assert.assertEquals(ActualCheckinErro, expectedMessage);

	}

	@DataProvider(name = "test")
	public String[][] testData() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\seleniumpractice-sept2023\\testData\\CheckInValidationData.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}

}
