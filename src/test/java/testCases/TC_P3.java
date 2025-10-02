package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_P3 extends BaseClass {

	@Test
	public void lowToHighPriceSorting() {
		logger.info("*** Starting Test Case : TC_P3 (Low to High Price Sorting) ***");
	try {	
		// Step 1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login successful with user: {}",p.getProperty("userName"));
		
		//Step 2: Navigate to HomePage and verify sorting
		logger.info("Verifying functionality for TC_P3: Price Low to High Sorting");
		HomePage hp = new HomePage(driver);
		hp.vfPrice();
		logger.info("Price Low to High sorting verification completed Successfully");
		
		logger.info("*** Test Case: TC_P3 Passed ***");
	}catch(Exception e) {
		logger.error("*** Test Case: TC_P3 Failed ***");
		logger.error("Error encountered during TC_P3 executin: {}",e.getMessage(),e);
		throw e; // re-throwning ensure the test is marked as failed in the report
	}finally {
		logger.info("*** Ending Test Case: TC_P3 ***");
	}
	}
}
