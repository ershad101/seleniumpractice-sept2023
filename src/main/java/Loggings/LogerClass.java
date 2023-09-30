package Loggings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LogerClass {

	public static Logger log;

	public static Logger getlogger() throws FileNotFoundException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\seleniumpractice-sept2023\\PropertyFile\\log4j.properties";
		File f1 = new File(path);
		FileInputStream file = new FileInputStream(f1);

		log = LogManager.getLogger(LogerClass.class.getName());

		PropertyConfigurator.configure(file);

		return log;

	}
	

}
