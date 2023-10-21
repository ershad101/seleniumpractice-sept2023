package POMfile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookHotelPage {

	public WebDriver driver;

	public Select select;

	public WebDriverWait wait;

	public BookHotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "hotel_name_dis")
	private WebElement HotelName;

	public void hotelNameSendkeys(String hotelName) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(HotelName));

		e1.sendKeys(hotelName);
	}

	@FindBy(id = "location_dis")
	private WebElement location;

	public void locationSendkeys(String hotelName) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(location));

		e1.sendKeys(hotelName);
	}

	@FindBy(id = "final_price_dis")
	private WebElement billedPrice;

	public String getBilledPrice() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(billedPrice));

		return e1.getText();

	}

	@FindBy(id = "first_name")
	private WebElement first_name;

	public void first_nameSendkeys(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(first_name));

		e1.sendKeys(value);

	}

	@FindBy(id = "last_name")
	private WebElement last_name;

	public void last_nameSendkeys(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(last_name));

		e1.sendKeys(value);

	}

	@FindBy(id = "address")
	private WebElement address;

	public void addressSendkeys(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(address));

		e1.sendKeys(value);

	}

	@FindBy(id = "cc_num")
	private WebElement creditCards;

	public void creditCardsSendkeys(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(creditCards));

		e1.sendKeys(value);

	}

	@FindBy(name = "cc_type")
	private WebElement creditCardType;

	public void creditCardTypeSelection(String value) throws InterruptedException {

		select = new Select(creditCardType);

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

	@FindBy(name = "cc_exp_month")
	private WebElement expiryDateMonth;

	public void MonthSlection(String value) throws InterruptedException {

		select = new Select(expiryDateMonth);

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

	@FindBy(name = "cc_exp_year")
	private WebElement expiryDateMYear;

	public void YearSlection(String value) throws InterruptedException {

		select = new Select(expiryDateMYear);

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

	@FindBy(id = "cc_cvv")
	private WebElement cvvField;

	public void cvvFieldSendkeys(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(cvvField));

		e1.sendKeys(value);

	}

	@FindBy(id = "book_now")
	private WebElement book_now;

	public void book_now_Button_Click() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(book_now));

		e1.click();

	}

	@FindBy(id = "first_name_span")
	private WebElement first_name_ErrorMessage;

	public String getfirst_name_ErrorMessage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(first_name_ErrorMessage));

		return e1.getText();

	}

	@FindBy(id = "last_name_span")
	private WebElement last_name_span_ErrorMessage;

	public String getlast_name_span_ErrorMessage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(last_name_span_ErrorMessage));

		return e1.getText();

	}

	@FindBy(id = "address_span")
	private WebElement address_span_ErrorMessage;

	public String getaddress_span_ErrorMessage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(address_span_ErrorMessage));

		return e1.getText();

	}

	@FindBy(id = "cc_num_span")
	private WebElement credit_cardERROR;

	public String getcredit_cardERROR() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(credit_cardERROR));

		return e1.getText();

	}

	@FindBy(id = "cc_expiry_span")
	private WebElement expiry_span_Error;

	public String getexpiry_span_Error() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(expiry_span_Error));

		return e1.getText();

	}

	@FindBy(id = "cc_cvv_span")
	private WebElement cvv_ErrorMessage;

	public String getcvv_ErrorMessage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(cvv_ErrorMessage));

		return e1.getText();

	}

	@FindBy(id = "final_price_dis")

	private WebElement finalPriceFiled;

	public String getFinalPrice() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		return wait.until(ExpectedConditions.visibilityOf(finalPriceFiled)).getText();

	}
}
