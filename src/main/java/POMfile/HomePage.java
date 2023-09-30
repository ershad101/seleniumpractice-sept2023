package POMfile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	public WebDriverWait wait;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username_show")
	private WebElement usernameWelcome;

	public String getWelcomeMessage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		String message = wait.until(ExpectedConditions.visibilityOf(usernameWelcome)).getText();

		return message;

	}

	public String getHomePageTitle() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		String title = driver.getTitle();

		return title;

	}

	public String getHomePageCurrentUrl() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		String url = driver.getCurrentUrl();

		return url;

	}

}
