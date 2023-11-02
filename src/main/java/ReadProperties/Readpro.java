package ReadProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readpro {

	public Properties pro;

	public Readpro() throws IOException {

		File path = new File(
				".\\PropertyFile\\Commondata.properties");

		FileInputStream f2 = new FileInputStream(path);

		pro = new Properties();
		pro.load(f2);
	}

	public String getUsername() {

		String Username = pro.getProperty("Username");

		return Username;

	}

	public String getPassword() {

		String Password = pro.getProperty("Password");

		return Password;

	}

	public String getBrowser() {

		String Browser = pro.getProperty("Browser");

		return Browser;

	}

	public String getUrl() {

		String url = pro.getProperty("Url");

		return url;

	}

	public static void main(String[] args) throws Exception {

		Readpro pro = new Readpro();
		System.out.println(pro.getBrowser());
	}

}
