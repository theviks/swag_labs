package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_C1_Test extends BaseClass {

	@Test
	public void verifyCartCount() {
		logger.info("*** Starting Test Case: TC_C1 (Verify adding a product to cart ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Product and add then to cart
		logger.info("verify functionality for TC_C1: Verify addng a product to cart");
		HomePage hp =  new HomePage(driver);
		hp.addToCart();
		hp.verifyCartCount();
		logger.info("Cart count displayed correctly");
		logger.info("*** Test Case: TC_C1 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_C1 Failed ***");
			logger.error("Error encountered during TC_C1 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_C1 ***");
		}
	}
}
