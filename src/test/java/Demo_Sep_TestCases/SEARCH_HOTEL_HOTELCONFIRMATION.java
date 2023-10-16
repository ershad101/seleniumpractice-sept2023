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

public class SEARCH_HOTEL_HOTELCONFIRMATION extends BaseClass {

	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public serachHotelPage searchHotel;

	public loginPage login;
	
	public selectHotel selectHotel;
	

	@Test(dataProvider = "test",groups = "hotelfunction")
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

	
	@Test(dataProvider = "test2",groups = "comman")
	public void validatehotelSelectTitle(String location, String hotel, String roomType, String numberOfRoom, String checkinDate,
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

		
		log.info("validate the title");
		String extectedTtile=pro.getHotelSelectTitle();

		
		selectHotel= new selectHotel(driver);
		
		String actualtitleTtile=selectHotel.getTitle();
		
		Assert.assertEquals(actualtitleTtile, extectedTtile);
		
		
	}

	

	@DataProvider(name = "test")
	public String[][] testData() throws EncryptedDocumentException, IOException {

		String path =".\\testData\\SearchHotel\\CheckInValidationData.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}
	
	@DataProvider(name = "test2")
	public String[][] selectHotel() throws EncryptedDocumentException, IOException {

		String path = ".\\testData\\SearchHotel\\validateSccefullHotelTitle.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}

}
