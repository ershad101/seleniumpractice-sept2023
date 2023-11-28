package Demo_Sep_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ExcellUtilities.readExcel;
import Loggings.LogerClass;
import POMfile.HomePage;
import POMfile.loginPage;
import POMfile.searchHotelPage;

public class Booked_Itinerary_DataTest extends BaseClass {

	public Logger log;
	public loginPage login;
	public HomePage homepage;
	public searchHotelPage searchHotel;

	@Test(dataProvider = "itineraryData")
	public void verfyBookedData(String location, String hotel, String roomtype, String numberofroom, String checkinDate,
			String checkoutDate, String adultOption, String childern, String type)
			throws InterruptedException, IOException {
		login = new loginPage(driver);

		login.login();
		try {
			log = LogerClass.getlogger();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		log.info("fill the neccessory data");

		searchHotel = new searchHotelPage(driver);
		searchHotel.hotelDetailsSubmission(location, hotel, roomtype, numberofroom, checkinDate, checkoutDate,
				adultOption, childern);

	}

	@DataProvider(name = "itineraryData")
	public String[][] verifyTestData() throws EncryptedDocumentException, IOException {

		String path = ".\\testData\\SearchHotel\\searchHotelDetails.xlsx";

		readExcel read = new readExcel(path, "Sheet1");

		String data[][] = read.dataContainer(path, "Sheet1");
		return data;

	}
}
