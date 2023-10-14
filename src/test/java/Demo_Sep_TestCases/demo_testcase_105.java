package Demo_Sep_TestCases;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import Loggings.LogerClass;
import POMfile.selectHotel;

public class demo_testcase_105 extends BaseClass {

	selectHotel hotelselect;
	
	public Logger log;

	public LogerClass obj;	

	@Test(dependsOnGroups = "comman")
	public void verify_date_time() {

     
		
		hotelselect = new selectHotel(driver);

	}
}
