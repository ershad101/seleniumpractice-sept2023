package ReadProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageProperty {

	public Properties pro;

	public PageProperty() throws IOException {

		File path = new File(
				"C:\\Users\\webca\\eclipse-workspace\\seleniumpractice-sept2023\\PropertyFile\\PageCommanData.properties");

		FileInputStream f2 = new FileInputStream(path);

		pro = new Properties();
		pro.load(f2);
	}

	public String gethomepageTitle() {

		String home = pro.getProperty("homepageTitle");
		return home;

	}
	
	public String gethomepageUrl() {

		String home = pro.getProperty("homepageUrl");
		return home;

	}
	
	public String getWelcomeMessage() {

		String home = pro.getProperty("WelcomeMessage");
		return home;

	}

}
