package POMfile;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booked_Itinerary_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	public Booked_Itinerary_Page(WebDriver driver) {

		this.driver = driver;

	}

	public List<String> getBookingIDSlist() {

		List<String> ids = new ArrayList<String>();

		for (int i = 2; i <= 9; i++) {
			By by = By.xpath("//table/tbody/tr[" + i + "]/td[2]/input");
			WebElement idElement = driver.findElement(by);
			wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			String idsValue = wait.until(ExpectedConditions.visibilityOf(idElement)).getAttribute("value");
			ids.add(idsValue);

		}
		return ids;

	}

}
