package POMfile;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	public WebDriver driver;

	public WebDriverWait wait;

	public JavascriptExecutor js;

	public loginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginButton;

	public void loginAction(String Username, String Passeord) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(Username);

		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(Passeord);

		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		;

	}

}
