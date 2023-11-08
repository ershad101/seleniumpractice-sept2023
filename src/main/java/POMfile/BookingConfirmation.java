package POMfile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingConfirmation {

	public WebDriver driver;

	public WebDriverWait wait;

	public BookingConfirmation(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='order_no']")
	private WebElement orderNo;

	public String getOrderNumber() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(45));

		return wait.until(ExpectedConditions.visibilityOf(orderNo)).getAttribute("value");

	}

	public boolean orderNumberDisplay() {

		boolean value = false;

		return orderNo.isDisplayed();

	}
	
	@FindBy(id = "my_itinerary")
	private WebElement My_itinerary_Button;;

	public void Clickon_my_itinerary() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(My_itinerary_Button)).click();
	}

}
