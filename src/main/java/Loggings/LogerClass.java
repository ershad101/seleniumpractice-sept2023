package Loggings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogerClass {

	public static Logger log;

	public static Logger logobject() throws FileNotFoundException {

		File file = new File(
				"C:\\Users\\webca\\eclipse-workspace\\seleniumpractice-sept2023\\PropertyFile\\log.properties");

		FileInputStream f2 = new FileInputStream(file);

		log = LogManager.getLogger(Logger.class.getName());

		return log;

	}
	

}
