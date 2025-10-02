package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_P4 extends BaseClass {

	@Test
	public void verifyProduct() {
		 logger.info("*** Starting Test Case: TC_P4 (Verify Product details navigation) ***");
		 try {
		//Step1: Login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login successful with user: {}",p.getProperty("userName"));
		
		//Step 2: Navigate to Product and verify it's details
		logger.info("Verify functionality for TC_P4: Product details are displayed Right");
		HomePage hp = new HomePage(driver);
		hp.verifyNavProduct();
		logger.info("Product details displayed correctly");
		
		logger.info("*** Test Case: TC_P4 Passed ***");
		 }catch(Exception e) {
			 logger.error("*** Test Case: TC_P4 Failed ***");
			 logger.error("Error encountered during TC_P4 executin: {}",e.getMessage(),e);
			 throw e;
		 }finally {
			 logger.info("*** Ending Test Case: TC_P3 ***");
		 }
	}
}
