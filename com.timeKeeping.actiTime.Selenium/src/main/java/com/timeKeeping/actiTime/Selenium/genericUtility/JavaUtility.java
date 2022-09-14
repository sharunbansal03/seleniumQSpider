package com.timeKeeping.actiTime.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * This class contains Java Generic functions
 * @author sharun
 *
 */
public class JavaUtility {
	/**
	 * This method generates Random Number
	 * @param upperLimit
	 * @return
	 */
	public int generateRandomNumber(int upperLimit) {
		Random random = new Random();
		return random.nextInt(upperLimit);
	}

	/**
	 * This method fetched data from Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyDataFile.properties");
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}

}
