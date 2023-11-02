package POMfile;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReadProperties.Readpro;

public class DashBorad {

	public WebDriver driver;

	public WebDriverWait wait;

	public JavascriptExecutor js;

	public Readpro pro;

	public Logger log;

	public DashBorad(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getTitle() {

		return driver.getTitle();

	}
}
