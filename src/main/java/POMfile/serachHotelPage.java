package POMfile;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Loggings.LogerClass;
import ReadProperties.PageProperty;

public class serachHotelPage {

	public WebDriver driver;

	public Select select;

	public WebDriverWait wait;
	
	
	public Logger log;

	public LogerClass obj;

	public HomePage home;

	public PageProperty pro;

	public serachHotelPage searchHotel;

	public loginPage login;
	
	public selectHotel selectHotel;

	public serachHotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "location")
	private WebElement locationDropDown;

	public void locationSelecation(String value) throws InterruptedException {

		select = new Select(locationDropDown);

		List<WebElement> locationOptions = select.getOptions();

		for (int i = 0; i < locationOptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String locationText = wait.until(ExpectedConditions.visibilityOf(locationOptions.get(i))).getText();

			if (locationText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);

			}

		}

	}

	@FindBy(id = "hotels")
	private WebElement hotelDropdown;

	public void hotelSelection(String value) throws InterruptedException {

		select = new Select(hotelDropdown);

		List<WebElement> hotelOptions = select.getOptions();

		for (int i = 0; i < hotelOptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String hotelText = wait.until(ExpectedConditions.visibilityOf(hotelOptions.get(i))).getText();

			// System.out.println(hotelText);
			if (hotelText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);
			}

		}
	}

	@FindBy(id = "room_type")
	private WebElement roomTypeDropdown;

	public void roomTypeSelection(String value) throws InterruptedException {

		select = new Select(roomTypeDropdown);

		List<WebElement> roomTypeOptions = select.getOptions();

		for (int i = 0; i < roomTypeOptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String hotelText = wait.until(ExpectedConditions.visibilityOf(roomTypeOptions.get(i))).getText();

			// System.out.println(hotelText);
			if (hotelText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);
			}

		}
	}

	@FindBy(id = "room_nos")
	private WebElement roomNumbers;

	public void roomNumbersSelection(String value) throws InterruptedException {

		select = new Select(roomNumbers);

		List<WebElement> roomNumbersOptions = select.getOptions();

		for (int i = 0; i < roomNumbersOptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String roomNumbersText = wait.until(ExpectedConditions.visibilityOf(roomNumbersOptions.get(i))).getText();

			System.out.println(roomNumbersText);
			if (roomNumbersText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);
			}

		}
	}

	@FindBy(id = "datepick_in")
	private WebElement datePickIn;

	public void datePickInSendKeys(String date) throws InterruptedException {

		Thread.sleep(1500);

		WebElement e1=wait.until(ExpectedConditions.visibilityOf(datePickIn));
		
		e1.clear();
		e1.sendKeys(date);
		;

	}

	@FindBy(id = "datepick_out")
	private WebElement datepick_out;

	public void datepick_outsendkeys(String date) throws InterruptedException {

		Thread.sleep(1500);

		WebElement e1=wait.until(ExpectedConditions.visibilityOf(datepick_out))
		;
		e1.clear();
		e1.sendKeys(date);
		;
	}

	@FindBy(id = "adult_room")
	private WebElement adult_room;

	public void adult_roomSelection(String value) throws InterruptedException {

		select = new Select(adult_room);

		List<WebElement> adult_roomoptions = select.getOptions();

		for (int i = 0; i < adult_roomoptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String roomNumbersText = wait.until(ExpectedConditions.visibilityOf(adult_roomoptions.get(i))).getText();

			// System.out.println(roomNumbersText);
			if (roomNumbersText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);
			}

		}
	}

	@FindBy(id = "child_room")
	private WebElement child_room;

	public void child_roomSelection(String value) throws InterruptedException {

		select = new Select(adult_room);

		List<WebElement> child_roomoptions = select.getOptions();

		for (int i = 0; i < child_roomoptions.size(); i++) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			String roomNumbersText = wait.until(ExpectedConditions.visibilityOf(child_roomoptions.get(i))).getText();

			if (roomNumbersText.equals(value)) {

				Thread.sleep(1500);

				select.selectByIndex(i);
			}

		}
	}
	
	

	@FindBy(id = "Submit")
	private WebElement submitButton;

	public void clickonSubmitButton() {

		wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
	}

	@FindBy(id = "Reset")

	private WebElement resetButton;

	public void clcikOnResetButton() {

		wait.until(ExpectedConditions.visibilityOf(resetButton)).click();
	}

	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")

	private WebElement Booked_Itinerary;

	public void clickonBooked_Itinerary() {
		wait.until(ExpectedConditions.visibilityOf(Booked_Itinerary)).click();

	}

	@FindBy(xpath = "//span[@id='checkin_span']")
	private WebElement checkInError;

	public String getCheckInErrorMessage() {

		String text = wait.until(ExpectedConditions.visibilityOf(checkInError)).getText();

		return text;

	}
	
	
	public void hotelDetailsSubmission(String location, String hotel, String roomType, String numberOfRoom, String checkinDate,
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


		
		
	}

	
	

}
