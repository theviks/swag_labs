package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_P2 extends BaseClass {

	@Test
	public void aToZsorting() {
		
		logger.info("*** Starting Test Case: TC_P2 (A to Z Sorting) ***");
		try {
			// Step 1: Login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login successful with user: {}", p.getProperty("userName"));
		
		// Step 2: Navigate to HomePage and verify sorting
		logger.info("Verifying functionality for TC_P2: A to Z Sorting");
		HomePage hp = new HomePage(driver);
		hp.vf();
		logger.info("A to Z sorting verification completed successfully.");
		
		logger.info("*** Test Case: TC_P2 PASSED ***");
		}catch(Exception e) {
			 logger.error("*** Test Case: TC_P2 FAILED ***");
		        logger.error("Error encountered during TC_P2 execution: {}", e.getMessage(), e);
		        throw e; // re-throwing ensures the test is marked as failed in the report
		}finally {
	        logger.info("*** Ending Test Case: TC_P2 ***");
	    }
		
		
	}
}
