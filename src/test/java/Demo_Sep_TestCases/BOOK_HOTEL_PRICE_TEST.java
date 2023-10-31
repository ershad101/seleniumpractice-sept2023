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
import POMfile.BookHotelPage;
import POMfile.HomePage;
import POMfile.loginPage;
import POMfile.selectHotel;
import POMfile.serachHotelPage;
import ReadProperties.PageProperty;

public class BOOK_HOTEL_PRICE_TEST extends BaseClass {

	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public serachHotelPage searchHotel;

	public loginPage login;

	public selectHotel selectHotel;

	public BookHotelPage bookHotel;

	@Test(dataProvider = "hotelPricedata", groups = "smoke")
	public void vlaidate_pricefield_bookedhotel_Page(String location, String hotel, String roomType,
			String numberOfRoom, String checkinDate, String checkoutdate, String adultoption, String childrenO)
			throws InterruptedException, IOException {

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

		selectHotel = new selectHotel(driver);

		log.info("select the specific hotel ");

		selectHotel.selectHotelButton("0");

		log.info("click on continue button");

		selectHotel.clickcontinueButton();

		log.info("validate the price for the hotel");

		bookHotel = new BookHotelPage(driver);

		String actualPrice = bookHotel.getFinalPrice();
		System.out.println(actualPrice);

	}

	 @Test(dataProvider = "test2", groups = "smoke")
	public void validatehotelSelectTitle(String location, String hotel, String roomType, String numberOfRoom,
			String checkinDate, String checkoutdate, String adultoption, String childrenO)
			throws InterruptedException, IOException {

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
		String extectedTtile = pro.getHotelSelectTitle();

		selectHotel = new selectHotel(driver);

		String actualtitleTtile = selectHotel.getTitle();

		Assert.assertEquals(actualtitleTtile, extectedTtile);

	}

	@DataProvider(name = "test")
	public String[][] testData() throws EncryptedDocumentException, IOException {

		String path = ".\\testData\\SearchHotel\\CheckInValidationData.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}

	@DataProvider(name = "hotelPricedata")
	public String[][] selectHotel() throws EncryptedDocumentException, IOException {

		String path = ".\\testData\\SearchHotel\\\\hotelPricedata.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}

}
