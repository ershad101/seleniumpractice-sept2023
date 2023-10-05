package POMfile;

import java.time.Duration;

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

	@FindBy(id = "radiobutton_0")
	private WebElement selectHotelButton;

	public void selectHotelButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(selectHotelButton));
		e1.click();

	}
	
	@FindBy(id = "continue")
	private WebElement continueButton;

	public void clickcontinueButton() {

		 WebElement e1=wait.until(ExpectedConditions.visibilityOf(continueButton));

		 
		 e1.click();

	}
	

}
