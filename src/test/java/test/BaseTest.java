package test;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesManager;

import java.math.BigInteger;

public class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class);


	@BeforeSuite(alwaysRun = true)
	public void BeforeSuite() throws Exception {
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		PropertiesManager.initializeProperties();
		logger.info("Properties Initialized");


	}
}
