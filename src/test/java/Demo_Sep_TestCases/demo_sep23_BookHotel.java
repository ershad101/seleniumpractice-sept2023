package Demo_Sep_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ExcellUtilities.readExcel;
import Loggings.LogerClass;
import POMfile.BookHotelPage;
import POMfile.selectHotel;
import POMfile.serachHotelPage;

public class demo_sep23_BookHotel extends BaseClass {

	public Logger log;

	public selectHotel selectHotel;

	public BookHotelPage bookHotel;
	
	
	public serachHotelPage searchHotelPage;
	
	

	@Test(dataProvider = "test")
	public void validateBookHotel(String nameFirst, String nameLast, String address, String creditCards, String creditCartType, String month, String year, String cvv,String location, String hotel, String roomType, String numberOfRoom, String checkinDate,
			String checkoutdate, String adultoption, String childrenO) throws InterruptedException, IOException  {

		log= LogerClass.getlogger();
		
		log.info("log to search hotel first");
		searchHotelPage= new serachHotelPage(driver);
		
		
		searchHotelPage.hotelDetailsSubmission(location, hotel, roomType, numberOfRoom, checkinDate, checkoutdate, adultoption, childrenO);
		
		selectHotel = new selectHotel(driver);

		log.info("select the hotel button");
		selectHotel.selectHotelButton();

		selectHotel.clickcontinueButton();

		log.info("fill the neccesory details");

		bookHotel = new BookHotelPage(driver);
		
		log.info("enter name");

		bookHotel.first_nameSendkeys(nameFirst);

		
		log.info("enter last name  ");
		bookHotel.last_nameSendkeys(nameLast);

		bookHotel.addressSendkeys(address);

		log.info("enter address");
		bookHotel.creditCardsSendkeys(creditCards);

		log.info("enter credit cards ");
		bookHotel.creditCardTypeSelection(creditCartType);

		bookHotel.MonthSlection(month);
		bookHotel.YearSlection(year);
		bookHotel.cvvFieldSendkeys(cvv);

		bookHotel.book_now_Button_Click();
		

	}
	

	@DataProvider(name = "test")
	public String[][] testData() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\k\\git\\seleniumpractice-sept2023\\testData\\BookHotel_TestData\\BookHotel1.xlsx";

		readExcel xl = new readExcel(path, "Sheet1");

		String data[][] = xl.dataContainer(path, "Sheet1");
		return data;

	}

}
