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

public class selectHotel {

	public WebDriver driver;

	public Select select;

	public WebDriverWait wait;

	public selectHotel(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='total_price_0']")
	private WebElement totalPrice;

	public String getTotalPrice() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(totalPrice));
		return e1.getAttribute("value");

	}

	public String getTitle() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		return driver.getTitle();

	}

	@FindBy(id = "continue")
	private WebElement continueButton;

	public void clickcontinueButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(continueButton));
		e1.click();

	}

	@FindBy(xpath = "//input[@type='radio']")
	private List<WebElement> RadioButtonList;

	public void selectHotelButton(String value) {

		for (WebElement elements : RadioButtonList) {

			String extValue = elements.getAttribute("value");

			System.out.println();
			if (extValue.equals(value)) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(25));

				wait.until(ExpectedConditions.elementToBeClickable(elements)).click();

				break;

			}
		}

	}

	@FindBy(id = "arr_date_0")
	private WebElement arrivalDAte;

	public String getarrivaldate() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(arrivalDAte));
		return e1.getAttribute("value");

	}

	@FindBy(id = "dep_date_0")
	private WebElement departuredTae;

	public String getdepartureDAte() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(departuredTae));
		return e1.getAttribute("value");

	}

}
